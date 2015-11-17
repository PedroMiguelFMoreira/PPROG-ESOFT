package junho2014;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class Teste {

    private List<Artigo> listaArtigos;

    public Teste() {
        this.listaArtigos = new ArrayList();
    }

    public List<Artigo> getListaArtigos() {
        return this.listaArtigos;
    }

    public boolean adicionarArtigos(Artigo artigo) {
        return this.listaArtigos.add(artigo);
    }

    public static void main(String[] args) {
        List<Artigo> listaArtigos = new ArrayList();

        Teste teste = new Teste();
        teste.adicionarArtigos(new Aplicacao("Exame 2014", 2015, "Pedro Moreira"));
        teste.adicionarArtigos(new Musica("Mama mia", 2012, "Kara", 2.90f));

        int totalArtigosPagos = 0;
        float precoTotal = 0;

        if (!teste.getListaArtigos().isEmpty()) {
            for (Artigo artigo : teste.getListaArtigos()) {
                if (artigo instanceof Pagavel) {
                    precoTotal += ((Pagavel) artigo).calcularPreco();
                    totalArtigosPagos++;
                }
            }

            System.out.println(String.format("Preço médio: %.2f€", (float) precoTotal / totalArtigosPagos));
        } else {
            System.out.println("Não existem artigos...");
        }
        
        try {
            Gestao.descontarPontos("Ana", -10);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
