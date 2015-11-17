package figuras;

public class Circulo extends Figura {

    private double raio;
    protected static final int RAIO_POR_OMISSAO = 1;

    public Circulo(double raio, String cor) {
        super(cor);
        this.raio = raio;
    }

    public Circulo(double raio) {
        super();
        this.raio = raio;
    }
    
    public Circulo(String cor) {
        this(Circulo.RAIO_POR_OMISSAO, cor);
    }
    
    public Circulo() {
        this(Circulo.RAIO_POR_OMISSAO, Figura.COR_POR_OMISSAO);
    }

    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double novoRaio) {
        this.raio = novoRaio;
    }

    @Override
    public String toString() {
        return String.format("Raio: %.1f | %s%n", this.raio, super.toString());
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        
        Circulo c = (Circulo) outroObjeto;
        return this.raio == c.getRaio();
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.raio) ^ (Double.doubleToLongBits(this.raio) >>> 32));
        return hash;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(this.raio, 2);
    }

}
