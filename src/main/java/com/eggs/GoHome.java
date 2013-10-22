package com.eggs;

import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoHome {

    private Logger logger = LoggerFactory.getLogger(GoHome.class);
    private static final String GOHOME_MSG = "gohome.msg";
    private static final String GOHOME_DATE = "gohome.date";
    private static final String GOHOME_DATE_FORMAT = "gohome.date.format";
    private static final String GOHOME_PROPERTIES = "gohome.properties";

    private ResourceBundle bundle = PropertyResourceBundle.getBundle("messages", Locale.ENGLISH);
    private Properties props = new Properties();

    public GoHome() {
        Locale locale = Locale.getDefault();
        logger.info("default LOCAL: {}", locale);
        
        bundle = PropertyResourceBundle.getBundle("messages", locale);
        try {
            props.load(GoHome.class.getClassLoader().getResourceAsStream(GOHOME_PROPERTIES));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
    
    
    public static void main(String[] args) throws Exception {
        GoHome go = new GoHome();
        go.printMessages();
    }


    private void printMessages() {
        System.out.println(bundle.getString("gohome.welcome"));
        System.out.println(getLocalSpecificMsg(bundle));
        System.out.println(bundle.getString("gohome.bye"));
    }

    private String getLocalSpecificMsg(ResourceBundle bundle) {
        MessageFormat fmt = new MessageFormat(bundle.getString("gohome.msg"));
        Object[] objs = {getMinutesLeft()};
        return fmt.format(objs);
    }

    private Long getMinutesLeft() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(props.getProperty(GOHOME_DATE_FORMAT));
        Date gohome = new Date();
        try {
            gohome = sdf.parse(props.getProperty(GOHOME_DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long minutes = (gohome.getTime() - now.getTime()) / 60000;
        return minutes;
    }

}
