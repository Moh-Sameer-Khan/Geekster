package com.geekster.CreatingObjectsMailIntegration.MyControllers;

import com.geekster.CreatingObjectsMailIntegration.MyObjects.MyObject;
import org.geekster.MailHandler;
//import org.geekster.Main;
//import javax.mail.*;
//import org.geekster.MailMetaData;
//import org.geekster.CustomizeMailAuthentication;
import org.geekster.Sub;
import com.geekster.CreatingObjectsMailIntegration.MyObjects.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.geekster.MailHandler.*;

// if im calling API name then spring scan the all class where is available RestController-->create obj type of controller and then search method  -- > serach by name who in parameter pass in port
@RestController // it's also create an object of this class
public class EmployeeController {
    @Autowired // dependency Injection // it's intent to make an object who is Bean created
    @Qualifier("emp1") /// its use for initalize a specific object by passing parameter
    Employee e;

    //    @GetMapping --> use for Get the data by Fetching API type of GET
    @GetMapping("nameEmp1")
    public String getEmployeeName() {
        System.out.println("Get Mapping Working!!"); // it will show in console not in Browser
        return e.getName();  // it will be show in Browser by api fetching

    }
    @GetMapping("test")
    public String getSomething() {
        return "Ohh. GetMapping Working Thanks!!";
    }

//        for sending Mail Integration
//        getmapping will be search for get type of search on post man and basically will get the output for us

    @Autowired
    private MyObject myObjects;

    public static Sub email;

    @GetMapping("Objects")
    public String getObjects() {
        //        Use the Created Objects
                String myObjectAsString = myObjects.toString();
        email.setsub(myObjectAsString);
        MailHandler mailHandler = new MailHandler();
        mailHandler.sendMail();

        return myObjectAsString;
    }
}
