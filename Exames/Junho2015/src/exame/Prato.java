package exame;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public abstract class Prato implements Preco, Serializable {

    private ListaAlimentos listaAlimentos;
    private static float IVA = 0.23f;

    public Prato(ListaAlimentos listaAlimentos) {
        setListaAlimentos(listaAlimentos);
    }

    public ListaAlimentos getListaAlimentos() {
        return this.listaAlimentos;
    }

    public void setListaAlimentos(ListaAlimentos listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    public String toString() {
        return "";
    }
    
    public abstract float calcularPreco();

    public static float getIVA() {
        return Prato.IVA;
    }

    public static void setIVA(float IVA) {
        Prato.IVA = IVA;
    }

}
