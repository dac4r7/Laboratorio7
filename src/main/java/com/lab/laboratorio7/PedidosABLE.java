/*
 Clase PedidosABLE : se encarga de abrir , buscar , listar y eliminar los pedidos
 Agregar pedido  
 Buscar pedido   
 Listar pedidos   
 Eliminar pedido   
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
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Diego Adrian Cesarin
 */
public class PedidosABLE {
    
    Scanner dato = new Scanner(System.in);
    Scanner numero = new Scanner(System.in);
   
    private CargarDatosPasta datospasta ; //Se encarga de solicitar los datos de la cantidad de pasta y crea el array de pastas
    private List<Pastas> pastas ; //Todas las pastas del pedido 
    private Pedido pedidoActual = null;  //Se utiliza para guardar y crear un pedido actual
    private Pedido pedidoBuscado = null; //Se guarda un pedido que es buscado
    private ArrayList<Pedido> pedidos;
    private int datoNumerico;
    
    PedidosABLE(ArrayList<Pedido> pedidos){
     this.pedidos = pedidos;  
     
     //objeto que seleccionara la pasta y almacena objeto con datos del cliente
     datospasta = new CargarDatosPasta( this.pastas , this.pedidos ); 
    }
    
    // agrega un pedido a la lista
    public ArrayList<Pedido> agregarPedido(ArrayList<Pedido> pedidos){
      this.pedidos = pedidos;  //se actualiza localmente la lista de pedidos
      datospasta.setPedidos(this.pedidos);
      //se crea el pedido con la seleccion de pastas y los datos del cliente que se piden dentro de datospasta   
      pedidoActual = datospasta.seleccionDePedido(); 
      pedidoActual.setNumeroPedido(this.pedidos.size());
      this.pedidos.add(pedidoActual); //agrega el nuevo pedido
      
        System.out.println("===SE AGREGO EL PEDIDO A LA LISTA===");  
        return this.pedidos;
    }
    
  //busco el pedido dentro del ArrayList la devolvemos si esta presente si no devuelve un null  
  public void buscarPedido(ArrayList<Pedido> pedidos){
       this.pedidos = pedidos;
       Pedido pedidoABuscar=null;
       int  numDePedido = validarNumero();          
       if(numDePedido <= pedidos.size()  )
        {
            pedidoBuscado = pedidos.get(numDePedido);
        }   
        if(pedidoABuscar != null){
          System.out.println("====SE ENCONTRO PEDIDO Nro "+numDePedido+"===");
          System.out.println(pedidoBuscado.mostrarResumen());  
          }else{ System.out.println("====== NO SE ENCONTRO EL PEDIDO ======"); }
    }
  
    //muestra los pedidos que estan en el Array
    public void listarPedidos(ArrayList<Pedido> pedidos){
      if(pedidos.size()==0){
      System.out.println("====== NO HAY PEDIDOS AUN =======");
      }else{
       for(Pedido p : pedidos){
        System.out.println(p.mostrarResumen()); 
       }
       }         
    }
    
    // elimina un pedido elegido de la lista
  public ArrayList<Pedido> eliminarPedido( ArrayList<Pedido> pedidos ){
      boolean seElimino = false; 
       this.pedidos= pedidos;
      Iterator<Pedido> it = this.pedidos.iterator();  //se crea el iterador
        System.out.println("======INGRESE EL NUMERO DE PEDIDO=====");
        datoNumerico = validarNumero();  //se valida el numero ingresado          
        try{ 
        while(it.hasNext()){
          Pedido elemento = (Pedido)it.next();
           if(elemento.getNumeroPedido() == datoNumerico){                       
              it.remove();
              System.out.println("==Numero de Pedido "+elemento.getNumeroPedido()+ " eliminado=="); 
              seElimino = true;
            }else if(!it.hasNext() && !seElimino ){
              System.out.println("===NO SE ENCONTRO EL PEDIDO "+datoNumerico +" ===");
            }
          } seElimino= false;
          }catch(NoSuchElementException nse){
            System.out.println("Fin de la lista");
          }catch(IllegalStateException ise){
            System.out.println("==No se pudo borrar el elemento==");
          }
        return this.pedidos;
    }
    
     // pide ingresar un numero y valida que es un numero , lo retorna 
  private int validarNumero() { 
       boolean ingresovalido = false, condicion=false; 
       int num = 0;
        System.out.print("Ingrese el Numero de Pedido : ");
       
    while (!ingresovalido ) {
       try{
         num = numero.nextInt();
              ingresovalido = true;    
        }catch(InputMismatchException e){
            System.out.println("= Debe Ingresar un NUMERO =");
             numero.nextLine();
        }     
      }
        return num;
    }

}
