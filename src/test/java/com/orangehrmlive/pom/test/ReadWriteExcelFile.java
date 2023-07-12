package com.orangehrmlive.pom.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadWriteExcelFile {

    File file = new File("D:\\Official\\WebAutomationWithPOM\\src\\test\\resources\\TestData.xlsx");
    FileInputStream fileInputStream = new FileInputStream(file);
    XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
    XSSFSheet sh = wb.getSheet("sheet1");

    public ReadWriteExcelFile() throws IOException {
    }

}
