package com.infosupport.springframework.basis.app.configuration;

import com.infosupport.springframework.basis.app.services.ConsolePrinterService;
import com.infosupport.springframework.basis.app.services.NameFactory;
import com.infosupport.springframework.basis.app.services.PrinterService;
import com.infosupport.springframework.basis.app.services.WorkerBeanInNeedOfPrinterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class SpringBeanDefinitions {

    @Bean("colourprinter")
    @Scope(scopeName = "singleton")
    public PrinterService getColourPrinterService(){
        return new ConsolePrinterService();
    }
    @Bean("kamerprinter")
    @Scope(scopeName = "prototype")
    public PrinterService getBlackWhitePrinterService(){
        return new ConsolePrinterService();
    }
    @Bean
    public WorkerBeanInNeedOfPrinterService getWorkerBean(){
        WorkerBeanInNeedOfPrinterService worker = new WorkerBeanInNeedOfPrinterService();
        worker.setPrinter(getColourPrinterService());
        return worker;
    }

    @Bean
    public NameFactory getNameFactory(){
        return new NameFactory();
    }

    @Bean
    public List<String> getNames(NameFactory nameFactory){
        return nameFactory.getNames();
    }
}
