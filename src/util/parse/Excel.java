package util.parse;

import java.io.File;
import java.io.IOException;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Excel {

	private Workbook book;

	public Excel(String filePath) {
		try {
			this.book = Workbook.getWorkbook(new File(filePath));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Sheet getSheetByName(String sheetName) {
		return this.book.getSheet(sheetName);
	}

	/**
	 * 读取单元格内容
	 * @param sheet
	 * @param rowIndex 单元格行的索引值
	 * @param columnIndex 单元格列的索引值
	 * */
	public String getCellContent(Sheet sheet,int rowIndex,int columnIndex) {
		return sheet.getCell(columnIndex, rowIndex).getContents();
	}

}