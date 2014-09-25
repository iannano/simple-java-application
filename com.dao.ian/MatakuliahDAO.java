/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao.ian;

import java.util.List;
import com.model.ian.ClassMatakuliah;

/**
 *
 * @author Ian-Nano
 */
public interface MatakuliahDAO {
    public void insert(ClassMatakuliah classMatakuliah);
    public void delete(String kode_matakuliah);
    public void update(String oldKode_matakuliah, ClassMatakuliah classMatakuliah);
    public ClassMatakuliah loadNama(String nama_matakuliah);
    public ClassMatakuliah load(String kode_matakuliah);
    public List<ClassMatakuliah>getAll();
    public List<ClassMatakuliah>getAll(String nama_matakuliah);
    public List<ClassMatakuliah>getAllNim (String kode_matakuliah);
}
