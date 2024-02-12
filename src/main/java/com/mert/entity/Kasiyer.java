package com.mert.entity;

public class Kasiyer extends BaseEntity {


    String ad;
    String soyAd;

    String tcNo;

    String adres;

    KasiyerDurumu durum;

    public Kasiyer(String ad, String soyAd) {
        super();
        this.ad = ad;
        this.soyAd = soyAd;
    }

    public Kasiyer(String ad, String soyAd, String tcNo, String adres, KasiyerDurumu durum) {
        super();
        this.ad = ad;
        this.soyAd = soyAd;
        this.tcNo = tcNo;
        this.adres = adres;
        this.durum = durum;
    }

    public KasiyerDurumu getDurum() {
        return durum;
    }

    public void setDurum(KasiyerDurumu durum) {
        this.durum = durum;
    }


    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }



    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }


// String tcNo;


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Kasiyer{");
        sb.append("ad='").append(ad).append('\'');
        sb.append(", soyAd='").append(soyAd).append('\'');
        sb.append(", tcNo='").append(tcNo).append('\'');
        sb.append(", adres='").append(adres).append('\'');
        sb.append(", durum=").append(durum);
        sb.append(", id='").append(getId()).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
