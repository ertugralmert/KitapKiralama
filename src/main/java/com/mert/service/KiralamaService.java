package com.mert.service;

import com.mert.entity.*;
import com.mert.repository.KasiyerRepository;
import com.mert.repository.KiralamaRepository;
import com.mert.repository.KitapRepository;
import com.mert.repository.MusteriRepository;
import com.mert.utility.DataBase;

import java.time.LocalDate;
import java.util.ArrayList;

public class KiralamaService extends BaseService<Kiralama> {

/*
-> KiralamaYap();
-> kitapAra();
-> musteriAra();
->kiralananKitapListesi();
 */

    /// ->>>>> Deneme
    private KiralamaRepository kiralamaRepository;
    private KitapRepository kitapRepository;
    private MusteriRepository musteriRepository;
    private MusteriService musteriService;
    private KasiyerRepository kasiyerRepository;

    private Kasiyer kasiyer;
    public  KiralamaService(){
        kiralamaRepository = new KiralamaRepository();
        kitapRepository = new KitapRepository();
        musteriRepository = new MusteriRepository();
        musteriService = new MusteriService();
        kasiyerRepository = new KasiyerRepository();




    }
    Kitap kitapKontrol;
    boolean check = false;
    boolean secondCheck = false;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isSecondCheck() {
        return secondCheck;
    }

    public void setSecondCheck(boolean secondCheck) {
        this.secondCheck = secondCheck;
    }

    String sonuc ;

    String musteriSonucu;

    public String getMusteriSonucu() {
        return musteriSonucu;
    }

    public void setMusteriSonucu(String musteriSonucu) {
        this.musteriSonucu = musteriSonucu;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    Musteri kontrolMusteri;

  public String kitapKontrolEt(String kitapAdi){
      check =false;
      sonuc = "Kitap sistemde mevcut değil";
        for (Kitap kitap: kitapRepository.findAll()){
            if (kitap.getAd().equalsIgnoreCase(kitapAdi)){
                kitapKontrol = kitap;
                check = true;
                sonuc = "Kitap Sistemde mevcut ve Müşteri Kontrol Ediliyor";
                //return "Kitap Sistemde mevcut ve Kiralanma durumu kontrol ediliyor";
            }
        }if (check == true){
        for(Kiralama kiralama : kiralamaRepository.findAll()) {
            if (kiralama.getKitap().getAd().equalsIgnoreCase(kitapAdi) && kiralama.getKiralamaDurumu()== KiralamaDurumu.KIRALIK) {
                check = false;
                sonuc = "Kitap Sistemde mevcut ancak kiralanmış durumda";
            }
        }
        }return sonuc;
  }

  public  String  musteriKontrol(String tcNo,LocalDate kiralamaTarihi,LocalDate iadeTarihi,double kiralamaFiyati,Kasiyer kasiyer){

          for ( Musteri musteri : musteriRepository.findAll()){
              secondCheck = false;
              if(musteri.getTcNo().equalsIgnoreCase(tcNo)){
                  kontrolMusteri = musteri;
                  KiralamaDurumu kiralamaDurumu = KiralamaDurumu.KIRALIK;
                  kitapKontrol.kiralamaSayisiniArttir();
                  Kiralama kiralama = new Kiralama(kitapKontrol,kontrolMusteri,kasiyer,kiralamaTarihi,iadeTarihi,kiralamaDurumu,kiralamaFiyati);
                  kiralamaRepository.add(kiralama);

                  check = false;
                  secondCheck = false;
                  sonuc = "Müşteri sistemde mevcut ve Kiralama işlemi başarılı!!!";
              }
          }
      return sonuc;
  }

  public String musteriKontrolSonrasiMusteriEkleme(String musteriAd,String musteriSoyad,String tcNo,String adres,
                                                 String telefon,LocalDate kiralamaTarihi,LocalDate iadeTarihi,double kiralamaFiyati,
                                                   Kasiyer kasiyer
                                                 ){
      Musteri yeniMusteri = new Musteri(musteriAd,musteriSoyad,tcNo,adres,telefon);
      musteriRepository.add(yeniMusteri);
      kontrolMusteri = yeniMusteri;
       musteriSonucu = "Müşteri sisteme eklendi ve kiralama işlemine devam ediliyor";
      KiralamaDurumu kiralamaDurumu = KiralamaDurumu.KIRALIK;
      kitapKontrol.kiralamaSayisiniArttir();
      Kiralama yeniKiralama = new Kiralama(kitapKontrol,kontrolMusteri,kasiyer,kiralamaTarihi,iadeTarihi,kiralamaDurumu,kiralamaFiyati);
      kiralamaRepository.add(yeniKiralama);

      check = false;

      sonuc = "Kiralama işlemi başarılı";
      return musteriSonucu + sonuc;
  }

  public String kitapIade(String kiralamaId, LocalDate iadeTarihi){
      for (Kiralama kiralama : kiralamaRepository.findAll()){
          if (kiralama.getKitap().getId().equalsIgnoreCase(kiralamaId)){
              kiralama.setKiralamaDurumu(KiralamaDurumu.IADE_EDILDI);
              kiralama.setIadeTarihi(iadeTarihi);
              String iadeEdilen= kiralama.getKitap().getAd().concat(" ").concat(kiralama.getKitap().getId());
              return "Kitap başarılı bir şekilde iade edildi ve liste güncellendi";
          }
      }return "Belirtilen ID'ye sahip kiralama mevcut değil";
  }



    @Override
    public boolean isFound() {
        return super.isFound();
    }

    @Override
    public void setFound(boolean found) {
        super.setFound(found);
    }



    @Override
    void remove(Kiralama entity) {
        super.remove(entity);
    }

    @Override
    public String findById(String Id) {
        setFound(false);
        StringBuilder idKiralama = new StringBuilder();

        for ( Kiralama kiralama : kiralamaRepository.findAll()){

            if (kiralama.getId().equals(Id)){
                idKiralama.append(kiralama.getKitap().getAd().concat(" kiralama ID:").
                        concat(kiralama.getId()).concat(" kitap ID: ").concat(kiralama.getKitap().getId().concat(" \n")));
                setFound(true);

            }
        }return idKiralama.toString().isEmpty() ? "Böyle bir kiralama yok" : idKiralama.toString();

    }



    @Override
    public String findByCustomer(String name) {
        setFound(false);
        StringBuilder musteriIsmiIleArama = new StringBuilder();
        for (Kiralama musteri : kiralamaRepository.findAll()){
            if (musteri.getMusteri().getAd().equalsIgnoreCase(name)){
                musteriIsmiIleArama.append(musteri.getMusteri().getId().
                        concat(" musteri Soyadi: ").concat(musteri.getMusteri().getSoyad().concat(" kitap: ").
                                concat(musteri.getKitap().getAd().concat(" \n"))));

                setFound(true);

            }
        }

        return musteriIsmiIleArama.toString().isEmpty() ? "Böyle bir müşteri veya kiraladığı kitap yok" :
                musteriIsmiIleArama.toString();
    }



    ///->> kesin olanlar
    @Override
    public void printAll() {
        kiralamaRepository.printAll();
    }

    @Override
    ArrayList<Kiralama> listele() {
        kiralamaRepository.findAll();
        return DataBase.kiralamaList;
    }

    @Override
    public Kasiyer findKasiyerById(String kasiyerId) {
        for (Kasiyer kasiyer: kasiyerRepository.findAll()){
            if(kasiyer.getId().equalsIgnoreCase(kasiyerId)){
                return kasiyer;
            }
        }return null;
    }
    @Override
    public String findByName(String name) {
        StringBuilder kitapAdinaGoreArama = new StringBuilder();
        setFound(false);
        for ( Kiralama kitap : kiralamaRepository.findAll()){
            if ( kitap.getKitap().getAd().equalsIgnoreCase(name)){
                kitapAdinaGoreArama.append(kitap.getMusteri().getAd().concat(" ").concat(kitap.getMusteri().getId().concat(" tarafından kiralanmış")));

                setFound(true);


            }
        }
        return kitapAdinaGoreArama.toString().isEmpty() ? "Böyle bir kitap yok" : kitapAdinaGoreArama.toString();
    }
    // ->>>>> 2. kısma özel method yazma


    @Override
    public String findCustomerByBookId(String id) {
      StringBuilder newFindCustomerByBookId = new StringBuilder();
      setFound(false);
      for(Kiralama kitap : kiralamaRepository.findAll()){
          if (kitap.getKitap().getId().equalsIgnoreCase(id)){
              newFindCustomerByBookId.append(kitap.getMusteri().getAd().concat(" ").concat(kitap.getMusteri().getSoyad().concat(" ").concat(kitap.getMusteri().getId().concat(" tarafından\n"))));
                setFound(true);
          }
      }return newFindCustomerByBookId.toString().isEmpty() ? "böyle bir müşteri yok" : newFindCustomerByBookId.toString();


    }

    @Override
    public String findCustomerByBookName(String name) {
      setFound(false);
      StringBuilder idVerilenKitapHangiMusteri = new StringBuilder();
      for(Kiralama kitap : kiralamaRepository.findAll()){
          if(kitap.getKitap().getAd().equalsIgnoreCase(name)){
              idVerilenKitapHangiMusteri.append(kitap.getMusteri().getAd().concat(" ").
                      concat(kitap.getMusteri().getSoyad().concat(" ").concat(kitap.getMusteri().getId().concat(" tarafından kiralanmış.\n"))));
              setFound(true);

          }
      } return idVerilenKitapHangiMusteri.toString().isEmpty() ? "böyle bir müşteri yok" : idVerilenKitapHangiMusteri.toString();

    }

    @Override
    public String findCustomerByCustomerName(String name) {
      setFound(false);
      StringBuilder ileBaslayanMusteriler = new StringBuilder();
      for( Kiralama musteri : kiralamaRepository.findAll()){
          if(musteri.getMusteri().getAd().startsWith(name)){
              ileBaslayanMusteriler.append(musteri.getMusteri().getAd().concat(" ").
                      concat(musteri.getMusteri().getSoyad().concat(" ").
                              concat(musteri.getMusteri().getId().concat(" müşteri bulundu.\n"))));
              setFound(true);
          }
      }
        return ileBaslayanMusteriler.toString().isEmpty() ? "böyle bir müşteri yok" : ileBaslayanMusteriler.toString();
    }

    @Override
    public String findBookByCustomerId(String id) {
      setFound(false);
      StringBuilder idVerilenMusterininKitapları = new StringBuilder();
      for(Kiralama musteri : kiralamaRepository.findAll()){
          if (musteri.getMusteri().getId().equalsIgnoreCase(id)){
              idVerilenMusterininKitapları.append(musteri.getKitap().getAd().
                      concat(" ").concat(musteri.getMusteri().getAd().concat(" ").
                              concat(musteri.getMusteri().getId().concat(" kitaplar kiralanmış"))));
              setFound(true);
          }
      }
        return idVerilenMusterininKitapları.toString().isEmpty() ? "kiralanan böyle bir kitap yok" : idVerilenMusterininKitapları.toString();
    }
}
