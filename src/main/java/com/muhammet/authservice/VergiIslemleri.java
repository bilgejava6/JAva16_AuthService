package com.muhammet.authservice;

import java.util.List;

public class VergiIslemleri {
    public static void main(String[] args) {
        Vergi vergi = new Vergi();
        //vergi.Hesapla();

        //vergi.Hesapla(Parametreler.builder().fiyat().build());
        vergi.topla(5,9);
        vergi.topla(10,32);

        List<Parametreler> list = List.of();

        vergi.Hesapla(list.get(0));
        vergi.Hesapla(list.get(1));

        list.forEach(p->{
            vergi.Hesapla(p);
        });

    }
}
