/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatet.modelo;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="incapacidad")

public class Incapacidad implements Serializable {

 @Id
 @SequenceGenerator(name="per_sec", sequenceName="sec_incapacidades", allocationSize = 1 )
 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="per_sec")
 @Column(name="id")
 private Integer codigo;
  
 @Column (name="nombres")
 private String nombres;
 
 @Column (name="apellidos")
 private String apellidos;
 
 @Column (name="direccion")
 private String direccion;
 
 @Column (name="tipo_documento")
 private String tipo_documento;
 
 @Column (name="telefono")
 private String telefono;
 
 @Column (name="fecha_incap")
 private String fecha_incap;

@Column (name="motivo_incap")
 private String motivo_incap;


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_incap() {
        return fecha_incap;
    }

    public void setFecha_incap(String fecha_incap) {
        this.fecha_incap = fecha_incap;
    }

    public String getMotivo_incap() {
        return motivo_incap;
    }

    public void setMotivo_incap(String motivo_incap) {
        this.motivo_incap = motivo_incap;
    }


    @Override
    public String toString() {
        return "{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", tipo_documento=" + tipo_documento + ", telefono=" + telefono + ", fecha_incap=" + fecha_incap +", motivo_incap=" + motivo_incap + '}';
    }

  
    
    
    
}
