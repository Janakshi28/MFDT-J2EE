/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.megafundtpark.sessionbeans;

import lk.megafundtpark.remote.interfaces.PhotosFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.megafundtpark.entities.Ebands;
import lk.megafundtpark.entities.Photos;
import lk.megafundtpark.remote.utils.PhotoDetails;


/**
 *
 * @author Janakshi
 */
@Stateless(mappedName = "photosfacade")
public class PhotosFacade implements PhotosFacadeRemote {

    @PersistenceContext(unitName = "MegaFunDTPark-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }
    
    private List<PhotoDetails> copyToPhotoDetails(List< Photos> photos) {
        List<PhotoDetails>  photoList = new ArrayList<PhotoDetails>();
        Iterator i =  photos.iterator();
        while (i.hasNext()) {
            Photos photo = (Photos) i.next();
            PhotoDetails details = new PhotoDetails(photo.getPhotoid(),photo.getIsframed(), photo.getIsenlarged(),photo.getIsedited(),
                                                    photo.getPic(), (photo.getEbands()).getBandid());
            photoList.add(details);
        }
        return photoList;
    }
    
    private PhotoDetails copyToPhotoDetails(Photos photo) {
        return new PhotoDetails(photo.getPhotoid(),photo.getIsframed(), photo.getIsenlarged(),photo.getIsedited(),
                                                    photo.getPic(), (photo.getEbands()).getBandid());
    }
    
    @Override
    public PhotoDetails getPhoto(String id) {
        try {
            PhotoDetails photo = this.copyToPhotoDetails(em.find(Photos.class, id));
            
            return photo;
        } catch (Exception e) {
            return null;
        }
    }
     
    @Override
    public void createPhoto(PhotoDetails details) {
        try {
            Photos photo = new Photos(details.getIsframed(),details.getIsenlarged(),details.getIsedited(),details.getPic());
            photo.setEbands(em.find(Ebands.class, details.getEbandId()));
            em.persist(photo);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void editPhoto(PhotoDetails details) {
        try {
            Photos photo = new Photos(details.getPhotoid(),details.getIsframed(),details.getIsenlarged(),details.getIsedited(),details.getPic(),
                                                 em.find(Ebands.class, details.getEbandId()));
            em.merge(photo);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
    public void removePhoto(Integer id) {
        try {
            Photos photo = em.find(Photos.class, id);
            em.remove(photo);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    @Override
     public List<PhotoDetails> getPhotoList(int bandId) {
            try {
                
                 List<Photos> results = em.createNamedQuery("Photos.findByBandId", Photos.class)
                        .setParameter("bandid", bandId)
                        .getResultList();
                if (results.isEmpty()) {
                    return null;
                } else {
                            return copyToPhotoDetails(results);
                }
            }
               // return customer;
             catch (Exception e) {
                return null;
            }
        
  
 }
    
    @Override
    public PhotoDetails find(Object pk) {
        Photos photo= em.find(Photos.class, pk);
        return new PhotoDetails(photo.getPhotoid(),photo.getIsframed(), photo.getIsenlarged(),photo.getIsedited(),
                                            photo.getPic(), (photo.getEbands()).getBandid());
    }
    
    @Override
    public List findAll() {
        return copyToPhotoDetails(em.createQuery("select object(o) from Photos as o").getResultList());
    }
    
}
