package com.example.calctransfer.Service;

import com.example.calctransfer.Entity.Note;
import com.example.calctransfer.Repository.NoteRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Component
public class ExcelExportService {

    @Autowired
    private NoteRepository noteRepository;

    //Notları excel dosyasına aktaran metot.
    public void exportNotesToExcel() {

        List<Note> notes = noteRepository.findAll();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("NoteAndUser");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Note ID");
        headerRow.createCell(1).setCellValue("Baslik");
        headerRow.createCell(2).setCellValue("Aciklama");
        headerRow.createCell(3).setCellValue("User ID");
        headerRow.createCell(4).setCellValue("Username");

        int rowNum = 1;
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(note.getId());
            row.createCell(1).setCellValue(note.getBaslik());
            row.createCell(2).setCellValue(note.getAciklama());
            row.createCell(3).setCellValue(note.getUser().getId());
            row.createCell(4).setCellValue(note.getUser().getUsername());
        }

        try (FileOutputStream fileOut = new FileOutputStream("notesusers.xlsx")) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("Veriler başarıyla Excel'e aktarıldı!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
