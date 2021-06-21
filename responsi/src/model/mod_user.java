/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.*;
import connect.koneksi;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import view.*;
/**
 *
 * @author acer
 */
public class mod_user implements con_user{
    String email, password, id;
    String upid, upnama, upemail, uppass, uprole;

    @Override
    public void simpan(view_user daf) throws SQLException {
        try{
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "insert into cerita values(NULL, '"+ daf.fjudul.getText() + "','"+daf.fisi.getText()+"','"+daf.fid.getText()+"')";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cerita Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            stt.close();
        }catch(Exception ex){
            
        }
    }

    @Override
    public void ubah(view_user daf) throws SQLException { //untuk update data yang dipilih
        try {
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "update cerita set "
                        + "cerid            = '" + daf.fcerid.getText() +"', "
                        + "judul            = '" + daf.fjudul.getText()+"', "
                        + "isi              = '" + daf.fisi.getText()+"', "
                        + "id               = '" + daf.fid.getText() +"' "
                        + "where cerid      = '" + daf.fcerid.getText() + "'";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cerita Berhasil di Ubah");
            stt.close();
            //con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cerita Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void hapus(view_user daf) throws SQLException { //untuk menghapus data yang telah dipilih
        try{
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "delete from cerita where cerid=" +daf.fcerid.getText();
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cerita Berhasil di Hapus");
            stt.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cerita Gagal Dihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void tampil(view_user daf) throws SQLException { //untuk menampilkan data dari database ke view
        try {
            try {
                File myObj = new File("data.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if(email == null) email = data;
                    else if(password == null) password = data;
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = koneksi.getKoneksi();
            Statement stta = con.createStatement();
            String sqla = "select * from akun where email='"+email+"' and password='"+password+"'";
            ResultSet resa = stta.executeQuery(sqla);
            while(resa.next())
            {
                id = resa.getString(1); //mengambil id dari tabel akun
            } 
            daf.fid.setText(""+id);
            stta.close();
            
            Statement stt = con.createStatement();
            String sql = "select * from cerita where id="+id; //mengambil seluruh data dari cerita yang memiliki id tertentu
            ResultSet res = stt.executeQuery(sql);
            while(res.next())
            {
                Object[] ob= new Object[8];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getString(3);
                ob[3] = res.getString(4);
                daf.tblmodel.addRow(ob);
            } 
            stt.close();
            //con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void kliktabel(view_user daf) throws SQLException { //untuk mengambil data dari tabel ke field
        try {
             int pilih = daf.tabel.getSelectedRow();
             daf.fcerid.setText(daf.tblmodel.getValueAt(pilih, 0).toString());
             daf.fjudul.setText(daf.tblmodel.getValueAt(pilih, 1).toString());
             daf.fisi.setText(daf.tblmodel.getValueAt(pilih, 2).toString());
             daf.fid.setText(daf.tblmodel.getValueAt(pilih, 3).toString());           
        } catch (Exception e) {
        }
    }

    @Override
    public void updateakun(view_user daf) throws SQLException { //untuk menyimpan update akun di user
        try{
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "update akun set "
                        + "id           = '" + daf.fid.getText()            +"', "
                        + "nama         = '" + daf.fnama.getText()          +"', "
                        + "email        = '" + daf.femail.getText()         +"', "
                        + "password     = '" + daf.fpass.getText()          +"', "
                        + "role         = '" + uprole  +"' "
                        + "where id     = '" + daf.fid.getText()            + "'";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Akun Berhasil di Ubah");
            stt.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Akun Gagal Diupdate", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void tampilakun(view_user daf) throws SQLException { //untuk mengambil dan menampilkan data dari akun ke field user
        try{
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "select * from akun where id="+id;
            ResultSet res = stt.executeQuery(sql);
            while(res.next())
            {
                upid = res.getString(1);
                upnama = res.getString(2);
                upemail = res.getString(3);
                uppass = res.getString(4);
                uprole = res.getString(5);
            }
            daf.fnama.setText(upnama);
            daf.femail.setText(upemail);
            daf.fpass.setText(uppass);
            stt.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Akun Gagal Ditampilkan", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
