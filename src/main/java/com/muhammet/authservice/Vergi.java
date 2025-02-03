package com.muhammet.authservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Vergi {

    public void Hesapla(Parametreler p ){

        if(p.yakitTuru.equalsIgnoreCase("Dizel")){
            if(p.motorHacmi > 1500){
                double vergi = p.fiyat * 0.35;
            }else{
                double vergi = p.fiyat * 0.20;
            }
        }else if (p.yakitTuru.equalsIgnoreCase("Benzin")){
            if(p.motorHacmi > 1500){
                double vergi = p.fiyat * 0.25;
            }else {
                double vergi = p.fiyat * 0.10;
            }
        }
    }

    public void topla(int s1, int s2){
        int toplam = s1 + s2;
        System.out.println(toplam);
    }

}

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
class Parametreler{
    Integer motorHacmi;
    String yakitTuru;
    Double fiyat;
}
