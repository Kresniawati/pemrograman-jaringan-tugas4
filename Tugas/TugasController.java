/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class TugasController {
    
    public Form view;
    
    public TugasController(Form view){
        
        this.view = view;
        
        this.view.getBtnHitung().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                hitung();
            }
        });
        
        this.view.getBtnClear().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                view.getTxtPjg().setText("");
                view.getTxtLbr().setText("");
                view.getTxtLuas().setText("");
                view.getTxtKll().setText("");
            }
        });
        
    }
    
    public void hitung(){
        if(this.view.getTxtPjg().getText().isEmpty() || this.view.getTxtLbr().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "FIELD MASIH KOSONG!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            int pjg = Integer.valueOf(view.getTxtPjg().getText());
            int lbr = Integer.valueOf(view.getTxtLbr().getText());

            int luas    = pjg * lbr;
            int kll     = (2*pjg) + (2*lbr);

            view.getTxtLuas().setText(String.valueOf(luas));
            view.getTxtKll().setText(String.valueOf(kll));
        }
    }
}
