package junho2014;

/**
 *
 * @author Pedro
 */
public class Musica extends Artigo implements Pagavel {

    private String interprete;
    private float precoBase;

    private static float IVA = 23.0f;

    public Musica(String titulo, int anoLancamento, String interprete, float precoBase) {
        super(titulo, anoLancamento);
        this.interprete = interprete;
        this.precoBase = precoBase;
    }

    public String getInterprete() {
        return this.interprete;
    }

    public float getPrecoBase() {
        return this.precoBase;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public void setPrecoBase(float precoBase) {
        this.precoBase = precoBase;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f (+%.1f%%IVA)", getInterprete(), getPrecoBase(), getIVA());
    }

    @Override
    public float calcularPreco() {
        return this.precoBase * (1 + Musica.IVA / 100.0f);
    }

    public static float getIVA() {
        return Musica.IVA;
    }

    public static void setIVA(float IVA) {
        Musica.IVA = IVA;
    }

}
