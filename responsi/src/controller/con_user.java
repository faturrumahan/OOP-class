/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.*;
import java.sql.*;
/**
 *
 * @author acer
 */
public interface con_user {
    public void simpan(view_user daf) throws SQLException;
    public void ubah(view_user daf) throws SQLException;
    public void hapus(view_user daf) throws SQLException;
    public void tampil(view_user daf) throws SQLException;
    public void kliktabel(view_user daf) throws SQLException;
    public void updateakun(view_user daf) throws SQLException;
    public void tampilakun(view_user daf) throws SQLException;
}
