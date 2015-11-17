package junho2014;

import java.util.List;

/**
 *
 * @author Pedro
 */
public class Album extends Artigo implements Pagavel {
    
    private List<Musica> conjuntoMusicas;
    private float desconto;
    
    public Album(String titulo, int anoLancamento, List<Musica> conjuntoMusicas, float desconto) {
        super(titulo, anoLancamento);
        this.conjuntoMusicas = conjuntoMusicas;
        this.desconto = desconto;
    }

    public List<Musica> getConjuntoMusicas() {
        return this.conjuntoMusicas;
    }

    public float getDesconto() {
        return this.desconto;
    }
    
    public void setConjuntoMusicas(List<Musica> conjuntoMusicas) {
        this.conjuntoMusicas = conjuntoMusicas;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
    
    @Override
    public String toString() {
        String listaMusicas = "";
        for (Musica musica : conjuntoMusicas) {
            listaMusicas += musica.toString();
        }
        
        return String.format("%s: %n%s", super.toString(), listaMusicas);
    }

    @Override
    public float calcularPreco() {
        float preco = 0;
        
        for (Musica musica : this.conjuntoMusicas) {
            preco += musica.calcularPreco();
        }
        
        return preco * (1 - this.desconto);
    }
    
}
