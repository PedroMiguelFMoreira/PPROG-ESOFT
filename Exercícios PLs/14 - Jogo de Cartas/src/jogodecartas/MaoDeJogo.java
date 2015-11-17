package jogodecartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa uma mão de jogo.
 *
 * @author ISEP-DEI-PPROG
 */
public class MaoDeJogo {

     /**
     * A mão de jogo.
     */
    private List<Carta> maoDeJogo;
    
    /**
     * A mão de jogo, por omissão, é vazia, ou seja, sem cartas.
     */
    private static final List<Carta> MAODEJOGO_POR_OMISSAO = new ArrayList<>();    
    
    /**
     * Constrói uma instância de {@code MaoDeJogo} recebendo um conjunto de
     * cartas.
     * 
     * @param mao o conjunto de cartas.
     */
    public MaoDeJogo(List<Carta> mao) {
        this.maoDeJogo = new ArrayList(mao);
    }

    /**
     * Constrói uma instância de {@code MaoDeJogo} vazia, ou seja, sem cartas.
     */
    public MaoDeJogo() {
        this.maoDeJogo = MaoDeJogo.MAODEJOGO_POR_OMISSAO;
    }
    
    /**
     * Constrói uma instância de {@code MaoDeJogo} com as mesmas caraterísticas
     * da mão de jogo recebida por parâmetro.
     * 
     * @param outraMaoDeJogo a mão de jogo com as caraterísticas a copiar.
     */
    public MaoDeJogo(MaoDeJogo outraMaoDeJogo) {
        for(Carta c : outraMaoDeJogo.maoDeJogo) {
            this.maoDeJogo.add(new Carta(c));
        }
    }

    /**
     * Devolve a descrição textual da mão de jogo (uma carta por linha).
     * 
     * @return caraterísticas das cartas da mão de jogo.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Carta c : this.maoDeJogo) {
            s.append(c.toString());
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Devolve um conjunto com os vários tipos de carta (duque, terno, etc.)
     * existentes na mão de jogo.
     * 
     * @return {@code List} com os tipos de carta existentes na mão de jogo.
     */
    public List<Carta.Tipo> tiposDeCarta() {
        List<Carta.Tipo> tiposDeCarta = new ArrayList();
        
        for (Carta carta : this.maoDeJogo) {
            tiposDeCarta.add(carta.getTipo());
        }
        
        return tiposDeCarta;
    }

    /**
     * Determina quantas cartas de um dado tipo existem na mão de jogo.
     * 
     * @param tipo o tipo de carta.
     * @return quantidade de cartas do tipo, que existem na mão de jogo.
     */
    public int contarCartasDoTipo(Carta.Tipo tipo) {
        int quantidade = 0;
        
        for (Carta carta : this.maoDeJogo) {
            if(carta.getTipo().equals(tipo)) {
                quantidade++;
            }
        }
        
        return quantidade;
    }

    /**
     * Ordena a mão de jogo por naipe e, dentro do mesmo naipe, ordena por tipo.
     */
    public void ordenar() {
        Collections.sort(this.maoDeJogo);
    }

}
