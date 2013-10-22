package com.eggs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class GoHome {

    private static final String GOHOME_MSG = "gohome.msg";
    private static final String GOHOME_DATE = "gohome.date";
    private static final String GOHOME_DATE_FORMAT = "gohome.date.format";
    private static final String GOHOME_PROPERTIES = "gohome.properties";

    public static void main(String[] args) throws Exception {
        
        Properties props = new Properties();
        props.load(GoHome.class.getClassLoader().getResourceAsStream(GOHOME_PROPERTIES));
        
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(props.getProperty(GOHOME_DATE_FORMAT));
        Date gohome = sdf.parse(props.getProperty(GOHOME_DATE));
        
        long minutes = (gohome.getTime() - now.getTime()) / 60000;      
        String format = props.getProperty(GOHOME_MSG);
        System.out.println(msg + minutes);
    }

}
