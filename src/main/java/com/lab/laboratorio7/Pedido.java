/*


*/
package com.lab.laboratorio7;

import Pastas.TipoPasta;
import Pastas.Pastas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

//import lab.laboratorio7.Cliente;


/**
 *
 * @author Diego A. Cesarin
 */
public class Pedido implements Serializable{
    
  private List<Pastas> pastas = new ArrayList<>(); //Todas las pastas del pedido 
  private Cliente cliente ;                        //Todos los datos del cliente
  private int numeroPedido ;
 
    public Pedido( List<Pastas> pastas, Cliente cliente ) {
     this.pastas = pastas;
     this.cliente = cliente;  //Se crea un cliente al pedido  
    } 

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }
    
    //Evalua que la seleccion de la pasta este entre los rangos mostrados, 
    //se suma la cantidad del tipo de pasta o se agrega un nuevo tipo de pasta al pedido
   
  public String mostrarResumen(){  //Muestra el resumen de los pedidos del cliente
      StringBuilder mensaje = new StringBuilder();
      //mensaje.append("| Nro. de PEDIDO : "+ this.getNumeroPedido() );
      mensaje.append("| CLIENTE : "+cliente.getNombre()+" "+ cliente.getApellido()+ " MEDIO DE VENTA: " +
                         cliente.getMediodeventa().toString()+ "\n");     
      mensaje.append("==================  DETALLE DE COMPRA  ====================\n");
      for(Pastas p : pastas){
          mensaje.append(p.descripcion());
      }
      mensaje.append(calcularCompra());
      return mensaje.toString();
  } 
    
   public String imprimirPedido(){  //Muestra el resumen de los pedidos del cliente
      StringBuilder mensaje = new StringBuilder();
      double total = 0;
      for(Pastas p : pastas){
        total += p.obtenerCantidad() * p.getPrecio();
      }
     // mensaje.append(" PEDIDO : "+ this.getNumeroPedido() );
      mensaje.append(" CLIENTE : "+cliente.getNombre()+" " +cliente.getApellido()+
                     "\n CANAL : "+ cliente.getMediodeventa().toString()+
                     "\n IMPORTE : " + total + "\n" );     
 
      return mensaje.toString();
  }
  
  public String calcularCompra(){ //Calcula el total de una compra para un cliente
    double total = 0;
    StringBuilder sb = new StringBuilder();
    for(Pastas p : pastas){
        total += p.obtenerCantidad() * p.getPrecio();
    }

    sb.append("----------------------------------------------------\n");
    sb.append("|  TOTAL A PAGAR: $" + total+"\n");           
    sb.append("----------------------------------------------------\n");
    return sb.toString();
   }

    public Cliente getCliente() {
        return cliente;
    }
    
}
