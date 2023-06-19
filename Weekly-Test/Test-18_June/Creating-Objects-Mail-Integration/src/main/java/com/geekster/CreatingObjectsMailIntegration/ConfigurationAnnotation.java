package com.geekster.CreatingObjectsMailIntegration;

import com.geekster.CreatingObjectsMailIntegration.MyObjects.Employee;
import com.geekster.CreatingObjectsMailIntegration.MyObjects.MyObject;
import org.springframework.context.annotation.Bean;

// @configuratin using for controlling to making an objects from spring to in my our hands and create our choices objects
//@Configuration
@org.springframework.context.annotation.Configuration
public class ConfigurationAnnotation {

    @Bean("emp1") // if i writes @Bean above any method then spring automatic called that method and create an object as he wants on him demand
    public Employee getEmpObject1() {
        System.out.println("Inside Bean Method getEmpObject1..!");
        return new Employee("Sameer");
    }


    @Bean // // if i writes @bean above any method then spring automatic called that method and create an object as he wants on him demand
    public Employee getEmpObject2() {
        System.out.println("Inside Bean Method getEmpObject2..!");
        return new Employee("Subhaan");
    }


    //    for getting via Email to send message
    @Bean
    public MyObject myObj() {
        String name = "Sameer Khan";
        int sellary = 400000;
        return new MyObject(name, sellary);
    }
}
