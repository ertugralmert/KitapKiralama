package com.mert.repository;

import com.mert.entity.Kasiyer;
import com.mert.entity.Kitap;
import com.mert.entity.Musteri;

import java.util.ArrayList;

public interface Repository<T> {

    void add(T entity);
    void remove (T entity);



    public ArrayList<T> findAll();

    public void printAll();



}
