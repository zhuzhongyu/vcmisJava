/**
 * 
 */
package coboo.impl.DocDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import coboo.document.Save;
import coboo.model.table.Table;

/**
 * @author zzy
 *
 */
public class NewDocDriver  {

	    /**
		 * 得到文档在文档树中的相对路径
		 */

	
	public String getRpath(String className) {

		try {
			String ClassName = "coboo.model.table." + className;
			Table t = (Table) Class.forName(ClassName).newInstance();
			return t.getRpath();
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	/**
	 * 从文件中获取档案树xml，对于新版就是直接将文件取出
	 */

	public String getDocument(String Docfilename) {
		FileInputStream testFile;
		try {
			testFile = new FileInputStream(Docfilename);

			BufferedReader br = new BufferedReader(new InputStreamReader(testFile));
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			String str = new String(sb);
			return str;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	

	/**
	 * @param personId
	 * @param dah
	 * @param tableClassName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String[][] getDocList(String personId, String dah, String tableClassName) {
		if(tableClassName==null)return null;
		String[][] ret = null;
		try {
			String PersonDocHome = new Save().get_personDocHome(personId,dah);
			if (PersonDocHome == null) {
				System.out.println("PersonDocHome is null");
				return null;
			}
			Table t = (Table) Class.forName("coboo.model.table." + tableClassName).newInstance();
			String PersonTableHome=PersonDocHome + '/' + t.getRpath();
			String filename =PersonTableHome  + "/index.xml";
			File f=new File(filename);
			if(!f.exists()){
				return null;
			}
			Document doc = new SAXReader().read(new File(filename));
			List list = doc.selectNodes("//node");
			ret = new String[list.size()][3];
			int i = 0;
			for (Iterator n = list.iterator(); n.hasNext(); i++) {
				Node node = (Node) n.next();
				// Arrays.copyOf(ret, (ret.length) + 1);
				ret[i][0] = node.valueOf("@createTime");
				ret[i][1] = node.valueOf("@createUser");
				
				String folder = node.valueOf("@folder");
				if (folder.contains("Residents")){
					folder=folder.substring(folder.indexOf(PersonTableHome)+PersonTableHome.length());
				}
				
				ret[i][2] = PersonTableHome+"/"+folder;
				
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return ret;
	}

}
