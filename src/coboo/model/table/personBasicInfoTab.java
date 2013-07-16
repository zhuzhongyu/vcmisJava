package coboo.model.table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.compass.core.CompassException;
import org.compass.core.CompassHit;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTransaction;

import coboo.cpsDatabases.vcmisServiceEvaluation.CobooCompass;
import coboo.cpsDatabases.vcmisServiceEvaluation.Doctor;
import coboo.cpsDatabases.vcmisServiceEvaluation.GxbInfo;
import coboo.cpsDatabases.vcmisServiceEvaluation.GxyInfo;
import coboo.cpsDatabases.vcmisServiceEvaluation.Info;
import coboo.cpsDatabases.vcmisServiceEvaluation.NzzInfo;
import coboo.cpsDatabases.vcmisServiceEvaluation.Person;
import coboo.cpsDatabases.vcmisServiceEvaluation.RespiratoryInfo;
import coboo.cpsDatabases.vcmisServiceEvaluation.TnbInfo;
import coboo.cpsDatabases.vcmisServiceEvaluation.ZlInfo;
import coboo.impl.DocDriver.meta.BloodTransfusionHistoryMeta;
import coboo.impl.DocDriver.meta.BloodTypeMeta;
import coboo.impl.DocDriver.meta.ChildFmlDiseaseMeta;
import coboo.impl.DocDriver.meta.ContacterMeta;
import coboo.impl.DocDriver.meta.ContacterPhoneMeta;
import coboo.impl.DocDriver.meta.DisableMeta;
import coboo.impl.DocDriver.meta.DiseaseHistoryMeta;
import coboo.impl.DocDriver.meta.DrugAllergyHistoryMeta;
import coboo.impl.DocDriver.meta.EduMeta;
import coboo.impl.DocDriver.meta.EnvironmentMeta;
import coboo.impl.DocDriver.meta.EthnicMeta;
import coboo.impl.DocDriver.meta.ExposedTimeMeta;
import coboo.impl.DocDriver.meta.FatherFmlDiseaseMeta;
import coboo.impl.DocDriver.meta.GenDiseaseMeta;
import coboo.impl.DocDriver.meta.MarriageStatueMeta;
import coboo.impl.DocDriver.meta.Meta;
import coboo.impl.DocDriver.meta.MotherFmlDiseaseMeta;
import coboo.impl.DocDriver.meta.NameMeta;
import coboo.impl.DocDriver.meta.PResidentTypeMeta;
import coboo.impl.DocDriver.meta.PayMethodMeta;
import coboo.impl.DocDriver.meta.PhoneMeta;
import coboo.impl.DocDriver.meta.ProfessionMeta;
import coboo.impl.DocDriver.meta.SexMeta;
import coboo.impl.DocDriver.meta.SiblingFmlDiseaseMeta;
import coboo.impl.DocDriver.meta.SurgeryHistoryMeta;
import coboo.impl.DocDriver.meta.WorkUnitMeta;
import coboo.impl.DocDriver.meta.WoundHistoryMeta;

/**
 * 个人基本信息表
 * 
 * @author 任笑言
 */

public class personBasicInfoTab extends Table {
	/**
	 * 
	 */
	private String Rpath = "A";
	private String[] Keys = { "personBasicInfoTab" };
	private String[] Values = { "true" };

	private String diseaseHistory;

	Meta[] metas = { super.personId,// 身份证号
			super.dah,// 编号
			super.birthdate,// 出生日期
			new BloodTransfusionHistoryMeta(),// 既往史-输血
			new BloodTypeMeta(),// 血型
			new ChildFmlDiseaseMeta(),// 家族史-子女
			new ContacterMeta(),// 联系人姓名
			new ContacterPhoneMeta(),// 联系人电话
			new DisableMeta(),// 残疾情况
			new DiseaseHistoryMeta(),// 既往史-疾病
			new DrugAllergyHistoryMeta(),// 药物过敏史
			new EduMeta(),// 文化程度
			new EthnicMeta(),// 民族
			new FatherFmlDiseaseMeta(),// 家族史-父亲
			new GenDiseaseMeta(),// 遗传病史
			new MarriageStatueMeta(),// 婚姻状况
			new MotherFmlDiseaseMeta(),// 家族史-母亲
			new NameMeta(),// 姓名
			new PayMethodMeta(),// 医疗费用支付方式
			new PhoneMeta(),// 本人电话
			new PResidentTypeMeta(),// 常住类型
			new ProfessionMeta(),// 职业
			new SexMeta(),// 性别
			new SiblingFmlDiseaseMeta(),// 家族史-兄弟姐妹
			new SurgeryHistoryMeta(),// 既往史-手术
			new WorkUnitMeta(),// 工作单位
			new WoundHistoryMeta(), // 既往史-外伤
			new EnvironmentMeta(),// 生活环境
			new ExposedTimeMeta() // 暴露史

	};

	/**
	 * @return the metas
	 */
	public Meta[] getMetas() {
		return metas;
	}

	/**
	 * @param metas
	 *            the metas to set
	 */
	public void setMetas(Meta[] metas) {
		for (Meta m : metas) {
			if (m.getClass().getSimpleName().equals("DiseaseHistoryMeta")) {
				this.diseaseHistory = m.getHValue();
				
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
	 * @param rpath
	 *            the rpath to set
	 */
	public void setRpath(String rpath) {
		Rpath = rpath;
	}

	/**
	 * @return the keys
	 */
	public String[] getKeys() {
		return Keys;
	}

	/**
	 * @param keys
	 *            the keys to set
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
	 * @param values
	 *            the values to set
	 */
	public void setValues(String[] values) {
		Values = values;
	}

	/******************************************************************************************
	 * 
	 * this is the method that we need implement
	 * 
	 * 
	 *******************************************************************************************/
	public void save() {
	
			try {
				super.saveFile(this);
		//		Table_indexdir indexdirtable = new CobooSession().getTable();
				CompassSession session = new CobooCompass().getCompass()
						.openSession();
				CompassTransaction tx = session.beginLocalTransaction();
				// ----------------------------------------------------------------------------
				CompassHits hits = session.find("ResidentpersonId:"
						+ personId.getHValue());
				if (hits.length() != 1) {
					System.out
							.print("no this peron object,or peron number too many");
					return;
				}
				CompassHit hit = hits.hit(0);
				Person person = (Person) hit.getData();
				// ------------------------------------------------------------------------------
				// person.setAddress(address);
				String keyword = "高血压";			
				if (diseaseHistory.contains(keyword)) {
			//		addKeyValue("gxy", "true");
					Info Info=person.getGxyInfo();
					if(Info==null)
					Info = new GxyInfo();
					aaa(keyword, Info);					
					person.setGxyInfo(Info);
				}
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				 keyword = "糖尿病";
				if (diseaseHistory.contains(keyword)) {
		//			addKeyValue("tnb", "true");
					Info Info=person.getTnbInfo();
					if(Info==null)
					 Info = new TnbInfo();
					aaa(keyword, Info);
					person.setTnbInfo(Info);
				}

				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				 keyword = "冠心病";
				if (diseaseHistory.contains(keyword)) {
					if (diseaseHistory.contains(keyword)) {
						Info Info=person.getGxbInfo();
						if(Info==null)
						 Info = new GxbInfo();
						aaa(keyword, Info);
						person.setGxbInfo(Info);
					}
				}
					////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					 keyword ="慢性阻塞性";
						if (diseaseHistory.contains(keyword)) {
							if (diseaseHistory.contains(keyword)) {
								Info Info=person.getRespiratoryInfo();
								if(Info==null)
								 Info = new RespiratoryInfo();
								aaa(keyword, Info);
								person.setRespiratoryInfo(Info);
							}
						}
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							 keyword ="恶性肿瘤";
								if (diseaseHistory.contains(keyword)) {
									if (diseaseHistory.contains(keyword)) {
										Info Info=person.getZlInfo();
										if(Info==null)
										 Info = new ZlInfo();
										aaa(keyword, Info);
										person.setZlInfo(Info);
									}
								}
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
									keyword ="脑卒中";
									if (diseaseHistory.contains(keyword)) {
										if (diseaseHistory.contains(keyword)) {
											Info Info=person.getNzzInfo();
											if(Info==null)
											 Info = new NzzInfo();
											aaa(keyword, Info);
											person.setNzzInfo(Info);
										}
									}
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// --------------------compitiable old-----------------------------
			//	indexdirtable.setID(this.personId.getHValue());
			//	indexdirtable.setDah(this.dah.getHValue());
			//	indexdirtable.setFieldNames(this.Keys);
			//	indexdirtable.setFieldValues(this.Values);
			//	indexdirtable.save();
				// ------------------------------------------------
				session.save(person);
				tx.commit();
				session.close();
			} catch (CompassException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
									
	}

	private void aaa(String keyword, Info Info) throws ParseException {
		String[] dismetas = diseaseHistory.split("/");
		// --gets gxy time-----
		for (int i = 0; i < dismetas.length; i++) {
			if (dismetas[i].contains(keyword)) {
				String  MONTH= dismetas[i + 1];
				String YEAR  = dismetas[i + 2];
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				Date date = sdf.parse(YEAR + "-" + MONTH);
				Info.setDiagTime(date);
				Doctor doctor = new Doctor();
				doctor.setDoctorId(this.Userid);
				Info.setDoctor(doctor);

			}
			if (dismetas[i].contains( "糖尿病")) {
				Info.setIf_tnb(true);
			}
			if (dismetas[i].contains("冠心病")) {
				Info.setIf_cardio_vascular_disease(true);
			}

			if (dismetas[i].contains("脑卒中")) {
				Info.setIf_cerebral_vascular_disease(true);
			}
			if (dismetas[i].contains("肿瘤")) {
				Info.setIf_zl(true);
			}
			if (dismetas[i].contains("肺嫉病")) {
				Info.setIf_respiratoryDisease(true);
			}
		}
		// ---------------------
	}

}