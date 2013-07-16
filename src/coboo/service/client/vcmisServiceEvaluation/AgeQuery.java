/**
 * 
 */
package coboo.service.client.vcmisServiceEvaluation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.compass.core.CompassHits;
import org.compass.core.CompassQueryBuilder;
import org.compass.core.CompassQueryBuilder.CompassBooleanQueryBuilder;
import org.compass.core.CompassSession;
import org.compass.core.CompassTransaction;

import coboo.cpsDatabases.vcmisServiceEvaluation.CobooCompass;
import coboo.document.XmlParser;
import coboo.service.IService;

/**
 * @author user
 *
 */
public class AgeQuery {
	public static void main(String[] args) {
		String[][] result = new AgeQuery().queryAge(-3, "<k><dah>2*</dah></k>", 0);
		for (String[] record : result) {
			System.out.println("");
			for (int i = 0; i < record.length; i++) {
				if (record[i] != null)
					System.out.print(record[i] + "\t\t");
			}
		}
	}

	private Object[]	results;
	CompassSession		session	= new CobooCompass().getCompass().openSession();

	public AgeQuery() {

	}

	/**
	 * 
	 * @param age 65岁以上age=65;3岁以下age=-3
	 * @param keyString 查询串<k><dah>95789*</dah></k>
	 * @return
	 */
	String[][] queryAge(int age, String keyString, int pageNumber) {
		keyString = keyString.substring(keyString.indexOf("<k>") + 3);

		Calendar rightNow = Calendar.getInstance();
		String nowYearS = String.valueOf(rightNow.get(Calendar.YEAR));
		String nowMonth = String.valueOf(rightNow.get(Calendar.MONTH) + 1);

		String nowDay = String.valueOf(rightNow.get(Calendar.DATE));
		String Now_str = nowYearS + "-" + nowMonth + "-" + nowDay;
		if (age > 0) {
			rightNow.add(Calendar.YEAR, -age);
		} else {
			rightNow.add(Calendar.YEAR, age);
		}
		Calendar birthday = rightNow;
		String year = String.valueOf(birthday.get(Calendar.YEAR));
		String month = String.valueOf(birthday.get(Calendar.MONTH) + 1);
		String day = String.valueOf(birthday.get(Calendar.DATE));
		String birth_str = year + "-" + month + "-" + day;
		System.out.println(Now_str);

		System.out.println(birth_str);
		String kStr;
		if (age > 0) {
			kStr = "<birthdatebegin>1800-01-01</birthdatebegin>";
			kStr += "<birthdateend>" + birth_str + "</birthdateend>";
		} else {
			kStr = "<birthdatebegin>" + birth_str + "</birthdatebegin>";
			kStr += "<birthdateend>" + Now_str + "</birthdateend>";
			// kStr = "<birthdate op='and' begin='" + birth_str + "' end='" +
			// Now_str + "'></birthdate>";
		}
		kStr = "<k>" + kStr + keyString;
		String keyXmlStr = kStr;
		// String sortFieldName = request.getParameter("sortFieldName");
		// String pageNumberStr = request.getParameter("pageNumber");
		// int pageNumber = Integer.parseInt(pageNumberStr);

		// keyXmlStr
		// xml字符串，例如<k><gxy>true</gxy><tnb>false</tnb><zl>false</zl><gxb>false</gxb></k>

		XmlParser p = new XmlParser();
		String[] fieldNames = p.getKeys(keyXmlStr);
		String[] fieldValues = p.getValues(keyXmlStr);
		results = queryAnd(fieldNames, fieldValues, pageNumber);
		// result = new CobooSession().getTable().Query(kStr, 0);
		System.out.println("get total " + kStr + "query result");
		return (String[][]) results[1];
	}

	private Object[] queryAnd(String[] fieldNames, String[] fieldValues, int pageNumber) {
		CompassSession session = new CobooCompass().getCompass().openSession();
		CompassTransaction tx = session.beginLocalTransaction();
		CompassQueryBuilder cqb = session.queryBuilder();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cqb.alias("Person");
		CompassBooleanQueryBuilder queryBuilder = cqb.bool();
		// queryBuilder.
		try {
			for (int i = 0; i < fieldNames.length; i++) {
				IService.convertFilelds(fieldNames, fieldValues, i);
				if (fieldNames[i].contains("begin")) {
					cqb.ge("Person.birthDate", dateFormat.parse(fieldValues[i]));
					continue;
				}
				if (fieldNames[i].contains("end")) {
					queryBuilder.addMust(cqb.le("Person.birthDate", dateFormat.parse(fieldValues[i])));
					continue;
				} else {
					queryBuilder.addMust(cqb.wildcard(fieldNames[i], fieldValues[i]));
				}

			}
		} catch (ParseException e) {

			e.printStackTrace();
		}
		CompassHits hits = queryBuilder.toQuery().hits();

		int totalHits = hits.getLength();
		int totalpageNumber;
		int pageSize = 100;
		if (totalHits < pageSize) {
			totalpageNumber = 1;
		} else if (totalHits % pageSize == 0) {
			totalpageNumber = totalHits / pageSize;
		} else {
			totalpageNumber = (totalHits / pageSize) + 1;
		}

		String[] title = new String[] { "nameIndex", "genderIndex", "perionId", "createrId", "dah", "gxy", "tnb", "gxb", "nzz", "zl" };
		String[][] records = new String[totalHits][10];
		for (int i = 0; i < totalHits; i++) {
			IService.getRecords(hits, records, i);

		}
		Object[] result = { title, records, totalpageNumber, totalHits };
		tx.commit();
		return result;

	}

	// private QueryResult result;
	/**
	 * 
	 * @param age 65岁以上age=65;3岁以下age=-3
	 * @param keyString 查询串<k><dah>95789*</dah></k>
	 * @return
	 */
	@SuppressWarnings("unused")
	int statAge(int age, String keyString) {
		String[][] result = queryAge(age, keyString, 0);
		return (Integer) results[2];
	}
}
