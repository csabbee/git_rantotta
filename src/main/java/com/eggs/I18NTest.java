package com.eggs;


public class I18NTest {

    
    public static void main(String[] args) {
        System.out.println("\u00c1rv\u00edzt\u0171r\u0151 t\u00fck\u00f6rf\u00far\u00f3g\u00e9p");
        
        I18NTest app = new I18NTest();
        app.loop();
        
    }

    private void loop() {
        boolean notend = true;
        while(notend) {
            sleep();
            printSomething();
        }
        
    }

    private void printSomething() {
        System.out.println("ebed");
        
    }

    private void sleep() {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
