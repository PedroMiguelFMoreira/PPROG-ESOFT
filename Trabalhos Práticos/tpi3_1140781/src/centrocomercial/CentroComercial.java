/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocomercial;

import java.util.ArrayList; 
import java.util.Collections;

/**
 * Cria uma instância de um centro comercial através guardando o nome e um
 * conjunto de lojas.
 *
 * @author Pedro
 */
public class CentroComercial extends Object {

    /**
     * Nome do centro comercial.
     */
    private String nome;

    /**
     * Lista de lojas existentes no centro comercial.
     */
    private ArrayList<Loja> listaLojas;

    /**
     * Nome do centro comercial por omissão.
     */
    private static final String NOME_POR_OMISSAO = "Sem Nome";

    /**
     * Lista de Lojas existentes no centro comercial por omissão.
     */
    private static final ArrayList<Loja> LISTALOJAS_POR_OMISSAO = new ArrayList();

    /**
     * Constrói uma instância de um centro comercial recebendo um nome e uma
     * lista de lojas.
     *
     * @param nome Nome do Centro Comercial.
     * @param listaLojas Lista de lojas do centro Comercial.
     */
    public CentroComercial(String nome, ArrayList listaLojas) {
        this.nome = nome;
        this.listaLojas = new ArrayList(listaLojas);
    }

    /**
     * Constrói uma instância de um centro comercial com o nome "Sem Nome" e uma
     * lista de lojas vazia.
     */
    public CentroComercial() {
        this(NOME_POR_OMISSAO, LISTALOJAS_POR_OMISSAO);
    }

    /**
     * Constrói uma cópia de um centro comercial com o nome e lista do objeto
     * passado por parametro.
     *
     * @param outroCentroComercial Objeto do tipo CentroComercial.
     */
    public CentroComercial(CentroComercial outroCentroComercial) {
        this(outroCentroComercial.getNome(), new ArrayList(outroCentroComercial.getListaLojas()));
    }

    /**
     * Devolve o nome do Centro Comercial.
     *
     * @return Nome do Centro Comercial.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Devolve a lista de lojas existente no centro comercial. 
     *
     * @return Lista de lojas existente no Centro Comercial.
     */
    public ArrayList<Loja> getListaLojas() {
        return new ArrayList(this.listaLojas);
    }

    /**
     * Modifica o nome do Centro Comercial.
     *
     * @param nome Novo nome do Centro Comercial.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica a lista de lojas do Centro Comercial.
     *
     * @param listaLojas Nova lista de lojas do Centro Comercial.
     */
    public void setListaLojas(ArrayList listaLojas) {
        this.listaLojas = new ArrayList(listaLojas);
    }

    /**
     * Devolve as características do Centro Comercial.
     * 
     * @return Caracteristicas do Centro Comercial.
     */
    @Override
    public String toString() {
        return String.format("O centro comercial tem como nome %s e possui as seguintes lojas:%n%s", this.nome, this.toStringListaLojas());
    }

    /**
     * Devolve as caracteristicas da lista de lojas.
     * 
     * @return Caracteristicas da lista de lojas.
     */
    public String toStringListaLojas() {
        StringBuilder s = new StringBuilder();
        for (Loja loja : this.listaLojas) {
            s.append(loja.toString());
            s.append("\n");
        }

        return s.toString();        
    }

    public void addLoja(Loja loja) {
        if (loja instanceof LojaAncoraPropria) {
            this.listaLojas.add(new LojaAncoraPropria((LojaAncoraPropria) loja));
        } else if (loja instanceof LojaAncoraExterna) {
            this.listaLojas.add(new LojaAncoraExterna((LojaAncoraExterna) loja));
        } else if (loja instanceof LojaComumQuiosque) {
            this.listaLojas.add(new LojaComumQuiosque((LojaComumQuiosque) loja));
        } else {
            this.listaLojas.add(new LojaComumRestauracao((LojaComumRestauracao) loja));
        }
    }

    /**
     * Calcula o total das receitas mensais de um Centro Comercial.
     *
     * @return Total das receitas mensais de um Centro Comercial.
     */
    public double calcularReceitas() {
        double totalReceitas = 0;

        for (Loja loja : this.listaLojas) {
            if (loja instanceof Renda) {
                totalReceitas += ((Renda) loja).calcularRenda();
            }

            if (loja instanceof Seguranca) {
                totalReceitas += ((Seguranca) loja).calcularSeguranca();
            }
        }

        return totalReceitas;
    }

}
