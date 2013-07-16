/**
 * 
 */
package coboo.document;

import java.io.File;
import java.io.FileFilter;

public class indexdir_Filter implements FileFilter {

	public boolean accept(File pathname) {
		String filename = pathname.getName().toLowerCase();
		if (filename.contains("indexdir")) {
			return true;
		} else {
			return false;
		}
	}
}