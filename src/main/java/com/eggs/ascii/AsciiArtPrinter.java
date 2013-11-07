package com.eggs.ascii;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.eggs.domain.Food;
import com.eggs.domain.Menu;
import com.eggs.interfaces.BaseMenuPrinter;
import com.eggs.interfaces.MenuRepository;
import com.github.lalyos.jfiglet.FigletFont;

@Component
@Qualifier("ascii")
public class AsciiArtPrinter extends BaseMenuPrinter {

    private Logger logger = LoggerFactory.getLogger(AsciiArtPrinter.class);
    
    @Autowired
    private ApplicationContext ctx;
    // shadow,lean,standard,starwars,speed,shadow,nipples,lean,big,
    private String font = "doom";

    public AsciiArtPrinter(MenuRepository menuRepository) {
        super(menuRepository);
    }
    
    private String getAsciiText(String msg) {
        return FigletFont.convertOneLine(msg);
    }

    @Override
    protected void printSingleMenu(Menu menu) {
        String name = menu.getRestaurant().getName();
        System.out.println(getAsciiText(name));
        
        System.out.println(menu.getRestaurant().getAddress());
        
        String nameHeader = ctx.getMessage("header.name", new Object[0], Locale.getDefault());
        String priceHeader = ctx.getMessage("header.price", new Object[0],  Locale.getDefault());

        System.out.format(" %-20s | %10s %n", nameHeader, priceHeader);
        
        for (Food food : menu.getFoodList()) {
            System.out.format(" %-20s | %10.2f %n", food.getName(), food.getPrice());
        }
    }
    public String getFont() {
        return font;
    }
    public void setFont(String font) {
        this.font = font;
    }

}
