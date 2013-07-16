
 package coboo.model.table;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.compass.core.CompassHit;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTransaction;

import coboo.cpsDatabases.vcmisServiceEvaluation.CobooCompass;
import coboo.cpsDatabases.vcmisServiceEvaluation.Doctor;
import coboo.cpsDatabases.vcmisServiceEvaluation.Org;
import coboo.cpsDatabases.vcmisServiceEvaluation.Person;
import coboo.impl.DocDriver.meta.*;

/**
 * 健康档案首页
 * @author WangZhendong
 * 
 */
public class prefaceTab extends Table {
	
	Meta[] metas = {
			new DocCodeMeta(),          		 	//编号
			new NameMeta(),            		     	//姓名
			new PresentAddressMeta(),    			//现住址
			new RegisteredResidenceAddressMeta(),   //户籍地址
			new ContacterPhoneMeta(),             	//联系电话
			new TownNameMeta(),		  				//乡镇名称
			new VillageNameMeta(), 		  			//村名称
			new FileBuildingUnitMeta(),		  		//建档单位
			new	FileBuildingPersonMeta(),	 		//建档人
			new ResponsibilityDoctorMeta(),	 		//责任医生
			new FileBuildingDateMeta() 		  		//建档日期
	};
	private String Rpath="INDEX";
	private String[] Keys={"prefaceTab"};
	private String[] Values={"true"};
	private String	address="";
	private String	docCreateDate;
	private String	docNumber="";
	private String	ZRDoctorName="";
	private String	residentName="";
	private String	HuJiAddress="";
	private String	telephone="";
	private String	TownName="";
	private String	VillageName="";
	private String	docCreaterDanwei="";
	private String	docCreaterName="";
	/**
	 * @return the keys
	 */
	public String[] getKeys() {
		return Keys;
	}

	/**
	 * @param keys the keys to set
	 */
	public void setKeys(String[] keys) {
		Keys = keys;
	}

	/**
	 * @return the values
	 */
	public String[] getValues() {
		return Values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(String[] values) {
		Values = values;
	}

	
	/**
	 * @return the metas
	 */
	public Meta[] getMetas() {
		return metas;
	}
 
	/**
	 * @param metas the metas to set
	 */
	public void setMetas(Meta[] metas) {
		for (Meta m : metas) {
			if (m.getClass().getSimpleName().equals("FileBuildingDateMeta")) {//建档日期
				this.docCreateDate = m.getHValue();
			}
			if (m.getClass().getSimpleName().equals("DocCodeMeta")) {
				this.docNumber = m.getHValue();
			}
			if (m.getClass().getSimpleName().equals("ResponsibilityDoctorMeta")) {//责任医生
				this.ZRDoctorName = m.getHValue();
			}
			if (m.getClass().getSimpleName().equals("PresentAddressMeta")) {	//现住址
				this.address = m.getHValue();
			}
			if (m.getClass().getSimpleName().equals("NameMeta")) {
				this.residentName = m.getHValue();
			}
			if (m.getClass().getSimpleName().equals("RegisteredResidenceAddressMeta")) {	//户籍地址
				this.HuJiAddress = m.getHValue();
			}
			if (m.getClass().getSimpleName().equals("ContacterPhoneMeta")) {//联系电话
				this.telephone = m.getHValue();
			}
			if (m.getClass().getSimpleName().equals("TownNameMeta")) {		//乡镇名称
				this.TownName = m.getHValue();
			}
			if (m.getClass().getSimpleName().equals("VillageNameMeta")) {	//村名称
				this.VillageName = m.getHValue();
			}
			if (m.getClass().getSimpleName().equals("FileBuildingUnitMeta")) {	//建档单位
				this.docCreaterDanwei = m.getHValue();
			}
			if (m.getClass().getSimpleName().equals("FileBuildingPersonMeta")) {//建档人
				this.docCreaterName = m.getHValue();
			}
			

		}
		this.metas = metas;
	}

	/**
	 * @return the rpath
	 */
	public String getRpath() {
		return Rpath;
	}

	/**
	 * @param rpath the rpath to set
	 */
	public void setRpath(String rpath) {
		Rpath = rpath;
	}

	/* (non-Javadoc)
	 * @see coboo.model.table.Table#save()
	 */
	@Override
	public void save() {
		CompassSession session = new CobooCompass().getCompass().openSession();
		CompassTransaction tx = session.beginLocalTransaction();
		CompassHits hits = session.find("ResidentpersonId:" + personId.getHValue());
		if (hits.length() !=1 ) {
		System.out.print("no this peron object,or peron number too many");
			return;
		}
			CompassHit hit = hits.hit(0);
			Person person = (Person) hit.getData();
			person.setAddress(address);
			Doctor doctor=new Doctor();
			doctor.setDoctorName(this.docCreaterName);
			Org org=new Org();
			org.setOrgName(this.docCreaterDanwei);
			doctor.setOrg(org);
			person.setCreatDoctor(doctor);
			person.setName(this.residentName);
			
		//	person.setDah(this.docNumber);//id can not be modified
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(this.docCreateDate);	
				person.setCreatTime(date);
			} catch (Exception e) {
				person.setCreatTime(new Date());
			}
			
			session.save(person);
			tx.commit();
			session.close();
		super.saveFile(this);
	}
	
}