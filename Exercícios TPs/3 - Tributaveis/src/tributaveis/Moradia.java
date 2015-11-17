package tributaveis;

public class Moradia implements Cores, Tributavel {

    private String morada;
    private float area;
    private String cor;

    public Moradia(String morada, float area, String cor) {
        this.morada = morada;
        this.area = area;
        this.cor = cor;
    }

    public String getMorada() {
        return this.morada;
    }

    public float getArea() {
        return this.area;
    }

    public String getCor() {
        return this.cor;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setArea(
            float area) {
        this.area = area;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return String.format("Moradia situada na %s com área de %.1f "
                + "tem cor %s", this.morada, this.area, this.cor);
    }

    @Override
    public float calcularImposto() {
        return this.getArea() * 2;
    }
}
