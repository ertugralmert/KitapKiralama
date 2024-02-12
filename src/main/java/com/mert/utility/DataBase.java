package com.mert.utility;

import com.mert.entity.Kasiyer;
import com.mert.entity.Kiralama;
import com.mert.entity.Kitap;
import com.mert.entity.Musteri;

import java.util.ArrayList;

public class DataBase {

  public static   ArrayList<Kitap> kitapList = new ArrayList<>(1000);
    public static  ArrayList<Kasiyer> kasiyerList = new ArrayList<>();
    public static   ArrayList<Musteri> musteriList = new ArrayList<>();
    public static   ArrayList<Kiralama> kiralamaList = new ArrayList<>(1000);

}
