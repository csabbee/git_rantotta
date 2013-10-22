package com.eggs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoHome {

    public static void main(String[] args) throws ParseException {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date gohome = sdf.parse("2013-10-22 17:00");
        
        long minutes = (gohome.getTime() - now.getTime()) / 60000;        
        System.out.println("minutes till gohome: " + minutes);
    }

}
