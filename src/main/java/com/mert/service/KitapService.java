package com.mert.service;

import com.mert.entity.Kitap;
import com.mert.repository.KitapRepository;

import java.util.ArrayList;

public class KitapService extends BaseService<Kitap> {



    private final KitapRepository kitapRepository;

    public KitapService(){
        kitapRepository = new KitapRepository();
    }

    @Override
  public   String findById(String Id) {
        setFound(false);
        StringBuilder idIleArama = new StringBuilder();

        for ( Kitap kitap : kitapRepository.findAll()){
            if (kitap.getId().equals(Id)){
                idIleArama.append(kitap.getAd().concat(" ").
                        concat(kitap.getId()).concat( " ").concat(" bulundu.\n"));
                setFound(true);
                break;
            }
        } return idIleArama.toString().isEmpty() ? "Kitap bulunamadı" : idIleArama.toString();


    }

    @Override
  public   String findByName(String name) {
        setFound(false);
        StringBuilder isimIleArama = new StringBuilder();
        for ( Kitap kitap : kitapRepository.findAll()){
            if ( kitap.getAd().equalsIgnoreCase(name)){
                isimIleArama.append(kitap.getId().concat(" ").concat(kitap.getAd()).concat(" \n"));
                setFound(true);
                break;

            }
        }return  isimIleArama.toString().isEmpty() ? "kitap bulunamadı" : isimIleArama.toString();


    }

    @Override
   public void add(Kitap kitap) {
        kitapRepository.add(kitap);



    }

    @Override
  public   void remove(Kitap kitap) {
       kitapRepository.remove(kitap);

    }


    @Override
   public ArrayList<Kitap> listele() {
        return kitapRepository.findAll();
    }

    @Override
    public void printAll() {
        kitapRepository.printAll();
    }

}
