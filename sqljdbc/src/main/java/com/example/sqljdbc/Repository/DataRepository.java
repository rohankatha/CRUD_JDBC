package com.example.sqljdbc.Repository;
import java.util.List;
import  com.example.sqljdbc.model.Data;
public interface DataRepository {
    int save(Data book);

    int update(Data book);

    Data findById(Long id);

    int deleteById(Long id);

    List<Data> findAll();


    int deleteAll();
}