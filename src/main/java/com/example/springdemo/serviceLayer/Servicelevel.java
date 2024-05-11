package com.example.springdemo.serviceLayer;

import com.example.springdemo.bean.JsonData;

import java.sql.SQLException;
import java.util.List;

public interface Servicelevel {
    public abstract List<Courses> bookByID(int id) throws ClassNotFoundException, SQLException;
    public abstract List<Courses> books() throws ClassNotFoundException, SQLException;
    public abstract int addcourses(JsonData c) throws ClassNotFoundException, SQLException;
    int updatecourses(String name,int value)throws ClassNotFoundException, SQLException;
         int deletedData(int id) throws ClassNotFoundException, SQLException;
}
