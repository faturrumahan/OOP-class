package model;

import controller.controller_Inventaris;
import connect.koneksi;
import java.sql.*;
import javax.swing.*;
import view.Inventaris;

public class model_Inventaris implements controller_Inventaris{

    @Override
    public void tambah(Inventaris inv) throws SQLException {
       try{
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "insert into inventaris values('"+ inv.fid.getText() + "','" + inv.fnama.getText() + "','"+ inv.fjenis.getText() +"','"+ inv.fjumlah.getText() +"','"+inv.fharga.getText()+"')";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Akun Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            stt.close();
       } catch (Exception e){
           JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
       }
    }

    @Override
    public void edit(Inventaris inv) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "update inventaris set "
                        + "id       = '" + inv.fid.getText()    +"', "
                        + "nama     = '" + inv.fnama.getText()  +"', "
                        + "jenis    = '" + inv.fjenis.getText() +"', "
                        + "jumlah   = '" + inv.fjumlah.getText()+"', "
                        + "harga    = '" + inv.fharga.getText() +"' "
                        + "where id = '" + inv.fid.getText()    + "'";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            stt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah!", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void reset(Inventaris inv) {
       inv.fid.setText("");
       inv.fnama.setText("");
       inv.fjenis.setText("");
       inv.fjumlah.setText("");
       inv.fharga.setText("");
    }

    @Override
    public void kliktabel(Inventaris inv) throws SQLException {
        try{
            int pilih = inv.Tabel.getSelectedRow();
            inv.fid.setText(inv.tblmodel.getValueAt(pilih, 0).toString());
            inv.fnama.setText(inv.tblmodel.getValueAt(pilih, 1).toString());
            inv.fjenis.setText(inv.tblmodel.getValueAt(pilih, 2).toString());
            inv.fjumlah.setText(inv.tblmodel.getValueAt(pilih, 3).toString());
            inv.fharga.setText(inv.tblmodel.getValueAt(pilih, 4).toString());
        }
        catch(Exception e){
            
        }
    }

    @Override
    public void tampil(Inventaris inv) throws SQLException {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "select * from inventaris";
            ResultSet res = stt.executeQuery(sql);
            while(res.next())
            {
                Object[] ob= new Object[8];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getString(3);
                ob[3] = res.getString(4);
                ob[4] = res.getString(5);
                inv.tblmodel.addRow(ob);
            } 
            stt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void hapus(Inventaris inv) throws SQLException {
        try{
            Connection con = koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "delete from inventaris where id='" + inv.fid.getText() +"'";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Dihapus");
            stt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
