
## **Welcome to README-FILE 👋**
___
___



> *Below, I'm showing the details related to my Restaurant-Management-Service-SIGN-IN and SIGN-UP like Framework & Language used, Data flow(function used), Data Structure used in my Project and Summary.*

-  ## [**Framework and Language Used :**](#heading-ids) ##
___
- ### Framework :  **SpringBoot**
- ### Language : **Java**


## [**Data Flow**](#heading-ids) ##
___
- ## 1. **Controller (Admin, Order, User, FoodItem & AuthenticationToken):-** ##
> - **@GetMapping :-**  *getAllUsers()*
> - **@PostMapping :-** *signUpUser(),signInUser(), addOrder(), addOrders(), addFoodItems(), sigInAdmin(), signUpAdmin()*
> - **@PutMapping :-** *Not used*
> - **@DeleteMapping :-** *signOutUser(), signOutAdmin()*
> - **[Others Annotaion Used :-](#heading-ids)** *@RestController,@Autowired, @PathVariable, @RequestBody, @RequestParam, @RequestMapping, @Validated, @Valid*

- ## 2. **Services (Admin, Order, User, FoodItem & AuthenticationToken):-** ##
> - **Method Used :-**  *signUpUser(),findFirstByUserEmail(), encryptPassword(), signInUser(), findAll(), getAllUsers(), sendEmail(), delete(), save(), signOutUser(), addOrder(), existsById(), saveOrder(), addFoodItems(), authenticate(), findFirstByTokenValue(), equals(), sigInAdmin(), signUpAdmin()*
> - **[Others Annotaion Used :-](#heading-ids)** *@Service, @Autowired, @Transactional*
> - **[Others Class Used :-](#heading-ids)** *EmailHandler, PasswordEncrypter*

- ## 3. **Repository (Admin, Order, User, FoodItem & AuthenticationToken) :-** ##
> - **Method Used :-**  *extends the CrudRepository(T, ID), findFirstByUserEmail(), findFirstByTokenValue(), findFirstByUserAuthToken(), findFirstByAdminEmail()*
> - **[Others Annotaion Used :-](#heading-ids)** *@Repository, @Autowired*

- ## 4. **DataBase Design:-** ##
> - **Database Used :-**  *SQL/Hibernate Database using*


- ## 5. **Model / Entity(Admin, Order, User, FoodItem & AuthenticationToken):-** ##
> - **Annotation Used :-**  *@Data, @NoArgsConstructor, @AllArgsConstructor, @Id, @OneToOne, @Column, @JoinColumn, @Entity, @GeneratedValue, @NotNull, @NotBlank, @ManyToOne, @OneToMany, @ManyToMany, @JoinTable, @Enumerated, @Pattern, @JsonIdentityInfo, @Min, @Max, @Table, @Size, @DecimalMin*
> - **[Others Class Used :-](#heading-ids)** *SignIbInput, SignUpOutput*

## [**Data Structure used in my Project**](#heading-ids) ##
____
> - **[Used :-](#heading-ids)** *SQL Database --> But Mostly used Java Concept, oops, collection, ENUM*

## [**Project Summary**](#heading-ids) ##
____
> - **[Aim :-](#heading-ids)** *This is basically good project for learning purpose springBoot basics, Mapping, sign-in, sign-up, sign-out, Annotation, API, spring mvc and CRUD Operation, crud Repository inbuilt method, and Custom Finder and Custom Query. In this project i just add Admin, add Order, get Admin, remove Order, get Users, a lot of things i learned from this project.*

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

This project is [Restaurant-Management-Service-API(SIGN-IN, SIGN-UP, SIGN-OUT)](https://choosealicense.com/licenses/mit/) licensed.

___
*This README was generated with* 🧡 *by [readme-md-generator](https://www.makeareadme.com/)*









