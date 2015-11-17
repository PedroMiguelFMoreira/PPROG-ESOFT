package listatelefonica.model;

public class Telefone {

    private String titular;
    private int numero;

    public Telefone(String titular, int numero) {
        this.setTitular(titular);
        this.setNumero(numero);
    }

    public String getTitular() {
        return this.titular;
    }

    public int getNumero() {
        return this.numero;
    }

    public final void setTitular(String titular) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é inválido!");
        }
        this.titular = titular;
    }

    public final void setNumero(int numero) {
        if (numero < 100000000 || numero > 999999999) {
            throw new IllegalArgumentException("Número é inválido!");
        }
        this.numero = numero;
    }

    @Override
    public String toString() {
        return String.format("%s é titular do telefone %d", this.titular, this.numero);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Telefone outroTelefone = (Telefone) outroObjeto;
        return this.titular.equalsIgnoreCase(outroTelefone.titular)
                && this.numero == outroTelefone.numero;
    }

}
