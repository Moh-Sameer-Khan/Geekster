package com.geekster.SpringbootAnnotation;

import com.geekster.SpringbootAnnotation.MyObjects.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfigurationAnnotation {
    //@component it's create an object automatic by spring using bean but now i'm making my object ... see below
//    Making an object who control myself so --> first use @configuration --> then @Bean on method
//    Here i want to make different-2 type of object in this class but yesterday class, we create an object of car type , not different-2 object
//    create a method that returns car object

// this bean without id / specific identity
//    @Bean  // if i write bean any method then spring automatic called that method and create an object as he wants on him demand

  @Bean("blue") // with specific id
//    @Bean
//    @Primary
    public Car getCarObject1() {  // step--1-runing
        System.out.println("Inside bean method getCarObject1.");
        return new Car("Blue"); ///step--2 --> go inside car class constructor then print that
    }

//    just check here method call or not but not making an object here
//    @Bean
//    public void getCarOb() {
//        System.out.println("It's a method who calling by bean");
//    }

//    @Bean // use and see bean and without bean how many object are creating
    @Bean("red") // with id
//    @Bean
//    @Primary
    public Car getCarObject2() {  //  step--1-runing
        System.out.println("Inside bean method getCarObject2.");
        return new Car("Red"); ///step--2 --> go inside car class constructor then print that
    }

}
