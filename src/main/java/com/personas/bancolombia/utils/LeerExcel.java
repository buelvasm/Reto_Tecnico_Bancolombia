package com.personas.bancolombia.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerExcel {
    private XSSFWorkbook libro;
    private FileInputStream file;
    //Clase que contiene metodo lectura archivo excel donde se encuentran los datos
    public String leerDatosExcel (String ruta,String hoja, int rowValue, int cellValue) throws IOException {
        String valor = null;
        file = new FileInputStream(new File(ruta));
        libro = new XSSFWorkbook(file);
        Sheet sheet = libro.getSheet(hoja);
        Row row = sheet.getRow(rowValue);
        Cell cell = row.getCell(cellValue);
        valor=cell.getStringCellValue();
        libro.close();
        file.close();
        return valor;
    }
}
