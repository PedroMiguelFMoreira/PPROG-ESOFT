package animais;

public class Leao extends Animal {

    public Leao(String nome) {
        super(nome);
    }

    @Override
    public void fazRuido() {
        System.out.println(this.getNome() + " a rugir... ");
    }
}
