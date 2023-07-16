package org.example;

import connection.SistemaRebelde;
import model.Rebelde;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

import static connection.Conectar.getConnection;

public class Main {
    static Scanner entrada = new Scanner(System.in);

    public static int menuExibir() {
        int opcao = 0;
        try {
            System.out.println("---------------------------------------------- ");
            System.out.println("| 1 - Inserir novos guerreiros                |");
            System.out.println("| 2 - Consultar todos os guerreiros           |");
            System.out.println("| 3 - Atualizar base dos guerreiros           |");
            System.out.println("| 4 - Deletar guerreiro                       |");
            System.out.println("| 5 - Buscar guerreiro por nome               |");
            System.out.println("| 6 - Reportar traidor                        |");
            System.out.println("| 7 - Gerar Relatório                         |");
            System.out.println("| 8 - Sair                                    |");
            System.out.println("---------------------------------------------- ");
            System.out.println("Escolha uma opção ");
            opcao = entrada.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Valor invalido! Digite um número inteiro positivo");
            entrada.nextLine();
        }

        return opcao;
    }

    public static void main(String[] args) {

        SistemaRebelde sistemaRebelde = new SistemaRebelde();

        Rebelde rebelde = new Rebelde();
        String nome;
        int idade;
        String genero;
        String base;
        boolean continuar = true;

        while (continuar) {
            int opcao = menuExibir();
            switch (opcao) {
                case 1:
                    System.out.println("\n==========Inserir novos Guerreiros======\n");

                    System.out.println("Qual o nome do guerreiro?");
                    nome = entrada.next();

                    System.out.println("Qual a idade do guerreiro?");
                    idade = entrada.nextInt();

                    System.out.println("Qual o gênero do guerreiro?");
                    genero = entrada.next();

                    System.out.println("Qual a base do guerreiro?");
                    base = entrada.next();

                    sistemaRebelde.inserirRebelde(new Rebelde(nome, idade, genero, base));
                    break;

                case 2:
                    System.out.println("\n==========Consultar todos os guerreiros======\n");
                    sistemaRebelde.consultarTabela();
                    break;

                case 3:
                    System.out.println("\n==========Atualizar a base do Guerreiro======\n");

                    System.out.println("Qual o nome do guerreiro?");
                    nome = entrada.next();

                    System.out.println("Qual a nova base do guerreiro?");
                    base = entrada.next();

                    sistemaRebelde.alterarLocalizacaoRebelde(nome, base);
                    break;

                case 4:
                    System.out.println("\n==========Deletar Guerreiro======\n");
                    System.out.println("Qual o id do guerreiro?");
                    int id = entrada.nextInt();

                    sistemaRebelde.deletarRebelde(id);
                    break;

                case 5:
                    System.out.println("\n==========Buscar guerreiro por nome======\n");
                    System.out.println("Qual o nome do guerreiro que deseja buscar?");
                    nome = entrada.next();

                    sistemaRebelde.buscarRebeldePorNome(nome);
                    break;

                case 6:
                    System.out.println("\n==========Reportar traidor======\n");
                    System.out.println("Qual o nome do guerreiro que deseja reportar?");
                    nome = entrada.next();

                    sistemaRebelde.reportarRebelde(nome);
                    break;

                case 7:
                    System.out.println("\n==========Gerar Relatório ======\n");
                    sistemaRebelde.gerarRelatorio();
                    break;

                case 8:
                    System.out.println("\n++++++++Saindo++++++++\n");
                    entrada.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("opção invalida!!!!");


            }


        }
    }
}







