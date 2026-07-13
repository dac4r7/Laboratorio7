/*


*/
package com.lab.laboratorio7;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Cliente implements Serializable{
      
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private String direccion;
    private Venta mediodeventa;  //Enum con los medios de venta

    public Cliente(String nombre, String apellido, String mail, String telefono, String direccion, Venta mediodeventa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        this.direccion = direccion;
        this.mediodeventa = mediodeventa;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Venta getMediodeventa() {
        return mediodeventa;
    }
    
}
