/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatet.Dao;

import com.test.hibernatet.modelo.Incapacidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class incapacidadDao {
    
    protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    
    public incapacidadDao (){
    
        tran = Persistence.createEntityManagerFactory("HibernatePU");
    
    }
    
    public Incapacidad fyndbyId(Incapacidad p){
        em = getEntityManager();
        return em.find(Incapacidad.class, p.getCodigo());
    }
    
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
    
    
    public void selectall(){
    
    //Iniciamos variable que contiene la sentencia a ejecutar
        String hql = "SELECT p from Incapacidad p";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Incapacidad> lista = query.getResultList();
        for (Incapacidad p : lista){
        System.out.print(p + "\n");
        }
        
    }

    
    
    
    public void Insertar (Incapacidad incapacidad){
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(incapacidad);
            em.getTransaction().commit();
            

        }catch (Exception ex){
        
            System.out.println("Error al insertar el objeto:" + ex.getMessage());
        
        
        }finally{
        
        if(em !=null){
            em.close();
            }
        
        }
    }

        
     public void actualizar (Incapacidad incapacidad){
     try{
         em = getEntityManager();
         em.getTransaction().begin();
         em.merge(incapacidad);
         em.getTransaction().commit();
         
     
     }catch (Exception ex){
     
         System.out.println("Error al actualizar el objeto:"+ex.getMessage());
     
     
        }finally{
            if(em !=null){
                
                em.close();
            
            }
        }  
         
     }
    
    
    public void eliminar (Incapacidad incapacidad){
    try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(incapacidad));
        em.getTransaction().commit();

   
    
    }catch (Exception ex){
        System.out.println("Error al eliminar el objeto incapacidad:"+ ex.getMessage());
    
    
        }finally{
    
        if(em !=null){
            em.close();
            
            }
        
        }
    
    }
    
    
}
