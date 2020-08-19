package com.infosupport.springframework.basis.app.services;

public class WorkerBeanInNeedOfPrinterService {

    private PrinterService printerService;

    public void doSomeWork(){
        printerService.printMessage("Start doing work");
        //do some work
        printerService.printMessage(("Finished doing work"));
    }

    public void setPrinter(PrinterService printer) {
        this.printerService=printer;
    }
}
