package co.edu.uniquindio.poo.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public record Factura(String codigo, LocalDate fecha, double total,
                      EstadoFactura estadoFactura, MetodoPago metodoPago, Cliente cliente,
                      ArrayList<DetalleFactura> listaDetallesFactura, Tienda ownedByTienda) {

    public String registrarFactura(Factura factura) {
        return ownedByTienda.registrarFactura(factura);
    }

    public Optional<Factura> buscarFactura(Factura factura) {
        return ownedByTienda.buscarFactura(codigo);
    }

    public String actualizarFactura(Factura facturaNueva) {
        return ownedByTienda.actualizarFactura(facturaNueva);
    }

    public String eliminarFactura(String codigo) {
        return ownedByTienda.eliminarFactura(codigo);
    }

    public double calcularTotal() {
        double total = 0;
        for (DetalleFactura detalle : listaDetallesFactura) {
            total += detalle.calcularTotal();
        }
        return total;
    }
    public void actualizarInventario(){
        for (DetalleFactura detalle : listaDetallesFactura) {
            Producto producto= detalle.getProducto();
           int cantidadComprada= detalle.getCantidadComprada();
            producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidadComprada);
        }
        }
}