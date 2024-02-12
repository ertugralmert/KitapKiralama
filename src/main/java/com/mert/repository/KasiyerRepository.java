package com.mert.repository;

import com.mert.entity.Kasiyer;
import com.mert.entity.Kitap;
import com.mert.entity.Musteri;
import com.mert.utility.DataBase;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class KasiyerRepository implements Repository<Kasiyer> {


    @Override
    public void add(Kasiyer kasiyer) {
        DataBase.kasiyerList.add(kasiyer);

    }

    @Override
    public void remove(Kasiyer kasiyer) {
        DataBase.kasiyerList.remove(kasiyer);

    }



    @Override
    public ArrayList<Kasiyer> findAll() {
        return DataBase.kasiyerList;
    }

    @Override
    public void printAll() {
        ArrayList<Kasiyer> kasiyerArrayList = findAll();
        for (Kasiyer kasiyer : kasiyerArrayList) {
            System.out.println(kasiyer);
        }
    }
}
