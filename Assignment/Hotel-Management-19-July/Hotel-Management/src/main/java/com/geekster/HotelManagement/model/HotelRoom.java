package com.geekster.HotelManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Room") // for table name changing
public class HotelRoom {

    @Id // it's use for primary key making
    private Long roomId;
    @Column(unique = true) // for making unique this column
    private Integer roomNumber;
    @Enumerated(EnumType.STRING) // it's use for giving the values in the h2 database bcz there is coming 0 and 1 by default it is to be ORDINAL so STRING
    private Type roomType;
    private Double roomPrice;
    @Column(name = "status") // for changing the name of column a/o we want
    private Boolean roomStatus;
}
