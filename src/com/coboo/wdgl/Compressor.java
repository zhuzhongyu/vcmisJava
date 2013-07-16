package com.coboo.wdgl;

import java.util.Enumeration;
import java.util.zip.*;
import java.io.*;

public class Compressor {
	/**
	* 压缩文件
	* @param zipFileName 保存的压缩包文件路径
	* @param inputFile 需要压缩的文件夹或者文件路径
	* @throws Exception
	*/
	public static void zip(String zipFileName, String inputFile) throws Exception {
		zip(zipFileName, new File(inputFile));
	}
	
	private static void zip(String zipFileName, File inputFile) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
		zipFileName));
		zip(out, inputFile, "");//递归压缩方法
		System.out.println("zip done");
		out.close();
	}
	/**
	* 递归压缩方法
	* @param out   压缩包输出流
	* @param f     需要压缩的文件
	* @param base 压缩的路径
	* @throws Exception
	*/
	private static void zip(ZipOutputStream out, File f, String base) throws Exception {
		if (f.isDirectory()) {   // 如果是文件夹，则获取下面的所有文件
			File[] fl = f.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {   // 如果是文件，则压缩
			out.putNextEntry(new ZipEntry(base)); // 生成下一个压缩节点
			FileInputStream in = new FileInputStream(f);   // 读取文件内容
			int b;
			while ((b = in.read()) != -1)
			out.write(b);   // 写入到压缩包
			in.close();
		}
	}
	
	
	/**
	 * 解压文件。
	 * @param ZipFileUrl 将要解压的文件。
	 * @param descDir 解压后的目标目录。
	 */
	public void UnZipMyFile(String ZipFileUrl,String descDir){
		if(!descDir.endsWith("\\") || !descDir.endsWith("/")){
			descDir += System.getProperty("file.separator");
		}
		
		File DescDir = new File(descDir);
		if(!DescDir.isDirectory()){
			DescDir.mkdirs();
		}
		try {
			// 打开压缩文件
			ZipFile zf = new ZipFile(new File(ZipFileUrl));
			ZipEntry entry = null;
			String zipEntryName = null;
			InputStream in = null;
			OutputStream out = null;
			byte[] buf1 = null;
			int len = 0;
			for (Enumeration entries = zf.entries(); entries.hasMoreElements();) {
				entry = ( (ZipEntry) entries.nextElement());
				zipEntryName = entry.getName();
				if(entry.isDirectory()){
					new File(descDir + zipEntryName).mkdirs();
				}else{
					in = zf.getInputStream(entry);
					out = new FileOutputStream(descDir + zipEntryName);
					buf1 = new byte[1024];
					while((len = in.read(buf1)) > 0) {
						out.write(buf1, 0, len);
					}
					in.close();
					out.close();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args){
		long a = System.currentTimeMillis();
		Compressor cpr = new Compressor();
		try {
			cpr.zip("e:\\test.zip", "e:\\test");
		} catch (Exception e) {
			e.printStackTrace();
		}
		cpr.UnZipMyFile("e:\\test.zip","e:\\test1");
		System.out.println(System.currentTimeMillis() - a);
	}
}
