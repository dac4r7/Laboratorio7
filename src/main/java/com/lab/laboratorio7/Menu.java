/*

   

 
   

 */
package com.lab.laboratorio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;



/**
 *
 * @author Diego Adrian Cesarin 
 */
public class Menu {

    Scanner dato = new Scanner(System.in);
    Scanner numero = new Scanner(System.in);
    private Pedido pedidoActual = null;  //Se utiliza para guardar y crear un pedido actual
    private Pedido pedidoBuscado = null; //Se guarda un pedido que es buscado
    private PedidosABLE pedidosABLE = null; //Agrega,Busca,Lista,Elimina
    private PedidoArchivo pedidoArchivo = null;
    private int datoNumerico;
       
    private ArrayList<Pedido> pedidos = new ArrayList<>();//Listado pedidos 

    public Menu(ArrayList<Pedido> pedidos) { 
        this.pedidos = pedidos;//se pasan los pedidos , cada pedido tiene su propio cliente y pasta
        this.pedidosABLE = new PedidosABLE(pedidos);
        this.pedidoArchivo = new PedidoArchivo(pedidos);
    }
    
    public void menuDeUsuario() throws IOException, ClassNotFoundException{
       int optionumber =0;
       boolean opcioncorrecta = false;      
      do{ 
       while(!opcioncorrecta){ 
       System.out.println("=========== MAT-NOODLES SRL ============");    
       System.out.println(" 1. Agregar pedido");   
       System.out.println(" 2. Buscar pedido");   
       System.out.println(" 3. Listar pedidos");   
       System.out.println(" 4. Eliminar pedido");   
       System.out.println(" 5. Exportar pedidos a TXT");   
       System.out.println(" 6. Guardar pedidos(Serializacion)");   
       System.out.println(" 7. Recuperar pedidos(Deserializacion)");   
       System.out.println(" 8. Salir");       
       System.out.println("========== INGRESE UNA OPCION =========");      
       try{
           optionumber = numero.nextInt();       
           if( optionumber > 0 && optionumber < 9){      
           opcioncorrecta = true; 
           }else{
               System.out.println("Las opciones van del 1 al 8.Reingrese una Opcion");
           }                             
          }catch(Exception e){
            System.out.println("Solo puede Ingresar un Numero del 1 al 8 !");  
            numero.nextLine();
        }
       }
       opcionesDeUsuario(optionumber);  //opciones del usuario
       opcioncorrecta=false;
       
      }while( optionumber > 0 && optionumber < 8);    
    }
   private void opcionesDeUsuario(int opcion) throws IOException, ClassNotFoundException {
        boolean seElimino = false;
        switch (opcion) {
            case 1://Agregar pedido  se actualizas this.pedidos            
                this.pedidos = pedidosABLE.agregarPedido(this.pedidos);
                break;
            case 2:  //Buscar pedido         
                pedidosABLE.buscarPedido(this.pedidos);
                break;         
            case 3: //listar pedidos
                pedidosABLE.listarPedidos(this.pedidos);
                break;
            case 4:   //eliminar pedidos  se actualiza this.pedidos        
                this.pedidos = pedidosABLE.eliminarPedido(this.pedidos);
                break;
            case 5: //exportar pedidos a txt
                 pedidoArchivo.exportarPedidosATxt(this.pedidos);
                  break;
            case 6://guardar pedidos serializados
                  pedidoArchivo.serializarPedidos(this.pedidos);
                  break;
            case 7://recuperar pedidos deserializados
                  this.pedidos = pedidoArchivo.deserializarPedidos();
                  break;
            case 8://salir
                  System.out.println("Saliendo");
                break;
        }     
    }
    
  
}
