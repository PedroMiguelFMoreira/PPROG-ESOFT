package animais;

public class CaoRobot implements Brincar {

    private String nome;

    public CaoRobot(String nome) {
        this.nome = nome;
    }

    @Override
    public void brinca() {
        System.out.println(this.nome + " a brincar.");
    }
}
