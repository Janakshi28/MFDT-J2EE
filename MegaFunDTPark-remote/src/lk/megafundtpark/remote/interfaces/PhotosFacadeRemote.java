/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.remote.interfaces;

import java.util.List;
import javax.ejb.Remote;
import lk.megafundtpark.remote.utils.PhotoDetails;

/**
 *
 * @author Janakshi
 */
@Remote
public interface PhotosFacadeRemote {

    public void persist(Object object);

    public PhotoDetails getPhoto(String id);

    public void createPhoto(PhotoDetails details);

    public void editPhoto(PhotoDetails details);

    public void removePhoto(Integer id);

    public PhotoDetails find(Object pk);

    public List findAll();

    public List<PhotoDetails> getPhotoList(int bandId);
    
}
