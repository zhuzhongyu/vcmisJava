/**
 * 
 */
package coboo.cpsDatabases.vcmisServiceEvaluation;

import org.compass.core.Property;
import org.compass.core.engine.SearchEngineException;
import org.compass.core.engine.subindex.SubIndexHash;

/**
 * @author zzy
 *
 */
public class SubIndexFromDoctorIdHash implements SubIndexHash {

	public String[] getSubIndexes() {
		String[] subRindexdir = new String[]{"Doctors"};		
		return subRindexdir;

	}
	public String mapSubIndex(String alias, Property[] ids) throws SearchEngineException {	
			return "Doctors";
		
	}

}
