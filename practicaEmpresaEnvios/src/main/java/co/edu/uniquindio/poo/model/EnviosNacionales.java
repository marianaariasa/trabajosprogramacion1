package co.edu.uniquindio.poo.model;

public class EnviosNacionales extends Envio {

    public static final double COSTO_FIJO = 6000;
    public static final double COSTO_KILO = 2000;
    protected static final double COSTO_DOMICILIO = 3000;

    private String ciudadDestino;
    private boolean requiereDomicilio;

    public EnviosNacionales(double valorFijo, String codigo, double peso,
                            double incremento, String destinatario,
                            EmpresaMensajeria ownedByEmpresa, String ciudadDestino,
                            boolean requiereDomicilio) {
        super(valorFijo, codigo, peso, incremento, destinatario, ownedByEmpresa);
        this.ciudadDestino = ciudadDestino;
        this.requiereDomicilio = requiereDomicilio;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public boolean isRequiereDomicilio() {
        return requiereDomicilio;
    }

    public void setRequiereDomicilio(boolean requiereDomicilio) {
        this.requiereDomicilio = requiereDomicilio;
    }

    @Override
    public double calcularCostoTotal() {
        double costo = calcularCostoFijo();

        if (requiereDomicilio) {
            costo += COSTO_DOMICILIO;
        }

        return costo;
    }

    @Override
    public String toString() {
        return "EnviosNacionales{" +
                "ciudadDestino='" + ciudadDestino + '\'' +
                ", requiereDomicilio=" + requiereDomicilio + '}'+
                "\n" + "\n" + "Informacion del envio: " + "\n" + "Destinatario: "
                + super.getDestinatario() + "\n" + "Codigo: " + super.getCodigo() +
                "\n" + "Peso: " + super.getPeso();
    }
}