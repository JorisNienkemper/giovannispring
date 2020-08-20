package com.infosupport.springframework.basis.app.services;

public class FilePrinterService implements PrinterService {
    @Override
    public void printMessage(String message) {
        System.out.println("message to file: " + message);
    }
}
