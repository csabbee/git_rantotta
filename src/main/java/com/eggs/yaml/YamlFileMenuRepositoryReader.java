package com.eggs.yaml;

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
import com.eggs.domain.MenuRepository;

@Component
@Qualifier("yaml")
public class YamlFileMenuRepositoryReader implements MenuRepository {

    private String yamlFileName;
    private Logger logger = LoggerFactory.getLogger(getClass());

    List<Menu> menus = new ArrayList<Menu>();
    public YamlFileMenuRepositoryReader() {
        this("karcsi.yml");
    }
    
    public YamlFileMenuRepositoryReader(String yamlFileName) {
        this.yamlFileName = yamlFileName;
    }

    @PostConstruct
    public void read() {
        logger.debug("read() started ...");
        Constructor constructor = new Constructor(Menu.class);

        TypeDescription menuDescription = new TypeDescription(Menu.class);
        menuDescription.putListPropertyType("foods", Food.class);

        constructor.addTypeDescription(menuDescription);
        Yaml yaml = new Yaml(constructor);

        logger.info("reading YAML: " + yamlFileName);
        InputStream stream = getClass().getClassLoader().getResourceAsStream(yamlFileName);

        Menu menu = (Menu) yaml.load(stream);
        menus.add(menu);
    }

    public List<Menu> getAllmenu() {
        return menus;
    }

}
