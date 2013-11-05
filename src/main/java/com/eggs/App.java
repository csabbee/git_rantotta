package com.eggs;

import java.applet.AppletContext;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.omg.CORBA.portable.ApplicationException;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        
        MenuPrinter printer = ctx.getBean(MenuPrinter.class);
        printer.printMenus();        
    }
}
