/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.query.ian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.dao.ian.MatakuliahDAO;
import com.model.ian.ClassMatakuliah;

/**
 *
 * @author Ian-Nano
 */
public class MatakuliahQuery implements MatakuliahDAO{
    private Connection connection = null;
    
    public MatakuliahQuery(Connection connection){
        this.connection = connection;
    }
    
    public void insert(ClassMatakuliah classMatakuliah){
        String sql = "INSERT INTO matakuliah(kode_matakuliah, nama_matakuliah, sks_matakuliah) values (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, classMatakuliah.getKode_matakuliah());
            preparedStatement.setString(2, classMatakuliah.getNama_matakuliah());
            preparedStatement.setString(3, String.valueOf(classMatakuliah.getSks_matakuliah()));
            preparedStatement.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(MatakuliahDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void delete(String nim){
        String sql = "DELETE FROM matakuliah WHERE kode_matakuliah=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            preparedStatement.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(MatakuliahDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public ClassMatakuliah loadNama(String nama){
        ClassMatakuliah classMatakuliah = null;
        String sql = "SELECT kode_matakuliah,nama_matakuliah,sks_matakuliah FROM matakuliah where nama_matakuliah=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    classMatakuliah = new ClassMatakuliah();
                    classMatakuliah.setKode_matakuliah(resultSet.getString(1));
                    classMatakuliah.setNama_matakuliah(resultSet.getString(2));
                    classMatakuliah.setSks_matakuliah(resultSet.getInt(3));
                }
        }
        catch(SQLException ex){
            Logger.getLogger(MatakuliahDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return classMatakuliah;
    }
    
    public List<ClassMatakuliah> getAll(){
        String sql = "SELECT kode_matakuliah,nama_matakuliah,sks_matakuliah FROM matakuliah";
        List<ClassMatakuliah> list = new ArrayList<ClassMatakuliah>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ClassMatakuliah classMatakuliah = new ClassMatakuliah();
                classMatakuliah.setKode_matakuliah(resultSet.getString(1));
                classMatakuliah.setNama_matakuliah(resultSet.getString(2));
                classMatakuliah.setSks_matakuliah(resultSet.getInt(3));
                list.add(classMatakuliah);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(MatakuliahDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return list;
    }
    
    public List<ClassMatakuliah>getAll(String nama_matakuliah){
        String sql = "SELECT * FROM mahasiswa where nama like?";
        List<ClassMatakuliah> list = new ArrayList<ClassMatakuliah>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nama_matakuliah + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ClassMatakuliah classMatakuliah = new ClassMatakuliah();
                classMatakuliah.setKode_matakuliah(resultSet.getString(1));
                classMatakuliah.setNama_matakuliah(resultSet.getString(2));
                classMatakuliah.setSks_matakuliah(resultSet.getInt(3));
                list.add(classMatakuliah);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(MatakuliahDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return list;
    }
    
    public ClassMatakuliah load(String kode_matakuliah){
        ClassMatakuliah classMatakuliah = null;
        String sql = "SELECT kode_matakuliah,nama_matakuliah,sks_matakuliah from matakuliah where kode_matakuliah=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kode_matakuliah);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                classMatakuliah = new ClassMatakuliah();
                classMatakuliah.setKode_matakuliah(resultSet.getString(1));
                classMatakuliah.setNama_matakuliah(resultSet.getString(2));
                classMatakuliah.setSks_matakuliah(resultSet.getInt(3));
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(MatakuliahDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return classMatakuliah;
    }
    
    public void update(String oldNim, ClassMatakuliah classMatakuliah){
        String sql = "UPDATE matakuliah SET nama_matakuliah=?,sks_matakuliah=? WHERE kode_matakuliah=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, classMatakuliah.getNama_matakuliah());
            preparedStatement.setInt(2, classMatakuliah.getSks_matakuliah());
            preparedStatement.setString(4, classMatakuliah.getKode_matakuliah());
            preparedStatement.executeUpdate();
        } 
        catch (SQLException ex){
            Logger.getLogger(MatakuliahDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public List<ClassMatakuliah> getAllNim(String kode_matakuliah){
        String sql = "SELECT * FROM matakuliah where kode_matakuliah LIKE ?";
        List<ClassMatakuliah> list = new ArrayList<ClassMatakuliah>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + kode_matakuliah + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ClassMatakuliah classMatakuliah = new ClassMatakuliah();
                classMatakuliah.setKode_matakuliah(resultSet.getString(1));
                classMatakuliah.setNama_matakuliah(resultSet.getString(2));
                classMatakuliah.setSks_matakuliah(resultSet.getInt(3));
                list.add(classMatakuliah);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(MatakuliahDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return list;
    }
}
