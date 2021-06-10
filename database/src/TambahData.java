import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.sql.*;

public class TambahData {
    public static void main(String[] args) {
        new Tambah();
    }
}

class Tambah extends JFrame implements ActionListener{
    String email, username, password, nama, tempat, tanggal, jk, domisili, desc;
    int count=0, check=2;
    
    String DBurl = "jdbc:mysql://localhost/formulir";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    JLabel lemail = new JLabel ("E-mail");
    final JTextField femail = new JTextField(30);
    
    JLabel lusername = new JLabel ("Username");
    final JTextField fusername = new JTextField(20);
    
    JLabel lpassword = new JLabel ("Password");
    final JTextField fpassword = new JTextField(20);
    
    JLabel lnama = new JLabel ("Nama Lengkap");
    final JTextField fnama = new JTextField(50);
    
    JLabel ltempat = new JLabel ("Tempat");
    final JTextField ftempat = new JTextField(50);
    
    JLabel ltanggal = new JLabel ("Tanggal Lahir");
    final JTextField ftanggal = new JTextField(50);
    
    JLabel ljk = new JLabel ("Jenis Kelamin");
    final JTextField fjk = new JTextField(50);
    
    JLabel ldomisili = new JLabel ("Domisili");
    final JTextField fdomisili = new JTextField(50);
    
    JLabel ldesc = new JLabel ("Deskripsi");
    final JTextField fdesc = new JTextField(200);
    
    JButton btncek = new JButton("Cek");
    JButton btnin = new JButton("Submit");
    final JTextField fcek = new JTextField(10);
    JButton btnout = new JButton("Tampilkan");
    
    public Tambah (){      
        setTitle("data");
        setSize(600,500);
        
        ButtonGroup group = new ButtonGroup();

        setLayout(null);
        add (lemail); add(femail);
        add(lusername); add(fusername);
        add (lpassword); add(fpassword);
        add(lnama); add(fnama);
        add(ltempat); add(ftempat);
        add(ltanggal); add(ftanggal);
        add(ljk); add(fjk);
        add(ldomisili); add(fdomisili);
        add(ldesc); add(fdesc);
        add (btncek); add (btnin); add(btnout);
        add (fcek);

        lemail.setBounds(10,10,120,20); femail.setBounds(120,10,205,20);
        lusername.setBounds(10,40,120,20); fusername.setBounds(120,40,205,20);
        lpassword.setBounds(10,70,120,20); fpassword.setBounds(120,70,205,20);
        lnama.setBounds(10,100,120,20); fnama.setBounds(120,100,205,20);
        ltempat.setBounds(10,130,120,20); ftempat.setBounds(120,130,150,20);
        ltanggal.setBounds(280,130,120,20); ftanggal.setBounds(380,130,120,20);
        ljk.setBounds(10,160,120,20); fjk.setBounds(120,160,205,20);
        ldomisili.setBounds(10,190,120,20); fdomisili.setBounds(120,190,205,20);
        ldesc.setBounds(10,220,120,20); fdesc.setBounds(120,220,205,20);
        btncek.setBounds(10,290,120,20); btnin.setBounds(150,290,120,20); btnout.setBounds(290,290,120,20);
        fcek.setBounds(10,320,100,20);
        setVisible(true);
        
        btncek.addActionListener(this);
        btnin.addActionListener(this);
        btnout.addActionListener(this);
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == btncek)
        {
            check = 0;
            email = femail.getText();
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            if (email.matches(regex));
            else { 
                femail.setText("email tidak valid");
                check = 1;
            }
            
            username = fusername.getText();
            Pattern pola = Pattern.compile("[^a-zA-Z0-9]");
            Matcher sama = pola.matcher(username);
            boolean id = sama.find();
            if(id) { 
                fusername.setText("tidak boleh mengandung simbol");
                check = 1;
            }
            
            password = fpassword.getText();
            Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
            Matcher matcher = pattern.matcher(password);
            boolean pass = matcher.find();
            if(pass);
            else {
                fpassword.setText("harus mengandung huruf, angka, dan simbol");
                check = 1;
            }
            
            nama = fnama.getText();
            tempat = ftempat.getText();
            tanggal = ftanggal.getText();
            jk = fjk.getText();
            domisili = fdomisili.getText();
            desc = fdesc.getText();
            count = desc.length();
            if (count > 200) { 
                fdesc.setText("tidak boleh lebih dari 200 huruf");
                check = 1;
            }
        }
        
        if (e.getSource() == btnin){
            if (check > 0) JOptionPane.showMessageDialog(null,"masih ada kesalahan");
            
            else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
                    statement = koneksi.createStatement();
                    String sql = "insert into akun values('"+femail.getText()+"','"+fusername.getText()+"','"+fpassword.getText()+"','"+fnama.getText()+"','"+ftempat.getText()+"','"+ftanggal.getText()+"','"+fjk.getText()+"','"+fdomisili.getText()+"','"+fdesc.getText()+"',NULL)";
                    statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
                    statement.close();
                    koneksi.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == btnout){
            new Lihat();
            dispose();
        }
    }
}