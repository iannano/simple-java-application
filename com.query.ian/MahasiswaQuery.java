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
import com.dao.ian.MahasiswaDAO;
import com.model.ian.ClassMahasiswa;

/**
 *
 * @author Ian-Nano
 */
public class MahasiswaQuery implements MahasiswaDAO{
    private Connection connection = null;
    
    public MahasiswaQuery(Connection connection){
        this.connection = connection;
    }
    
    public void insert(ClassMahasiswa classSiswa){
        String sql = "INSERT INTO mahasiswa(nim, nama, alamat,no_telp) values (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, classSiswa.getNim());
            preparedStatement.setString(2, classSiswa.getNama());
            preparedStatement.setString(3, classSiswa.getAlamat());
            preparedStatement.setString(4, classSiswa.getTelphone());
            preparedStatement.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void delete(String nim){
        String sql = "DELETE FROM mahasiswa WHERE nim=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            preparedStatement.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public ClassMahasiswa loadNama(String nama){
        ClassMahasiswa classSiswa = null;
        String sql = "SELECT nim,nama,alamat,no_telp FROM mahasiswa where nama=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    classSiswa = new ClassMahasiswa();
                    classSiswa.setNim(resultSet.getString(1));
                    classSiswa.setNama(resultSet.getString(2));
                    classSiswa.setAlamat(resultSet.getString(3));
                    classSiswa.setTelphone(resultSet.getString(4));
                }
        }
        catch(SQLException ex){
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return classSiswa;
    }
    
    public List<ClassMahasiswa> getAll(){
        String sql = "SELECT nim,nama,alamat,no_telp FROM mahasiswa";
        List<ClassMahasiswa> list = new ArrayList<ClassMahasiswa>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ClassMahasiswa classSiswa = new ClassMahasiswa();
                classSiswa.setNim(resultSet.getString(1));
                classSiswa.setNama(resultSet.getString(2));
                classSiswa.setAlamat(resultSet.getString(3));
                classSiswa.setTelphone(resultSet.getString(4));
                list.add(classSiswa);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return list;
    }
    
    public List<ClassMahasiswa>getAll(String nama){
        String sql = "SELECT * FROM mahasiswa where nama like?";
        List<ClassMahasiswa> list = new ArrayList<ClassMahasiswa>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nama + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ClassMahasiswa classSiswa = new ClassMahasiswa();
                classSiswa.setNim(resultSet.getString(1));
                classSiswa.setNama(resultSet.getString(2));
                classSiswa.setAlamat(resultSet.getString(3));
                classSiswa.setTelphone(resultSet.getString(4));
                list.add(classSiswa);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return list;
    }
    
    public ClassMahasiswa load(String nim){
        ClassMahasiswa classSiswa = null;
        String sql = "SELECT nim,nama,alamat,no_telp from mahasiswa where nim=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                classSiswa = new ClassMahasiswa();
                classSiswa.setNim(resultSet.getString(1));
                classSiswa.setNama(resultSet.getString(2));
                classSiswa.setAlamat(resultSet.getString(3));
                classSiswa.setTelphone(resultSet.getString(4));
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return classSiswa;
    }
    
    public void update(String oldNim, ClassMahasiswa classSiswa){
        String sql = "UPDATE mahasiswa SET nama=?,alamat=?,no_telp=? WHERE nim=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, classSiswa.getNama());
            preparedStatement.setString(2, classSiswa.getAlamat());
            preparedStatement.setString(3, classSiswa.getTelphone());
            preparedStatement.setString(4, classSiswa.getNim());
            preparedStatement.executeUpdate();
        } 
        catch (SQLException ex){
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public List<ClassMahasiswa> getAllNim(String nim){
        String sql = "SELECT * FROM mahasiswa where nim LIKE ?";
        List<ClassMahasiswa> list = new ArrayList<ClassMahasiswa>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nim + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ClassMahasiswa classMahasiswa = new ClassMahasiswa();
                classMahasiswa.setNim(resultSet.getString(1));
                classMahasiswa.setNama(resultSet.getString(2));
                classMahasiswa.setAlamat(resultSet.getString(3));
                classMahasiswa.setTelphone(resultSet.getString(4));
                list.add(classMahasiswa);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return list;
    }
}
