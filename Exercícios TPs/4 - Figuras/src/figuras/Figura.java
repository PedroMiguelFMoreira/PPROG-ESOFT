package figuras;

import java.util.Objects;

public abstract class Figura implements Comparable<Figura> {

    private String cor;
    protected static final String COR_POR_OMISSAO = "Cinzento";

    public Figura(String cor) {
        this.cor = cor;
    }

    public Figura() {
        this(Figura.COR_POR_OMISSAO);
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String novaCor) {
        this.cor = novaCor;
    }

    @Override
    public String toString() {
        return String.format("Cor: %s", this.cor);
    }

    @Override
    public int compareTo(Figura o) {
        if (this.calcularArea() > o.calcularArea()) {
            return 1;
        } else if (this.calcularArea() < o.calcularArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object outroObjecto) {
        if (this == outroObjecto) {
            return true;
        }

        if (outroObjecto == null || this.getClass() != outroObjecto.getClass()) {
            return false;
        }

        Figura outraFigura = (Figura) outroObjecto;

        return this.cor.equalsIgnoreCase(outraFigura.getCor());

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.cor);
        return hash;
    }

    public abstract double calcularArea();

}
