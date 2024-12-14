package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtilities {

    FileInputStream f1;
    FileOutputStream fo;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    CellStyle style;
    String path;

    public XlUtilities(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        f1 = new FileInputStream(path);
        workbook = new XSSFWorkbook(f1);
        sheet = workbook.getSheet(sheetName);
        int rowcount = sheet.getLastRowNum();
        workbook.close();
        f1.close();
        return rowcount;
    }

    public int getCellCount(String sheetName, int rownum) throws IOException {
        f1 = new FileInputStream(path);
        workbook = new XSSFWorkbook(f1);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rownum);
        int cellcount = row.getLastCellNum();
        workbook.close();
        f1.close();
        return cellcount;
    }

    public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
        f1 = new FileInputStream(path);
        workbook = new XSSFWorkbook(f1);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rownum);
        cell = row.getCell(colnum);

        DataFormatter formatter = new DataFormatter();
        String data = formatter.formatCellValue(cell);

        workbook.close();
        f1.close();
        return data;
    }

    public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
        File xlfile = new File(path);

        if (!xlfile.exists()) {
            workbook = new XSSFWorkbook();
            fo = new FileOutputStream(path);
            workbook.write(fo);
        } else {
            f1 = new FileInputStream(path);
            workbook = new XSSFWorkbook(f1);
        }

        if (workbook.getSheetIndex(sheetName) == -1) {
            workbook.createSheet(sheetName);
        }

        sheet = workbook.getSheet(sheetName);

        if (sheet.getRow(rownum) == null) {
            sheet.createRow(rownum);
        }

        row = sheet.getRow(rownum);
        if (row.getCell(colnum) == null) {
            row.createCell(colnum);
        }

        cell = row.getCell(colnum);
        cell.setCellValue(data);

        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        f1.close();
        fo.close();
    }
}
