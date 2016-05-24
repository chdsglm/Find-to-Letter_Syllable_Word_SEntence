package odev_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Odev_1 {

    public static void main(String[] args) throws IOException {
        System.out.println("Dosya adini giriniz:");
       
        // Dosya adini kullanicidan okuyoruz.
        Scanner scanner = new Scanner(System.in);
        String dosya_adi = scanner.nextLine();
        
        try {
            FileReader reader = new FileReader(dosya_adi);
            BufferedReader br = new BufferedReader(reader);
            
            String sesli_harfler = "aeýioöuü";
            
            String satir;
            
            int satir_sayisi = 0;
            int harf_sayisi = 0;
            int kelime_sayisi = 0;
            int hece_sayisi = 0;
            int cumle_sayisi = 0;
            
            while ((satir = br.readLine()) != null) {
                satir_sayisi++;
                harf_sayisi += satir.length();
                
                String[] kelimeler = satir.split(" ");
                kelime_sayisi += kelimeler.length;
                
                for (int i = 0; i < kelimeler.length; ++i) {
                    int son_harf_index = kelimeler[i].length() - 1;
                    switch (kelimeler[i].charAt(son_harf_index)) {
                        case '.': cumle_sayisi++;
                            break;
                        case '?': cumle_sayisi++;
                            break;
                        case '!': cumle_sayisi++;
                            break;
                    }
                    
                    kelimeler[i].toLowerCase();
                    for (int j = 0; j < kelimeler[i].length(); ++j)
                        if (sesli_harfler.contains(kelimeler[i].substring(j, j + 1))) {
                            hece_sayisi++;
                        }    
                }
            }
            br.close();
            
            System.out.println("harf_sayisi:" + harf_sayisi);
            System.out.println("hece_sayisi:" + hece_sayisi);
            System.out.println("kelime_sayisi:" + kelime_sayisi);
            System.out.println("cumle_sayisi:" + cumle_sayisi);
            System.out.println("satir_sayisi:" + satir_sayisi);
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunumadi");        
        }
    }   
}
