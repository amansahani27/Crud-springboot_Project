package com.example.springdemo.controllerlayer;

import com.example.springdemo.bean.JsonData;
import com.example.springdemo.serviceLayer.Courses;
import com.example.springdemo.serviceLayer.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("restApiAman")
public class MyControllerLevel {
    @Autowired
    ServiceImpl service;
    @GetMapping("/getRecordById/{id}")
    public List<Courses> getRecordById(@PathVariable int id) throws Exception {
        return service.bookByID(id);

    }
    @GetMapping("/getAllRecord")
    public List<Courses> getAllRecord() throws Exception {
        return service.books();

    }
    @PostMapping(value = "/addRecord",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addRecord(@RequestBody JsonData c) throws Exception {
        int i=service.addcourses(c);
return new ResponseEntity<>(i + " row/s affected ", HttpStatus.ACCEPTED);

    }

    @PutMapping(value ="/updateRecord/{name}/{value}")
    public ResponseEntity<String> updateRecord(@PathVariable String name, @PathVariable int value) throws Exception {
     int i= service.updatecourses(name,value);
        return new ResponseEntity<>( i+ " row/s updated ", HttpStatus.ACCEPTED);

    }
@DeleteMapping(value = "/deleteRecord/{id}")
    public String deleteRecord(@PathVariable int id) throws SQLException, ClassNotFoundException {
        int i=0;
    i=service.deletedData(id);
    return (i==1?"Decord deleted ":"Invalid id");
}


}
