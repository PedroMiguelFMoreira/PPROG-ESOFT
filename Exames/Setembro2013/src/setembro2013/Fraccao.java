package setembro2013;

/**
 *
 * @author Pedro
 */
public class Fraccao {

    private int numerador;
    private int denominador;

    public Fraccao(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccao() {
        this.numerador = 1;
        this.denominador = 1;
    }

    public Fraccao(Fraccao fraccao) {
        this.numerador = fraccao.getNumerador();
        this.denominador = fraccao.getDenominador();
    }

    public int getNumerador() {
        return this.numerador;
    }

    public int getDenominador() {
        return this.denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public void simplificada() {
        for (int i = getLimitador(); i > 0; i--) {
            if(getNumerador() % i == 0 && getDenominador() % i == 0) {
                setNumerador(getNumerador() / i);
                setDenominador(getDenominador() / i);
            }
        }

    }

    private int getLimitador() {
        return (getNumerador() < getDenominador()) ? getNumerador() : getDenominador();
    }

    public Fraccao multiplica(Fraccao fraccao) {
        int numeradorResultante = this.getNumerador() * fraccao.getNumerador();
        int denominadorResultante = this.getDenominador() * fraccao.getDenominador();

        return new Fraccao(numeradorResultante, denominadorResultante);
    }

    public void mostra() {
        System.out.println(this.numerador + "/" + this.denominador);
    }

    public float getValorDecimal() {
        return (float) this.numerador / this.denominador;
    }

    public boolean isInteiro() {
        return this.numerador % this.denominador == 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fraccao f1 = new Fraccao(3, 4);
        Fraccao f2 = new Fraccao(f1);
        Fraccao f3 = new Fraccao();

        f3.setNumerador(12);
        f3.setDenominador(18);
        f3.mostra();
        Fraccao f4 = f3.multiplica(f1);
        f4.simplificada();
        double x = f4.getValorDecimal();
        if (f4.isInteiro()) {
            System.out.println("A fracção é um inteiro.");
        }
    }

}
