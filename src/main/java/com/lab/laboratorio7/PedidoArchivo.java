/*
SE ENCARGA DE MANIPULAR ARCHIVOS 
GUARDAR EN TXT
SERIALIZAR Y GUARDAR
DESERIALIZAR UN ARCHIVO GUARDADO

*/
package com.lab.laboratorio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Diego Adrian Cesarin
 */
public class PedidoArchivo {
    
    private ArrayList<Pedido> pedidos;
    private ObjectInputStream datosentrada = null; //Stream para los datos leidos
    private ObjectOutputStream datossalida = null;//Stream de salida de datos
    private String rutaalarchivo = "src/main/resources/pedidos.dat";//ruta por defecto   
      
    public PedidoArchivo( ArrayList<Pedido> pedidos){
      this.pedidos = pedidos;        
    }
    
    //Exporta la lista de pedidos a un archivo TXT
   public void exportarPedidosATxt(ArrayList<Pedido> pedidos) throws FileNotFoundException{
       this.pedidos = pedidos;
       String ruta = "src/main/resources/pedidos.txt";
       File f = new File(ruta);
       FileWriter fw = null;
       BufferedWriter bw = null;
       FileReader fr = null;
       BufferedReader br = null;
       
         
       try{
           fw = new FileWriter(f,true);
           bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw);
           
           Iterator it = this.pedidos.iterator();
           while(it.hasNext()){
           Pedido p = (Pedido)it.next();
               pw.println("Nro de PEDIDO: "+p.getNumeroPedido());
               pw.println(p.imprimirPedido());
           }
           pw.close();
        
           System.out.println("--PEDIDOS EXPORTADOS Como pedidos.txt--");
       }catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo");
        } catch (IOException e) {
            System.out.println("Error al escribir");
        }     
   }
   
   public void serializarPedidos(ArrayList<Pedido> pedido) throws IOException, FileNotFoundException, ClassNotFoundException{
    this.pedidos = pedido;
    this.abrirSalida();     
    try{ 
        if(datossalida != null){
        datossalida.writeObject(this.pedidos);//se guarda en el archivo
         System.out.println("--ARCHIVO SERIALIZADO GUARDADO CON EXITO--");
        }else if(datossalida == null)
             {System.out.println("datossalida= null"); }
       }catch(IOException ioe){
       System.out.println("--NO SE PUDO SERIALIZAR LOS PEDIDOS--");   
       ioe.printStackTrace();
       }
    if(datossalida != null){
        datossalida.close();
    }
   }
   
   public ArrayList<Pedido> deserializarPedidos() throws IOException, ClassNotFoundException{
   
   ArrayList<Pedido> registros = null;
  // if( this.datosentrada == null ){
    this.abrirEntrada();
 //  }
    if(this.datosentrada != null){
    try{ 
        registros = (ArrayList<Pedido>) datosentrada.readObject();  //lee el contenido del archivo
         System.out.println("----- PEDIDOS RECUPERADOS -----");
       }catch(EOFException eof){        
       }catch(IOException e){
            System.out.println("**ERROR EN LA LECTURA DEL ARCHIVO**");
            e.printStackTrace();
       }
     datosentrada.close();
    }else{
        System.out.println("-- NO HAY DATOS QUE RECUPERAR --");
    }
    return registros;      
   }
   
    public void abrirEntrada() throws FileNotFoundException, IOException {//lee archivo serializado
     try{
        datosentrada = new ObjectInputStream( new FileInputStream(rutaalarchivo)) ;
     }catch(FileNotFoundException fe){
         System.out.println("--- NO HAY ARCHIVO ---");
     }
    }
    
    public void abrirSalida() throws FileNotFoundException, IOException, ClassNotFoundException{              
        //escribe archivo serializado
        datossalida = new ObjectOutputStream( new FileOutputStream(this.rutaalarchivo));         
  
    }

    
}
