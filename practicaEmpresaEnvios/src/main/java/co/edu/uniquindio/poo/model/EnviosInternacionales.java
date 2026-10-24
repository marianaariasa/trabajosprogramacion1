package co.edu.uniquindio.poo.model;

public class EnviosInternacionales extends Envio {

    public static final double COSTO_FIJO = 15000;
    public static final double COSTO_KILO = 9000;
    private static final double COSTO_SEGURO = 20000;

    private String paisDestino;
    private boolean seguro;

    public EnviosInternacionales(double valorFijo, String codigo, double peso,
                                 double incremento, String destinatario,
                                 EmpresaMensajeria ownedByEmpresa, String paisDestino,
                                 boolean seguro) {
        super(valorFijo, codigo, peso, incremento, destinatario, ownedByEmpresa);
        this.paisDestino = paisDestino;
        this.seguro = seguro;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    @Override
    public double calcularCostoTotal() {
        double costo = calcularCostoFijo();

        if (seguro) {
            costo += COSTO_SEGURO;
        }

        return costo;
    }

    @Override
    public String toString() {
        return "EnviosInternacionales{" +
                "paisDestino='" + paisDestino + '\'' +
                ", seguro=" + seguro + '}'+  "\n" + "\n"+ "Informacion del envio: " +
                "\n" + "Destinatario: " + super.getDestinatario() +
                "\n" + "Codigo: " + super.getCodigo() + "\n" + "Peso: " + super.getPeso();
    }
}