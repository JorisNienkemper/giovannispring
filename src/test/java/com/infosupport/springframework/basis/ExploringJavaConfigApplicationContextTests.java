package com.infosupport.springframework.basis;

import com.infosupport.springframework.basis.app.configuration.SpringBeanDefinitions;
import com.infosupport.springframework.basis.app.services.PrinterService;
import com.infosupport.springframework.basis.app.services.WorkerBeanInNeedOfPrinterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ExploringJavaConfigApplicationContextTests {
    ApplicationContext applicationContext;
    @BeforeEach
    void setUp(){
        applicationContext  = new AnnotationConfigApplicationContext(SpringBeanDefinitions.class);
    }
    @Test
    void startDeApplicationContext() {

        PrinterService printer = applicationContext.getBean(PrinterService.class);
        printer.printMessage("Hello AnnotationConfigApplicationcontext!");
    }

    @Test
    void getWorkerBeanWithDependenceFromApplicationContext() {
        WorkerBeanInNeedOfPrinterService worker = applicationContext.getBean(WorkerBeanInNeedOfPrinterService.class);
        worker.doSomeWork();
    }

    @Test
    void getNamesFromApplicationContext() {
        List<String> names = (List<String>) applicationContext.getBean("getNames");
        for(String name:names){
            System.out.println(name);
        }
    }

    @Test
    void getColourPrinter() {
        PrinterService printer = applicationContext.getBean("colourprinter", PrinterService.class);
        printer.printMessage("Print in kleur");
    }
}
