package jogodecartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa um baralho de cartas.
 *
 * @author ISEP-DEI-PPROG
 */
public class Baralho {

    /**
     * O baralho de cartas.
     */
    private List<Carta> baralho;

    /**
     * Tipos de baralho.
     */
    public static enum Tipo {
        /**
         * Baralho com 40 cartas.
         */
        BAR_40,
        /**
         * Baralho com 52 cartas.
         */
        BAR_52
    };

    /**
     * Tipo de baralho por omissão.
     */
    private static final Tipo BARALHO_POR_OMISSAO = Tipo.BAR_40;

    /**
     * Constrói uma instância de {@code Baralho} recebendo o tipo de baralho.
     *
     * @param tipoDeBaralho o tipo de baralho.
     */
    public Baralho(Tipo tipoDeBaralho) {
        this.baralho = (tipoDeBaralho == Tipo.BAR_40 ? new ArrayList<>(40)
                                                    : new ArrayList<>(52));
        for (Carta.Naipe n : Carta.Naipe.values()) {
            for (Carta.Tipo t : Carta.Tipo.values()) {
                if (tipoDeBaralho == Tipo.BAR_40
                        && t.compareTo(Carta.Tipo.Sena) > 0
                        && t.compareTo(Carta.Tipo.Dama) < 0) {
                    continue;
                }
                this.baralho.add(new Carta(t, n));
            }
        }
    }

    /**
     * Constrói uma instância de {@code Baralho} com o baralho por omissão.
     */
    public Baralho() {
        this(Baralho.BARALHO_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de {@code Baralho} com as mesmas caraterísticas
     * do baralho recebido por parâmetro.
     *
     * @param outroBaralho o baralho com as características a copiar.
     */
    public Baralho(Baralho outroBaralho) {
        this.baralho = new ArrayList<>(outroBaralho.baralho.size());
        for (Carta c : outroBaralho.baralho) {
            this.baralho.add(new Carta(c));
        }
    }

    /**
     * Devolve a descrição textual do baralho (uma carta por linha).
     *
     * @return caraterísticas das cartas do baralho.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Carta c : this.baralho) {
            s.append(c.toString());
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Permuta as cartas do baralho de um modo aleatório.
     */
    public void baralhar() {
        Collections.shuffle(this.baralho);
    }

    /**
     * Parte ao meio o baralho de cartas.
     */
    public void partir() {

        // Reserva a primeira metade das cartas do baralho
        List<Carta> mbar = new ArrayList<>(
                this.baralho.subList(0, this.baralho.size() / 2));

        // Remove a primeira metade das cartas do baralho
        this.baralho.removeAll(mbar);

        // Coloca no final a primeira metade das cartas do baralho
        this.baralho.addAll(mbar);
    }

    /**
     * Remove e devolve as primeiras n cartas do baralho.
     *
     * @param n o número de cartas a remover e devolver.
     * @return {@code List} com as primeiras n cartas do baralho.
     */
    public List<Carta> primeirasCartas(int n) {

        // Reserva as primeiras n cartas do baralho
        List<Carta> mbar = new ArrayList<>(
                this.baralho.subList(0, 
                        (n < this.baralho.size() ? n : this.baralho.size())));

        // Remove as primeiras n cartas do baralho
        this.baralho.removeAll(mbar);

        return mbar;
    }

    /**
     * Remove e devolve as últimas n cartas do baralho.
     *
     * @param n o número de cartas a remover e devolver.
     * @return {@code List} com as últimas n cartas do baralho.
     */
    public List<Carta> ultimasCartas(int n) {
        // Reserva as últimas n cartas do baralho
        List<Carta> mbar = new ArrayList<>(
                this.baralho.subList(
                        (n > this.baralho.size() ? 0 : this.baralho.size() - n), 
                        this.baralho.size()));

        // Remove as últimas n cartas do baralho
        this.baralho.removeAll(mbar);

        return mbar;
    }

}
