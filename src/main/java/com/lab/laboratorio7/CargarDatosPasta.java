/*
 
Se encarga de cargar todos los datos de la seleccion del
tipo de Pasta del cliente

*/
package com.lab.laboratorio7;

import Pastas.Agnolotis;
import Pastas.FideosalHuevo;
import Pastas.Noquis;
import Pastas.Pastas;
import Pastas.Ravioles;
import Pastas.TipoPasta;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Diego Adrian Cesarin
 */
public class CargarDatosPasta {

   // Scanner dato = new Scanner(System.in);
    Scanner numero = new Scanner(System.in);
    private CargarDatosCliente datoscliente ; //Se encarga de solicitar los datos del cliente y crear un objeto cliente
    private List<Pastas> pastas = null; //Todas las pastas del pedido 
    private Pedido pedidoActual = null;  //Se utiliza para guardar y crear un pedido actual
    private Pedido pedidoBuscado = null; //Se guarda un pedido que es buscado
    private ArrayList<Pedido> pedidos;
    private int datoNumerico;
    
    public CargarDatosPasta( List<Pastas> pastas , ArrayList<Pedido> pedidos) {
      this. pastas = pastas;
      this.pedidos = pedidos;       
    }
    
  //lo utiliza el metodo agregarbPedido dentro de PedidosABLE , para crear un cliente y seleccionar las pastas de un pedido
  public Pedido seleccionDePedido(){
         
        boolean respuesta = false, ingresovalido=false;
        String seleccion="N";
        int opcion = 0;
        do{
            System.out.println("================ SELECCION DE PASTA ===================");
            System.out.println("================= OPCIONES DE PASTA ===================");
            System.out.println("-1.Fideos al huevo -2.Ravioles -3.Noquis -4.Agnolotis");
            System.out.print(">> ");
         try{
                String sel = numero.nextLine();
                              
                 opcion = Integer.parseInt(sel);   //pasamos el String a un numero si tuviera un espacio
                                                   //lanza NumberFormatException 
                 if(this.pastas == null){          //crea un nuevo array de pastas  
                  pastas = new ArrayList<>();      //especifico para este cliente
                  }
                 ingresovalido = evaluarSeleccionPasta(opcion);//Se evalua que la opcion sea valida 1 a 4, y crea el array de pastas
           
                if (!ingresovalido) {
                    System.out.println("Opciones disponibles->1.Fideos al huevo 2.Ravioles 3.Noquis 4.Agnolotis");
                }
            }catch(InputMismatchException e) {
                System.out.println("Debe ingresar un NUMERO");
                numero.nextLine();
            }catch(NumberFormatException nfe){
                    System.out.println("Debe ingresar un NUMERO(1,2,3 o 4) y no puede contener espacios");                  
              }                        
        System.out.println(">>DESEA AGREGAR MAS PASTA AL PEDIDO ?<<S/N>>");
        respuesta = validarRespuesta();   
      
        }while(respuesta);   
        
        datoscliente = new CargarDatosCliente();//al momento de crearlo va a solicitar todos los datos del cliente     
        //se pasan las pastas y objeto cliente creado
       return new Pedido(this.pastas,datoscliente.getCliente());
  }
  
    
  //Evalua que la seleccion de la pasta este entre los rangos mostrados, 
  //se suma la cantidad del tipo de pasta o se agrega un nuevo tipo de pasta al pedido
    private boolean evaluarSeleccionPasta(int opcion) {
       // se crea la lista de pastas si no existe
       
        if (opcion < 1 || opcion > 4) {
            return false;
        }        
        switch (opcion) {
            case 1: FideosalHuevo pastaFideos = (FideosalHuevo)buscarPasta(TipoPasta.fideos);
                    if(pastaFideos == null){
                       pastas.add(new FideosalHuevo(7000)); //si no esta el tipo de pasta se agrega al array se pasa el precio
                     }else{ pastaFideos.agregarCantidad();
                       }                 
                break;
            case 2: Ravioles pastaRavioles = (Ravioles)buscarPasta(TipoPasta.ravioles);//se busca si ya existe el tipo de pasta dentro del pedido
                      if(pastaRavioles == null){
                       pastas.add(new Ravioles(6500)); //si no esta el tipo de pasta se agrega al array se pasa el precio
                     }else{ pastaRavioles.agregarCantidad();
                       }             
                break;
            case 3:  Noquis pastaNoquis = (Noquis)buscarPasta(TipoPasta.noquis);//se busca si ya existe el tipo de pasta dentro del pedido
                      if(pastaNoquis == null){
                       pastas.add(new Noquis(6500)); //si no esta el tipo de pasta se agrega al array se pasa el precio
                     }else{ pastaNoquis.agregarCantidad();
                       }            
                break;
            case 4:  Agnolotis pastaAgnolotis = (Agnolotis)buscarPasta(TipoPasta.agnolotis);//se busca si ya existe el tipo de pasta dentro del pedido
                     if(pastaAgnolotis == null){
                       pastas.add(new Agnolotis(7500)); //si no esta el tipo de pasta se agrega al array se pasa el precio
                     }else{ pastaAgnolotis.agregarCantidad();
                     }          
                break;
        }
        return true;
    }
       
  //buscamos la pasta dentro del ArrayList la devolvemos si esta presente , si no esta presente se devuelve null
    public Pastas buscarPasta(TipoPasta tipo){
        int i=0;
        Pastas pastaEncontrada=null;
        while( i < this.pastas.size() && !this.pastas.get(i).equals(tipo) )
        {
            i++;          
        }
        if(i < pastas.size() ){
            pastaEncontrada = pastas.get(i);
        }
        return pastaEncontrada;
    }
    
   //Evalua si una respuesta es S o N
    public boolean validarRespuesta(){  
         Scanner d = new Scanner(System.in);
       boolean verificar = false, respuesta = false;
       String dato;
       while(!verificar){
       try{
           dato = d.nextLine();
           if(dato.equalsIgnoreCase("s")){
               respuesta= true;
               verificar=true;
           }else if(dato.equalsIgnoreCase("n")){
                respuesta = false;
                verificar = true;
           }else{
               throw new InputMismatchException("Solo puede ingresar s(para SI) o n(para NO)");
           }
       }catch(InputMismatchException ime){
           System.out.println(ime.getMessage());
       }      
      }
       return respuesta;      
    }

    //para actualizar los pedidos que existen
    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
}
