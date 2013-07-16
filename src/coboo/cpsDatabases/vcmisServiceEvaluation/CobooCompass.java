/**
 * 
 */
package coboo.cpsDatabases.vcmisServiceEvaluation;

import java.io.File;

import org.compass.core.Compass;
import org.compass.core.config.CompassConfiguration;

/**
 * @author user
 *
 */
public class CobooCompass {
	private Compass					compass;
	private CompassConfiguration	compassConfig;

	public CobooCompass() {
		String Residents_home = coboo.config.Config.getInstance().getResidents_home();
		compassConfig = new CompassConfiguration();
		compassConfig.setConnection("file://" + Residents_home + "/cpsdata");

		addConfigFiles();
		this.compass = compassConfig.buildCompass();
	}

	private void addConfigFiles() {
		String path = this.getClass().getResource("/").getPath();
		File dir = new File(path + "/coboo/cpsDatabases/vcmisServiceEvaluation");
		compassConfig.addFile(dir.getAbsolutePath()+"/0.cmd.xml");
		for (File f : dir.listFiles()) {
			String absolutePath = f.getAbsolutePath();
			if( (absolutePath.endsWith(".xml"))&&(!absolutePath.endsWith("0.cmd.xml"))) {
			//	System.out.println(absolutePath);
				compassConfig.addFile(absolutePath);
			}
		}
	}

	/**
	 * @return the compass
	 */
	public Compass getCompass() {
		return compass;
	}

}
