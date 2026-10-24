package co.edu.uniquindio.poo.model;

public class EnviosExpres extends EnviosNacionales {

    public static final double COSTO_FIJO = 6000;
    private static final double INCREMENTO = 0.30;
    private static final double COSTO_URGENTE = 5000;

    private int horasMaximas;

    public EnviosExpres(double valorFijo, String codigo,
                        double peso, double incremento,
                        String destinatario, EmpresaMensajeria ownedByEmpresa,
                        String ciudadDestino, boolean requiereDomicilio,
                        int horasMaximas) {
        super(valorFijo, codigo, peso, incremento, destinatario,
                ownedByEmpresa, ciudadDestino, requiereDomicilio);
        this.horasMaximas = horasMaximas;
    }

    public int getHorasMaximas() {
        return horasMaximas;
    }

    public void setHorasMaximas(int horasMaximas) {
        this.horasMaximas = horasMaximas;
    }

    @Override
    public double calcularCostoTotal() {
        double costo = super.calcularCostoTotal() * (1 + INCREMENTO);

        if (horasMaximas <= 24) {
            costo += COSTO_URGENTE;
        }

        return costo;
    }

    @Override
    public String toString() {
        return "EnviosExpres{" +
                "horasMaximas=" + horasMaximas +
                '}' + "\n"+  "\n"+ "Informacion del envio: " + "\n" + "Destinatario: " +
                super.getDestinatario() + "\n" + "Codigo: " + super.getCodigo() +
                "\n" + "Peso: " + super.getPeso() + "\n" + "Ciudad destino: " + super.getCiudadDestino()
                + "\n" + "Requiere domicilio: " + isRequiereDomicilio();
    }
}