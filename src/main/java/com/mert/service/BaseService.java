package com.mert.service;

import com.mert.entity.Kasiyer;
import com.mert.entity.Kiralama;
import com.mert.repository.KitapRepository;

import java.util.ArrayList;

public abstract class BaseService<T> {


    private boolean found = false;

    public BaseService() {
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public String findById(String Id){
        return null;
    }

    public String  findByName(String name){
        return null;
    }




    void add(T entity){
         System.out.println("Ekleme veya Kiralama işlemi başarılı");
     }

     void remove(T entity){
         System.out.println("Silme işlemi başarılı");
     }

    ArrayList<T> listele(){
         return null;
    }

    public void printAll(){
        System.out.println("tüm sonuçlar çıktı");
    }

    public String findByCustomer(String name){
        return null;
    }

    public Kasiyer findKasiyerById(String kasiyerId){
        System.out.println("kasiyer ID ile arama başlatıldı");
        return null;
    }

    // 2.kısma göre method yazma

    /**
     * Id bilgisi verilmiş olan kitap kim tarafından kiralanmış
     *
     * @param id
     * @return
     */
    public String findCustomerByBookId(String id){
        return null;
    }

    /**
     * Adı verilen kitap daha önce kimler tarafından kiralanmış
     * @param name
     * @return
     */
    public String findCustomerByBookName(String name){
        return null;
    }

    /**
     * Verilen String ile başlayan müşterileri bulma
     * @param name
     * @return
     */
    public String findCustomerByCustomerName(String name){
        return null;
    }

    /**
     * ID'si verilen müşterinin kiraladığı kitapların listesini bulunuz
     * @param id
     * @return
     */
    public String findBookByCustomerId(String id){
        return null;
    }

}
