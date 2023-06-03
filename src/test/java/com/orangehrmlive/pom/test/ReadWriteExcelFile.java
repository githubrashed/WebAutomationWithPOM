package com.orangehrmlive.pom.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadWriteExcelFile {
    String excelFilePath = ".\\resources\\userpass.xlsx";
    FileInputStream fileInputStream = new FileInputStream(excelFilePath);
    XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

    public ReadWriteExcelFile() throws FileNotFoundException {
    }
}
