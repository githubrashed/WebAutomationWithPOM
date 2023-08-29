package com.orangehrmlive.pom.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadWriteExcelFile {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Official\\WebAutomationWithPOM\\src\\test\\resources\\TestData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheetAt(0); //getSheet("sheet1")

        /*int rows = sheet.getLastRowNum(); //get total row
        System.out.println("Total no of Row: " + rows);
        int cols = sheet.getRow(1).getLastCellNum(); //get total row
        System.out.println("Total no of Column under a row: " + cols);

        //Using For Loop -- Read row and column data
        for (int r = 0; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            for (int c = 0; c < cols; c++) {
                XSSFCell cell = row.getCell(c);
                switch (cell.getCellType()) { //get type of Cell
                    case STRING:
                        System.out.println(cell.getStringCellValue()); //get String value from cell
                        break;
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue()); //get Numeric value from cell
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue()); //get boolean value from cell
                        break;
                }
                System.out.println(" | ");
            }
            System.out.println();

        }*/

        //Iterating all rows by Iterator

        Iterator iterator = sheet.iterator();
        while (iterator.hasNext()) {
            XSSFRow row = (XSSFRow) iterator.next();
            Iterator cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                XSSFCell cell = (XSSFCell) cellIterator.next();
                switch (cell.getCellType()) { //get type of Cell
                    case STRING:
                        System.out.println(cell.getStringCellValue()); //get String value from cell
                        break;
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue()); //get Numeric value from cell
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue()); //get boolean value from cell
                        break;
                }
                System.out.println(" | ");

            }
        }
    }
}


