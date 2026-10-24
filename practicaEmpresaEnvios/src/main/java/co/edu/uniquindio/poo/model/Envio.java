package co.edu.uniquindio.poo.model;

public abstract class Envio {

    private String codigo;
    private double peso;
    private double incremento;
    private double valorFijo;
    private String destinatario;
    private EmpresaMensajeria ownedByEmpresa;

    public Envio(double valorFijo, String codigo, double peso,
                 double incremento, String destinatario,
                 EmpresaMensajeria ownedByEmpresa) {
        this.valorFijo = valorFijo;
        this.codigo = codigo;
        this.peso = peso;
        this.incremento = incremento;
        this.destinatario = destinatario;
        this.ownedByEmpresa = ownedByEmpresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getIncremento() {
        return incremento;
    }

    public void setIncremento(double incremento) {
        this.incremento = incremento;
    }

    public double getValorFijo() {
        return valorFijo;
    }

    public void setValorFijo(double valorFijo) {
        this.valorFijo = valorFijo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public EmpresaMensajeria getOwnedByEmpresa() {
        return ownedByEmpresa;
    }

    public void setOwnedByEmpresa(
            EmpresaMensajeria ownedByEmpresa) {
        this.ownedByEmpresa = ownedByEmpresa;
    }

    public double calcularCostoFijo() {
        return valorFijo + peso * incremento;
    }

    public abstract double calcularCostoTotal();

    @Override
    public String toString() {
        return "Envio{" +
                "codigo='" + codigo + '\'' +
                ", peso=" + peso +
                ", incremento=" + incremento +
                ", valorFijo=" + valorFijo +
                ", destinatario='" + destinatario + '\'' +
                '}';
    }
}