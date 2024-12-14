package api.utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    @DataProvider(name = "ExcelData")
    public Object[][] getDataFromExcel() throws IOException {
        // Define the file path for the Excel file
        String path = System.getProperty("user.dir") + "//testdatafile//userdata.xlsx";

        // Specify the sheet name
        String sheetName = "Sheet1";

        // Initialize the XlUtilities object
        XlUtilities xl = new XlUtilities(path);

        // Get row and cell counts
        int rowCount = xl.getRowCount(sheetName);
        int cellCount = xl.getCellCount(sheetName, 0);

        // Initialize a 2D Object array to hold the data
        Object[][] data = new Object[rowCount][cellCount];

        // Loop through rows and columns to fetch data
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < cellCount; j++) {
                data[i][j] = xl.getCellData(sheetName, i, j);
            }
        }

        return data;
    }
    
    @DataProvider(name = "ExcelData")
    public Object[][] getDataFromExcel1() throws IOException {
        // Define the file path for the Excel file
        String path = System.getProperty("user.dir") + "//testdatafile//userdata.xlsx";

        // Specify the sheet name
        String sheetName = "Sheet1";

        // Initialize the XlUtilities object
        XlUtilities xl = new XlUtilities(path);

        // Get row and cell counts
        int rowCount = xl.getRowCount(sheetName);
        int cellCount = xl.getCellCount(sheetName, 0);

        // Initialize a 2D Object array to hold the data
        Object[][] data = new Object[rowCount][cellCount];

        // Loop through rows and columns to fetch data
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < cellCount; j++) {
                data[i][j] = xl.getCellData(sheetName, i, j);
            }
        }

        return data; // Ensure to return the populated data array
    }

}
