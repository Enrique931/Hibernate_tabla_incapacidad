/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatet.Operations;

import com.test.hibernatet.Dao.incapacidadDao;
import com.test.hibernatet.modelo.Incapacidad;
import java.util.Scanner;

public class OperHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        incapacidadDao incapacidad = new incapacidadDao();
        
        Incapacidad p1 = null;
        int opcion = -1;
        Scanner entrada = new Scanner(System.in);
        String id, nombres, apellidos, direccion, email, dui, tip_sangre;
  
        while (opcion !=0){
        
        try{
            System.out.println("Elige una opcion:\n1.-Listar Incapacidades" + 
          "\n2.-Buscar incapacidad por Id\n" +
                    "3.-Agregar a una incapacidad\n" +
                    "4.-Modificar una incapacidad\n"+
                    "5.-Eliminar una incapacidad\n" +
                    "0.-Salir\n");

            opcion = Integer.parseInt(entrada.nextLine());
            
            switch (opcion){
                case 1:
                    System.out.println("\n1.Listado***********");
                    incapacidad.selectall();
                    break;
                    
                case 2:
                    System.out.println("\n2.Buscar incapacidad por Id***********");
                    System.out.println("Introduce el Id de la incapacidad a buscar:");
                    id = entrada.nextLine();
                    p1 = new Incapacidad();
                    p1.setCodigo(new Integer(id));
                    p1 = incapacidad.fyndbyId(p1);
                    System.out.println("Registro encontrado:" + p1);
                    break;
                case 3:
                    System.out.println("\n3.Insertar***********");
                    System.out.println("Introduce los nombres de la persona a agregar");
                    nombres = entrada.nextLine();
                    
                    System.out.println("Introduce los apellidos de la persona a agregar");
                    apellidos = entrada.nextLine();
                    
                    System.out.println("Introduce la direccion de la persona a agregar");
                    direccion = entrada.nextLine();
                    
                    System.out.println("Introduce el tipo de documento");
                String tipo_documento = entrada.nextLine();
                    
                    System.out.println("Introduce numero de telefono");
                String telefono = entrada.nextLine();
                    
                    System.out.println("Introduce la fecha de incapacidad");
                String fecha_incap = entrada.nextLine();

                    System.out.println("Introduce el motivo de la incapacidad");
                String motivo_incap = entrada.nextLine();
                                  
                    p1 = new Incapacidad();
                    p1.setNombres(nombres);
                    p1.setApellidos(apellidos);
                    p1.setDireccion(direccion);
                    p1.setTipo_documento(tipo_documento);
                    p1.setTelefono(telefono);
                    p1.setFecha_incap(fecha_incap);
                    p1.setMotivo_incap(motivo_incap);
                    incapacidad.Insertar(p1);
                    break;




                case 4:
                    System.out.println("\n4.Modificar***********");
                    //primero buscamos la incapacidad a modificar
                    System.out.println("Introducir el Id de la incapacidad a modificar");
                    id = entrada.nextLine();
                    p1= new Incapacidad();
                    p1.setCodigo(new Integer(id));
                    incapacidad.fyndbyId(p1);
                    
                    System.out.println("Introduce el nombre de la persona a modificar");
                    nombres = entrada.nextLine();
                    
                    System.out.println("Introduce el apellido de la persona a modificar");
                    apellidos = entrada.nextLine();
                    
                    System.out.println("Introduce la direccion a modificar");
                    direccion = entrada.nextLine();
                    System.out.println("Introduce el tipo de documento");
                    tipo_documento = entrada.nextLine();
                    
                    System.out.println("Introduce numero de telefono");
                    telefono = entrada.nextLine();
                    
                    System.out.println("Introduce la fecha de incapacidad");
                    fecha_incap = entrada.nextLine();

                    System.out.println("Introduce el motivo de la incapacidad");
                    motivo_incap = entrada.nextLine();
                    
                    p1.setNombres(nombres);
                    p1.setApellidos(apellidos);
                    p1.setDireccion(direccion);
                    p1.setTipo_documento(tipo_documento);
                    p1.setTelefono(telefono);
                    p1.setFecha_incap(fecha_incap);
                    p1.setMotivo_incap(motivo_incap);
                    incapacidad.actualizar(p1);
                    break;
                case 5:
                    System.out.println("\n5.Eliminar***********");
                    //buscamos la incapacidad a eliminar
                    System.out.println("Introduce el id de la incapacidad a eliminar");
                    id= entrada.nextLine();
                    p1 = new Incapacidad();
                    p1.setCodigo(new Integer(id));
                    p1 = incapacidad.fyndbyId(p1);
                    //Eliminar el registro encontrado
                    incapacidad.eliminar(p1);
                    break;
                case 0:
                    System.out.println("Salida efectuada");
                    System.exit(0);
                    break;
                    
            
                } 
                    System.out.println("\n");
            
               }catch(Exception ex){
                    System.out.println("Surgio una falla en la ejecucion del programa:" + ex.getMessage());
            }
        
        } 
    }
    
}
