package com.mert.entity;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class Kiralama extends BaseEntity{

private     String id;

 private    double kiralamaFiyati;
    Kitap kitap;

    Musteri musteri;

    Kasiyer kasiyer;


    KiralamaDurumu kiralamaDurumu;
    LocalDate kiralamaTarihi;
    LocalDate iadeTarihi;


    public Kiralama(Kitap kitap, Musteri musteri, Kasiyer kasiyer,LocalDate kiralamaTarihi,LocalDate iadeTarihi,KiralamaDurumu kiralamaDurumu,double kiralamaFiyati)  {
        super();
        this.id = UUID.randomUUID().toString();
        this.kitap = kitap;
        this.musteri = musteri;
        this.kasiyer = kasiyer;
        this.kiralamaTarihi = kiralamaTarihi;
        this.iadeTarihi = iadeTarihi;
        this.kiralamaDurumu = kiralamaDurumu;
        this.kiralamaFiyati = kiralamaFiyati;

    }

    public double getKiralamaFiyati() {
        return kiralamaFiyati;
    }

    public void setKiralamaFiyati(double kiralamaFiyati) {
        this.kiralamaFiyati = kiralamaFiyati;
    }

    public KiralamaDurumu getKiralamaDurumu() {
        return kiralamaDurumu;
    }

    public void setKiralamaDurumu(KiralamaDurumu durum) {
        this.kiralamaDurumu = durum;
    }

    public LocalDate getKiralamaTarihi() {
        return kiralamaTarihi;
    }

    public void setKiralamaTarihi(LocalDate kiralamaTarihi) {
        this.kiralamaTarihi = kiralamaTarihi;
    }

    public LocalDate getIadeTarihi() {
        return iadeTarihi;
    }

    public void setIadeTarihi(LocalDate iadeTarihi) {
        this.iadeTarihi = iadeTarihi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Kitap getKitap() {
        return kitap;
    }

    public void setKitap(Kitap kitap) {
        this.kitap = kitap;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Kasiyer getKasiyer() {
        return kasiyer;
    }

    public void setKasiyer(Kasiyer kasiyer) {
        this.kasiyer = kasiyer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Kiralama{");
        sb.append("id='").append(id).append('\'');
        sb.append(", kitap=").append(kitap);
        sb.append(", musteri=").append(musteri);
        sb.append(", kasiyer=").append(kasiyer);
        sb.append(", kiralamaDurumu=").append(kiralamaDurumu);
        sb.append(", kiralamaTarihi=").append(kiralamaTarihi);
        sb.append(", iadeTarihi=").append(iadeTarihi);
        sb.append('}');
        return sb.toString();
    }
}
