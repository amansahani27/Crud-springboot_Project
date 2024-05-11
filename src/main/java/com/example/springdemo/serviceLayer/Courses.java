package com.example.springdemo.serviceLayer;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class Courses {
    private String bookName;
    private int price;
    private String authorName;
    private int bookNo;
public Courses(String bookName,int price,String authorName,int bookNo){
    super();
    this.bookName=bookName;
    this.price=price;
    this.authorName=authorName;
    this.bookNo=bookNo;
}
}
