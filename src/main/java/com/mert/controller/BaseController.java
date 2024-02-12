package com.mert.controller;

import java.util.Scanner;

public abstract class BaseController {

  private  Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void ekleme(){
        System.out.println("Başarılı şekilde ekleme yapıldı");
    }

    public void aramaId(){
        System.out.println("Arama başlatıldı");
    }
    public void aramaName(){
        System.out.println("Arama başlatıldı");
    }

    public void listele(){
        System.out.println("Listelenme işlemi başarılı");
    }

    public void printAll(){
        System.out.println("Çıktılar aşağıdadır");
    }

public void duzenleme(){
    System.out.println("Düzenleme tamamlanmıştır");
}
public void giris(){
    System.out.println("Giriş yapılmıştır");
}

public void mainGUI(){
    System.out.println("""
            ->>>>>>>>>>MERHABA<<<<<<<<-
            ***** Program Started ****
            1-> Kasiyer İşlemleri
              
            2-> Musteri İşlemleri
              
            3-> Kitap İşlemleri
           
            4-> Kiralama İşlemleri          
                  
            0-> Çıkış 
            """);
}

public void childGUI(){
    System.out.println("GUI oluşturuldu");
}

public void findByCustomerName(){
    System.out.println("Müşteri arama başlatıldı");
}

public void Iade(){
    System.out.println("Iade işlemi başarılı");
}
// -> 2. kısma özel methodlar
    /**
     * Id bilgisi verilmiş olan kitap kim tarafından kiralanmış
     *
     * @param id
     * @return
     */
public void findCustomerByBookId(){
    System.out.println("id bilgisi verilmiş olan kitaplar kim tarafından kiralanmış");
}
    /**
     * Adı verilen kitap daha önce kimler tarafından kiralanmış
     * @return
     */
public void findCustomerByBookName(){
    System.out.println("adı verilen kitap daha önce kim kiralamış");
}
    /**
     * Verilen String ile başlayan müşterileri bulma
     * @return
     */
public void findCustomerByCustomerName(){
    System.out.println("... ile başlayan müşteriler");
}
    /**
     * ID'si verilen müşterinin kiraladığı kitapların listesini bulunuz
     * @return
     */
public void findBookByCustomerId( ){
    System.out.println("id verilen müşterinin kiraladığı kitapların listesi");
}
}
