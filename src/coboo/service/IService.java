/**
 * 
 */
package coboo.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

//import org.apache.lucene3_4.index.CorruptIndexException;
//import org.apache.lucene3_4.store.LockObtainFailedException;
import org.compass.core.CompassHit;
import org.compass.core.CompassHits;
import org.compass.core.CompassQueryBuilder;
import org.compass.core.CompassQueryBuilder.CompassBooleanQueryBuilder;
import org.compass.core.CompassSession;
import org.compass.core.CompassTransaction;
import coboo.config.Config;
import coboo.cpsDatabases.vcmisServiceEvaluation.CobooCompass;
import coboo.cpsDatabases.vcmisServiceEvaluation.Doctor;
import coboo.cpsDatabases.vcmisServiceEvaluation.Org;
import coboo.cpsDatabases.vcmisServiceEvaluation.Person;

import coboo.document.Save;
//import coboo.document.Table_indexdir;

import coboo.impl.DocDriver.NewDocDriver;

/**
 * @author user
 *
 */
public class IService {

	public static boolean addDocs(String dah, String personId, String createrId, String keyXmlStr, String[] docXmlStr) {
		Save save = new Save(createrId);
		save.saveSingleDoc(personId, dah, docXmlStr[0]);
		return true;
	}

	

	// =============================2=============================================

	public static void convertFilelds(String[] fieldNames,
			String[] fieldValues, int i) {
		if(fieldNames[i].equals("gxy")){
			fieldNames[i]="Person.gxyInfo.diagTime";
			fieldValues[i]="*";
		}
		if(fieldNames[i].equals("tnb")){
			fieldNames[i]="Person.tnbInfo.diagTime";
			fieldValues[i]="*";
		}
		if(fieldNames[i].equals("gxb")){
			fieldNames[i]="Person.gxbInfo.diagTime";
			fieldValues[i]="*";
		}
		if(fieldNames[i].equals("nzz")){
			fieldNames[i]="Person.nzzInfo.diagTime";
			fieldValues[i]="*";
		}
		if(fieldNames[i].equals(Config.PERSONID))fieldNames[i]="ResidentpersonId";
		if(fieldNames[i].equals(Config.NAME))fieldNames[i]="name";
	}

	public static void deletePerson(String personId,String dah) {
		try {

			// ------------------------------------------------------------------------------
			CompassSession session = new CobooCompass().getCompass().openSession();
			CompassTransaction tx = session.beginLocalTransaction();
			CompassHits hits = session.find("ResidentpersonId:" + personId);
			if (hits.length() > 0) {
				CompassHit hit = hits.hit(0);
				Person person = (Person) hit.getData();
				session.delete(person);
			}
			tx.commit();
			session.close();
			new Save(personId).deletePerson(personId,dah);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 通过档案的绝对文件路径，解析出该档案的所有数据元的值并通过二维数组返回调用者(返回xml)
	 */
	public static String getDoc(String Docfilename) {
		
		 NewDocDriver driver = new NewDocDriver();
		return driver.getDocument(Docfilename);
	}

	public static String[][] getDocsList(String dah, String personId, String tableClassName) {
		NewDocDriver driver = new NewDocDriver();
		return driver.getDocList(personId, dah, tableClassName);

	}

	public static void getRecords(CompassHits hits, String[][] records, int i) {
		Person hit = (Person) hits.hit(i).data();
		records[i][0]=hit.getName();
		records[i][1]=hit.getSex();
		records[i][2]=hit.getId();
		records[i][3]=hit.getCreatDoctor().getDoctorName();
		records[i][4]=hit.getDah();
		if(hit.getGxyInfo()!=null){
		records[i][5]="true";
		}else{
			records[i][5]="false";
		}
		
		if(hit.getTnbInfo()!=null){
		records[i][6]="true";
		}else{
			records[i][6]="false";
		}

		if(hit.getGxbInfo()!=null){
		records[i][7]="true";
		}else{
			records[i][7]="false";
		}
		
		if(hit.getNzzInfo()!=null){
		records[i][8]="true";
		}else{
			records[i][8]="false";
		}

		if(hit.getZlInfo()!=null){
		records[i][9]="true";
		}else{
			records[i][9]="false";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String personId = "211002196810281116";
		newPerson(personId, "zzy", "211002-001-001-00002", "211002-001-001", "teddy");
		// deletePerson(personId);
	}

	/**
	 * 登记新的居民档案信息
	 * @param personId
	 * @param name
	 * @param dah
	 * @param orgId
	 * @param createrId
	 * @return  @return 1 correct,-1 personId error,-2 same personid,-3 docNumber error,-9 other error
	 */
	public static int newPerson(String personId, String name, String dah, String orgId, String createrId) {
		if (personId.length() != 18) {
			return -2;
		}
		if (dah.length() != 17) {
			System.out.println("dah length not is 17");
			return -3;
		}
		try {

				// compass part
				CompassSession Csession = new CobooCompass().getCompass().openSession();
				CompassTransaction tx = Csession.beginLocalTransaction();
				CompassQueryBuilder queryBuilder =Csession.queryBuilder();
				CompassHits hits = queryBuilder.bool()
						.addMust(queryBuilder.alias("Person"))			
						.addMust(queryBuilder.term("Person.personId", personId))
						.toQuery()
						.hits();
				if(hits.length()==0){
				Person person = new Person();
				
				Doctor creatDoctor = new Doctor();
			
				Org org = new Org();
				org.setOrgId(orgId);
				org.setOrgName(orgId);
				
				creatDoctor.setDoctorId(createrId);
				creatDoctor.setDoctorName(createrId);
				creatDoctor.setOrg(org);
				
				person.setPersonId(personId);
				Date birthDate = new java.text.SimpleDateFormat("yyyyMMdd").parse(personId.substring(6, 14));
				person.setBirthDate(birthDate);
				person.setCreatDoctor(creatDoctor);
				person.setDah(dah);
				person.setName(name);
			    person.setCreatTime(new Date());
				String sexid = personId.substring(16, 17);
				if (Integer.parseInt(sexid) % 2 != 0) {
					sexid = "1";// male
				} else {
					sexid = "2";// female
				}
				person.setSex(sexid);
			//	Csession.save(org);
				Csession.save(person);
				tx.commit();
				Csession.close();
				// compass end
			} else {
				return -2;
			}
			return 1;
		} catch (ParseException e) {
			e.printStackTrace();
			return -9;
		}
	}
	/**
	 * AND查询
	 * @param fieldNames 要查询的字段数组
	 * @param fieldValues 被查询的字段数组fieldNames所对应的值
	 * @param sortFieldName 排序字段名字
	 * @param pageNumbers 查询的页码，从0开始计算
	 * @return 二维数组，每行是一条查询的结果记录
	 */
	public static Object[] queryAnd(String[] fieldNames, String[] fieldValues, String sortFieldName, int pageNumber) {
		CompassSession session = new CobooCompass().getCompass().openSession();
		CompassTransaction tx = session.beginLocalTransaction();
		CompassQueryBuilder cqb = session.queryBuilder();
	 	cqb.alias("Person");
		CompassBooleanQueryBuilder queryBuilder=cqb.bool();
		//queryBuilder.
		for(int i=0;i<fieldNames.length;i++){
			convertFilelds(fieldNames, fieldValues, i);
		queryBuilder.addMust(cqb.wildcard(fieldNames[i],fieldValues[i]));
		}
		CompassHits hits = queryBuilder.toQuery().hits();
		
		int totalHits = hits.getLength();
		int totalpageNumber;		
		int pageSize=100;
		if (totalHits < pageSize) {
			totalpageNumber= 1;
		} else if (totalHits % pageSize == 0) {
			totalpageNumber= totalHits / pageSize;
		} else {
			totalpageNumber= (totalHits / pageSize) + 1;
		}
	
		String[]title=new String[]{"nameIndex","genderIndex","perionId","createrId","dah","gxy","tnb","gxb","nzz","zl"};
		String[][] records=new String[totalHits][10];
		for(int i=0;i<totalHits;i++){
			getRecords(hits, records, i);
		
		}
		Object[] result = { title, records, totalpageNumber, totalHits };
		tx.commit();
	return result;
	
	}

	/**
	 * OR查询
	 * @param fieldNames 要查询的字段数组
	 * @param fieldValues 被查询的字段数组fieldNames所对应的值
	 * @param sortFieldName 排序字段名字
	 * @param pageNumbers 查询的页码，从0开始计算
	 * @return 二维数组，每行是一条查询的结果记录
	 */
	public static Object[] queryOr(String[] fieldNames, String[] fieldValues, String sortFieldName, int pageNumber) {

		CompassSession session = new CobooCompass().getCompass().openSession();
		CompassTransaction tx = session.beginLocalTransaction();
		CompassQueryBuilder cqb = session.queryBuilder();
		cqb.alias("Person");
		CompassBooleanQueryBuilder queryBuilder=cqb.bool();
		//queryBuilder.
		for(int i=0;i<fieldNames.length;i++){
			convertFilelds(fieldNames, fieldValues, i);
			queryBuilder.addShould(cqb.wildcard(fieldNames[i],fieldValues[i]));
		}
		CompassHits hits = queryBuilder.toQuery().hits();
		
		int totalHits = hits.getLength();
		int totalpageNumber;		
		int pageSize=100;
		if (totalHits < pageSize) {
			totalpageNumber= 1;
		} else if (totalHits % pageSize == 0) {
			totalpageNumber= totalHits / pageSize;
		} else {
			totalpageNumber= (totalHits / pageSize) + 1;
		}
	
		String[]title=new String[]{"nameIndex","genderIndex","perionId","createrId","dah","gxy","tnb","gxb","nzz","zl"};
		String[][] records=new String[totalHits][8];
		for(int i=0;i<totalHits;i++){
			getRecords(hits, records, i);
		
		}
	Object[] result = { title, records, totalpageNumber, totalHits };
		tx.commit();
	return result;
	


	}

	/**
	 * AND统计
	 * @param fieldNames
	 * @param fieldValues
	 * @return
	 */
	public static int statAnd(String[] fieldNames, String[] fieldValues) {
		CompassSession session = new CobooCompass().getCompass().openSession();
		CompassTransaction tx = session.beginLocalTransaction();
		CompassQueryBuilder cqb = session.queryBuilder();
		cqb.alias("Person");
		CompassBooleanQueryBuilder queryBuilder=cqb.bool();
		//queryBuilder.
		for(int i=0;i<fieldNames.length;i++){
			convertFilelds(fieldNames, fieldValues, i);
		queryBuilder.addMust(cqb.wildcard(fieldNames[i],fieldValues[i]));
		}
		CompassHits hits = queryBuilder.toQuery().hits();
		int totalHits = hits.getLength();	
		tx.commit();		
		return totalHits;

	}
	
	/**
	 * OR统计
	 * @param fieldNames
	 * @param fieldValues
	 * @return
	 */
	public static int statOr(String[] fieldNames, String[] fieldValues) {
		CompassSession session = new CobooCompass().getCompass().openSession();
		CompassTransaction tx = session.beginLocalTransaction();
		CompassQueryBuilder cqb = session.queryBuilder();
		cqb.alias("Person");
		CompassBooleanQueryBuilder queryBuilder=cqb.bool();
		//queryBuilder.
		for(int i=0;i<fieldNames.length;i++){
			convertFilelds(fieldNames, fieldValues, i);
		queryBuilder.addShould(cqb.wildcard(fieldNames[i],fieldValues[i]));
		}
		CompassHits hits = queryBuilder.toQuery().hits();
		int totalHits = hits.getLength();	
		tx.commit();		
		return totalHits;

	}

}
