package top.zzh.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import top.zzh.bean.Contact;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContactWriter {

    private static Boolean isNewVersion = true;

    public static void writeExcel(String path, List<Contact> contactList) throws IOException {
        if (path.endsWith(".xls")) {
            writeExcel(path, ".xls", contactList);
        } else if (path.endsWith(".xlsx")) {
            writeExcel(path, ".xlsx", contactList);
        }
    }

    public static void writeExcel(String path, String ext, List<Contact> contactList) throws IOException {
        Workbook workbook = null;
        if (".xls".equalsIgnoreCase(ext)) {
            isNewVersion = false;
            workbook = new HSSFWorkbook();
        } else if (".xlsx".equalsIgnoreCase(ext)) {
            workbook = new XSSFWorkbook();
        }
        if (workbook != null) {
            Sheet sheet = workbook.createSheet("Sheet1");
            writeTitle(sheet, "****公司员工通讯录");
            writeHeader(sheet, new String[]{"编号", "姓名", "头像", "手机号", "性别", "生日"});
            writeContent(sheet, contactList);
            workbook.write(new FileOutputStream(path));
            workbook.close();
        }
    }

    private static void writeTitle(Sheet sheet, String title) {
        Workbook workbook = sheet.getWorkbook();
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight((short) 280);
        cellStyle.setFont(font);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(title);
    }

    private static void writeHeader(Sheet sheet, String[] columnNames) {
        Workbook workbook = sheet.getWorkbook();
        Row row = sheet.createRow(1);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        Font font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);
        for (int col = 0, len = columnNames.length; col < len; col++) {
            Cell cell = row.createCell(col);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(columnNames[col]);
        }
    }

    private static void writeContent(Sheet sheet, List<Contact> contactList) {
        Workbook workbook = sheet.getWorkbook();
        CellStyle evenRowStyle = workbook.createCellStyle();
        evenRowStyle.setFillBackgroundColor(IndexedColors.GOLD.index);
        evenRowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        CellStyle oddRowStyle = workbook.createCellStyle();
        oddRowStyle.setFillBackgroundColor(IndexedColors.GREEN.index);
        oddRowStyle.setFillPattern(FillPatternType.SQUARES);
        // 隐藏列
        // sheet.setColumnHidden(0, true);
        for (int row = 2, totalRows = contactList.size() + 2; row < totalRows; row++) {
            Contact contact = contactList.get(row - 2);
            Row rowData = sheet.createRow(row);
            // 隐藏行
            // rowData.setZeroHeight(true);
            rowData.createCell(0).setCellValue(contact.getId());
            rowData.createCell(1).setCellValue(contact.getName());
            Cell cell2 = rowData.createCell(2);
            // drawPicture(sheet, "src/main/resources/pic.PNG", row, 2);
            insertPicture(sheet, "src/main/resources/pic.PNG", 0, 0, 300, 300,
                    row, 2, row + 1, 3);
            sheet.setColumnWidth(3, 5000);
            rowData.createCell(3).setCellValue(contact.getPhone());
            rowData.createCell(4).setCellValue(contact.getGender());
            sheet.setColumnWidth(5, 5000);
            Cell cell = rowData.createCell(5);
            CreationHelper creationHelper = workbook.getCreationHelper();
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy/MM/dd"));
            cell.setCellStyle(cellStyle);
            cell.setCellValue(contact.getBirthday());
            /** 不推荐使用设置行style的方式来设置填充色
            if (row % 2 == 0) {
                rowData.setRowStyle(evenRowStyle);
            } else {
                rowData.setRowStyle(oddRowStyle);
            }
             */
        }
    }

    private static void drawPicture(Sheet sheet, String imagePath, int row, int col) {
        try {
            Workbook workbook = sheet.getWorkbook();
            byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(imagePath));
            int picIdx = workbook.addPicture(imageBytes, Workbook.PICTURE_TYPE_PNG);
            CreationHelper creationHelper = workbook.getCreationHelper();
            ClientAnchor clientAnchor = creationHelper.createClientAnchor();
            clientAnchor.setRow1(row);
            clientAnchor.setCol1(col);
            Drawing drawing = sheet.createDrawingPatriarch();
            Picture picture = drawing.createPicture(clientAnchor, picIdx);
            picture.resize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在指定工作表的指定位置插入图片
     * @param sheet 工作表
     * @param imagePath 图片路径
     * @param leftDX 图片在单元格中离左上角的x距离
     * @param topDY 图片在单元格中离左上角的y距离
     * @param widthDX 图片的宽度
     * @param heightDY 图片的高度
     * @param beginRow 图片开始的行
     * @param beginCol 图片开始的列
     * @param endRow 图片结束的行
     * @param endCol 图片结束的列
     */
     public static void insertPicture(Sheet sheet, String imagePath,
                              int leftDX, int topDY, int widthDX ,int heightDY,
                              int beginRow, int beginCol, int endRow, int endCol) {
        Workbook workbook = sheet.getWorkbook();
        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor clientAnchor = workbook.getCreationHelper().createClientAnchor();
        clientAnchor.setDx1(leftDX);
        clientAnchor.setDy1(topDY);
        clientAnchor.setDx2(widthDX);
        clientAnchor.setDy2(heightDY);
        clientAnchor.setRow1(beginRow);
        clientAnchor.setCol1(beginCol);
        clientAnchor.setRow2(endRow);
        clientAnchor.setCol2(endCol);
        try {
            drawing.createPicture(clientAnchor,
                    workbook.addPicture(IOUtils.toByteArray(new FileInputStream(imagePath)), Workbook.PICTURE_TYPE_PNG));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact(1, "Mr 1", "18888888888", "Male", Calendar.getInstance().getTime()));
        contactList.add(new Contact(2, "Mr 2", "18888888888", "Male", Calendar.getInstance().getTime()));
        writeExcel("src/main/resources/c.xlsx", contactList);
    }

}
