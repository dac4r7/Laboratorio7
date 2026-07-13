/*
 */
package Pastas;

import Pastas.Pastas;
import Pastas.TipoPasta;
import com.lab.laboratorio7.PedidoInvalidoException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


/**
 *
 * @author Diego Adrian Cesarin
 */
public class Ravioles extends Pastas implements Serializable{

    private int cantidad;
    private transient Scanner numero = new Scanner(System.in);
    public TipoPasta tipo = TipoPasta.ravioles;
    private double precio;

    public Ravioles( double precio) {
        super( precio);
        this.precio = precio;
        agregarCantidad();
    }

    public void agregarCantidad(){ 
        boolean seleccionOk = false;
        int cantidad = 0;  
        
           while (!seleccionOk) {         
            System.out.print("Ingrese el numero de Cajas : "); 
            try {
                 //se evalua la cantidad de pasta en el pedido
                cantidad = numero.nextInt();
                 if (cantidad < 1) {
                   throw new PedidoInvalidoException("La cantidad de cajas de Ravioles no puede ser menor a 1");
                  }                 
                seleccionOk = true; // solo si todo salió bien y se finalizo la compra
                System.out.println("- SE AGREGO AL PEDIDO -");
            } catch (PedidoInvalidoException pie) {
                System.out.println(pie.getMessage());
            } catch (InputMismatchException ime) {
                System.out.println("Se debe ingresar un numero(entero) de Cajas para la cantidad");
                numero.nextLine(); // limpia el buffer
            }
        }      
        this.cantidad += cantidad;
    }
    
   
    @Override
    public int obtenerCantidad() {
        return cantidad;
    }

    @Override
    public TipoPasta obtenerTipo() {
        return tipo;
    }

    @Override
    public String descripcion() {
        StringBuilder sb = new StringBuilder();
        sb.append("TIPO: " + obtenerTipo() + "  CANTIDAD DE CAJAS: " + obtenerCantidad()+"\n");
        sb.append("PRECIO POR CAJA : $" + getPrecio()+"  SUBTOTAL : $" + (obtenerCantidad() * getPrecio())+"\n");
        return sb.toString();
    }

    public double getPrecio() {
        return precio;
    }

     @Override
    public int hashCode() {
        return Objects.hash(tipo); // Si el ID es igual, el hash será igual
    }

  // sobreescribimos el metodo equals para que compare por tipo
    @Override
    public boolean equals(Object obj) {
        if (this.obtenerTipo() == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TipoPasta other = (TipoPasta)obj;
        return this.tipo == other; // Son la misma pasta si coincide el tipo 
    }
}
