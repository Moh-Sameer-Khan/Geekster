
## **Welcome to README-FILE 👋**
___
___



> *Below, I'm showing the details related to my Student-Portal-mapping project like Framework & Language used, Data flow(function used), Data Structure used in my Project and Summary.*

-  ## [**Framework and Language Used :**](#heading-ids) ##
___
- ### Framework :  **SpringBoot**
- ### Language : **Java**


## [**Data Flow**](#heading-ids) ##
___
- ## 1. **Controller (Student ,Address, Course, Laptop & Book):-** ##
> - **@GetMapping :-**  *getStudentByName(), getBookByBookAuthor(), getAddressByZipCode(), getLaptopByBrand(), getCourseByCourseId()*
> - **@PostMapping :-** *addCourse(),addAddress(), addStudent(), addBook(), addLaptop()*
> - **@PutMapping :-** *updateCourseInfoByCourseName(), updateLaptopInfoByBrand(), updateBookInfoByBookAuthor(), updateAddressInfoByCountry(), updateStudentInfoByDept()*
> - **@DeleteMapping :-** *removeAllStudentsByDept(), removeAllAddressById(), removeAllBooksByBookAuthor(), removeAllLaptopByBrand(), removeAllCoursesByCourseDuration()*
> - **[Others Annotaion Used :-](#heading-ids)** *@RestController,@Autowired, @PathVariable, @RequestBody, @RequestParam, @RequestMapping, @Valid, @Validated*

- ## 2. **Services (Student ,Address, Course, Laptop & Book):-** ##
> - **Method Used :-**  *addAddress(),getAddressByZipCode(), updateAddressInfoByCountry(), findAll(), removeAddressById(), findById(), deleteById(), updateBookInfoByBookAuthor(), save(), addBook(), getAllBooksByBookAuthor(), removeAllBooksByBookAuthor(), addCourse(), getCourseByCourseId(), updateCourseInfoByCourseName(), removeAllCoursesByCourseDuration(), addLaptop(), removeAllLaptopByBrand(), updateLaptopInfoByBrand(), getLaptopByBrand(), addStudent(), getStudentByName(), updateStudentInfoByDept(), removeAllStudentsByDept()*
> - **[Others Annotaion Used :-](#heading-ids)** *@Service, @Autowired, @Transactional*

- ## 3. **Repository (Student ,Address, Course, Laptop & Book) :-** ##
> - **Method Used :-**  *extends the CrudRepository(T, ID), findByAddressZipCode(), updateAddressInfoByCountry(), findByBookAuthor(), updateBookInfoByBookAuthor(), removeAllBooksByBookAuthor(), removeAllCoursesByCourseDuration(), updateCourseInfoByCourseName(), findByLaptopBrand(), updateLaptopInfoByBrand(), removeAllLaptopByBrand(), findByStudentName(), updateStudentInfoByDept(), removeAllStudentsByDept()*
> - **[Others Annotaion Used :-](#heading-ids)** *@Repository, @Modifying, @Query*

- ## 4. **DataBase Design:-** ##
> - **Database Used :-**  *SQL/Hibernate Database using*


- ## 5. **Model / Entity(Student ,Address, Course, Laptop & Book):-** ##
> - **Annotation Used :-**  *@Data, @NoArgsConstructor, @AllArgsConstructor, @Id, @OneToOne, @Column, @JoinColumn, @Entity, @GeneratedValue, @Enumerated, @NotBlank, @Min, @Max, @ManyToMany, @ManyToOne*

## [**Data Structure used in my Project**](#heading-ids) ##
____
> - **[Used :-](#heading-ids)** *SQL Database --> But Mostly used Java Concept, oops, collection, ENUM*

## [**Project Summary**](#heading-ids) ##
____
> - **[Aim :-](#heading-ids)** *This is basically good project for learning purpose springBoot basics, Mappings, Annotation, API, spring mvc and CRUD Operation, crud Repository inbuilt method, and Custom Finder and Custom Query. In this project i just add Student, add Address, get Student, remove Student By Id, update Student, get Address by id , Address by id, Address delete, Address add, Address update by ID and State, a lot of things i learned from this project.*

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

This project is [Student-Portal-Mapping](https://choosealicense.com/licenses/mit/) licensed.

___
*This README was generated with* 🧡 *by [readme-md-generator](https://www.makeareadme.com/)*









