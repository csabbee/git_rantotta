package com.eggs;

import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.eggs.impl.ConsoleMenuPrinter;
import com.eggs.impl.CsvFileMenuRepositoryReader;
import com.eggs.impl.YamlFileMenuRepositoryReader;

public class App {
    private static Logger logger = Logger.getLogger(App.class);

    private static void printReader(MenuRepositoryReader reader) {
        ConsoleMenuPrinter printer = new ConsoleMenuPrinter(reader);

        printer.printMenus();
    }

    public static void main(String[] args) {

        if (args.length > 1) {
            SLF4JBridgeHandler.removeHandlersForRootLogger();
            SLF4JBridgeHandler.install();
        }

        String fileName = args[0];
        logger.info("reading menu from:" + fileName);

        ListableBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        
        MenuPrinter printer = factory.getBean(MenuPrinter.class);
        printer.printMenus();
        
        String[] beanNamse = factory.getBeanDefinitionNames();
        for (String name : beanNamse) {
            
            System.out.println("bean name:" + name);
            
        }
//        CsvFileMenuRepositoryReader csvReader = new CsvFileMenuRepositoryReader("karcsi", "marcello");
//        YamlFileMenuRepositoryReader yamlReader = new YamlFileMenuRepositoryReader(fileName);
//
//        printReader(csvReader);
//        printReader(yamlReader);
    }
}
