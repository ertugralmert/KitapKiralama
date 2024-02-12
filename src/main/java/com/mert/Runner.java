package com.mert;

import com.mert.controller.*;
import com.mert.entity.KasiyerDurumu;
import com.mert.entity.Kiralama;
import com.mert.entity.KiralamaDurumu;
import com.mert.entity.Kitap;
import com.mert.repository.KiralamaRepository;
import com.mert.repository.KitapRepository;
import com.mert.service.BaseService;
import com.mert.service.KasiyerService;
import com.mert.service.KiralamaService;
import com.mert.service.KitapService;
import com.mert.utility.DataBase;
import com.mert.utility.Kasa;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    /*
    Description:
    -> Database olmadığından dolayı ve projenin testinin sağlıklı yapılabilmesi için Runner Class'ında
        GUI oluşturuldu bu sayede çıkış yapmadığınız sürece GUI de gösterilen işlemleri yapabilir ve test edebilirsiniz
    -> Polimorphism yapabilmek adına Inheritance kurallarına pek uyulmadı, ancak düzeltilebilir.
    -> Encapsulation, static, final, interface kavramları kullanıldı.
    -> interface, extends yapabilmek adına nesne tanımlaması yapabilmek için farklı class'larda <T entity> kavramı öğrenildi
    -> Kendim test sırasında Runner kısmında hata aldığımda bunu sürekli döngüde tutmak adına try catch konusu araştırıldı
    -> scanner.next() -> bir sonraki satıra geçiş öğrenildi
    -> String Builder ile alınan listeyi String'e dönüştürme yapıldı
    -> return sırasında tenary kullanıldı
    ->
    -> Bilgilendirme: Kiralama Hakkında
    ->> Kasiyer Id'si olmadan kiralama yapamazsınız
    ->> Kasiyer mevcut ancak durumu PASIF ise kiralama işlemine geçilemez!
    ->> Kiralama sırasında müşterinin mevcutluğu TC NO ile kontrol edilir.
            tc numarasına sahip müşteri varsa kiralama otomatik olarak yapılır.
            yoksa o sırada yeni bir müşteri eklemesi yapılır ve kiralaam işlemine geçilir.
    ->> Kiralama yapabilmek için Kitap Listesinde kitap olmalıdır.
    ->> Kiralanan kitabı İade edebilmek için kiralanan kitabın ID'sini kullanmak gerekir.
    ->> Iade edilen kitap tekrardan kiralanabilir.

     */
    public static void islemSec(){
        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz!");
        System.out.print("> ");
    }
    public static int girisHatasiEngelleme(Scanner scanner){
        while(true){
            try{
                return scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Lütfen sayısal seçim yapınız!");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        BaseController gui = new KasiyerController();
        BaseController kasiyer = new KasiyerController();
        BaseController kitap = new KitapController();
        BaseController musteri = new MusteriController();
        BaseController kiralama = new KiralamaController();
        Scanner scanner = new Scanner(System.in);

        int sayi;
        int sayi2;
        int sayi3;
        int sayi4;
        int sayi5;
        int sayi6;

        do {
            gui.mainGUI();
            islemSec();
             sayi = girisHatasiEngelleme(scanner);
            switch (sayi){
                case 1 :
                    do{
                                kasiyer.childGUI();
                       islemSec();
                        sayi2 = girisHatasiEngelleme(scanner);
                        switch (sayi2) {
                            case 1:
                                System.out.println("Kasiyer Ekleme");
                                kasiyer.ekleme();
                                break;
                            case 2:
                                System.out.println("Kasiyer Durum Düzenleme");
                                kasiyer.duzenleme();
                                break;
                            case 3:
                                System.out.println("Kasiyer Listeleme");
                                kasiyer.printAll();
                                break;
                            case 0 :
                                System.out.println("Çıkış yapıldı");
                                break;
                            default:
                                System.out.println("Geçersiz seçim");
                                break;
                        }

                    }while (sayi2 != 0);
                    break;
                case 2:

                    do {musteri.childGUI();
                        islemSec();
                        sayi3 = girisHatasiEngelleme(scanner);
                        switch (sayi3){
                            case 1:
                                System.out.println("Müşteri Ekleme");
                                musteri.ekleme();
                                break;
                            case 2:
                                System.out.println("Müşteri ID göre Ara");
                                musteri.aramaId();
                                break;
                            case 3:
                                System.out.println("Müşteri İsme göre Ara");
                                musteri.aramaName();
                                break;
                            case 4:
                                System.out.println("Müşteri Listeleme");
                                musteri.printAll();
                                break;
                            case 0 :
                                System.out.println("Çıkış Yapıldı");
                            default:
                                System.out.println("Geçersiz İşlem");
                                break;
                        }

                    }while(sayi3 != 0);
                    break;
                case 3:
                do{kitap.childGUI();
                    islemSec();
                    sayi4 = girisHatasiEngelleme(scanner);
                    switch (sayi4){
                        case 1:
                            System.out.println("Kitap Ekleme");
                            kitap.ekleme();
                            break;
                        case 2:
                            System.out.println("Kitap ID'ye göre Arama");
                            kitap.aramaId();
                            break;
                        case 3 :
                            System.out.println("Kitap isme göre Arama");
                            kitap.aramaName();
                            break;
                        case 4:
                            System.out.println("Kitap Listesi");
                            kitap.printAll();
                            break;
                        case 0 :
                            System.out.println("Çıkış Yapıldı");
                            break;
                        default:
                            System.out.println("Geçersiz İşlem Yaptınız");
                            break;
                    }

                }while (sayi4 !=0);
                break;
                case 4:
                    do{kiralama.childGUI();
                        islemSec();
                        sayi5 = scanner.nextInt();
                        switch (sayi5){
                            case 1:
                                System.out.println("Kiralama Yap");
                                kiralama.ekleme();

                                break;
                            case 2:
                                System.out.println("Kiralama ID'ye göre Arama");
                                kiralama.aramaId();
                                break;
                            case 3:
                                System.out.println("Kiralık Olanları Listele");
                                kiralama.printAll();
                                break;
                            case 4:
                                System.out.println("Iade et");
                                kiralama.Iade();
                                break;
                            case 5:
                                kiralama.findCustomerByBookId();
                                break;
                            case 6:
                                kiralama.findCustomerByBookName();
                                break;
                            case 7:
                                kiralama.findCustomerByCustomerName();
                                break;
                            case 8:
                                kiralama.findBookByCustomerId();
                                break;
                            case 9:
                                System.out.println("Kazanılan Para");
                                System.out.println(Kasa.getToplamKazanilanPara());
                                break;
                            case 0:
                                System.out.println("Çıkış Yapıldı");

                            default:
                                System.out.println("Geçersiz İşlem Yaptınız");
                                break;
                        }

                    }while (sayi5 !=0);
                    break;
                case 0 :
                    System.out.println("Çıkış Yapıldı");
                default:
                    System.out.println("Geçersiz İşlem");
            }

        }while (sayi != 0);



    }
}
