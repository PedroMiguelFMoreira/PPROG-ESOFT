package animais;

public class Gato extends AnimalEstimacao {

    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void fazRuido() {
        System.out.println(this.getNome() + " a miar... ");
    }

    public void cacaRatos() {
        System.out.println(this.getNome() + " a caçar ratos.");
    }
}
