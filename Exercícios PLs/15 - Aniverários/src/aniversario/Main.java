package aniversario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    public static Scanner ler = new Scanner(System.in);
    public static Formatter escrever = new Formatter(System.out);

    public static void main(String[] args) {
        boolean ficheiroCriado = false;
        System.out.print("Nome do ficheiro: ");
        Formatter ficheiro = null;
        do {
            String caminho = ler.nextLine();
            try {
                ficheiro = new Formatter(new File(caminho), "UTF-8");
                ficheiroCriado = true;
            } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                System.out.printf(""
                        + "Impossível criar ficheiro!!%n"
                        + "%s (Acesso negado)%n"
                        + "Digite novamente o nome do ficheiro: ", caminho);
            }
        } while (!ficheiroCriado);

        String nome = "";
        do {
            System.out.println("Nome (\"ENTER para terminar\"):");
            nome = ler.nextLine();
            if (!nome.trim().isEmpty()) {
                Data data = lerData();
                ficheiro.format("%s, %s", nome, data.toString());
            }
        } while (!nome.trim().isEmpty());

        ficheiro.close();
        System.out.println("Aplicação terminada.");
    }

    public static Data lerData() {
        Data d = null;
        boolean dataValida = false;
        System.out.print("Data de aniversário (ano/mes/dia): ");

        do {
            String[] data = ler.nextLine().split("/");

            try {
                if (data.length != 3) {
                    throw new NumberFormatException();
                }

                d = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                dataValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Formato é inválido");
                System.out.println("Digite novamente a data de aniversário (ano/mês/dia):");
            } catch (DiaInvalidoException | MesInvalidoException e) {
                System.out.println(e.getMessage());
                System.out.println("Digite novamente a data de aniversário (ano/mês/dia):");
            }
        } while (!dataValida);

        return d;
    }

}
