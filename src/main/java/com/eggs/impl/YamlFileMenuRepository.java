package com.eggs.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.eggs.domain.Food;
import com.eggs.domain.Menu;
import com.eggs.interfaces.MenuPrinter;
import com.eggs.interfaces.MenuRepository;

@Component
@Qualifier("yaml")
public class YamlFileMenuRepository implements MenuRepository {

    private String yamlFileName;
    private Logger logger = LoggerFactory.getLogger(getClass());
    private List<Menu> menus = new ArrayList<Menu>();
    private MenuPrinter printer;
    
    public YamlFileMenuRepository(MenuPrinter printer) {
        this("menus.yml");
        this.printer = printer;
    }
    
    public YamlFileMenuRepository(String yamlFileName) {
        this.yamlFileName = yamlFileName;
    }

    @PostConstruct
    public void read() {
        logger.debug("read() started ...");
        Constructor constructor = new Constructor(YamlFileMenuRepository.class);
        TypeDescription menuRepoDescription = new TypeDescription(YamlFileMenuRepository.class);
        menuRepoDescription.putListPropertyType("menus", Menu.class);

        TypeDescription menuDescription = new TypeDescription(Menu.class);
        menuDescription.putListPropertyType("foods", Food.class);

        constructor.addTypeDescription(menuDescription);
        Yaml yaml = new Yaml(constructor);

        logger.info("reading YAML: " + yamlFileName);
        InputStream stream = getClass().getClassLoader().getResourceAsStream(yamlFileName);

        YamlFileMenuRepository menuRepo = (YamlFileMenuRepository) yaml.load(stream);
    }

    public List<Menu> getAllmenu() {
        return menus;
    }

}
