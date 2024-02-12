package com.mert.entity;

import java.util.UUID;

public class Kitap extends BaseEntity{

  private   String ad;
  private   String yazar;

  private   String brans;

  private int kiralamaSayisi;


    // -> bunun eklenmesi yapılacak

    public Kitap(){

    }


    public Kitap(String ad, String yazar,String brans) {
        super();
        this.ad = ad;
        this.yazar = yazar;
        this.brans = brans;


    }



    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getBrans() {
        return brans;
    }

    public void setBrans(String brans) {
        this.brans = brans;
    }

    public int getKiralamaSayisi() {
        return kiralamaSayisi;
    }

    public void setKiralamaSayisi(int kiralamaSayisi) {
        this.kiralamaSayisi = kiralamaSayisi;
    }

    public void kiralamaSayisiniArttir(){
        this.kiralamaSayisi++;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Kitap{");
        sb.append("ad='").append(ad).append('\'');
        sb.append(", yazar='").append(yazar).append('\'');
        sb.append(", brans='").append(brans).append('\'');
        sb.append(", kiralamaSayisi=").append(kiralamaSayisi);
        sb.append(", id='").append(getId()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
