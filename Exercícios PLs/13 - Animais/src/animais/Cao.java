package animais;

public class Cao extends AnimalEstimacao {

    public Cao(String nome) {
        super(nome);
    }

    @Override
    public void fazRuido() {
        System.out.println(this.getNome() + " a ladrar.");
    }

    public void cacaGatos() {
        System.out.println(this.getNome() + " a caçar gatos.");
    }
}
