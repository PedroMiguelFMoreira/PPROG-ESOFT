package torreshanoi.model;

public class Disco implements Comparable<Disco> {

    private int tamanho;

    public Disco(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return String.format(" | Disco %d | ", this.getTamanho());
    }

    @Override
    public int compareTo(Disco outroDisco) {
        if (this.getTamanho() < outroDisco.getTamanho()) {
            return 1;
        }

        return 0;
    }

}
