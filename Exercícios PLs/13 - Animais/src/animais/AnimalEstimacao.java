package animais;

public abstract class AnimalEstimacao extends Animal implements Brincar {

    public AnimalEstimacao(String nome) {
        super(nome);
    }

    public void brinca() {
        System.out.println(this.getNome() + " a brincar.");
    }
}

