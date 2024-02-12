package com.mert.repository;

import com.mert.entity.Kitap;
import com.mert.entity.Musteri;
import com.mert.utility.DataBase;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class MusteriRepository implements Repository<Musteri> {


    @Override
    public void add(Musteri musteri) {
        DataBase.musteriList.add(musteri);

    }

    @Override
    public void remove(Musteri musteri) {
        DataBase.musteriList.remove(musteri);

    }


    @Override
    public ArrayList<Musteri> findAll() {
        return DataBase.musteriList;
    }

    @Override
    public void printAll() {
        ArrayList<Musteri> musteriArrayList = findAll();
        for (Musteri musteri : musteriArrayList) {
            System.out.println(musteri);
        }
    }
}
