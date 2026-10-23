package co.edu.uniquindio.poo.model;

public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    public Empleado(String nombre, String documento, int edad,
                    float salarioBase, CategoriaEmpleado categoria,
                    float descuentoSalud, float descuentoPension) {
        if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo");
        }
        if (descuentoSalud < 0 || descuentoSalud > 100) {
            throw new IllegalArgumentException("El descuento de salud debe estar entre 0 y 100");
        }
        if (descuentoPension < 0 || descuentoPension > 100) {
            throw new IllegalArgumentException("El descuento de pension debe estar entre 0 y 100");
        }
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public int getEdad() {
        return edad;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public CategoriaEmpleado getCategoria() {
        return categoria;
    }

    protected void validarPorcentaje(float porcentaje, String nombreCampo) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El " + nombreCampo + " debe estar entre 0 y 100.");
        }
    }
    public abstract float calcularSalarioBruto();

    public float calcularBonificacionCategoria() {
        float porcentaje = 0;
        if (categoria == CategoriaEmpleado.JUNIOR) {
            porcentaje = 5;
        } else if (categoria == CategoriaEmpleado.SEMI_SENIOR) {
            porcentaje = 10;
        } else if (categoria == CategoriaEmpleado.SENIOR) {
            porcentaje = 15;
        }
        return salarioBase * porcentaje / 100;
    }

    public float calcularDescuentos() {
        float salarioBruto = calcularSalarioBruto();
        float valorDescuentoSalud = salarioBruto * descuentoSalud / 100;
        float valorDescuentoPension = salarioBruto * descuentoPension / 100;
        return valorDescuentoSalud + valorDescuentoPension;
    }

    public float calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDescuentos();
    }

    public abstract String getTipoEmpleado();

    public void mostrarInformacion() {
        System.out.println("Tipo: " + getTipoEmpleado());
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Edad: " + edad);
        System.out.println("Categoria: " + categoria);
        System.out.println("Salario base: " + salarioBase);
        System.out.println("Bonificacion categoria: " + calcularBonificacionCategoria());
        System.out.println("Salario bruto: " + calcularSalarioBruto());
        System.out.println("Descuentos: " + calcularDescuentos());
        System.out.println("Salario neto: " + calcularSalarioNeto());
    }

    public ResumenPago generarResumenPago() {
        return new ResumenPago(documento, nombre, getTipoEmpleado(),
                calcularSalarioBruto(), calcularDescuentos(), calcularSalarioNeto());
    }

}

