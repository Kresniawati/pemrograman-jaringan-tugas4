/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertemuan4.praktikum2;

import pertemuan4.praktikum2.Praktikum2.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;


//import pertemuan3.FormPraktikum2;
//import pertemuan3.Praktikum2Controller;



/**
 *
 * @author Lenovo
 */
public class Praktikum2Controller {
    private FormPraktikum2 view;
   private List<Integer> list = new ArrayList<>();

     public Praktikum2Controller(FormPraktikum2 view) {
         this.view = view;
         
        this.view.getBtBaca().addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                proses();
             }
            
        });
                
        this.view.getBtSimpan().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 save();
             }
         });
         
     }
      private void save() {
         JFileChooser loadFile = view.getLoadFile();
         if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(view)) {
             BufferedWriter writer = null;
             try {
                 String contents = view.getTxtPane().getText();
                 if (contents != null && !contents.isEmpty()) {
                     writer = new BufferedWriter(new FileWriter(loadFile.getSelectedFile()));
                     writer.write(contents);
                 }

             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
             } finally {
                 if (writer != null) {
                     try {
                         writer.flush();
                         writer.close();
                         view.getTxtPane().setText("");
                     } catch (IOException ex) {
                         Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             }  
                  
              }JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan!!");
      }
          
                                     
     private void proses() {
      JFileChooser loadFile = view.getLoadFile();
         StyledDocument doc = view.getTxtPane().getStyledDocument();
         if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
             BufferedInputStream reader = null;
             try {
                 reader = new BufferedInputStream(new FileInputStream(loadFile.getSelectedFile()));
//                 String data = null;
                 
                doc.insertString(0, "", null);
                int temp = 0;
                List<Integer> list = new ArrayList<>();
                 byte[] b;
                 while ((temp=reader.read(b)(byte b[])) != -1) {
                     list.add(temp);
                 }
                 if (!list.isEmpty()){
                     byte[] dt = new byte[list.size()];
                     int i = 0;
                     for (Integer integer : list){
                         dt[i]= integer.byteValue();
                         i++;
                     }
                     doc.insertString(doc.getLength(), new String(dt), null);
                     JOptionPane.showMessageDialog(view, "File berhasil dibaca.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                 }
              
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException | BadLocationException ex) {
                 Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
             } finally {
                 if (reader != null) {
                     try {
                         reader.close();
                     } catch (IOException ex) {
                         Logger.getLogger(Praktikum2Controller.class.getName()).log(Level.SEVERE, null, ex);
                     }
                        
                 }
             }
          
         }
     }
}
    

