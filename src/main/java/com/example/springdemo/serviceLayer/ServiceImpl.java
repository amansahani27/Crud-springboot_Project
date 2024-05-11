package com.example.springdemo.serviceLayer;

import com.example.springdemo.bean.JsonData;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceImpl implements Servicelevel {

    List<Courses> c;

    public ServiceImpl() {
        c = new ArrayList<>();
    }


    @Override
    public List<Courses> bookByID(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Superman@1");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from books where bookno=" + id);
        rs.next();
        String s = rs.getString("Bookname");
        String s1 = rs.getString("Authorname");
        int a = rs.getInt("price");
        int a1 = rs.getInt("bookno");
        c.add(new Courses(s, a, s1, a1));
        con.close();
        st.close();
        return c;
    }

    @Override
    public List<Courses> books() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Superman@1");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from books");
        while (rs.next()) {
            String s = rs.getString("Bookname");
            String s1 = rs.getString("Authorname");
            int a = rs.getInt("price");
            int a1 = rs.getInt("bookno");
            c.add(new Courses(s, a, s1, a1));

        }
        con.close();
        st.close();
        return c;
    }

    @Override
    public int addcourses(JsonData c1) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Superman@1");
        PreparedStatement ps = con.prepareStatement("insert into books values(?,?,?,?)");
        ps.setString(1, c1.getBookName());
        ps.setInt(2, c1.getPrice());
        ps.setString(3, c1.getAuthorName());
        ps.setInt(4, c1.getBookNo());
        int i = ps.executeUpdate();
        con.close();
        ps.close();
        return i;
//return "msg DOne";
    }

    @Override
    public int updatecourses(String name, int value) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Superman@1");
        Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("Update books set AuthorName = ? where bookno= ?");
        ps.setString(1,name);
        ps.setInt(2,value);
        int i=ps.executeUpdate();
        con.close();
        ps.close();
        return i;
    }

    @Override
    public int deletedData(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Superman@1");
        Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("Delete from books where bookno="+id);
        int i=ps.executeUpdate();

        ps.close();
        st.close();
        return i;
    }
}