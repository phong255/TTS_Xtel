package org.example;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class Main {
    private  static  final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        for (int i=0;i<10;i++){
            logger.error("Loi abcd " + i);
            logger.fatal("Loi abcd " + i);
            logger.debug("Loi abcd " + i);
            logger.info("hahahahahahahaha");
        }
    }
}