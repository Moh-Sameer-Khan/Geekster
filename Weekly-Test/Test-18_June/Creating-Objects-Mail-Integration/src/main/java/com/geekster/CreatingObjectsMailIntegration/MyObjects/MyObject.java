package com.geekster.CreatingObjectsMailIntegration.MyObjects;

import org.springframework.stereotype.Component;

public class MyObject {

        private String name;
        private  int sellary;

        public MyObject(String name, int sellary) {
            this.name = name;
            this.sellary = sellary;
        }

//        this value pass by the Postman in json form above both name and sellary
        @Override
        public String toString() {
            return "MyObject { " + " name = ' " + name + " '\'" + ", sellary = " + sellary  + '}';
        }
}
