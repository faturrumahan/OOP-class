package kalkulator;

import javax.swing.*;
import java.awt.event.*;

public class Kalkulator {
    public static void main(String[] args) {
        new GUI();
    }
}

class GUI extends JFrame implements ActionListener{
    String operasi; Float a,temp, akhir;
    final JTextField fspace = new JTextField(10);
    JButton btn1 = new JButton("1"); JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3"); JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5"); JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7"); JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9"); JButton btn0 = new JButton("0");
    JButton btnplus = new JButton("+"); JButton btnmin = new JButton("-");
    JButton btnmult = new JButton("*"); JButton btndiv = new JButton("/");
    JButton btnhasil = new JButton("=");
    
    public GUI (){      
        setTitle("Kalkulator");
        setSize(280,400);

        setLayout(null);
	add(fspace);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(btn9);
        add(btn0);
        add(btnplus);
        add(btnmin);
        add(btnmult);
        add(btndiv);
        add(btnhasil);
        
        // setBounds(m,n,o,p)
	// m = posisi x; n = posisi y
	// o = panjang komponen; p = tinggi komponen
        fspace.setBounds(30,10,205,40);
        btn1.setBounds(30,70,60,40);
        btn2.setBounds(100,70,60,40);
        btn3.setBounds(170,70,60,40);
        btn4.setBounds(30,120,60,40);
        btn5.setBounds(100,120,60,40);
        btn6.setBounds(170,120,60,40);
        btn7.setBounds(30,170,60,40);
        btn8.setBounds(100,170,60,40);
        btn9.setBounds(170,170,60,40);
        btnplus.setBounds(30,220,60,40);
        btn0.setBounds(100,220,60,40);
        btnmin.setBounds(170,220,60,40);
        btnmult.setBounds(30,270,60,40);
        btndiv.setBounds(100,270,60,40);
        btnhasil.setBounds(170,270,60,40);
        setVisible(true); 
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn0.addActionListener(this);
        btnplus.addActionListener(this);
        btnmin.addActionListener(this);
        btnmult.addActionListener(this);
        btndiv.addActionListener(this);
        btnhasil.addActionListener(this);
        
        
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {                                        
            if (e.getSource() == btn1) fspace.setText(fspace.getText()+"1");
            if (e.getSource() == btn2) fspace.setText(fspace.getText()+"2");
            if (e.getSource() == btn3) fspace.setText(fspace.getText()+"3");
            if (e.getSource() == btn4) fspace.setText(fspace.getText()+"4");
            if (e.getSource() == btn5) fspace.setText(fspace.getText()+"5");
            if (e.getSource() == btn6) fspace.setText(fspace.getText()+"6");
            if (e.getSource() == btn7) fspace.setText(fspace.getText()+"7");
            if (e.getSource() == btn8) fspace.setText(fspace.getText()+"8");
            if (e.getSource() == btn9) fspace.setText(fspace.getText()+"9");
            if (e.getSource() == btn0) fspace.setText(fspace.getText()+"0");
            
            if (e.getSource() == btnplus){
                a=Float.parseFloat(fspace.getText());
                if(operasi=="hasil") temp=null;
                if(operasi=="plus") temp=temp+a;
                if(operasi=="min") temp=temp-a;
                if(operasi=="mult") temp=temp*a;
                if(operasi=="div") temp=temp/a;
                if(temp==null) temp = a;
                operasi="plus";
                fspace.setText("");
            }
            if (e.getSource() == btnmin){
                a=Float.parseFloat(fspace.getText());
                if(operasi=="hasil") temp=null;
                if(operasi=="plus") temp=temp+a;
                if(operasi=="min") temp=temp-a;
                if(operasi=="mult") temp=temp*a;
                if(operasi=="div") temp=temp/a;
                if(temp==null) temp = a;
                operasi="min";
                fspace.setText("");
            }
            if (e.getSource() == btnmult){
                a=Float.parseFloat(fspace.getText());
                if(operasi=="hasil") temp=null;
                if(operasi=="plus") temp=temp+a;
                if(operasi=="min") temp=temp-a;
                if(operasi=="mult") temp=temp*a;
                if(operasi=="div") temp=temp/a;
                if(temp==null) temp = a;
                operasi="mult";
                fspace.setText("");
            }
            if (e.getSource() == btndiv){
                a=Float.parseFloat(fspace.getText());
                if(operasi=="hasil") temp=null;
                if(operasi=="plus") temp=temp+a;
                if(operasi=="min") temp=temp-a;
                if(operasi=="mult") temp=temp*a;
                if(operasi=="div") temp=temp/a;
                if(temp==null) temp = a;
                operasi="div";
                fspace.setText("");
            }
            
            if (e.getSource() == btnhasil){
                akhir=temp;
                if("plus".equals(operasi)){
                    fspace.setText(Float.toString(akhir+Float.parseFloat(fspace.getText())));   
                }
                if("min".equals(operasi)){
                    fspace.setText(Float.toString(akhir-Float.parseFloat(fspace.getText())));
                }
                if("mult".equals(operasi)){
                    fspace.setText(Float.toString(akhir*Float.parseFloat(fspace.getText())));
                }
                if("div".equals(operasi)){
                    fspace.setText(Float.toString(akhir/Float.parseFloat(fspace.getText())));
                }
                operasi="hasil";
            }
        }    
}


