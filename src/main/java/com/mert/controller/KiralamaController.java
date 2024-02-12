package com.mert.controller;

import com.mert.entity.Kasiyer;
import com.mert.entity.KiralamaDurumu;
import com.mert.service.KasiyerService;
import com.mert.service.KiralamaService;
import com.mert.utility.Kasa;

import java.time.LocalDate;

public class KiralamaController extends BaseController{
    private final KiralamaService kiralamaService;
    private final KasiyerService kasiyerService;



    public KiralamaController(){
        kiralamaService = new KiralamaService();
        kasiyerService = new KasiyerService();
    }

    @Override
    public void Iade() {
        System.out.println("Lütfen Kiralanan Kitap ID giriniz");
        String kiralamaId = getScanner().nextLine();
        LocalDate iadeTarihi = LocalDate.now();
        String sonuc = kiralamaService.kitapIade(kiralamaId,iadeTarihi);
        System.out.println(sonuc);
    }

    @Override
    public void childGUI() {
        System.out.println("""
                 Kiralama İşlemleri
                1-> Kiralama Yap
                2-> Kiralama ID göre ara
                3-> Kiralama Listesini Göster
                4-> Kiralanan Kitabı Iade et
                5-> ID bilgisi verilmiş olan Kitap Kimler tarafından kiralanmış
                6-> Adı verilen kitap daha önce kimler tarafından kiralanmış
                7-> ... ile başlayan / ismi girilen müşterileri bul
                8->ID verilen müşterinin kiraladığı kitapların listesini bul
                9-> Kazanılan parayı gör
                0-> Çıkış
                """);
    }

    @Override
    public void ekleme() {
        System.out.println("Kasiyer Girişi Yapmalısınız");
        System.out.print("Kasiyer ID giriniz: ");
        String kasiyerId = getScanner().nextLine();
        String loginSonucu = kasiyerService.kasiyerLogin(kasiyerId);
        System.out.println(loginSonucu);
        if (loginSonucu.contains("Giriş yaptı")){
            System.out.println("Kiralama İşlemi Başlatılıyor");
            System.out.println("Aşağıdaki bilgileri doldurmanız gerekiyor");
            System.out.print("Lütfen kitap adını giriniz: ");
            String kitapAdi = getScanner().nextLine();
            kiralamaService.kitapKontrolEt(kitapAdi);
            System.out.println(kiralamaService.getSonuc());
            if (kiralamaService.isCheck()) {
                System.out.print("Lütfen TC No giriniz: ");
                String tcNo = getScanner().nextLine();
                System.out.print("Kiralama fiyatını giriniz: ");
                double kiralamaFiyati = getScanner().nextDouble();
                Kasa.kiralamaParasiEkle(kiralamaFiyati);
                String bug = getScanner().nextLine();
                LocalDate kiralamaTarihi = LocalDate.now();
                LocalDate iadeTarihi = kiralamaTarihi.plusDays(15);
                kiralamaService.findKasiyerById(kasiyerId);
                Kasiyer kasiyer = kiralamaService.findKasiyerById(kasiyerId);
                kiralamaService.musteriKontrol(tcNo, kiralamaTarihi, iadeTarihi,kiralamaFiyati,kasiyer);
                System.out.println(kiralamaService.isCheck());
                System.out.println(kiralamaService.isSecondCheck());
                System.out.println(kiralamaService.getSonuc());
                if (kiralamaService.isCheck() && !kiralamaService.isSecondCheck()) {
                    System.out.print("Lütfen adınızı giriniz: ");
                    String musteriAdi = getScanner().nextLine();
                    System.out.print("Lütfen soyadınızı giriniz: ");
                    String musteriSoyad = getScanner().nextLine();
                    System.out.print("Lütfen adresinizi giriniz: ");
                    String adres = getScanner().nextLine();
                    System.out.print("Lütfen telefon numaranızı giriniz: ");
                    String telefon = getScanner().nextLine();
                    KiralamaDurumu durum = KiralamaDurumu.KIRALIK;


                    kiralamaService.musteriKontrolSonrasiMusteriEkleme(musteriAdi, musteriSoyad, tcNo, adres, telefon, kiralamaTarihi,
                            iadeTarihi,kiralamaFiyati,kasiyer);
                    System.out.println(kiralamaService.getMusteriSonucu());
                    System.out.println(kiralamaService.getSonuc());
                }

            }
        }else {
            System.out.println("Giriş Başarısız.Kiralama işlemi yapılamaz");
        }

    }


    @Override
    public void aramaId() {
        System.out.println("Kiralanan ID ile arama işlemi başlatılıyor!");
        System.out.print("Aranması gereken Id giriniz: ");
        String id = getScanner().nextLine();
        System.out.println(kiralamaService.findById(id));
    }

    @Override
    public void aramaName() {
        System.out.println("Kiralanlar listesinde isme göre arama başlatılıyor");
        System.out.print("Lütfen aramak istediğiniz kitap ismini giriniz: ");
        String name = getScanner().nextLine();
        System.out.println( kiralamaService.findByName(name));
    }

    @Override
    public void listele() {

    }

    @Override
    public void printAll() {
        kiralamaService.printAll();
    }

    @Override
    public void findByCustomerName() {
        System.out.print("Lütfen müşteri ismi giriniz: ");
        String customerName = getScanner().nextLine();
        System.out.println(kiralamaService.findByCustomer(customerName));
    }

    // -> 2. kısma özel methodlar

    @Override
    public void findCustomerByBookId() {
        System.out.println("Id si verilmiş olan kitapları kiralayanlar ");
        System.out.print("Lütfen Kitap ID'si giriniz: ");
        String id  = getScanner().nextLine();
        System.out.println(kiralamaService.findCustomerByBookId(id));

    }

    @Override
    public void findCustomerByBookName() {
        System.out.println("Adı verilen kitap, kimler tarafından kiralanmış");
        System.out.print("lütfen Kitap Adı giriniz: ");
        String name = getScanner().nextLine();
        System.out.println(kiralamaService.findCustomerByBookName(name));
    }

    @Override
    public void findCustomerByCustomerName() {
        System.out.println(".... ile başlayan müşteriler");
        System.out.print("Lütfen aramak istediğiniz ismi veya ilk harflerini giriniz: ");
        String name = getScanner().nextLine();
        System.out.println(kiralamaService.findCustomerByCustomerName(name));
    }

    @Override
    public void findBookByCustomerId() {
        System.out.println(" Id verilen müşterinin kiraladığı kitaplar");
        System.out.print("Lütfen Müşteri Id giriniz: ");
        String id = getScanner().nextLine();
        System.out.println(kiralamaService.findBookByCustomerId(id));

    }
}
