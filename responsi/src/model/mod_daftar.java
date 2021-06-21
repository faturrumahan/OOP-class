/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.*;
import connect.koneksi;
import java.sql.*;
import javax.swing.*;
import view.*;
/**
 *
 * @author acer
 */
public class mod_daftar implements con_daftar{

    @Override
    public void simpan(view_daftar daf) throws SQLException { //menyimpan data baru
        try{
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "insert into akun values(NULL, '"+ daf.fnama.getText() + "','"+daf.femail.getText()+"','"+daf.fpass.getText()+"','"+daf.crole.getSelectedItem()+"')";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Akun Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            stt.close();
        }catch(Exception ex){
            
        }
    }
    
}
