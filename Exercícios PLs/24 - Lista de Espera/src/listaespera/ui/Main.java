/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaespera.ui;

import java.util.Scanner;
import listaespera.model.ListaEspera;

/**
 *
 * @author Pedro
 */
public class Main {

    /*
    Exercício Lista de Espera

Elabore uma aplicação para gerir a lista de espera das consultas urgentes realizadas numa dada clínica médica. O atendimento dos utentes é feito pela ordem de chegada, sendo o primeiro utente da lista de espera, o primeiro a ser consultado.

O programa deve satisfazer os seguintes requisitos:

    A implementação da lista de espera deve ser baseada na classe LinkedList da biblioteca do Java.

    Apresentar uma interface com o utilizador do tipo consola.

    Mostrar ao utilizador um menu com opções para:

        Adicionar um novo utente à lista de espera.

        Eliminar o primeiro utente da lista de espera.

        Listar todos os utentes em espera.

        Terminar a execução da aplicação.

    Utilizar uma arquitetura de duas camadas, separando o código da interface com o utilizador (camada "ui") do código relacionado com os dados da aplicação (camada "model").
     */
    public static void main(String[] args) {
        ListaEspera listaEspera = new ListaEspera();
        Scanner ler = new Scanner(System.in);
        
        menu();
        char op;
        do {
            System.out.printf("%nDigite uma opção: ");
            op = ler.next().charAt(0);
            
            switch (op) {
                case '1':
                    menu();
                    break;
                case '2':
                    System.out.printf("Introduza o nome do utente: ");
                    ler.nextLine();
                    try {
                        listaEspera.adicionarUtente(
                            listaEspera.novoUtente(
                                    ler.nextLine()));
                    } catch (IllegalArgumentException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case '3':
                    System.out.printf("Introduza o nome do utente: ");
                    ler.nextLine();
                    try {
                        listaEspera.removerUtente(
                            listaEspera.novoUtente(
                                    ler.nextLine()));
                    } catch (IllegalArgumentException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case '4':
                    System.out.println(listaEspera.listarUtentes());
                    break;
                case '5':
                    //
                    break;
                default:
                    System.err.printf("Não inseriu uma opção válida!%n");
            }
            
        } while(op != '5');
    }
    
    public static void menu() {
        System.out.printf("Opções: %n"
                + "1. Ver menu %n"
                + "2. Adicionar utente %n"
                + "3. Remover utente %n"
                + "4. Listar utente %n"
                + "5. Terminar programa %n");
    }
}
