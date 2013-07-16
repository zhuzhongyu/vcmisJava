package coboo.config;

import java.io.File;
import java.io.FileFilter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.coboo.base.Bean_BaseInfo;

public class Config {
	public static final String	CREATER		= "createrId";
	public static String		PERSONID	= "perionId";
	public static String		PATH		= "path";
	public static String		DOCNUMBER	= "dah";
	public static String		NAME		= "nameIndex";
	public static String		SEX			= "genderIndex";
	public static String		ORGID		= "sssqIndex";
	public static String		CTIME		= "modified";
	public static String		BIRTHDATE	= "birthdate";
	public boolean				webServer	= false;
	private static Config		m_intance	= null;

	public String				configfilename;
	public String				OS;

	private Config() {
		String path;
		File config1 = new File("/config.xml");
		if (config1.exists()) {
			configfilename = "/config.xml";
		} else if (new File("c:/config.xml").exists()) {
			configfilename = "c:/config.xml";
		} else {
			path = this.getClass().getResource("/").getPath();
			configfilename = path + "/coboo/config/config.xml";
		}
	}

	synchronized public static Config getInstance() {
		if (m_intance == null) {
			m_intance = new Config();
		}
		return m_intance;
	}

	// ===================================================================================
	public File[] getDocDirs() {
		File docdir = new File(getDocuments_Home());
		return docdir.listFiles(new jkda_Filter());

	}

	// ====================================================================================

	public String getResidents_home() {
		String residentsHome = getDocuments_Home() + "/Residents";
		File r = new File(residentsHome);
		if (!r.exists())
			r.mkdir();
		return residentsHome;
	}

	// ===================================================================================
	public String getDocuments_Home() {
		String coboodir = Bean_BaseInfo.coboodir;
		if (coboodir != null) {
			this.webServer = true;
			return Bean_BaseInfo.coboodir;

		}

		String Documents_Home = "/usr/local/apache-tomcat-6.0.20/webapps/coboo/";
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File(configfilename));
			Documents_Home = doc.selectSingleNode("//Documents_Home").getText(); // coboodir
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return Documents_Home;

	}

	// ======================================================================================
	public static void main(String args[]) {
		Config c = new Config();
		System.out.println(System.getProperty("os.name"));

		System.out.println("documment_home:");
		System.out.println(c.getDocuments_Home());

		System.out.println("jkdas:");
		File[] jkdas = c.getDocDirs();
		for (int i = 0; i < jkdas.length; i++) {
			System.out.println(jkdas[i].getAbsolutePath());
		}
		System.out.println("indexdirs:");

	}
}

class jkda_Filter implements FileFilter {

	public boolean accept(File pathname) {
		String filename = pathname.getName().toLowerCase();
		if (filename.indexOf("jkda") > -1) {
			return true;
		} else {
			return false;
		}
	}
}
