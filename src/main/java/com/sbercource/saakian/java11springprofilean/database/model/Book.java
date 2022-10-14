package com.sbercource.saakian.java11springprofilean.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Integer id;
    private String author;
    private String title;
    private String date;
}
