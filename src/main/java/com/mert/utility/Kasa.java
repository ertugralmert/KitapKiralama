package com.mert.utility;

public class Kasa {
    private static double toplamKazanilanPara = 0;
    public static void kiralamaParasiEkle(double kiralamaFiyati){
        toplamKazanilanPara += kiralamaFiyati;
    }
    public static double getToplamKazanilanPara(){
        return toplamKazanilanPara;
    }
}
