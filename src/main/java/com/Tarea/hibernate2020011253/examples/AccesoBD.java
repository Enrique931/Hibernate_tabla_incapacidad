
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatet.examples;

import com.test.hibernatet.modelo.Incapacidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AccesoBD {
    
     
        protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    
    public AccesoBD (){
    
        tran = Persistence.createEntityManagerFactory("HibernatePU");
    
    }
    
      
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
        
        
    public void consultar(){
    em = getEntityManager();
    String sql = "SELECT * FROM INCAPACIDAD";
    Query query = em.createNativeQuery(sql,Incapacidad.class);
    List<Incapacidad> lista = query.getResultList();
    for (Incapacidad p : lista){
        System.out.print(p + "\n");
        }
    }
    
    
    public void Insertar(Integer id, String nombres, String apellidos, String direccion, String tipo_documento, String telefono, String fecha_incap, String motive_incap){
        
        try{
        em=getEntityManager();
        em.getTransaction().begin();
        String sql = "INSERT INTO INCAPACIDAD(ID,NOMBRES,APELLIDOS,DIRECCION,TIPO_DOCUMENTO,TELEFONO,FECHA_INC,MOTIVO_INCAP)VALUES(?,?,?,?,?,?,?,?)";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, id);
        query.setParameter(2, nombres);
        query.setParameter(3, apellidos);
        query.setParameter(4, direccion);
        query.setParameter(5, tipo_documento);
        query.setParameter(6, telefono);	
        query.setParameter(7, fecha_incap);
            Object motivo_incap = null;
        query.setParameter(8, motivo_incap);	
        query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Inserción de incapacidad con exito");
    
        }catch(Exception ex){
        System.out.println("Sucedio un error en el programa " + ex.getMessage());
        
        
        }finally{
    
        if(em !=null){
            em.close();
            
            }
    
        }
    
    
    }
  
    public void actualizar(String nombres, String apellidos, String direccion, String correo, String tipo_documento, String telefono,String fecha_incap,String motivo_incap,Integer id){
        try{ 
            em=getEntityManager();
            em.getTransaction().begin();
            String sql = "UPDATE INCAPACIDAD SET NOMBRES=?,APELLIDOS=?,DIRECCION=?,TIPO_DOCUMENTO =?,TELEFONO =?,FECHA_INCAP =?, MOTIVO_INCAP =?,  WHERE ID=?";
            Query query = em.createNativeQuery(sql);
            query.setParameter(1, nombres);
            query.setParameter(2, apellidos);
            query.setParameter(3, direccion);
            query.setParameter(4, tipo_documento);
            query.setParameter(5, telefono);
            query.setParameter(6, fecha_incap);
            query.setParameter(7, motivo_incap);
            query.setParameter(8, id);
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Actualización de incapacidad con exito");
    
        }catch(Exception ex){
            System.out.println("Sucedio un error en el programa " + ex.getMessage());
                
        }finally{
        if(em !=null){
            em.close();
            
            }
                      
        }
    
    }
    
  
 
    public void eliminar(Integer id) {
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            String sql = "DELETE FROM INCAPACIDAD WHERE ID = ?";
            Query query = em.createNativeQuery(sql).setParameter(1, id);
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Borrado de incapacidad satisfactorio");
           
        }catch(Exception ex){
            
            System.out.println("Sucedio un error en el programa"+ex.getMessage());
       
        }finally{
    
        if(em !=null){
            em.close();
            
            }
    
        }
             
        
    }


}
    
    

