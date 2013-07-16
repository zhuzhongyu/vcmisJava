package coboo.impl;

import java.io.File;

public class Util {

	/**
	 * @param args
	 */

	public static boolean deleteDir(File file) {
		File[] temp = file.listFiles();
		for (int i = 0; i < temp.length; i++) {
			// System.out.println(temp[i].getName());
			if (temp[i].isDirectory()) {
				if (temp[i].listFiles().length != 0) {
					deleteDir(temp[i]);
				}
				delDir(temp[i]);
			} else {
				temp[i].delete();
			}
		}
		return true;
	}

	// ==================================================================
	private static void delDir(File file) {
		if (file.listFiles().length == 0)
			file.getAbsoluteFile().delete();
	}

	// ==================================================================
	public static void main(String[] args) {

	}

}
