/*
 */
package Pastas;

import Pastas.Pastas;
import Pastas.TipoPasta;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import com.lab.laboratorio7.PedidoInvalidoException;
import java.io.Serializable;

/**
 *
 * @author Diego Adrian Cesarin
 */
public class FideosalHuevo extends Pastas implements Serializable{

    private int cantidad;
    public TipoPasta tipo = TipoPasta.fideos;
    private transient Scanner numero = new Scanner(System.in);
    private double precio;

    public FideosalHuevo( double precio) {
        super( precio); 
        this.precio = precio;
        agregarCantidad();
    }
    
    public FideosalHuevo(){  
    }
    
      public void agregarCantidad(){ 
        boolean seleccionOk = false;
        int cantidad = 0;  
        
           while (!seleccionOk) {         
            System.out.print("Ingrese el numero de kilogramos : "); 
            try {
                 //se evalua la cantidad de pasta en el pedido
                cantidad = numero.nextInt();
               if (cantidad < 1 || cantidad > 10) {
                 throw new PedidoInvalidoException("La cantidad de kilogramos de fideos no puede ser mayor a 10kg o menor a 1");
                  }                 
                seleccionOk = true; // solo si todo salió bien y se finalizo la compra
                System.out.println("- SE AGREGO AL PEDIDO -");
            } catch (PedidoInvalidoException pie) {
                System.out.println(pie.getMessage());
            } catch (InputMismatchException ime) {
                System.out.println("Se debe ingresar un numero(entero) de Kilos para la cantidad");
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
       sb.append("TIPO: " + obtenerTipo() + "  CANTIDAD DE kg: " + obtenerCantidad()+"\n");
        sb.append("PRECIO POR kg: $" + getPrecio()+"  SUBTOTAL: $" + (obtenerCantidad() * getPrecio())+"\n");
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
