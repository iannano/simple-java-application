/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utils.ian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ian-Nano
 */
public class TableModelMahasiswa {
    private Connection connection = null;
    public static DefaultTableModel defaultTableModel;
    
    public TableModelMahasiswa(Connection connection){
        this.connection = connection;
    }
    
    public void ModelTableMahasiswa(JTable jTable){
        defaultTableModel = new DefaultTableModel();
        
        defaultTableModel.addColumn("NIM");
        defaultTableModel.addColumn("Nama");
        defaultTableModel.addColumn("Alamat");
        defaultTableModel.addColumn("Telphone");
        
        String sql = "SELECT * FROM mahasiswa";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                defaultTableModel.addRow(new Object[]{
                    resultSet.getString("NIM"),
                    resultSet.getString("Nama"),
                    resultSet.getString("Alamat"),
                    resultSet.getString("No_telp")
                });
                jTable.setModel(defaultTableModel);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(TableModelMahasiswa.class.getName()).log(Level.SEVERE,null,ex);
        }
        defaultTableModel.fireTableDataChanged();
    }
    
    public void refreshTable(JTable jTable){
        jTable.setModel(defaultTableModel);
        defaultTableModel.fireTableDataChanged();
    }
}
