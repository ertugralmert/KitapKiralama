package com.mert.entity;

import java.util.UUID;

public class Musteri extends BaseEntity {

  private   String ad;
  private   String soyad;
  private   String tcNo;
  private   String adres;
  private   String telefon;

    public Musteri(String ad, String soyad, String tcNo, String adres, String telefon) {
    super();
        this.ad = ad;
        this.soyad = soyad;
        this.tcNo = tcNo;
        this.adres = adres;
        this.telefon = telefon;
    }



    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Musteri{");
        sb.append("ad='").append(ad).append('\'');
        sb.append(", soyad='").append(soyad).append('\'');
        sb.append(", tcNo='").append(tcNo).append('\'');
        sb.append(", adres='").append(adres).append('\'');
        sb.append(", telefon='").append(telefon).append('\'');
        sb.append(", id='").append(getId()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
