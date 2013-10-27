package com.eggs;

import java.io.IOException;
import java.util.Properties;

import com.gtranslate.Translator;

public class OnTheFlyTranslate {
	
	private Properties props = new Properties();
	private static final String OTFT_PROPERTIES = "translator.properties";
	private static final String OTFT_SOURCE = "translator.source";
	private static final String OTFT_DESTINATION = "translator.dest";
	
	private OnTheFlyTranslate(){
		try {
            props.load(OnTheFlyTranslate.class.getClassLoader().getResourceAsStream(OTFT_PROPERTIES));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	public static OnTheFlyTranslate getInstacne(){
		return new OnTheFlyTranslate();
	}
	
	public String translate(String textToBeTranslated){
		Translator translate = Translator.getInstance();
		return translate.translate(textToBeTranslated,props.getProperty(OTFT_SOURCE), props.getProperty(OTFT_DESTINATION));
	}
}
