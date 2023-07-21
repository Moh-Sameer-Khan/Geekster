
## **Welcome to README-FILE 👋**
___
___

# [**Hotel-Management**](#heading-ids) 

> *Below, I'm showing the details related to my Hotel-Management project like Framework & Language used, Data flow(function used), Data Structure used in my Project and Summary.*

-  ## [**Framework and Language Used :**](#heading-ids) ##
___
- ### Framework : **SpringBoot**
- ### Language : **Java, MySQL**
- ### Others : **Java Persistence API (JPA), Swagger UI**

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
- ### 1. **Controller (Hotel-Room):-** ###
> - **Room Controller :-**  
> 1. `POST /room` - *Create a new hotel room.*
> 2. `GET /rooms` - *Get the all list of hotel rooms*
> 3. `POST /rooms/addRooms` - *Adding the multiple rooms at a time*
> 4. `GET /rooms/{roomId}` - *Get the One hotel room by Room ID*
> 5. `GET /rooms/{roomId}/exists` - *Get the room exist or not*
> 6. `GET /rooms/counts` - *Get the Total Room in the Hotel*
> 7. `DELETE /rooms/{roomId}` - *Delete the room from list if that room is not available*
> 8. `DELETE /rooms` - *Delete all rooms if not available at a time*
> 9. `UPDATE /rooms/updateById/{roomId}/{type}` - *Update the room information by any id who exist*
> 10. `GET /rooms/status/{status}` - *Get the room status means that is available or not*
> 11. `GET /rooms/status/{status}/type/{type}` - *Get the room type Ac Or Not-Ac by Status*
> 12. `GET /rooms/status/{status}/type/{type}/priceRange` - *Get the room By Range of price by type of room*
> 13. `GET /rooms/type/{roomType}` - *Get the All room list in descending order by type of room*
> 14. `GET /ooms/type1/{roomType1}/type2/{roomType2}` - *Get the all list rooms by type of room*


- ### 2. **DataBase Design:-**  ###
> - **Database Used :-**  *SQL/Hibernate Database using*


- ### 3. **Model / Entity(User, Post, AuthenticationToken):-** ###
> - **Annotation Used :-**  *@Data, @NoArgsConstructor, @AllArgsConstructor, @Id, @Column, @JoinColumn, @Entity, @GeneratedValue, @Enumerated, @NotBlank, @Min, @Max, @Table*

## [**Data Structure used in my Project**](#heading-ids) ##
____
> - **[Used :-](#heading-ids)** *SQL Database --> But Mostly used Java Concept, oops, collection, ENUM*

## [**Security**](#heading-ids) ##
____
*Not used here*

## [**Encryption**](#heading-ids) ##
____
*Not used here*


## [**Project Summary**](#heading-ids) ##
____
> - **[Aim :-](#heading-ids)** *This is basically good project for learning purpose springBoot basics, Annotation, API, spring mvc and CRUD Operation, crud Repository inbuilt method, and Custom Finder and Custom Query. In this project i just add Rooms, get all Rooms a particular room,  update room inforamtion lot of things i learned from this project.*

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

This project is [Hotel-Management](https://choosealicense.com/licenses/mit/) licensed.

___
*This README was generated with* 🧡 *by [readme-md-generator](https://www.makeareadme.com/)*









