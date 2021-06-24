package controller;

import view.Inventaris;
import java.sql.*;

/**
 *
 * @author acer
 */
public interface controller_Inventaris {
    public void tambah(Inventaris inv) throws SQLException;
    public void edit(Inventaris inv) throws SQLException;
    public void tampil(Inventaris inv) throws SQLException;
    public void hapus(Inventaris inv) throws SQLException;
    public void reset(Inventaris inv);
    public void kliktabel(Inventaris inv) throws SQLException;
}
