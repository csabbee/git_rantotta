package com.eggs;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.apache.log4j.Logger;
import org.slf4j.bridge.SLF4JBridgeHandler;

import com.eggs.impl.ConsoleMenuPrinter;
import com.eggs.impl.CsvFileMenuRepositoryReader;
import com.eggs.impl.YamlFileMenuRepositoryReader;
import com.eggs.jmx.BreakFastMBean;
import com.eggs.jmx.BreakFast;

public class App {
    private static Logger logger = Logger.getLogger(App.class);

    private static void printReader(MenuRepositoryReader reader) {
        ConsoleMenuPrinter printer = new ConsoleMenuPrinter(reader.read());

        printer.printMenus();
    }

    public static void main(String[] args) throws IOException {

        if (args.length > 1) {
            SLF4JBridgeHandler.removeHandlersForRootLogger();
            SLF4JBridgeHandler.install();
        }

        String fileName = args[0];

        CsvFileMenuRepositoryReader csvReader = new CsvFileMenuRepositoryReader("karcsi", "marcello");
        YamlFileMenuRepositoryReader yamlReader = new YamlFileMenuRepositoryReader(fileName);

        registerMbean(yamlReader.read());

        Scanner scanner = new Scanner(System.in);
        while (scanner.nextLine().charAt(0) != 'q') {
            logger.info("reading menu from:" + fileName);
    
            printReader(csvReader);
            printReader(yamlReader);
        }
    }

    private static void registerMbean(MenuRepository repo) {
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
            mbs.registerMBean(new BreakFast(repo), new ObjectName("com.eggs.mbeans:type=Breakfast"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
