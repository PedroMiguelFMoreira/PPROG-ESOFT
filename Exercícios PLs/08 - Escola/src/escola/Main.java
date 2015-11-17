package escola;

/**
 *
 * @author Pedro
 */
public class Main {

    public static void main(String[] args) {

        Professor ict = new Professor("Isabel Azevedo", "Adjunto");
        Professor amb = new Professor("António Barros", "Assistente");
        Professor nps = new Professor("Nuno Silva", "Coordenador");

        Aluno aln1 = new Aluno("Tiago Ferreira", 1131658);
        Aluno aln2 = new Aluno("João Camelo", 1140295);
        Aluno aln3 = new Aluno("Tiago Carvalho", 1140611);

        AlunoBolseiro alnbls1 = new AlunoBolseiro("Pedro Moreira", 1140781, 1050);

        Pessoa[] pessoas = new Pessoa[10];

        pessoas[0] = ict;
        pessoas[1] = amb;
        pessoas[2] = nps;
        pessoas[3] = aln1;
        pessoas[4] = aln2;
        pessoas[5] = aln3;
        pessoas[6] = alnbls1;

        double encargomensal = 0;

        System.out.println("Lista completa:");
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                System.out.println(pessoa.getClass().getSimpleName() + ": " + pessoa.getNome());
                // pessoa instanceof Professor || pessoa instanceof AlunoBolseiro
                if (pessoa instanceof Custo) {
                    encargomensal += ((Custo) pessoa).calcularCusto();
                }
            }
        }

        System.out.println("\nLista de professores:");
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Professor) {
                System.out.println(pessoa.getNome() + ", " + ((Professor) pessoa).getCategoria());
            }
        }

        System.out.println("\nLista de alunos:");
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Aluno) {
                System.out.println(pessoa);
            }
        }

        System.out.println("\nLista de alunos (não-bolseiros):");
        for (Pessoa pessoa : pessoas) {
            // if (pessoa instanceof Aluno && !(pessoa instanceof AlunoBolseiro)) {
            if (pessoa != null && pessoa.getClass() == Aluno.class) {
                System.out.println(pessoa);
            }
        }

        System.out.println("\nEncargo mensal da escola: " + encargomensal + "€");

    }

}
