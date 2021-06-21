package view;

import java.awt.FlowLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import connect.koneksi;
import view.*;

/**
 *
 * @author acer
 */
public class login {
    public static void main(String[] args) {
        new log();
    }
}

class log extends JFrame implements ActionListener{
    String email, password;
    JLabel lemail = new JLabel ("Email"); JTextField femail = new JTextField(100);
    JLabel lpass = new JLabel ("Password"); JTextField fpass = new JTextField(100);
    JButton login = new JButton("Login"); JButton daftar = new JButton("Daftar");
    
    public log(){
        setTitle("Login");
        setSize(400,250);
        setVisible(true);
        
        setLayout(null);
        add(lemail); add(femail);
        add(lpass); add(fpass);
        add(login); add(daftar);
        
        lemail.setBounds(30,50,120,20); femail.setBounds(150,50,170,20);
        lpass.setBounds(30,90,120,20); fpass.setBounds(150,90,170,20);
        login.setBounds(240,130,80,20); daftar.setBounds(150,130,80,20);
        
        login.addActionListener(this);
        daftar.addActionListener(this);
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == login){
            try{
                Connection con = koneksi.getKoneksi();
                Statement stt = con.createStatement();
                //login sebagai admin
                String sql = "select * from akun where email='"+femail.getText()+"' and password='"+fpass.getText()+"' and role='admin'";
                ResultSet res = stt.executeQuery(sql);
                if (res.next()) {
                    JOptionPane.showMessageDialog(null, "Login Admin Success.");
                    new view_admin().setVisible(true);
                    dispose();
                }
                else { //login sebagai user
                    Statement sttu = con.createStatement();
                    String sqlu = "select * from akun where email='"+femail.getText()+"' and password='"+fpass.getText()+"' and role='user'";
                    ResultSet resu = sttu.executeQuery(sqlu);
                    if (resu.next()) {
                        try {
                            FileWriter myWriter = new FileWriter("data.txt", false);
                            myWriter.write(""+femail.getText());
                            myWriter.write("\r\n");   // write new line
                            myWriter.write(""+fpass.getText());
                            myWriter.close();
                        } catch (IOException x) {
                            x.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "Login User Success.");
                        new view_user().setVisible(true);
                        dispose();
                    }
                    else JOptionPane.showMessageDialog(null, "Login Failed.");
                }
                
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } 
        }
        if (e.getSource() == daftar){
            new view_daftar().setVisible(true);
            dispose();
        }
    }
}
