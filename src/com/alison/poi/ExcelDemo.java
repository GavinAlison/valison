package com.alison.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {
	public static void main(String[] args) throws IOException {
		 new ExcelDemo().loadExcel();
		 
		// 使用此方法可以检测当前目录
		// System.out.println(new File(".").getAbsolutePath());
		// File file = new File("com/alison/poi/excel/impProductTemp.xls");
		// System.out.println(file.getAbsolutePath());
		// System.out.println(file.isFile());

	}

	@SuppressWarnings("deprecation")
	public void loadExcel() throws IOException {
		// getResource(str)参数字符有字符"/" ，识别 / 不会把 / 转换其他字符,
		// 如果是 \\\\ 的话， 它不识别该字符，需要通过java.net.URLEncode.encode(str, "UTF-8")转换
		String filePath = this.getClass().getClassLoader().getResource(
				transformPath("impProductTemp.xls")).getFile();
		//toString()构造URL的字符串表示，  getFile()返回URL文件名，getPath() 
		String filePath1 = this.getClass().getClassLoader().getResource(
				transformPath("impProductTemp.xls")).toString();
		
		System.out.println(filePath);
		///D:/workspace/valison/WebRoot/WEB-INF/classes/com/alison/poi/excel/impProductTemp.xls
//		filePath = java.net.URLDecoder.decode(filePath, "UTF-8");
		System.out.println("---------------");
		

		System.out.println(filePath1);
//		System.out.println(filePath1);
		
		//filePath = "D:\\workspace\\valison\\WebRoot\\WEB-INF\\classes\\com\\alison\\poi\\excel\\impProductTemp.xls";
		FileInputStream in = new FileInputStream(filePath);
		
		
		Workbook workbook = null;
		try {
			// 打开excel HSSGWorkbook--.xls
			workbook = new HSSFWorkbook(in);
		} catch (Exception e) {
			// 打开excel XSSFWorkbook--.xlsx
			workbook = new XSSFWorkbook(in);
		}
		//返回第一个sheet工作簿
		Sheet sheet = workbook.getSheetAt(0);
		// Gets the last row on the sheet 返回sheet的last行， 
		//last row contained n this sheet (0-based),  下标以0开始，总行数为 最大的下标 + 1
		int lastRowNum = sheet.getLastRowNum();
		//short representing the last logical cell in the row PLUS ONE,
		//or -1 if the row does not contain any cells.
		//返回-1表示没有cell，返回数字，则是cell的逻辑cell,就是长度
		int cellnum = sheet.getRow(0).getLastCellNum();
		System.out.println(lastRowNum);
		System.out.println(cellnum);

	};

	private String transformPath(String fileName)
			throws UnsupportedEncodingException {
		String path = "com/alison/poi/excel/" + fileName;
		//jdk下 识别 "/"字符
		//path = path.replaceAll("/", "\\\\");
		return path;
	}

}
