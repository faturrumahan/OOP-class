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
public class mod_admin implements con_admin{

    @Override
    public void ubah(view_admin adm) throws SQLException { //mengubah data yang dipilih ke database
        try {
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "update akun set "
                        + "id           = '" + adm.fid.getText()            +"', "
                        + "nama         = '" + adm.fnama.getText()          +"', "
                        + "email        = '" + adm.femail.getText()         +"', "
                        + "password     = '" + adm.fpass.getText()          +"', "
                        + "role         = '" + adm.crole.getSelectedItem()  +"' "
                        + "where id     = '" + adm.fid.getText()            + "'";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            stt.close();
            //con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        finally{
            //tampil(inv);
            adm.setLebarKolom();
            //Baru(inv);
        }
    }

    @Override
    public void tampil(view_admin adm) throws SQLException { //menampilkan data yang diambil dari database
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "select * from akun";
            ResultSet res = stt.executeQuery(sql);
            while(res.next())
            {
                Object[] ob= new Object[8];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getString(3);
                ob[3] = res.getString(4);
                ob[4] = res.getString(5);
                adm.tblmodel.addRow(ob);
            } 
            stt.close();
            //con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void hapus(view_admin adm) throws SQLException { //menghapus data yang dipilih
        try{
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "delete from akun where id=" +adm.fid.getText();
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            stt.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void kliktabel(view_admin adm) throws SQLException { //mengambil data dari tabel dan memindah ke field
        String role = null;
        try {
             int pilih = adm.tabel.getSelectedRow();
             adm.fid.setText(adm.tblmodel.getValueAt(pilih, 0).toString());
             adm.fnama.setText(adm.tblmodel.getValueAt(pilih, 1).toString());
             adm.femail.setText(adm.tblmodel.getValueAt(pilih, 2).toString());
             adm.fpass.setText(adm.tblmodel.getValueAt(pilih, 3).toString());
             role = String.valueOf(adm.tblmodel.getValueAt(pilih, 4).toString());
             adm.crole.setSelectedItem(adm.tblmodel.getValueAt(pilih, 4).toString());
             
                   
        } catch (Exception e) {
        }
    }   
}
