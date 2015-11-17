package contadores;

public abstract class ContadorEletrico extends Contador {

    private double potencia;

    private static int numContElect = 0;
    private static final String ID = "ELECT-";

    public ContadorEletrico(String cliente, int consumo, double potencia) {
        super(ContadorEletrico.ID + (ContadorEletrico.numContElect + 1), cliente, consumo);
        this.potencia = potencia;
        ContadorEletrico.numContElect++;
    }

    public double getPotencia() {
        return this.potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return String.format("%s Potência contradada: %.1f", super.toString(), this.getPotencia());
    }

    @Override
    public abstract double calcularCusto();

    public static int getNumContador() {
        return ContadorEletrico.numContElect;
    }

}
