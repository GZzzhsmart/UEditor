package com.ht.poi;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ContactWriter {

    @Test
    public void testWriteContact() {
        writeContact("d:/a.xls");
    }

    public void writeContact(String path) {
        HSSFWorkbook workbook = new HSSFWorkbook(); // 保存在内存中的一个工作薄
        HSSFSheet hssfSheet = workbook.createSheet("1601班的通讯录");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCell = hssfRow.createCell(0);
        hssfCell.setCellValue("通讯录");
        try {
            workbook.write(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
