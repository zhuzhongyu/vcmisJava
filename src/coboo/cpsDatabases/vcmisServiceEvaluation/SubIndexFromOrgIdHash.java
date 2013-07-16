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
public class SubIndexFromOrgIdHash implements SubIndexHash {

	public String[] getSubIndexes() {
		String[] subRindexdir = new String[]{"Orgs"};		
		return subRindexdir;

	}
	public String mapSubIndex(String alias, Property[] ids) throws SearchEngineException {	
			return "Orgs";
		
	}

}
