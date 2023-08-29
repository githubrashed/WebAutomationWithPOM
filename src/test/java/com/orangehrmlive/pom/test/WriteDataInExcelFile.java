package com.orangehrmlive.pom.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataInExcelFile {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");
        Object[][] empData =
                {
                        {"EmpId", "Name", "Job"},
                        {101, "David", "Engineer"},
                        {103, "Scott", "Analyst"}
                };
        //Using For Loop
        int rows = empData.length;
        int clos = empData[0].length;
        System.out.println(rows); //total rows
        System.out.println(clos); //total columns
        for (int r = 0; r < rows; r++) {
            XSSFRow row = sheet.createRow(r);
            for (int c = 0; c < clos; c++) { // 0 column
                XSSFCell cell = row.createCell(0);
                Object value = empData[r][c];
                if (value instanceof String) cell.setCellValue((Integer) value);
                if (value instanceof String) cell.setCellValue((Boolean) value);
                if (value instanceof String) cell.setCellValue((String) value);
            }
        }

        String filePath = ".\\dataFiles\\employee.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();
        System.out.println("Data Written successfully in desired excel file");

    }
}
