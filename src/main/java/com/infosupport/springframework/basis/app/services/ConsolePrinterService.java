package com.infosupport.springframework.basis.app.services;

public class ConsolePrinterService implements PrinterService {
    @Override
    public void printMessage(String message){

        System.out.println("message to console: " + message);
    }
}
