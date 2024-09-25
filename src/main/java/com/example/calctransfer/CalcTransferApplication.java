package com.example.calctransfer;

import com.example.calctransfer.Service.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalcTransferApplication implements CommandLineRunner {

    @Autowired
    private ExcelExportService excelExportService;

    public static void main(String[] args) {
        SpringApplication.run(CalcTransferApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        excelExportService.exportNotesToExcel();
    }
}
