package exame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class ListaAlimentos implements Serializable {

    private List<Alimento> listaAlimentos;

    public ListaAlimentos() {
        this.listaAlimentos = new ArrayList<Alimento>();
    }

    public List<Alimento> getListaAlimentos() {
        Collections.sort(this.listaAlimentos);

        return this.listaAlimentos;
    }

    public boolean adicionarAlimento(Alimento alimento) {
        if (!this.listaAlimentos.contains(alimento)) {
            return this.listaAlimentos.add(alimento);
        }

        return false;
    }

}
