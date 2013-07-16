/**
 * 
 */
package coboo.document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.lucene3_4.index.CorruptIndexException;
import org.apache.lucene3_4.store.LockObtainFailedException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import coboo.config.Config;
import coboo.impl.DocDriver.meta.Meta;
import coboo.model.table.Table;

/**
 * @author zzy
 *
 */
public class Save {
	private String	user	= "";

	public Save() {

	}

	public Save(String userId) {
		user = userId;
	}

	/**
	 * @param personId
	 * @param dah
	 * @param tableStrXml
	 */
	public boolean saveSingleDoc(String personId, String dah, String tableStrXml) {
		String personHome= get_personDocHome(personId,dah);
	
		
		if (personHome == null) {
			return false;
		}
		Table t = changeToTable(tableStrXml);
		if (t == null) {
			return false;
		}
		t.setDah(dah);
		t.setPersonId(personId);
		t.setPersionDir(personHome);
		t.setUserid(this.user);
		t.save();
		return true;
		
	}
	/**
	 * @param personId
	 * @param dah
	 * @return
	 */
	public String get_personDocHome(String personId, String dah) {
		 return Config.getInstance().getResidents_home()+"/COM_"+dah.substring(0, 12)+"/"+personId;
		
	}

	/**
	 * @param tableStrXml
	 * @return
	 * @throws DocumentException 
	 */
	@SuppressWarnings("unchecked")
	private Table changeToTable(String tableStrXml) {
		Document d;
		try {
			d = DocumentHelper.parseText(tableStrXml);
			Element root = d.getRootElement();
			String classSimpleName = root.getName();

			Table t = (Table) Class.forName("coboo.model.table." + classSimpleName).newInstance();

			List<Element> list = root.elements();
			Meta[] metas = (Meta[]) new Meta[list.size()];
			Object[] xmlElements = list.toArray();
			// for (Element e : list) {
			int length = xmlElements.length;
			for (int i = 0; i < length; i++) {

				String metaName = ((Element) xmlElements[i]).getName();
				try {
					metas[i] = (Meta) Class.forName("coboo.impl.DocDriver.meta." + metaName).newInstance();
				} catch (Exception e) {
					System.out.println(metaName + "  not found!");
					length--;
					i--;
					Meta[] metas1 = (Meta[]) new Meta[length];
					for(int j=0;j<=i;j++){
						metas1[j]=metas[j];
					}
					Object[] xmlElements1=new Object[length];
					for(int j=0;j<length;j++){
						if(j==i+1){
							xmlElements1[j]=xmlElements[length];
						}else{
						xmlElements1[j]=xmlElements[j];
						}
					}
					xmlElements=xmlElements1;
					metas=metas1;
					continue;
					// e.printStackTrace();
				}
				if (metas[i] != null) {
					List<Element> es = ((Element) xmlElements[i]).elements();
					Object[] eee = es.toArray();
					String[] values = new String[es.size()];
					if (eee.length != values.length) {
						System.out.print("warning meta error!");
					}
					for (int j = 0; j < eee.length; j++) {
						values[j] = ((Element) eee[j]).getStringValue();
					}
					((Meta) metas[i]).setSValues(values);
				}
			}
			t.setMetas(metas);
			return t;
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

	}

	/**
	 * @param personId
	 * @param dah
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws LockObtainFailedException 
	 * @throws CorruptIndexException 
	 */
	public void deletePerson(String personId, String dah) throws CorruptIndexException, LockObtainFailedException, IOException, ClassNotFoundException {
		String path = get_personDocHome(personId,dah);
		if (path == null) {
			System.out.println("the person's path not found");
			return;
		}
	//	new CobooSession().getTable().deleteIndex(personId);
		File f = new File(path);
		if (f.exists()) {
			String par = f.getParent();
			String recycleDir = par + "/RecycleBin";
			File recycledir = new File(recycleDir);
			if (!recycledir.exists()) {
				recycledir.mkdirs();
			}
			String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String delDir = recycleDir + "/" + personId + "." + date;
			File deldir = new File(delDir);
			f.renameTo(deldir);
		}
		
	}

	@SuppressWarnings("rawtypes")
	public void deleteNodeFromIndexXmlFile(String indexXmlFileName, String simpleFileName) {
		try {
			SAXReader reader = new SAXReader();
			Document document;
			document = reader.read(new File(indexXmlFileName));
			Element root = document.getRootElement();
			Element dirElm = root.element("dir");// "member"是节点名
			List list = dirElm.elements();
			for (int i = 0; i < list.size(); i++) {
				Element e = (Element) list.get(i);
				String value = e.attributeValue("folder");
				if (simpleFileName.contains(value)) {
					dirElm.remove(e);
				}
			}
			XMLWriter writer = new XMLWriter(new FileWriter(indexXmlFileName));
			writer.write(document);
			writer.close();
		} catch (DocumentException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}




}
