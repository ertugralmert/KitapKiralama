package com.mert.controller;

import com.mert.entity.Kasiyer;
import com.mert.entity.KasiyerDurumu;
import com.mert.service.KasiyerService;

import java.util.Scanner;

public class KasiyerController extends BaseController {

    private final KasiyerService service;

    public KasiyerController() {
        service = new KasiyerService();
    }

    @Override
    public void ekleme() {
        System.out.println("Lütfen kasiyer bilgilerini giriniz");
        System.out.print("Kasiyer adı: ");
        String ad = getScanner().nextLine();
        System.out.print("Kasiyer soyad: ");
        String soyad = getScanner().nextLine();
        System.out.print("Tc No: ");
        String tcNo = getScanner().nextLine();
        System.out.print("adres: ");
        String adres = getScanner().nextLine();
        System.out.print("Kasiyer Durumu: AKTIF || PASIF: ");
        String kasiyerDurum = getScanner().nextLine();
        KasiyerDurumu durum;
        if ("AKTIF".equalsIgnoreCase(kasiyerDurum)){
            durum = KasiyerDurumu.AKTIF;
        }else if ("PASIF".equalsIgnoreCase(kasiyerDurum)){
            durum = KasiyerDurumu.PASIF;
        }else{ System.out.println("Geçersiz Giriş -> Varsayılan PASIF");
            durum = KasiyerDurumu.PASIF;}

        Kasiyer kasiyer = new Kasiyer(ad, soyad, tcNo,adres,durum);
        service.add(kasiyer);
    }

    @Override
    public void aramaId() {
        System.out.print("Aramak istediğiniz ID giriniz: ");
        String Id = getScanner().nextLine();
        System.out.println(service.findById(Id));
    }

    @Override
    public void aramaName() {
        System.out.print("Aramak istediğiniz kasiyer adını giriniz: ");
        String name = getScanner().nextLine();
        System.out.println(service.findByName(name));
    }

    @Override
    public void listele() {
        System.out.print("Kasiyer Listesi aşağıdadır");
        System.out.println(service.listele());
    }

    @Override
    public void printAll() {
        service.printAll();
    }







    @Override
    public void duzenleme() {
        System.out.print("Değiştirmek istediğiniz kasiyer ID giriniz: ");
        String kasiyerId= getScanner().nextLine();
        service.kasiyerDurumuDegistirme(kasiyerId);
        System.out.println(service.getAciklama());
    }



    @Override
    public void giris() {

        System.out.println("Merhaba , Lütfen işlem yapabilmek için giriş yapınız");
        System.out.print("ID'inizi Giriniz: ");
        String kasiyerId = getScanner().nextLine();
        System.out.println(service.kasiyerLogin(kasiyerId));


    }

    @Override
    public void childGUI() {
        System.out.println("""
Kasiyer İşlemleri
1-> Kasiyer Ekleme
2-> Kasiyer Durum Düzenleme AKTIF/PASIF
3-> Kasiyer Listeleme
0-> Çıkış
""");
    }

    @Override
    public Scanner getScanner() {
        return super.getScanner();
    }
}
