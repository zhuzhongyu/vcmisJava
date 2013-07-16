/**
 * 
 */
package coboo.service.client;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.lucene3_4.document.Document;
import org.apache.lucene3_4.document.Field;
import org.apache.lucene3_4.index.CorruptIndexException;
import org.apache.lucene3_4.index.IndexReader;
import org.apache.lucene3_4.index.Term;
import org.apache.lucene3_4.store.Directory;
import org.apache.lucene3_4.store.FSDirectory;
import org.compass.core.CompassSession;
import org.compass.core.CompassTransaction;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import coboo.config.Config;
import coboo.cpsDatabases.vcmisServiceEvaluation.CobooCompass;
import coboo.cpsDatabases.vcmisServiceEvaluation.Doctor;
import coboo.cpsDatabases.vcmisServiceEvaluation.GxbInfo;
import coboo.cpsDatabases.vcmisServiceEvaluation.GxyInfo;
import coboo.cpsDatabases.vcmisServiceEvaluation.Info;
import coboo.cpsDatabases.vcmisServiceEvaluation.NzzInfo;
import coboo.cpsDatabases.vcmisServiceEvaluation.Org;
import coboo.cpsDatabases.vcmisServiceEvaluation.Person;
import coboo.cpsDatabases.vcmisServiceEvaluation.TnbInfo;
import coboo.document.Index;
import coboo.document.Writer;
import coboo.document.comdir_Filter;
import coboo.document.indexdir_Filter;

/**
 * @author user
 * 
 */

public class toolbox {

	public static void main(String[] args) throws CorruptIndexException,
			IOException, DocumentException, ParseException, ClassNotFoundException {
		if (args.length == 0) {
			System.out.println("USEAGE:\n java -jar toolbox.jar COMMAND");
			System.out.println("\t step1 list.xml");
			System.out.println("\t\t list.xml example");
			System.out.println("\t\t ===============================================================");
			System.out.println("\t\t<roots> <root name=\"长征社区卫生服务站\" id=\"69\"  dah=\"210881000001xxxxx\"/></roots>");
			System.out.println("\t\t ===============================================================");
			System.out.println("\t step2");
			System.out	.println("\t step3");
			System.out	.println("\t replace file.xml\n\t执行前需要将coboo下indexdir格式目录移去!");
			System.out	.println("\t optimize");
		
			return;
		}
		toolbox indexMove = new toolbox();
		if (args[0].equals("step1")) {
			indexMove.step1(args[1]);
			System.out.println("\n\n\n");
			System.out.println("step1 OK!");
			return;
		}
		if (args[0].equals("step2")) {
			indexMove.step2_movedir();
			System.out.println("\n\n\n");
			System.out.println("step2 OK!");
			return;
		}
		if (args[0].equals("step3")) {
			indexMove.step3_tocompass();
			System.out.println("\n\n\n");
			System.out.println("all OK!");
			return;
		}
		if (args[0].equals("replace")) {

			String filename = args[1];
			indexMove.repacle_part_field(filename);
			System.out.println("\n\n\n");
			System.out.println("Replaced from " + filename + " OK!");
			return;
		}

		if (args[0].equals("optimize")) {
			indexMove.optimize();
			System.out.println("\n\n\n");
			System.out.println("Optimized OK!");
			return;
		}
		
	}
	/**
******************************************************************************************************************	 * 
<?xml version="1.0" encoding="UTF-8"?>
<roots>
                <root name="长征社区卫生服务站" id="69"  dah="210881000001xxxxx"/>
                <root name="西海办事处社区卫生服务中心" id="67"  dah="210881000002xxxxx"/>
                <root name="太阳升办事处社区卫生服务中心" id="66"  dah="210881000003xxxxx"/>
                <root name="东城办事处社区卫生服务中心" id="65"  dah="210881000004xxxxx"/>
                <root name="团山办事处社区卫生服务中心" id="64"  dah="210881000005xxxxx"/>
                <root name="鼓楼办事处社区卫生服务中心" id="63"  dah="210881000006xxxxx"/>
                <root name="西城办事处社区卫生服务中心" id="62"  dah="210881000007xxxxx"/>
                <root name="盖州市第三人民医院（万福）" id="187"  dah="210881000008xxxxx"/>

</roots>
**********************************************************************************************************************
	 * 
	 * 
	 * 根据mysql记录的社区id，查到社区id，sssqIndex与正确dah前12位的对应关系，批量生成dah
	 * @throws DocumentException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void step1(String filename) throws DocumentException, IOException, ClassNotFoundException{
		SAXReader reader = new SAXReader();
		//String filename = coboo.config.Config.getInstance().getDocuments_Home()+"/list.xml";
		org.dom4j.Document  d = reader.read(new File(filename));
		org.dom4j.Element r = d.getRootElement();
		System.out.println("begin...");
		for (Iterator it = r.elementIterator(); it.hasNext();) {
			Element element = (Element) it.next();
			String id = element.attributeValue("id");
			String dah = element.attributeValue("dah");
		
			if(id!=null && dah!=null&&!dah.equals("")){					
		    	Index.getInstance().updateAllIndex(id, dah);
				
			}
			
		}
		System.out.println("end");
	}
	/**
	 * 本函数执行的条件是数据完全是Residents规范的标准，本程序将lucene3.4数据转化成compass数据,执行前需要将coboo下indexdir格式目录移去
	 * @throws IOException
	 * @throws ParseException
	 */
	private void step3_tocompass() throws IOException, ParseException{
		iniReaderWriter();
		CompassSession Csession = new CobooCompass().getCompass().openSession();
		CompassTransaction tx = Csession.beginLocalTransaction();
		for (IndexReader r : SubReaders) {
		
			int max = r.maxDoc();
			System.out.println("max=" + max);
			//-------------------------------------------------------------------
			for (int n = 0; n < max; n++) {
				org.apache.lucene3_4.document.Document d = r.document(n);
			
				String createrId = d.get(Config.CREATER);
				if(createrId==null){
					createrId=d.get("unuse24");
				}
				String orgid = d.get(Config.ORGID);
				String personId = d.get(Config.PERSONID);
				String dah = d.get(Config.DOCNUMBER);
				String name = d.get(Config.NAME);
				String birthDate=d.get(Config.BIRTHDATE);
				String createTime = d.get(Config.CTIME);
				String sex = d.get(Config.SEX);
				String path = d.get(Config.PATH);
                String ifHk=d.get("HealthyCheckUpTable");
                if(ifHk==null)ifHk="false";
                String gxy=d.get("gxy");
                if(gxy==null)gxy="false";
                String tnb=d.get("tnb");
                if(tnb==null)tnb="false";
                String gxb=d.get("gxb");
                if(gxb==null)gxb="false";
                String nzz=d.get("nzz");
                if(nzz==null)nzz="false";
                String zl=d.get("zl");
                if(zl==null)zl="false";
            
                
				
				Person person = new Person();
				
				Doctor creatDoctor = new Doctor();			
				Org org = new Org();
				org.setOrgId(orgid);
				org.setOrgName(orgid);				
				creatDoctor.setDoctorId(createrId);
				creatDoctor.setDoctorName(createrId);
				creatDoctor.setOrg(org);
				person.setPersonId(personId);
				Date D_birthDate = new java.text.SimpleDateFormat("yyyyMMdd").parse(personId.substring(6, 14));
				person.setBirthDate(D_birthDate);
				person.setCreatDoctor(creatDoctor);
				person.setDah(dah);
				person.setName(name);
				Date createtime = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(createTime);
			    person.setCreatTime(createtime);
				person.setSex(sex);	
			       //-----------------------------------------------------------
					if(gxy.equals("true")){
						
						Info Info = new GxyInfo();
						Info.setIf_gxy(true);
						Info.setDiagTime(new Date());
						Info.setDoctor(creatDoctor);					
						person.setGxyInfo(Info);
						
					}
					if(tnb.equals("true")){
						Info Info = new TnbInfo();
						Info.setIf_tnb(true);
						Info.setDiagTime(new Date());
						Info.setDoctor(creatDoctor);
						person.setTnbInfo(Info);
					}
					if(nzz.equals("true")){
						Info Info = new NzzInfo();
						Info.setIf_cerebral_vascular_disease(true);
						Info.setDiagTime(new Date());
						Info.setDoctor(creatDoctor);
						person.setNzzInfo(Info);
					}
					if(gxb.equals("true")){
						Info Info = new GxbInfo();
						Info.setIf_cardio_vascular_disease(true);
						Info.setDiagTime(new Date());
						Info.setDoctor(creatDoctor);
						person.setGxyInfo(Info);
					}
					//----------------------------------------------------------

				Csession.save(person);
				System.out.println("record"+n);
			
				// compass end
			}
			//----------------------------------------------------------------
		}
		tx.commit();
		Csession.close();
	}
	/**
	 * 
	 * @param filename
	 ***************************************************************************************************************************
	 <roots>
    
		<root name="1德城街道社区" fieldname="dah" old_head="441226001000" new_head="210802002007"/>
		<root name="2新圩镇" fieldname="dah" old_head="441226578000" new_head="441226101000"/>
		<root name="3回龙镇" fieldname="dah" old_head="441226295000" new_head="441226102000"/>
		<root name="4官圩镇" fieldname="dah" old_head="441226332000" new_head="441226103000"/>
		<root name="5马圩镇" fieldname="dah" old_head="441226690000" new_head="441226105000"/>
		<root name="6高良镇" fieldname="dah" old_head="441226252000" new_head="441226106000"/>
		<root name="7莫村镇" fieldname="dah" old_head="441226471000" new_head="441226107000"/>
		<root name="8永丰镇" fieldname="dah" old_head="441226658000" new_head="441226109000"/>
		<root name="9武垄镇" fieldname="dah" old_head="441226586000" new_head="441226110000"/>
		<root name="10播植镇" fieldname="dah" old_head="441226543000" new_head="441226111000"/>
		<root name="11风村镇" fieldname="dah" old_head="441226738000" new_head="441226112000"/>
		<root name="12悦城镇" fieldname="dah" old_head="441226631000" new_head="441226113000"/>
		<root name="13九市镇" fieldname="dah" old_head="441226594000" new_head="441226114000"/>
		
</roots>
	 * ***********************************************************************************************************************
	 * 
	 * @throws IOException
	 * @throws DocumentException
	 */
	private void repacle_part_field(String filename) throws IOException,
			DocumentException {
		String old_fieldValue_str = "", new_fieldValue_str = "", fieldnameStr = "";
		SAXReader reader = new SAXReader();
		org.dom4j.Document d = reader.read(new File(filename));
		org.dom4j.Element r = d.getRootElement();
		System.out.println("begin...");
		for (Iterator it = r.elementIterator(); it.hasNext();) {
			Element element = (Element) it.next();
			old_fieldValue_str += element.attributeValue("old_head") + "|";
			new_fieldValue_str += element.attributeValue("new_head") + "|";
			fieldnameStr += element.attributeValue("fieldname") + "|";
		}
		String[] old_heads = old_fieldValue_str.split("|");
		String[] new_heads = new_fieldValue_str.split("|");
		String[] fieldnames = fieldnameStr.split("|");
		int headlength = old_heads[0].length();
		// ----------------------------------------------------------------------------
		// Iterator iter = WriterMap.entrySet().iterator();
		String residentsHome = Config.getInstance().getResidents_home();
		File residenthome = new File(residentsHome);
		File[] f2 = residenthome.listFiles(new comdir_Filter());

		for (int i = 0; i < old_heads.length; i++) {
			for (File f : f2) {
				String comdir = f.getName();
				String onumber = comdir.substring(4);
				if (onumber.startsWith(old_heads[i])) {
					String CommunityIndexDir = comdir + "/indexdir";
					Directory dir = FSDirectory.open(new File(Config
							.getInstance().getResidents_home()
							+ "/"
							+ CommunityIndexDir));
					Writer w = new Writer(dir, false);
					IndexReader ir = IndexReader.open(w, true);
					int max = ir.maxDoc();
					for (int n = 0; n < max; n++) {
						Document doc = ir.document(n);

						String old_full_fieldValue = doc.get(fieldnames[i]);
						if (old_heads[i].equals(old_full_fieldValue.substring(
								0, headlength))) {
							doc.removeField(fieldnames[i]);
							String old_dah_tail = old_full_fieldValue
									.substring(headlength);
							doc.add(new Field(fieldnames[i], new_heads[i]
									+ old_dah_tail, Field.Store.YES,
									Field.Index.NOT_ANALYZED));
							// w.deleteDocuments(new Term(fieldnames[i],
							// old_dah));
							// w.addDocument(doc);
							w.updateDocument(new Term(fieldnames[i],
									old_full_fieldValue), doc);
							System.out.println("replaced old dah "
									+ old_heads[i] + " with new dah"
									+ new_heads[i]);
							System.out.println("doc number" + n + "/" + max);

						}
					}

					w.commit();
					w.optimize();
					System.out.println("optimizing..."
							+ w.getDirectory().toString());
					ir.close();
					w.close();
					String comdir2 = "COM_" + new_heads[i];
					String par = f.getParent();
					String abs_comdir2 = par + "/" + comdir2;
					File f_comdir2 = new File(abs_comdir2);
					f.renameTo(f_comdir2);
					break;
				}
			}
		}

	}

	public IndexReader[] SubReaders;
	private HashMap<String, Writer> WriterMap = new HashMap<String, Writer>();
	private HashMap<String, org.apache.lucene.index.IndexWriter> CompassWriterMap = new HashMap<String, org.apache.lucene.index.IndexWriter>();

	/**
	 * 
	 */
	public toolbox() {
		super();

	}

	/**
	 * 本函数是在dah已经是正确17位格式的前提下执行。
	 * 本函数提取lucene3.4索引中的dah，对于不符合3.2格式的path进行重新设置，并且把相应的person目录移动到正确位置
	 * mv oldindexdir to new indexdir mv oldjkda to Residents change old path to
	 * new path
	 * 
	 * @throws CorruptIndexException
	 * @throws IOException
	 */
	void step2_movedir() throws CorruptIndexException, IOException {
		iniReaderWriter();
		for (IndexReader r : SubReaders) {
			int max = r.maxDoc();
			System.out.println("max=" + max);
			for (int n = 0; n < max; n++) {
				File f_oldPath = null;
				File f_newPath = null;
				Document d = r.document(n);
				String dah = d.get(Config.DOCNUMBER);
				String personId = d.get(Config.PERSONID);
				String oldpath = d.get(Config.PATH);
				if (oldpath.contains("Residents"))
					continue;

				String newpath = "Residents/COM_" + dah.substring(0, 12) + "/"
						+ personId;
				d.removeField(Config.PATH);
				d.add(new Field(Config.PATH, newpath, Field.Store.YES,
						Field.Index.NOT_ANALYZED));
				oldpath = oldpath.substring(0, oldpath.indexOf("/A/"));
				f_oldPath = new File(oldpath);
				f_newPath = new File(Config.getInstance().getDocuments_Home()
						+ "/" + newpath);

				if (dah.length() == 17) {
					String dir = Config.getInstance().getDocuments_Home()
							+ "/Residents/COM_" + dah.substring(0, 12)
							+ "/indexdir";
					String key = "COM_" + dah.substring(0, 12);
					Writer w = null;
					w = this.WriterMap.get(key);
					if (w == null) {
						// w.addDocument(d);
						File file = new File(dir);
						file.mkdirs();
						Directory fd = FSDirectory.open(file);
						w = new Writer(fd, true);
						WriterMap.put(key, w);

					}
					// w.addDocument(d);
					w.updateDocument(new Term(Config.PERSONID, personId), d);
					// System.out.println(d.toString());

					if (f_oldPath != null) {
						boolean status = f_oldPath.renameTo(f_newPath);
						if (status == false) {
							String shellCommand = "mv "
									+ f_oldPath.getAbsolutePath() + " "
									+ f_newPath.getAbsolutePath();
							String[] cmd = { "/bin/sh", "-c", shellCommand };
							Process process = Runtime.getRuntime().exec(cmd);
							try {
								System.out.println(shellCommand);
								process.waitFor();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
				System.out.println("doc number" + n + "/" + max);
			}
		}
		Iterator iter = WriterMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();

			Writer val = (Writer) entry.getValue();
			val.commit();
			System.out.println("optimizing..." + val.getDirectory().toString());
			val.optimize();
		}
	}

	/**
	 * 
	 * @throws IOException
	 */
	void iniReaderWriter() throws IOException {
		String Documents_Home = Config.getInstance().getDocuments_Home();
		File docdir = new File(Documents_Home);
		File[] f1 = docdir.listFiles(new indexdir_Filter());
		int length1 = f1.length;
		String residentsHome = Config.getInstance().getResidents_home();
		File r = new File(residentsHome);
		File[] f2 = r.listFiles(new comdir_Filter());
		int length2 = f2.length;

		this.SubReaders = new IndexReader[length1 + length2];
		for (int i = 0; i < length1; i++) {
			Directory dir = FSDirectory.open(f1[i]);
			SubReaders[i] = IndexReader.open(dir, true);
		}
		for (int i = length1; i < length2 + length1; i++) {
			String CommunityIndexDir = f2[i-length1].getAbsolutePath() + "/"
					+ "indexdir";
			Directory dir = FSDirectory.open(new File(CommunityIndexDir));
			String key = f2[i-length1].getName();
			WriterMap.put(key, new Writer(dir, false));
			SubReaders[i ] = IndexReader.open(dir, true);
		}

	}

	/**
	 * @throws IOException
	 * @throws CorruptIndexException
	 * 
	 */
	private void optimize() throws CorruptIndexException, IOException {
		iniReaderWriter();
		Iterator iter = WriterMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();

			Writer val = (Writer) entry.getValue();
			val.commit();
			System.out.println("optimizing..." + val.getDirectory().toString());
			val.optimize();
		}

	}
}