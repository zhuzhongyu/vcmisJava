/**
 * 
 */
package coboo.service.client.vcmisServiceEvaluation;
import java.util.Calendar;

import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTransaction;

import coboo.cpsDatabases.vcmisServiceEvaluation.CobooCompass;
import coboo.cpsDatabases.vcmisServiceEvaluation.Person;

/**
 * @author user
 *
 */
public class TestCompass {
	
	public void setUpData() {
		CompassSession session = new CobooCompass().getCompass().openSession();
		CompassTransaction tx = session.beginLocalTransaction();
		Person hypertension_table = new Person();
		Calendar c = Calendar.getInstance();
		c.set(1968, 10, 28);
		hypertension_table.setPersonId("211002196810281116");
		
		
		
	
		session.save(hypertension_table);
		tx.commit();
		session.close();
	}
	void testSetUpData() {
		CompassSession session = new CobooCompass().getCompass().openSession();
		CompassTransaction tx = null;
		try {
			tx = session.beginTransaction();
			CompassHits hits = session.find("zhang san");
			// assertEquals(1,hits.length());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestCompass().setUpData();
		System.out.println("ok");
	}

}
