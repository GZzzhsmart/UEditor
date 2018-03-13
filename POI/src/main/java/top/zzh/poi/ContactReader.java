package top.zzh.poi;

import top.zzh.bean.Contact;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ContactReader {

    public static void main(String[] args) throws IOException {
        readExcel("src/main/resources/Contact.xlsx");
    }

    public static void readExcel(String path) throws IOException {
        if (path.endsWith(".xls")) {
            readExcel(path, ".xls");
        } else if (path.endsWith(".xlsx")) {
            readExcel(path, ".xlsx");
        }
    }

    public static void readExcel(String path, String ext) throws IOException {
        Workbook workbook = null;
        if (".xls".equalsIgnoreCase(ext)) {
            workbook = new HSSFWorkbook(new FileInputStream(path));
        } else if (".xlsx".equalsIgnoreCase(ext)) {
            workbook = new XSSFWorkbook(new FileInputStream(path));
        }
        if (workbook != null) {
            Sheet sheet = workbook.getSheet("Sheet1");
            for (int row = 1, lastRowNum = sheet.getLastRowNum(); row <= lastRowNum; row++) {
                Contact contact = new Contact();
                Row rowData = sheet.getRow(row);
                contact.setId((int) rowData.getCell(0).getNumericCellValue());
                contact.setName(rowData.getCell(1).getStringCellValue());
                contact.setPhone(rowData.getCell(2).getStringCellValue());
                contact.setGender(rowData.getCell(3).getStringCellValue());
                contact.setBirthday(rowData.getCell(4).getDateCellValue());
                System.out.println(contact);
            }
            workbook.close();
        }
    }

    public static void readXls() throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("src/main/resources/Contact.xls"));
        Sheet sheet = workbook.getSheet("Sheet1");
        for (int row = 1, lastRowNum = sheet.getLastRowNum(); row <= lastRowNum; row++) {
            Contact contact = new Contact();
            Row rowData = sheet.getRow(row);
            contact.setId((int) rowData.getCell(0).getNumericCellValue());
            contact.setName(rowData.getCell(1).getStringCellValue());
            contact.setPhone(rowData.getCell(2).getStringCellValue());
            contact.setGender(rowData.getCell(3).getStringCellValue());
            contact.setBirthday(rowData.getCell(4).getDateCellValue());
            System.out.println(contact);
        }
        workbook.close();
    }

    public static void readXlsx() throws IOException {
        Workbook workbook = new XSSFWorkbook(new FileInputStream("src/main/resources/Contact.xlsx"));
        Sheet sheet = workbook.getSheet("Sheet1");
        for (int row = 1, lastRowNum = sheet.getLastRowNum(); row <= lastRowNum; row++) {
            Contact contact = new Contact();
            Row rowData = sheet.getRow(row);
            contact.setId((int) rowData.getCell(0).getNumericCellValue());
            contact.setName(rowData.getCell(1).getStringCellValue());
            contact.setPhone(rowData.getCell(2).getStringCellValue());
            contact.setGender(rowData.getCell(3).getStringCellValue());
            contact.setBirthday(rowData.getCell(4).getDateCellValue());
            System.out.println(contact);
        }
        workbook.close();
    }

    public static void readPictures(Workbook workbook) throws IOException {
        List lst = workbook.getAllPictures();
        for (Iterator it = lst.iterator(); it.hasNext(); ) {
            PictureData pict = (PictureData)it.next();
            String ext = pict.suggestFileExtension();
            byte[] data = pict.getData();
            if (ext.equals("jpeg")){
                FileOutputStream out = new FileOutputStream("pict.jpg");
                out.write(data);
                out.close();
            }
        }
    }

}
