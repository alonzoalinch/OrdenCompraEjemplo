package ProyectoOrdenCompra;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EjemploOrdenes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String fabricante;
        String nombre;
        int precio;

        List<OrdenCompra> ordenCompras = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            OrdenCompra ordenCompra = new OrdenCompra("OC" + (i+1));
            ordenCompras.add(ordenCompra);
            ordenCompra.setFecha(new Date());
            System.out.println("Ingrese nombre de Cliente: ");
            String name = scanner.next();
            System.out.println("Ingrese apellido de Cliente: ");
            String lastname = scanner.next();
            ordenCompra.setCliente(new Cliente(name, lastname));
            System.out.println("Ingrese productos de la " + ordenCompras.get(i).getDescripcion());

            for (int j = 0; j < 2; j++) {
                System.out.println("Ingrese nuevo Producto " + (j + 1));
                System.out.println("Ingrese nombre de fabricante: ");
                fabricante = scanner.next();
                System.out.println("Ingrese nombre del producto; ");
                nombre = scanner.next();
                System.out.println("Ingrese precio del producto: ");

                precio = scanner.nextInt();

                Producto producto = new Producto(fabricante, nombre, precio);
                ordenCompra.addProducto(producto);
            }
        }

        for (OrdenCompra ordenCompra : ordenCompras) {
            System.out.println("Identificador: "+ordenCompra.getIdentificador());
            System.out.println("Descipción: "+ordenCompra.getDescripcion());
            System.out.println("Fecha: "+ ordenCompra.getFecha());
            System.out.println("Cliente: " + ordenCompra.getCliente().getNombre() + " "+ ordenCompra.getCliente().getApellido() );
            for (Producto producto : ordenCompra.getProductos()) {
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Fabricante: " + producto.getFabricante());
                System.out.println("Precio: " + producto.getPrecio());
            }
            System.out.println(" Precio Total " + ordenCompra.retrieveTotal(ordenCompra.getProductos()));
        }

    }
} 
