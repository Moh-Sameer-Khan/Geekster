
## **Welcome to README-FILE 👋**
___
___

# [**Doctor-App(Basic Design-SignIn, SignUp)**](#heading-ids) 

> *Below, I'm showing the details related to my Docor app  Basic Design project like Framework & Language used, Data flow(function used), Data Structure used in my Project and Summary.*

-  ## [**Framework and Language Used :**](#heading-ids) ##
___
- ### Framework : **SpringBoot**
- ### Language : **Java, MySQL**
- ### Others : **Java Persistence API (JPA), Swagger UI, Email**

-  ## [**Prerequisites :**](#heading-ids) ##
*To run this project, ensure that you have the following installed:*
> - Java Development Kit (JDK)
>- MySQL
>- Maven

-  ## [**Getting Started Use :**](#heading-ids) ##

1. Clone this repository to your local machine.
2. Set up your MySQL database and configure the connection details in the `application.properties` file.
3. Build the project using Maven: `mvn clean install`.
4. Run the application: `mvn spring-boot:run`.
5. Access Swagger UI in your browser at: `http://localhost:8080/swagger-ui.html`.

## [**Data Flow**](#heading-ids) ##

- ## [**Endpoints Used:**](#heading-ids) ##
___
- ### 1. **Controller (Doctor, Admin, Appointment, Pateint, AuthenticationToken):-** ###
> - **Patient Controller :-**  
> 1. `POST /patient/signUp` - *Create a new Patient with signUP.*
> 2. `POST /user/signIn` - *Authenticate and obtain a token for the patient and By Hashing Password and Using Email*
> 3. `GET /patients` - *Get the list of all patients*
> 4. `POST /patients/appointment/schedule` - *Uploading a schedule an authoize Patinet*

> - **Appointment Controller :-**  
> 1. `POST /appointment` - *Create a new appointment*

> - **Doctor Controller :-**  
> 1. `POST /doctor` - *Create a new doctor*

- ### 2. **DataBase Design:-** ###
> - **Database Used :-**  *SQL/Hibernate Database using*


- ### 3. **Model / Entity(Doctor, Admin, Appointment, Pateint, AuthenticationToken):-** ###
> - **Annotation Used :-**  *@Data, @NoArgsConstructor, @AllArgsConstructor, @Id, @OneToOne, @Column, @JoinColumn, @Entity, @GeneratedValue, @Enumerated, @NotBlank, @Min, @Max, @ManyToMany, @ManyToOne, @JsonIdentityInf, @OneToMany*

## [**Data Structure used in my Project**](#heading-ids) ##
____
> - **[Used :-](#heading-ids)** *SQL Database --> But Mostly used Java Concept, oops, collection, ENUM*

## [**Security**](#heading-ids) ##
____
*Authentication is implemented using an Authentication Token class. This token is generated upon successful sign-in and must be included in the headers of subsequent requests to authorized endpoints.*

## [**Encryption**](#heading-ids) ##
____
*Authentication is implemented using an Authentication Token class. This token is generated upon successful sign-in and must be included in the headers of subsequent requests to authorized endpoints.*


## [**Project Summary**](#heading-ids) ##
____
> - **[Aim :-](#heading-ids)** *This is basically good project for learning purpose springBoot basics, Mappings, Annotation, API, spring mvc and CRUD Operation, crud Repository inbuilt method, and Custom Finder and Custom Query. In this project i just add Patient, get all pateints, a particular Patient,  update Appointment inforamtion lot of things i learned from this project.*

## **[👨‍💻 Sameer](#heading-ids)** ##
____

- Twitter: [@Sameer.twitter](https://twitter.com/Sameerr1819)

- Github: [@Sameer-Github](https://github.com/Moh-Sameer-Khan)


🤝 **Contributing**
___
Contributions, Thanks to everyone , contributing with me and know about more myself [visit my profile](https://www.instagram.com/sameer181911/).

**Show Your Support**
___
Give a ⭐if this project helped you!

- ```bash
  BECOME A SOFTWARE DEVELOPER 👩‍💻

<!-- Here something icon -->

📝 **License**
___
Copyright © 2023 [Moh Sameer Khan](#heading-ids).

This project is [Doctor-App-Basic-Design](https://choosealicense.com/licenses/mit/) licensed.

___
*This README was generated with* 🧡 *by [readme-md-generator](https://www.makeareadme.com/)*









