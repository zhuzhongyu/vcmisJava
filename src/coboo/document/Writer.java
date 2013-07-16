/**
 * 
 */
package coboo.document;

import java.io.IOException;
import java.io.Serializable;

import org.apache.lucene3_4.analysis.KeywordAnalyzer;
import org.apache.lucene3_4.index.CorruptIndexException;
import org.apache.lucene3_4.index.IndexWriter;
import org.apache.lucene3_4.store.Directory;
import org.apache.lucene3_4.store.LockObtainFailedException;

/**
 * @author user
 *
 */
public class Writer extends IndexWriter implements Serializable {

	/**
	 * @param d
	 * @param a
	 * @param mfl
	 * @return 
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	
	public Writer(Directory d,boolean create) throws CorruptIndexException, LockObtainFailedException, IOException{
		super(d,new KeywordAnalyzer(),create,IndexWriter.MaxFieldLength.LIMITED);
	}
	private static final long	serialVersionUID	= 1L;
	

}
