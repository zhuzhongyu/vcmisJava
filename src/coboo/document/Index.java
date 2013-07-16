/**
 * 
 */
package coboo.document;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.lucene3_4.document.Document;
import org.apache.lucene3_4.document.Field;
import org.apache.lucene3_4.document.Fieldable;
import org.apache.lucene3_4.index.CorruptIndexException;
import org.apache.lucene3_4.index.IndexReader;
import org.apache.lucene3_4.index.IndexReader.FieldOption;
import org.apache.lucene3_4.index.MultiReader;
import org.apache.lucene3_4.index.Term;
import org.apache.lucene3_4.search.IndexSearcher;
import org.apache.lucene3_4.search.TermQuery;
import org.apache.lucene3_4.search.TopDocs;
import org.apache.lucene3_4.store.Directory;
import org.apache.lucene3_4.store.FSDirectory;
import org.apache.lucene3_4.store.LockObtainFailedException;

import coboo.config.Config;

/**
 * @author 朱中宇
 * @deprecated
 */
public class Index {
	// ////////////////////////////////////////////////////////////////////////////////////////
	private static Index				m_intance	= null;

	private HashMap<String, Integer>	ReaderIxMap	= new HashMap<String, Integer>();

	private HashMap<String, Writer>		WriterMap	= new HashMap<String, Writer>();

	private String[]					IndexFields	= null;
	public IndexReader[]				SubReaders;
	public MultiReader					multiReader;

	/***
	 * 
	 * @param fieldNames fieldNames[0]="sssqIndex",values[0]=commmunityId；fieldNames[1]="dah",values[1]="211002001001XXXXX"
	 * @param values
	 * @throws IOException
	 * @throws ClassNotFoundException
	 *
	 */
	public void updateAllIndex(String id, String dah) throws IOException, ClassNotFoundException {
		String key;
		Iterator it = ReaderIxMap.entrySet().iterator();
		// =========循环所有索引目录======================================================
		while (it.hasNext()) {
			Map.Entry e = (Entry) it.next();
			key = (String) e.getKey();
			boolean found = false;
			Writer w = WriterMap.get(key);
			System.out.println("begin index...." + w.toString());
			IndexReader ir = IndexReader.open(w, true);
			int max = ir.maxDoc();
			int j=1;
			for (int i = 0; i < max; i++) {
				System.out.println("record " + i + ".......id" +id + "......" + "dah" +dah);
				Document doc = ir.document(i);
				String sssqIndex = doc.get(Config.ORGID);
				if (!sssqIndex.equals(id))
					continue;
				j++;
				String personId = doc.get(Config.PERSONID);
				doc.removeField("dah");
	
				String s = String.valueOf(j);
				int l = s.length();
				if (l == 1) {
					s = "0000" + s;
				} else if (l == 2) {
					s = "000" + s;
				} else if (l == 3) {
					s = "00" + s;
				} else if (l == 4) {
					s = "0" + s;
				}
				dah = dah.substring(0, 12) + s;
				doc.add(new Field("dah", dah, Field.Store.YES, Field.Index.NOT_ANALYZED));
				w.updateDocument(new Term(Config.PERSONID, personId), doc);
			}
			w.commit();
			// =================================================================================
		}

	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 更新某人的索引记录，有字段keys[i]则更新，没有则添加
	 * @param personId 身份证号
	 * @param fieldNames 
	 * @param values
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public boolean updateIndex(String personId, String[] fieldNames, String[] values) throws IOException, ClassNotFoundException {
		// refreshReaders();
		boolean found = false;
		Document document = new Document();
		Object[] key = getKey(personId);
		if (key == null) {
			return false;
		}
		int ix = ReaderIxMap.get(key[0]);
		Writer w = WriterMap.get(key[0]);
		Term t = new Term(Config.PERSONID, personId);
		Document oldDoc = (Document) key[1];
		Iterator<Fieldable> ite = oldDoc.getFields().iterator();

		// -------------------------------------------------------------------------------------------
		for (int i = 0; i < fieldNames.length; i++) {
			Field f = new Field(fieldNames[i], values[i], Field.Store.YES, Field.Index.NOT_ANALYZED);
			document.add(f);
		}
		// -------------------------------------------------------------------------------------------
		while (ite.hasNext()) {
			Field oldField = (Field) ite.next();
			// ----
			found = false;
			for (int i = 0; i < fieldNames.length; i++) {
				if (fieldNames[i] == oldField.name()) {
					found = true;
					break;
				}
			}
			// -----
			if (!found) {
				document.add(oldField);
			}
		}

		w.updateDocument(t, document);
		w.commit();

		// ======================================
		// Directory d=SubReaders[ix].directory();
		// SubReaders[ix].close();
		// SubReaders[ix]=IndexReader.open(d, true);
		SubReaders[ix] = SubReaders[ix].reopen();
		multiReader = (MultiReader) multiReader.reopen();
		// ======================================
		System.out.println("Person " + personId + " has been updated");
		return true;
	}

	public boolean disablePersonKey(String personId, String[] keys) throws IOException, ClassNotFoundException {
		String[] values = new String[keys.length];
		for (int i = 0; i < keys.length; i++) {
			values[i] = "false";
		}
		updateIndex(personId, keys, values);
		return true;
	}

	/**
	 * 删除某人的索引记录
	 * @param personId
	 * @throws IOException 
	 * @throws LockObtainFailedException 
	 * @throws CorruptIndexException 
	 * @throws ClassNotFoundException 
	 */
	public boolean deleteIndex(String personId) throws CorruptIndexException, LockObtainFailedException, IOException, ClassNotFoundException {
		Term t = new Term(Config.PERSONID, personId);
		Object[] key = getKey(personId);
		if (key == null) {
			return false;
		}

		Writer w = WriterMap.get(key[0]);
		w.deleteDocuments(t);
		w.commit();
		// ======================================
		int ix = ReaderIxMap.get(key[0]);
		// Directory d=SubReaders[ix].directory();
		// SubReaders[ix].close();
		// SubReaders[ix]=IndexReader.open(d, true);
		SubReaders[ix] = SubReaders[ix].reopen();
		multiReader = (MultiReader) multiReader.reopen();
		// ======================================

		System.out.println("Person " + personId + " is deleted!");
		return true;

	}

	/**
	 * 新建某个人的索引项,如果没有该社区
	 * @param personId
	 * @param sexid
	 * @param orgId
	 * @param name
	 * @param dah
	 * @param CommunityId
	 * @param communityDir
	 * @param createTime
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public boolean newPersonIndexEntry(String personId, String sexid, String orgId, String name, String dah, String CommunityId, String communityDir,
			String createTime, String path, String createrId) throws IOException {
		if (null != getKey(personId)) {
			System.out.print("try to create repeat records");
			return false;
		}
		String key = "COM_" + CommunityId;
		Writer w = WriterMap.get(key);

		if (w == null) {
			newCommunityIndex(communityDir);
			w = WriterMap.get(key);
		}
		Document doc = new Document();
		doc.add(new Field(Config.PERSONID, personId, Field.Store.YES, Field.Index.NOT_ANALYZED));
		doc.add(new Field(Config.ORGID, orgId, Field.Store.YES, Field.Index.NOT_ANALYZED));
		doc.add(new Field(Config.NAME, name, Field.Store.YES, Field.Index.NOT_ANALYZED));
		doc.add(new Field(Config.DOCNUMBER, dah, Field.Store.YES, Field.Index.NOT_ANALYZED));
		doc.add(new Field(Config.CTIME, createTime, Field.Store.YES, Field.Index.NOT_ANALYZED));
		doc.add(new Field(Config.PATH, path, Field.Store.YES, Field.Index.NOT_ANALYZED));
		doc.add(new Field(Config.SEX, sexid, Field.Store.YES, Field.Index.NOT_ANALYZED));
		doc.add(new Field(Config.CREATER, createrId, Field.Store.YES, Field.Index.NOT_ANALYZED));
		w.addDocument(doc);
		w.commit();
		// ==============================
		int ix = ReaderIxMap.get(key);
		// Directory d=SubReaders[ix].directory();
		// SubReaders[ix].close();
		// SubReaders[ix]=IndexReader.open(d, true);
		SubReaders[ix] = SubReaders[ix].reopen();
		multiReader = (MultiReader) multiReader.reopen();

		// ==============================
		return true;
	}

	/**
	 * @param key
	 * @throws IOException 
	 * @throws CorruptIndexException 
	 */
	private boolean newCommunityIndex(String communityDir) throws CorruptIndexException, IOException {
		String indexdir = communityDir + "/indexdir";
		File f = new File(indexdir);
		File communityf = new File(communityDir);
		if (f.exists()) {
			return false;
		}
		f.mkdirs();
		Directory dir = FSDirectory.open(f);
		String key = communityf.getName();
		Writer w = new Writer(dir, true);
		w.commit();
		WriterMap.put(key, w);// create

		int length = SubReaders.length;
		IndexReader[] a = new IndexReader[length + 1];
		for (int i = 0; i < length; i++) {
			a[i] = SubReaders[i];
		}
		SubReaders = a;

		// --------------------------------------------------
		SubReaders[length] = IndexReader.open(dir, true);
		ReaderIxMap.put(key, length);
		multiReader = (MultiReader) multiReader.reopen();

		// --------------------------------------------------

		return true;

	}

	/**
	 * 获得Readers
	 * @return
	 */
	public IndexReader[] getReaders() {
		return SubReaders;

	}

	/**
	 * 返回系统索引中所有的字段数组
	 * @return
	 * @throws IOException 
	 * @throws CorruptIndexException 
	 */
	public String[] getIndexFields() {

		return IndexFields;
	}

	private Object[] getKey(String personId) throws IOException {

		Term t = new Term(Config.PERSONID, personId);
		Iterator it = ReaderIxMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Entry) it.next();
			IndexSearcher Searcher = new IndexSearcher(SubReaders[(Integer) e.getValue()]);
			TopDocs Hits = Searcher.search(new TermQuery(t), 1);
			if (Hits.totalHits > 0) {
				String key = (String) e.getKey();
				int docid = Hits.scoreDocs[0].doc;
				Document doc = Searcher.doc(docid);
				Object[] ret = { key, doc };
				return ret;

			}
		}
		return null;
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * constructor
	 */

	private Index() {
		try {
			initReadersWriters();
			multiReader = new MultiReader(SubReaders, false);
			Object[] o = multiReader.getFieldNames(FieldOption.ALL).toArray();
			// Object[] o =
			// SubReaders[0].getFieldNames(FieldOption.ALL).toArray();
			int len = o.length;
			IndexFields = new String[len];
			for (int i = 0; i < len; i++) {
				IndexFields[i] = o[i].toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initReadersWriters() throws IOException {

		String Documents_Home = Config.getInstance().getDocuments_Home();
		File docdir = new File(Documents_Home);
		File[] f1 = docdir.listFiles(new indexdir_Filter());

		String residentsHome = Config.getInstance().getResidents_home();
		File r = new File(residentsHome);
		File[] f2 = r.listFiles(new comdir_Filter());

		int length1 = f1.length;
		int length2 = f2.length;
		this.SubReaders = new IndexReader[length1 + length2];

		for (int i = 0; i < length1; i++) {
			Directory dir = FSDirectory.open(f1[i]);
			String key = f1[i].getName();
			WriterMap.put(key, new Writer(dir, false));
			SubReaders[i] = IndexReader.open(dir, false);
			ReaderIxMap.put(key, i);
		}
		for (int i = length1; i < length1 + length2; i++) {
			String CommunityIndexDir = f2[i - length1].getAbsolutePath() + "/" + "indexdir";
			Directory dir = FSDirectory.open(new File(CommunityIndexDir));
			String key = f2[i - length1].getName();

			WriterMap.put(key, new Writer(dir, false));
			SubReaders[i] = IndexReader.open(dir, false);
			ReaderIxMap.put(key, i);
		}

	}

	/**
	 * * 静态工厂方法,返回此类的唯一实例.* 当发现实例没有初始化的时候,才初始化. *
	 * @return LazySingleton
	 */
	synchronized public static Index getInstance() {
		if (m_intance == null) {
			m_intance = new Index();
		}
		return m_intance;
	}

	// /////////////////////////////////////////////////////////////////////
	/**
	 * 测试用主函数
	 * @throws IOException 
	 * @throws LockObtainFailedException 
	 * @throws CorruptIndexException 
	 */
	// ///////////////////////////////////////////////////////////////////
	public static void main(String[] args) {

	}
}