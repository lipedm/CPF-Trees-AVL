package views;

import classes.*;
import java.util.*;

import java.util.Scanner;

public class Console {

    private Scanner insert = new Scanner(System.in);

    public Console mainMenu(Console console) throws Exception {
        AVLTree t = new AVLTree();
        Node root = null;
        CSVLoader csvLoader = new CSVLoader();
        List<People> peopleList = new ArrayList<>();
        int selection = 0;

        System.out.println("\nWelcome to CPF AVL System");
        do {
            System.out.println("\n[1] Carregar Arquivo");
            System.out.println("[2] Busca por CPF");
            System.out.println("[3] Busca por Nome");
            System.out.println("[4] Sair");

            System.out.print("\nSeleciona uma opcao: ");
            selection = insert.nextInt();

            switch (selection) {
                case 1:
                peopleList = csvLoader.readFile();
                for (People people : peopleList) {
                    root = t.insert(root, people);
                }
                t.print(root);
                    break;

                case 2:
                    System.out.println("Digite o CPF da pessoa");
                    root = t.searchByCpf(root, insert.next());
                    System.out.println(t.getSearchPath());

                    break;

                case 3:
                    System.out.print("Digite o nome da pessoa: ");
                    t.searchByName(root, insert.next());                    
                    break;

                case 4:
                    return console;

                default:
                    System.out.println("Selecione uma opcao valida! (:");
                    break;
            }


        } while (selection != 4);

        insert.close();
        return console;
    }
}
