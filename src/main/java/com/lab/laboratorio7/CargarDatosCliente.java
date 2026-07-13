/*
Se encarga de Cargar todos los datos 
del cliente y devolver un objeto cliente

*/
package com.lab.laboratorio7;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Diego A. Cesarin
 */
public class CargarDatosCliente {
    
    Scanner datos = new Scanner(System.in);
    Scanner num = new Scanner(System.in);
    private Cliente cliente = null;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private String direccion;
    private Venta mediodeventa;  //Enum con los medios de venta

    public CargarDatosCliente() {
     this.cliente = cargarDatosCliente();        
    }
    //carga y valida los datos del cliente creando el objeto Cliente
    private Cliente cargarDatosCliente() { 
       
        String cadena = "";
        int opcion;
        boolean ingresovalido = false;
         System.out.println("==== DATOS DEL CLIENTE ====");
        setNombre( validarNomOApp("Nombre"));   //validamos el Nombre y lo agregamos
             
        setApellido(validarNomOApp("Apellido"));   //Validamos el apellido y lo agregamos

        System.out.print("Ingrese el Email : ");
        cadena = datos.nextLine();
        setMail(cadena);
        this.telefono = validarNumero();          //se valida el telefono de 8 a 10 numeros
        System.out.print("Ingrese la Direccion : ");
        cadena = datos.nextLine();
        setDireccion(cadena);

        while (!ingresovalido) {  //selecciona el medio de venta
            System.out.println("1.Telefono 2.Web 3.Redes Sociales");
            try {
                opcion = num.nextInt();

                if (seleccionarMediodeVenta(opcion)) {  //Se valida  el medio de venta 
                    ingresovalido = true;
                } 
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un numero.");
                num.nextLine(); // limpia la entrada incorrecta
            }
        }
        return new Cliente(nombre,  apellido,  mail, telefono,  direccion, mediodeventa);
    }
    
      //valida un nombre o un apellido
     private String validarNomOApp(String dato){
       String cadena = ""; 
       boolean ingresovalido = false; 

        while (!ingresovalido) {
            try {       //Cargamos Apellido
                System.out.print("Ingrese el "+ dato + " : ");
                cadena = datos.nextLine();
                ingresovalido = validarCadena(cadena);
            } catch (InputMismatchException ime) {
                System.out.println("El "+dato+" admite solo letras(max 15) y no puede quedar vacio");
            } catch (IllegalArgumentException iae) {
                System.out.println("El "+dato+" admite solo letras(max 15) y no puede quedar vacio");
            }
        }
        return cadena; 
     }
     
       //Segun la Opcion elegida selecciona un medio de venta
     private boolean seleccionarMediodeVenta(int opcion) {
        try{
         if (opcion < 1 || opcion > 3) {
            throw new ArithmeticException();}
         }catch(ArithmeticException ae){
             System.out.println("Opcion invalida. Debe ser 1, 2 o 3.");
            return false;}
        
        switch (opcion) {
            case 1:
                this.mediodeventa = Venta.telefono ;
                break;
            case 2:
                this.mediodeventa = Venta.web ;
                break;
            case 3:
                this.mediodeventa = Venta.redes_sociales ;
                break;
        }
        return true;
    }
     
         //valida que la cadena no este vacia o supere 15 caracteres
    private boolean validarCadena(String cadena) { 
        if (cadena == null || cadena.isEmpty() || cadena.length() > 15) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isLetter(cadena.charAt(i))) {//evalua caracter a caracter
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
    
     //valida el numero de telefono se utiliza IllegalArgumentException e InputMismatchException
    private String validarNumero() { 
       Scanner dato = new Scanner(System.in);
       boolean ingresovalido = false, condicion=false;     
       String num="" ;
        System.out.print("Ingrese el Telefono(8 a 10 digitos ) : ");
        
    while (!ingresovalido &&  !condicion ) {
       try{
         num = dato.nextLine().trim();  //quitamos los espacios
         
         if(!num.matches("\\d+")){//Se valida que solo haya numeros dentro de num
             throw new InputMismatchException();
         }              
         int longitud = num.length();
         condicion = longitud >7  && longitud < 11 ;
           
         if(condicion){
              ingresovalido = true;
         }else if(!condicion){
             throw new IllegalArgumentException("=== El telefono tiene que tener de 8 a 10 digitos ===");
         }           
        }catch(IllegalArgumentException iae){
            System.out.println( iae.getMessage() );//lanza el mensaje anterior
        }catch(InputMismatchException  ime){
            System.out.println("=== Solo puede haber un NUMERO como telefono ===");
        }  
      }
        return num;
    }
    
     public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
     private void setMail(String mail) {
        this.mail = mail;
    }
      private void setTelefono() {
        this.telefono = validarNumero();
    }
    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }
  //devuelve el cliente creado durante la carga de datos
    public Cliente getCliente() {
        return cliente;
    }
    
    
}
