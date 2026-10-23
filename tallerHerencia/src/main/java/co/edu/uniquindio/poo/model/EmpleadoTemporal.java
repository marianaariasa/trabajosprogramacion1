package co.edu.uniquindio.poo.model;

public class EmpleadoTemporal extends Empleado{
    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase,
                            CategoriaEmpleado categoria, float descuentoSalud,
                            float descuentoPension, int diasTrabajados, float valorDia) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        if (diasTrabajados < 0) {
            throw new IllegalArgumentException("Los dias trabajados no pueden ser negativos");
        }
        if (valorDia < 0) {
            throw new IllegalArgumentException("El valor por dia no puede ser negativo");
        }
        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }
    public float calcularPagoDias() {
        return diasTrabajados * valorDia;
    }

    @Override
    public float calcularSalarioBruto() {
        return calcularPagoDias() + calcularBonificacionCategoria();
    }

    @Override
    public String getTipoEmpleado() {
        return "Empleado temporal";
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public float getValorDia() {
        return valorDia;
    }

    public void setValorDia(float valorDia) {
        this.valorDia = valorDia;
    }
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Dias trabajados: " + diasTrabajados);
        System.out.println("Valor dia: " + valorDia);
    }
}
