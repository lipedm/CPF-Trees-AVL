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
            System.out.println("[4] Procurar pro Aniversário");
            System.out.println("[5] Sair");

            System.out.print("\nSeleciona uma opcao:\n");
            selection = insert.nextInt();

            switch (selection) {
                case 1:
                    peopleList = csvLoader.readFile();
                    for (People people : peopleList) {
                        root = t.insert(root, people);
                    }
                    System.out.println(peopleList);
                    break;

                case 2:
                    System.out.println("Digite o CPF da pessoa:\n");
                    t.searchByCpf(root, insert.next());
                    selection = 0;
                    break;

                case 3:
                    System.out.print("Digite o nome da pessoa:\n");
                    t.searchByName(root, insert.next());
                    selection = 0;
                    break;

                case 4:
                    System.out.println("Digite a data inicial:\n");
                    String data1 = insert.next();
                    System.out.println("Digite a data final:\n");
                    String data2 = insert.next();
                    t.searchByDates(root, data1, data2);
                    selection = 0;
                    break;

                case 5:
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
