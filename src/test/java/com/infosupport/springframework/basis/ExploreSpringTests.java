package com.infosupport.springframework.basis;

import com.infosupport.springframework.basis.app.services.ConsolePrinterService;
import com.infosupport.springframework.basis.app.services.WorkerBeanInNeedOfPrinterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ExploreSpringTests {
    ApplicationContext applicationContext;
    @BeforeEach
    void setUp(){
         applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
    }
    @Test
    void startenVanDeSpringContainerAKASpringContext() {

        assertThat(applicationContext).isNotNull();
    }

    @Test
    void traditioneleAanpakZonderContainerOfAKAApplicationContext() {
        ConsolePrinterService printer = new ConsolePrinterService();
        WorkerBeanInNeedOfPrinterService worker = new WorkerBeanInNeedOfPrinterService();
        worker.setPrinter(printer);
        worker.doSomeWork();
    }

    @Test
    void getASpringPrinterFromTheContext() {
        ConsolePrinterService printer = applicationContext.getBean(ConsolePrinterService.class);
        ConsolePrinterService consoleprinter = (ConsolePrinterService) applicationContext.getBean("consoleprinter");
        printer.printMessage("Hello springcontext");
        consoleprinter.printMessage("Hello springcontext");

    }

    @Test
    void getWorkerBeanWithDependencyFromTheContext() {
        WorkerBeanInNeedOfPrinterService worker = applicationContext.getBean(WorkerBeanInNeedOfPrinterService.class);
        worker.doSomeWork();
    }
}
