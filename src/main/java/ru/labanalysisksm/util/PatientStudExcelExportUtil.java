package ru.labanalysisksm.util;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.labanalysisksm.models.entities.PatientStud;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class PatientStudExcelExportUtil {
    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private final List<PatientStud> patientStudList;

    public PatientStudExcelExportUtil(List<PatientStud> patientStudList) {
        this.patientStudList = patientStudList;
        workbook = new XSSFWorkbook();
    }

    private void createCells(Row row, int columnCount, Object value, CellStyle cellStyle) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof LocalDate) {
            cell.setCellValue((LocalDate) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(cellStyle);
    }

    private void createHeaderRow() {
        //Титул
        sheet = workbook.createSheet("КСМ Студенты");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(11);
        style.setFont(font);
        createCells(row, 0, """
                Реестр выполненных анализов лабораторией Клиники №1 ВолГМУ
                за период с 2022-11-01 по 2022-11-30 по контрагенту
                КСМ (иностр) по всем типам финансирования\s""", style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 10));
        font.setFontHeightInPoints((short) 10);
        //Заголовок
        row = sheet.createRow(1);
        font.setFontHeight(10);
        style.setFont(font);
        createCells(row, 0, "Дата", style);
        createCells(row, 1, "ФИО", style);
        createCells(row, 2, "Цитология", style);
        createCells(row, 3, "ВИЧ", style);
        createCells(row, 4, "Сифилис методом ИФА", style);
        createCells(row, 5, "Кал на кишеч группу", style);
        createCells(row, 6, "Гельминтологическое исследование фекалий на я/г", style);
        createCells(row, 7, "Исследование крови на гепатит В", style);
        createCells(row, 8, "Исследование крови на гепатит С", style);
        createCells(row, 9, "Серологическое исследование на брюшной тиф- Реакция Видаля", style);
        createCells(row, 10, "Всего", style);

    }

    private void writeCustomerData() {
        int rowCount = 2;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(10);
        style.setFont(font);
        for (PatientStud patientStud : patientStudList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCells(row, columnCount++, patientStud.getLocalDate(), style);
            createCells(row, columnCount++, patientStud.getPatientName(), style);
            createCells(row, columnCount++, patientStud.isCytologyTOR(), style);
            createCells(row, columnCount++, patientStud.isHivTOR(), style);
            createCells(row, columnCount++, patientStud.isSyphilisTOR(), style);
            createCells(row, columnCount++, patientStud.isCoroutineTOR(), style);
            createCells(row, columnCount++, patientStud.isHelminthTOR(), style);
            createCells(row, columnCount++, patientStud.isHepatitisBTOR(), style);
            createCells(row, columnCount++, patientStud.isHepatitisCTOR(), style);
            createCells(row, columnCount++, patientStud.isVidalTOR(), style);
            createCells(row, columnCount++, patientStud.getSum(), style);
        }
    }

    public void exportDataToExcel(HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            createHeaderRow();
            writeCustomerData();
            workbook.write(outputStream);
        } finally {
            assert outputStream != null;
            outputStream.close();
            workbook.close();
        }
    }
}

