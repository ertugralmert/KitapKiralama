package com.mert.controller;

import com.mert.entity.Kitap;
import com.mert.repository.KitapRepository;
import com.mert.service.BaseService;
import com.mert.service.KitapService;

import java.util.Scanner;

public class KitapController extends BaseController {


    private final KitapService service;
    public KitapController(){
        service = new KitapService();
    }


    @Override
    public void ekleme() {
        System.out.println("Lütfen kitap bilgilerini giriniz");
        System.out.print("Kitap adı: ");
        String ad = getScanner().nextLine();
        System.out.print("Kitap yazarı: ");
        String yazar = getScanner().nextLine();
        System.out.print("Brans: ");
        String brans = getScanner().nextLine();
        Kitap kitap = new Kitap(ad, yazar, brans);
        service.add(kitap);
    }

    @Override
    public void aramaId() {
        System.out.print("Aramak istediğiniz ID giriniz: ");
        String Id = getScanner().nextLine();
        System.out.println(service.findById(Id));
    }

    @Override
    public void aramaName() {
        System.out.print("Aramak istediğiniz kitabın adını giriniz: ");
        String name = getScanner().nextLine();
        System.out.println(service.findByName(name));
    }

    @Override
    public void listele() {
        System.out.print("Kitap Listesi aşağıdadır");
        System.out.println(service.listele());
    }

    @Override
    public void printAll() {
        service.printAll();
    }

    @Override
    public void childGUI() {
        System.out.println("""
 Kitap İşlemleri
  1->Kitap Ekleme
  2->Kitap ID'ye göre Arama
  3->Kitap Isme Göre Arama
  4->Kitap Listeleme
  0->Çıkış
  """);
    }
}

/**

 */