/**
 * 
 */
package coboo.cpsDatabases.vcmisServiceEvaluation;

import java.io.File;

import org.compass.core.Property;
import org.compass.core.engine.SearchEngineException;
import org.compass.core.engine.subindex.SubIndexHash;

import coboo.config.Config;
import coboo.document.comdir_Filter;

/**
 * @author zzy
 *
 */
public class SubIndexFromDahHash implements SubIndexHash {

	public String[] getSubIndexes() {
		String residentsHome = Config.getInstance().getResidents_home();
		File r = new File(residentsHome);
		File[] f2 = r.listFiles(new comdir_Filter());
		int length2 = f2.length;
		String[] subRindexdir = new String[length2];
		for (int i = 0; i < length2; i++) {
			subRindexdir[i] = f2[i].getName();
		}
		return subRindexdir;

	}

	public String mapSubIndex(String alias, Property[] ids) throws SearchEngineException {
		String dah =  ids[1].getStringValue();
		String subRdir = "COM_"+dah.substring(0, 12);
		{
			return subRdir;
		}
	}

}
