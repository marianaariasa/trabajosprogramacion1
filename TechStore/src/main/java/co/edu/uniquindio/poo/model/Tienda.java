package co.edu.uniquindio.poo.model;
import java.time.LocalDate;
import java.util.*;
public class Tienda {
    private final String nombre;
    private final String nit;
    private String telefono;

    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final List<Factura> listaFacturas = new LinkedList<Factura>();
    private Map<String, Producto> listaProductos = new HashMap<>();


    public Tienda(String nombre, String nit, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    // setters y getters

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // hacer el metodo buscar cliente usando un optional
    public String registrarCliente(Cliente cliente) {
        Optional<Cliente> clienteEncontrado = buscarCliente(cliente.getDocumentoIdentidad());
        if (clienteEncontrado.isEmpty()) {
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        } else {
            return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
        }
    }

    public Optional<Cliente> buscarCliente(String documentoIdentidad) {
        return listaClientes.stream() // .stream recorre la lista para encontrar algo
                .filter(cliente -> cliente.getDocumentoIdentidad().equals(documentoIdentidad)) // expresión lambda es similar a un for
                .findFirst();
    }

    public String actualizarCliente(String nombre, String documentoIdentidad, String telefono,
                                    String correo, String ciudad) {
        Optional<Cliente> clienteEncontrado = buscarCliente(documentoIdentidad);
        if (clienteEncontrado.isPresent()) {
            Cliente cliente = clienteEncontrado.get();
            cliente.setNombreCompleto(nombre);
            cliente.setTelefono(telefono);
            cliente.setCorreo(correo);
            cliente.setCiudadResidencia(ciudad);
            return "El cliente fue actualizado exitosamente";
        }

        return "No se encontró un cliente con ese documento";
    }

    public String eliminarCliente(String documentoIdentidad) {
        Optional<Cliente> clienteEncontrado = buscarCliente(documentoIdentidad);
        if (clienteEncontrado.isPresent()) {
            listaClientes.remove(clienteEncontrado.get());
            return "El cliente fue eliminado exitosamente";
        }
        return "No se encontró un cliente con ese documento";
    }

    public String registrarFactura(Factura factura) {
        Optional<Factura> facturaEncontrada = buscarFactura(factura.codigo());
        if (facturaEncontrada.isEmpty()) {
            listaFacturas.add(factura);
            return "La factura fue registrada exitosamente";
        }
        return "No se puede registrar, ya existe una factura con ese codigo";
    }

    public Optional<Factura> buscarFactura(String codigo) {
        return listaFacturas.stream()
                .filter(factura -> factura.codigo().equals(codigo))
                .findFirst();
    }

    public String actualizarFactura(Factura facturaNueva) {
        Optional<Factura> facturaEncontrada = buscarFactura(facturaNueva.codigo());
        if (facturaEncontrada.isPresent()) {
            Factura facturaAntigua = facturaEncontrada.get();
            listaFacturas.remove(facturaAntigua);
            listaFacturas.add(facturaNueva);
            return "La factura se ha actualizado exitosamente";
        } else {
            return "No existe una factura con ese codigo";
        }
    }

    public String eliminarFactura(String codigo) {
        Optional<Factura> resultado = buscarFactura(codigo);
        if (resultado.isPresent()) {
            Factura facturaEncontrada = resultado.get();
            listaFacturas.remove(facturaEncontrada);
            return "La factura se eliminado exitosamente";
        } else {
            return "No existe una factura con ese codigo";
        }
    }

    public String registrarProducto(Producto producto) {
        Optional<Producto> productoEncontrado = buscarProducto(producto.getCodigo());
        if (productoEncontrado.isEmpty()) {
            listaProductos.put(producto.getCodigo(), producto);
            return "El producto fue registrado exitosamente";
        }
        return "No se puede registrar, ya existe un producto con ese codigo";
    }

    public Optional<Producto> buscarProducto(String codigo) {
        return listaProductos.values().stream()
                .filter(producto -> producto.getCodigo().equals(codigo))
                .findFirst();
    }

    public String actualizarProducto(Producto productoNuevo) {
        Optional<Producto> productoEncontrado = buscarProducto(productoNuevo.getCodigo());
        if (productoEncontrado.isPresent()) {
            listaProductos.put(productoNuevo.getCodigo(), productoNuevo);
            return "El producto se ha actualizado exitosamente";
        } else {
            return "No existe un producto con ese codigo";
        }
    }

    public String eliminarProducto(String codigo) {
        Optional<Producto> resultado = buscarProducto(codigo);
        if (resultado.isPresent()) {
            listaProductos.remove(resultado);
            return "El producto se ha eliminado exitosamente";
        } else {
            return "No existe un producto con ese codigo";
        }
    }

    public double obtenerTotalVendido(LocalDate fecha) {
        double totalVendido = 0;
        for (Factura factura : listaFacturas) {
            if (factura.fecha().equals(fecha)) {
                totalVendido += factura.calcularTotal();
            }
        }
        return totalVendido;
    }

    public List<Factura> consultarFacturasCliente(Cliente cliente) {
        List<Factura> facturasCliente = new ArrayList<>();
        for (Factura factura : listaFacturas) {
            if (factura.cliente().getDocumentoIdentidad()
                    .equals(cliente.getDocumentoIdentidad())) {
                facturasCliente.add(factura);
            }
        }
        return facturasCliente;
    }

    public Map<String, Producto> obtenerProductosBajoInventario() {
        Map<String, Producto> productosBajoInventario = new HashMap<>();
        for (Producto producto : listaProductos.values()) {
            if (producto.getCantidadDisponible() <= 5) {
                productosBajoInventario.put(
                        producto.getCodigo(),
                        producto
                );
            }
        }
        return productosBajoInventario;
    }

    //Punto 1 seguimiento
    public Map<String, Producto> obtenerProductosConCantidadesMayoresA10() {
        Map<String, Producto> productosD = new HashMap<>();
        for (Producto aux : listaProductos.values()) {
            if (aux.getCantidadDisponible() >= 10) {
                productosD.put(aux.getCodigo(), aux);
            }
        }
        return productosD;
    }
    //punto 2 seguimiento
    public List<String> obtenerCodigosProductosEntre10Y50() {
        List<String> codigos = new ArrayList<>();
        for (Producto aux:listaProductos.values()) {
            if (aux.getCantidadDisponible() >= 10 && aux.getCantidadDisponible() < 50) {
                codigos.add(aux.getCodigo());
            }
        }
        return codigos;
    }
    // punto 3 seguimiento
    public List<Cliente> obtenerListaClientesFecha() {
        List<Cliente> listaClientesFecha = new ArrayList<>();
        for (Factura aux:listaFacturas) {
            if (aux.fecha().equals(LocalDate.of(2026, 10, 7)));
            listaClientesFecha.add(aux.cliente());
        }
        return listaClientesFecha;
    }

































}