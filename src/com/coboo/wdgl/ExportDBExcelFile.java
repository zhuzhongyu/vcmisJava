package com.coboo.wdgl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportDBExcelFile 
{
	/**
	 * 写excel文件。
	 * @param fileName
	 * @param data
	 * @return
	 */
	public static boolean writeExcel(String fileName,String[][] data) 
	{

		File file = new File(fileName);
		if(file.exists())
			file.delete();
		
		FileOutputStream fOut = null;
		try 
		{

			HSSFWorkbook workbook = new HSSFWorkbook();
			
			HSSFSheet sheet = workbook.createSheet("PhoneBook");
			
			HSSFFont font = workbook.createFont();
			font.setColor(HSSFFont.COLOR_NORMAL);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);

			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyle.setFont(font);
			cellStyle.setWrapText(true);

			int startRow = 0;
			int rowNum = 0;// 行标
			int colNum = 0;// 列标

			HSSFCell cell = null;
			for (; rowNum < data.length; rowNum++) 
			{
				// 新建第rowNum行
				HSSFRow row = sheet.createRow((short) rowNum+startRow);
				for (colNum = 0; colNum < data[rowNum].length; colNum++) {
					// 在当前行的colNum位置创建单元格
					cell = row.createCell((short) colNum);
	//				cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellStyle(cellStyle);
					String str_data = data[rowNum][colNum];
					if(str_data==null)
					{
						str_data = "";
					}
					cell.setCellValue(str_data);
				}
			}

			// 工作薄建立完成，下面将工作薄存入文件
			// 新建一输出文件流
			fOut = new FileOutputStream(file);
			// 把相应的Excel 工作簿存盘
			workbook.write(fOut);
			fOut.flush();
			// 操作结束，关闭文件
			fOut.close();

			// System.out.println("Excel文件生成成功！Excel文件名：" +
			// file.getAbsolutePath());
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
			
		} 
		finally 
		{
			if (fOut != null)
			{
				try 
				{
					fOut.close();
				} 
				catch (IOException e1)
				{
					
				}
			}
		}
	}
	
	
	
	/**
	 * 
	 * @param fileName 文件名称
	 * @return Vector<Object>类型数据
	 * @throws IOException
	 */

	public static String[][] readExcel(String fileName,int columnCount) throws IOException 
	{

		File file = new File(fileName);
		FileInputStream in = null;
		in = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(in);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getLastRowNum()+1;
		int cols = 0;
		HSSFRow row1 = null;
		HSSFCell cell1 = null;
		for (cols = 0;; cols++) {
			row1 = sheet.getRow((short) 0);
			cell1 = row1.getCell((short) cols);
			if (cell1 == null) {
				break;
			}
		}

		String [][] data = new String[rows][columnCount];

		try {

			HSSFRow row = null;
			HSSFCell cell = null;
			int rowNum = 0;
			int colNum = 0;
			while (rowNum <= rows) 
			{
				row = sheet.getRow((short) rowNum);
				for (colNum = 0;; colNum++) 
				{
					cell = row.getCell((short) colNum);
					if (cell == null) 
					{
						break;
					}
					else
					{
						if(cell.getCellType()==0)
						{
							java.text.DecimalFormat df = new java.text.DecimalFormat("#");
							data[rowNum][colNum] = df.format(cell.getNumericCellValue());
						}
						else
						{
							data[rowNum][colNum] = cell.getStringCellValue();
						}
					}
				}
				rowNum++;
			}
			in.close();

		} catch (Exception e) {
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
				}
			}
		}

		return data;
	}
	
}
