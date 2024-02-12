package com.mert.repository;

import com.mert.entity.Kitap;
import com.mert.utility.DataBase;

import java.util.ArrayList;

public class KitapRepository implements Repository<Kitap>{


    @Override
    public void add(Kitap kitap) {
        DataBase.kitapList.add(kitap);


    }

    @Override
    public void remove(Kitap kitap) {
        DataBase.kitapList.remove(kitap);


    }



    @Override
    public ArrayList<Kitap> findAll() {

        return DataBase.kitapList;
    }

    @Override
    public void printAll() {
        ArrayList<Kitap> kitapArrayList = findAll();
        for ( Kitap kitap:kitapArrayList){
            System.out.println(kitap);
        }
    }

}


