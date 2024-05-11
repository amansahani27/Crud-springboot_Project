package com.example.springdemo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
public class JsonData implements Serializable
{

    private String bookName;
    private int price;
    private String authorName;
    private int bookNo;

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "bookName='" + bookName + '\'' +
                ", price=" + price +
                ", authorName='" + authorName + '\'' +
                ", bookNo=" + bookNo +
                '}';
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


}

