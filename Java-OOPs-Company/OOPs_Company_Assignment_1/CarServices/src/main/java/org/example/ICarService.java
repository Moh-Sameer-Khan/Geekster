package org.example;

import java.util.HashMap;

public interface ICarService {
    HashMap<String, Pair> getServicePrices();


    public int basicService();

    public int engineFixing();

    public int clutchFixing();

    public int brakeFixing();

    public int gearFixing();

}
