package org.activities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity15 {
    static String userDir = System.getProperty("user.dir");
    static String filePath = userDir + "\\src\\test\\resources\\TestSheet.xlsx";

    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Datatypes");
        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };
        int rowIndex = 0;
        int colIndex = 0;
        System.out.println("Creating excel");


        for (Object[] datatype: datatypes) {
            Row row = sheet.createRow(rowIndex++);
            for (Object field: datatype) {
                Cell cell = row.createCell(colIndex++);
                if (field instanceof String){
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try{
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
