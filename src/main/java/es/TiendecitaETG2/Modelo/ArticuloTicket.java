package es.TiendecitaETG2.Modelo;

public class ArticuloTicket {
    private int id;
    private String descripcion;
    private double precio;
    private int stock;
    private String proveedor;

    public ArticuloTicket(int id, String descripcion, double precio, int stock, String proveedor) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Descripción: " + descripcion + " | Precio: " + precio + " | Stock: " + stock + " | Proveedor: " + proveedor;
    }
}
