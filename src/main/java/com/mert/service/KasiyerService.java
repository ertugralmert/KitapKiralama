package com.mert.service;

import com.mert.controller.BaseController;
import com.mert.controller.KasiyerController;
import com.mert.entity.Kasiyer;
import com.mert.entity.KasiyerDurumu;
import com.mert.entity.Musteri;
import com.mert.repository.KasiyerRepository;
import com.mert.repository.MusteriRepository;


import java.util.ArrayList;

public class KasiyerService extends BaseService<Kasiyer>{


    private final KasiyerRepository kasiyerRepository;

    public KasiyerService(){
        kasiyerRepository = new KasiyerRepository();
    }

    @Override
    public   String findById(String Id) {
        setFound(false);
        StringBuilder idIleArama = new StringBuilder();

        for ( Kasiyer kasiyer : kasiyerRepository.findAll()){
            if (kasiyer.getId().equals(Id)){
                idIleArama.append(kasiyer.getAd().concat(" ").concat(kasiyer.getSoyAd()).concat(" ").
                        concat(kasiyer.getSoyAd().concat(" \n")));
                setFound(true);
            }
        }
        return idIleArama.toString().isEmpty() ? "Böyle bir kasiyer yok" : idIleArama.toString();

    }

    @Override
    public   String findByName(String name) {
        setFound(false);
        StringBuilder nameIleArama = new StringBuilder();
        for ( Kasiyer kasiyer : kasiyerRepository.findAll()){
            if ( kasiyer.getAd().equalsIgnoreCase(name)){
                nameIleArama.append(kasiyer.getAd().concat(" ").concat(kasiyer.getSoyAd()).concat(" ").
                        concat(kasiyer.getId().concat(" \n")));
                setFound(true);

            }
        }
        return nameIleArama.toString().isEmpty() ? "Kasiyer ismi bulunamadı" : nameIleArama.toString();

    }


    @Override
    public void add(Kasiyer kasiyer) {
        kasiyerRepository.add(kasiyer);



    }

    @Override
    public   void remove(Kasiyer kasiyer) {
        kasiyerRepository.remove(kasiyer);

    }


    @Override
    public ArrayList<Kasiyer> listele() {
        return kasiyerRepository.findAll();
    }

    @Override
    public void printAll() {
        kasiyerRepository.printAll();
    }

    public String kasiyerLogin(String kasiyerId){

        aciklama = "Kasiyer aktif değil veya Giriş Başarışız!!";
        for (Kasiyer kasiyer : kasiyerRepository.findAll()){
            if(kasiyer.getId().equalsIgnoreCase(kasiyerId) && kasiyer.getDurum() == KasiyerDurumu.AKTIF){
                aciklama = (kasiyer.getAd().concat(" Giriş yaptı"));



            }
        }return aciklama;
    }

    public String kasiyerDurumuDegistirme(String kasiyerId){
        aciklama = "Bir sorun oluştu!";

        for ( Kasiyer kasiyer:kasiyerRepository.findAll()){
            if (kasiyer.getId().equalsIgnoreCase(kasiyerId)) {
                if (kasiyer.getDurum() == KasiyerDurumu.AKTIF) {
                    kasiyer.setDurum(KasiyerDurumu.PASIF);
                    aciklama = "Kasiyer Durumu Pasif Yapıldı";
                } else if (kasiyer.getDurum()==KasiyerDurumu.PASIF){
                    kasiyer.setDurum(KasiyerDurumu.AKTIF);
                    aciklama = "Kasiyer Durumu Aktif edildi";
                }
            }
        } return aciklama;
    }

   private String aciklama;

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
