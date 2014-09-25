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
public class TableModelMatakuliah {
    private Connection connection = null;
    public static DefaultTableModel defaultTableModel;
    
    public TableModelMatakuliah(Connection connection){
        this.connection = connection;
    }
    
    public void ModelTableMatakuliah(JTable jTable){
        defaultTableModel = new DefaultTableModel();
        
        defaultTableModel.addColumn("Kode Matakuliah");
        defaultTableModel.addColumn("Nama Matakuliah");
        defaultTableModel.addColumn("SKS Matakuliah");
        
        String sql = "SELECT * FROM matakuliah";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                defaultTableModel.addRow(new Object[]{
                    resultSet.getString("Kode_Matakuliah"),
                    resultSet.getString("Nama_Matakuliah"),
                    resultSet.getString("SKS_Matakuliah")
                });
                jTable.setModel(defaultTableModel);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(TableModelMatakuliah.class.getName()).log(Level.SEVERE,null,ex);
        }
        defaultTableModel.fireTableDataChanged();
    }
}
