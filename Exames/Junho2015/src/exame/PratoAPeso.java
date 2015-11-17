package exame;

/**
 *
 * @author Pedro
 */
public class PratoAPeso extends Prato implements Desconto {

    private float peso;

    private static float precoKg = 10f;
    private static float pesoLimite = 0.5f;

    public PratoAPeso(ListaAlimentos listaAlimentos, float peso) {
        super(listaAlimentos);
        setPeso(peso);
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public float calcularPreco() {
        return this.getPeso() * PratoAPeso.getPrecoKg() - this.calcularDesconto();
    }

    @Override
    public float calcularDesconto() {
        if (this.getPeso() > PratoAPeso.getPesoLimite()) {
            float pesoComDesconto = this.getPeso() - PratoAPeso.getPesoLimite();

            return pesoComDesconto * PratoAPeso.getPrecoKg() * Desconto.DESCONTO;
        }

        return 0;
    }

    public static float getPrecoKg() {
        return PratoAPeso.precoKg;
    }

    public static float getPesoLimite() {
        return PratoAPeso.pesoLimite;
    }

    public static void setPrecoKg(float precoKg) {
        PratoAPeso.precoKg = precoKg;
    }

    public static void setPesoLimite(float pesoLimite) {
        PratoAPeso.pesoLimite = pesoLimite;
    }

}
