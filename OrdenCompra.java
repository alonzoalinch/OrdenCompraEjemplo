package ProyectoOrdenCompra;

import java.util.*;


public class OrdenCompra {

    private Integer identificador;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private List<Producto> productos = new ArrayList<>(4);

    public static int ultimoId;


    public OrdenCompra(){
        this.identificador = ++ultimoId;
    }
    public void addProducto(Producto producto) {
       productos.add(producto);
    }

    public Double retrieveTotal( List<Producto> productos) {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
    public OrdenCompra(String descripcion) {
        this();
        this.descripcion = descripcion;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
