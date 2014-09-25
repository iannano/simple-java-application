/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pertemuan.dao.ian;
import java.util.List;
import pertemuan.model.ian.ClassMahasiswa;
/**
 *
 * @author Ian-Nano
 */
public interface MahasiswaDAO {
    public void insert(ClassMahasiswa sw);
    public void delete(String nim);
    public void update(String oldNim, ClassMahasiswa sw);
    public ClassMahasiswa loadNama(String nama);
    public ClassMahasiswa load(String nim);
    public List<ClassMahasiswa>getAll();
    public List<ClassMahasiswa>getAll(String name);
    public List<ClassMahasiswa>getAllNim (String nim);
}
