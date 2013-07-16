package com.coboo.wdgl;

import java.io.*;
public class CreateFileDir {

	public static Boolean CreateDir(String destDirName){
		File dir=new File(destDirName);
		if(dir.exists()) {
			return false;
		}
		if(!destDirName.endsWith(File.separator)){
			destDirName=destDirName+File.separator;
			
		}
		if(dir.mkdirs()){
			return true;
		}
		else{
			return false;
		}
		
	}
}
