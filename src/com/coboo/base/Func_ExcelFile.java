package com.coboo.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

public class Func_ExcelFile 
{
	//写报表名
	public static void writeExcelTableName(HSSFWorkbook workbook,HSSFSheet sheet,String tableName,short columnCount)
	{
		Region reg = new Region(0,(short)0,0,(short)(columnCount-1)); //合并单元格
		sheet.addMergedRegion(reg);
		HSSFRow row_head = sheet.createRow(0);
		row_head.setHeight((short)800);   //设置表头高度
		HSSFCell cell_head = row_head.createCell((short)0);
//		cell_head.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell_head.setCellValue(tableName);
		
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFFont.COLOR_NORMAL);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short)20); //设置表头字体大小

		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFont(font);
		cellStyle.setWrapText(true);
		
		cell_head.setCellStyle(cellStyle);
	}
	//写报表表头
	public static void writeExcelTableHeader(HSSFWorkbook workbook,HSSFSheet sheet,String[]tableHeader)
	{
		HSSFRow row = sheet.createRow((short)2);
		
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFFont.COLOR_NORMAL);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);

		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFont(font);
		cellStyle.setWrapText(true);
		
		for(short i=0;i<tableHeader.length;i++)
		{
			HSSFCell cell = row.createCell(i);
//			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(tableHeader[i]);
			
		}
	}
	//写报表填报单位
	public static void writeExcelTableUnit(HSSFWorkbook workbook,HSSFSheet sheet,String unit,short columnCount)
	{
		Region reg = new Region(1,(short)0,1,(short)(columnCount-5)); //合并单元格
		sheet.addMergedRegion(reg);
		HSSFRow row_head = sheet.createRow(1);
		row_head.setHeight((short)400);   //设置表头高度
		HSSFCell cell_head = row_head.createCell((short)0);
//		cell_head.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell_head.setCellValue("填报单位："+unit);
		
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFFont.COLOR_NORMAL);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short)10); //设置表头字体大小

		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFont(font);
		cellStyle.setWrapText(true);
		
		cell_head.setCellStyle(cellStyle);
	}
	//写报表填报时间
	public static void writeExcelTableDate(HSSFWorkbook workbook,HSSFSheet sheet,String date,short columnCount)
	{
		Region reg = new Region(1,(short)(columnCount-4),1,(short)(columnCount-1)); //合并单元格
		sheet.addMergedRegion(reg);
		HSSFRow row_head = sheet.createRow(1);
		row_head.setHeight((short)400);   //设置表头高度
		HSSFCell cell_head = row_head.createCell((short)(short)(columnCount-4));
//		cell_head.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell_head.setCellValue("填报时间："+date);
		
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFFont.COLOR_NORMAL);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short)10); //设置表头字体大小

		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFont(font);
		cellStyle.setWrapText(true);
		
		cell_head.setCellStyle(cellStyle);
	}
	
	public static boolean writeExcel(String fileName,String tableName,String[]tableHeader,String[][] data,short[]width,String unit,String date) 
	{

		File file = new File(fileName);
		if(file.exists())
			file.delete();
		
		FileOutputStream fOut = null;
		try 
		{

			HSSFWorkbook workbook = new HSSFWorkbook();
			
			HSSFSheet sheet = workbook.createSheet("PhoneBook");
			
			writeExcelTableName(workbook,sheet,tableName,(short)width.length);
			writeExcelTableHeader(workbook,sheet,tableHeader);
			writeExcelTableUnit(workbook,sheet,unit,(short)width.length);
			writeExcelTableDate(workbook,sheet,date,(short)width.length);
			
			//设置单元格宽度
			for(short i=0;i<width.length;i++)
			{
				sheet.setColumnWidth(i,width[i]);
			}
			
			
			HSSFFont font = workbook.createFont();
			font.setColor(HSSFFont.COLOR_NORMAL);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);

			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyle.setFont(font);
			cellStyle.setWrapText(true);

			int startRow = 3;
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
}
