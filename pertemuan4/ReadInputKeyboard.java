/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertemuan4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author Lenovo
 */
public class ReadInputKeyboard {
     public static void main(String[] args) throws IOException {
     
        Scanner sc = new Scanner(System.in);
         System.out.println("Masukkan karakter apapun, [tekan keluar tekan `q`]:");
         String input = "";
         do {
             input = sc.nextLine();
             System.out.print(""+ input);
         }while (!input.equals('q'));
     }
}
