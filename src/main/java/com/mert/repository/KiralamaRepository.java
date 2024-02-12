package com.mert.repository;

import com.mert.entity.Kasiyer;
import com.mert.entity.Kiralama;
import com.mert.entity.Musteri;
import com.mert.utility.DataBase;

import java.util.ArrayList;

public class KiralamaRepository implements Repository<Kiralama>{


    @Override
    public void add(Kiralama kiralama) {
        DataBase.kiralamaList.add(kiralama);

    }

    @Override
    public void remove(Kiralama kiralama) {
        DataBase.kiralamaList.remove(kiralama);

    }



    @Override
    public ArrayList<Kiralama> findAll() {
        return DataBase.kiralamaList;
    }

    @Override
    public void printAll() {
        ArrayList<Kiralama> kiralamaArrayList = findAll();
        for (Kiralama kiralama : kiralamaArrayList) {
            System.out.println(kiralama);
        }
    }
}
