package com.geekster.CreatingObjectsMailIntegration.MyObjects;

public class MyObjects {

        private String name;
        private  int sellary;

        public MyObjects(String name, int sellary) {
            this.name = name;
            this.sellary = sellary;
        }
        //    @Override
        public String covertToString() {
            return "MyObject { " + " name = ' " + name + " '\'" + ", sellary = " + sellary  + '}';
        }
}
