package matriz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Matriz<E> {

    private List< List<E>> matriz;
    private int numeroMaximoColunas;

    public Matriz() {
        this.matriz = new ArrayList<>();
        this.numeroMaximoColunas = 0;
    }

    public int getNumeroDeLinhas() {
        return this.matriz.size();
    }

    public int getNumeroDeColunas(int indiceLinha) {
        verificarIndiceLinha(indiceLinha);
        return this.matriz.get(indiceLinha).size();
    }

    public E getElemento(int indiceLinha, int indiceColuna) {
        verificarIndices(indiceLinha, indiceColuna);
        return this.matriz.get(indiceLinha).get(indiceColuna);
    }

    public void adicionarLinha(Collection<? extends E> colecao) {
        this.matriz.add(new ArrayList<>(colecao));
        if (colecao.size() > this.numeroMaximoColunas) {
            this.numeroMaximoColunas = colecao.size();
        }
    }

    public boolean contem(E elemento) {
        for (List<E> linha : this.matriz) {
            if (linha.contains(elemento)) {
                return true;
            }
        }

        return false;
    }

    public E substituirElemento(int indiceLinha, int indiceColuna, E elemento) {
        verificarIndices(indiceLinha, indiceColuna);
        return this.matriz.get(indiceLinha).set(indiceColuna, elemento);
    }

    public List<E> removerLinha(int indice) {
        verificarIndiceLinha(indice);
        return this.matriz.remove(indice);
    }

    public <T> T[] colunaParaArray(int indice, T[] array) {
        verificarIndiceColuna(indice);
        int tamanhoColuna = this.tamanhoColuna(indice);

        if (array.length < tamanhoColuna) {
            array = (T[]) Array.newInstance(
                    array.getClass().getComponentType(),
                    tamanhoColuna);
        }

        for (int i = 0; i < tamanhoColuna; i++) {
            array[i] = (T) this.matriz.get(i).get(indice);
        }

        if (array.length > tamanhoColuna) {
            array[tamanhoColuna] = null;
        }

        return array;
    }

    public void limpar() {
        this.matriz.clear();
    }

    private int tamanhoColuna(int indice) {
        verificarIndiceColuna(indice);
        int numeroLinhas = 0;
        for (List<E> linha : this.matriz) {
            if (indice < linha.size()) {
                numeroLinhas++;
            }
        }
        return numeroLinhas;
    }

    private void verificarIndiceLinha(int indice) {
        if (indice < 0 || indice >= this.matriz.size()) {
            throw new IndexOutOfBoundsException(
                    "Índice Linha: " + indice
                    + ", Tamanho: " + this.matriz.size());
        }
    }

    private void verificarIndiceColuna(int indiceColuna) {
        if (indiceColuna < 0 || indiceColuna >= this.numeroMaximoColunas) {
            throw new IndexOutOfBoundsException(
                    " Índice Coluna: " + indiceColuna
                    + ", Tamanho: " + this.numeroMaximoColunas);
        }
    }

    private void verificarIndices(int indiceLinha, int indiceColuna) {
        if (indiceLinha < 0
                || indiceLinha >= this.matriz.size()
                || indiceColuna < 0
                || indiceColuna >= this.matriz.get(indiceLinha).size()) {
            String mensagem = mensagemIndiceLinhaInvalido(indiceLinha)
                    + mensagemIndiceColunaInvalido(indiceLinha);
            throw new IndexOutOfBoundsException(mensagem);
        }
    }

    private String mensagemIndiceLinhaInvalido(int indice) {
        return "Índice Linha: " + indice
                + ", Tamanho: " + this.matriz.size();
    }

    private String mensagemIndiceColunaInvalido(int indice) {
        return " Índice Coluna: " + indice
                + ", Tamanho: " + this.matriz.get(indice).size();
    }

}
