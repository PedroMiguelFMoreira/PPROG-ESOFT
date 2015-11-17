package junho2014;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public abstract class Gestao {

    private static List<Cliente> listaClientes = new ArrayList<Cliente>();

    public static void adicionarCliente(String nome) {
        Gestao.listaClientes.add(new Cliente(nome));
    }

    @Override
    public String toString() {
        String listaDeClientes = "";
        for (Cliente cliente : Gestao.listaClientes) {
            listaDeClientes = String.format("%s%n", listaDeClientes);
        }

        return String.format("%s", listaDeClientes);
    }

    public static int totalPontos() {
        int totalPontos = 0;

        for (Cliente cliente : Gestao.listaClientes) {
            totalPontos += cliente.getPontos();
        }

        return totalPontos;
    }

    public static void acumularBonus(int valorLimiteBonus) {
        int bonus;

        for (Cliente cliente : Gestao.listaClientes) {
            if ((bonus = cliente.getPontos()) > valorLimiteBonus) {
                cliente.acumularPontos((int) (bonus * 0.10));
            }
        }
    }

    public static void descontarPontos(String nome, int pontos) {
        Cliente clienteAlterado = null;
        for (Cliente cliente : Gestao.listaClientes) {
            if (nome.equals(cliente.getNome())) {
                clienteAlterado = cliente;
                if (pontos < 0 || pontos < cliente.getPontos()) {
                    throw new IllegalArgumentException("Exceção");
                }

                cliente.descontarPontos(pontos);
            }
        }

        if (clienteAlterado == null) {
            throw new IllegalArgumentException("Exceção");
        }
    }

}
