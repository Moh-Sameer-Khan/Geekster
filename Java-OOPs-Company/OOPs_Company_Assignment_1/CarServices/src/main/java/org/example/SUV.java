package org.example;

import java.util.HashMap;

public class SUV implements ICarService {

    HashMap<String , Pair> hm = new HashMap<>();



    @Override
    public HashMap<String, Pair> getServicePrices() {
        hm.put("BS01" , new Pair("Basic Servicing" , 2000) );
        hm.put("EF01" , new Pair("Engine Fixing" , 5000) );
        hm.put("CF01" , new Pair("Clutch Fixing" , 2000) );
        hm.put("BF01" , new Pair("Brake Fixing" , 1000) );
        hm.put("GF01" , new Pair("Gear Fixing" , 3000) );
        return hm;
    }

    @Override
    public int basicService() {

        return hm.get("BS01").price;
    }

    @Override
    public int engineFixing() {

        return hm.get("EF01").price;
    }

    @Override
    public int clutchFixing() {

        return hm.get("CF01").price;
    }

    @Override
    public int brakeFixing() {

        return hm.get("BF01").price;
    }

    @Override
    public int gearFixing() {
        return hm.get("GF01").price;
    }
}