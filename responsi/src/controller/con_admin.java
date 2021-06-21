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
public interface con_admin {
    public void ubah(view_admin adm) throws SQLException;
    public void tampil(view_admin adm) throws SQLException;
    public void hapus(view_admin adm) throws SQLException;
    public void kliktabel(view_admin adm) throws SQLException;
}
