package com.mert.service;

import com.mert.entity.Kitap;
import com.mert.entity.Musteri;
import com.mert.repository.KitapRepository;
import com.mert.repository.MusteriRepository;


import java.util.ArrayList;

public class MusteriService extends BaseService<Musteri>{

    private final MusteriRepository musteriRepository;

    public MusteriService(){
        musteriRepository = new MusteriRepository();
    }

    @Override
    public   String findById(String Id) {
        setFound(false);
        StringBuilder idIleArama = new StringBuilder();


        for ( Musteri musteri : musteriRepository.findAll()){
            if (musteri.getId().equals(Id)){
                idIleArama.append(musteri.getAd().concat(" ").concat(musteri.getSoyad().concat(" ").
                        concat(musteri.getId().concat(" \n"))));
                setFound(true);
            }
        }return idIleArama.toString().isEmpty() ? "Müşteri bulunamadı" : idIleArama.toString();
    }

    @Override
    public   String findByName(String name) {
        StringBuilder bulunanMusteriler = new StringBuilder();

        setFound(false);
        for ( Musteri musteri : musteriRepository.findAll()){
            if ( musteri.getAd().startsWith(name)){
                bulunanMusteriler.append(musteri.getAd().concat(" ").concat(musteri.getSoyad().concat(musteri.getId().concat(" müşteri bulundu\n"))));
                setFound(true);
            }

        } return bulunanMusteriler.toString().isEmpty() ? "Müşteri Bulunamadı" : bulunanMusteriler.toString();


    }

    @Override
    public void add(Musteri musteri) {
        musteriRepository.add(musteri);



    }

    @Override
    public   void remove(Musteri musteri) {
        musteriRepository.remove(musteri);

    }


    @Override
    public ArrayList<Musteri> listele() {
        return musteriRepository.findAll();
    }

    @Override
    public void printAll() {
        musteriRepository.printAll();
    }


}
