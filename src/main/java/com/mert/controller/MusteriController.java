package com.mert.controller;

import com.mert.entity.BaseEntity;
import com.mert.entity.Kitap;
import com.mert.entity.Musteri;
import com.mert.service.MusteriService;

public class MusteriController extends BaseController {

    private final MusteriService service;

    public MusteriController() {
        service = new MusteriService();
    }

    @Override
    public void ekleme() {
        System.out.println("Lütfen müşteri bilgilerini giriniz");
        System.out.print("Müşteri adı: ");
        String ad = getScanner().nextLine();
        System.out.print("Musteri soyad: ");
        String soyad = getScanner().nextLine();
        System.out.print("Tc No: ");
        String tcNo = getScanner().nextLine();
        System.out.print("adres: ");
        String adres = getScanner().nextLine();
        System.out.print("telefon: ");
        String telefon = getScanner().nextLine();
        Musteri musteri = new Musteri(ad, soyad, tcNo,adres,telefon);
        service.add(musteri);
    }

    @Override
    public void aramaId() {
        System.out.print("Aramak istediğiniz ID giriniz: ");
        String Id = getScanner().nextLine();
        System.out.println(service.findById(Id));
    }

    @Override
    public void aramaName() {
        System.out.print("Aramak istediğiniz Müşter adını giriniz: ");
        String name = getScanner().nextLine();
        System.out.println(service.findByName(name));
    }

    @Override
    public void listele() {
        System.out.print("Musteri Listesi aşağıdadır: ");
        System.out.println(service.listele());
    }

    @Override
    public void printAll() {
        service.printAll();
    }

    @Override
    public void childGUI() {
        System.out.println("""
  Müşteri İşlemleri
 1-> Müşteri Ekleme
 2-> Müşteri ID'göre arama
 3-> Müşteri Isme Göre arama
 4-> Müşteri Listeleme
 0-> Çıkış
 """);
    }
}
