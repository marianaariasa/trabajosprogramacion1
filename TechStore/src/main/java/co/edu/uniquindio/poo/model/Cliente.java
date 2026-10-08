package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {

    private final String documentoIdentidad;
    private String nombreCompleto;
    private final Tienda ownedByTienda;
    private String telefono;
    private String correo;
    private String ciudadResidencia;
    private final List<Factura> listaFacturas= new ArrayList<>();

    public Cliente(String documentoIdentidad, String nombreCompleto,
                   Tienda ownedByTienda, String telefono,
                   String correo, String ciudadResidencia) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.ownedByTienda = ownedByTienda;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public List<Factura> getListaFacturas() {
        return Collections.unmodifiableList(listaFacturas);
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}