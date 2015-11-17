package escola;

public class Aluno extends Pessoa {

    private int numero;

    public Aluno(String nome, int numero) {
        super(nome);
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString() {
        return String.format("%s, número %d", super.toString(), this.numero);
    }

}
