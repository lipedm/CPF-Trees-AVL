package views;

import classes.*;

import java.util.Scanner;
import java.util.List;

public class Console {

    private Scanner insert = new Scanner(System.in);

    public Console mainMenu(Console console) throws Exception {
        AVLTree t = new AVLTree();
        Node root = null;
        CSVLoader csvLoader = new CSVLoader();
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
                    System.out.print("Digite o nome do arquivo: ");
                    csvLoader.readFile();
                    
                    break;

                case 2:
                    if (root != null) {
                        System.out.println("Digite o CPF da pessoa");
                        root = t.search(root, insert.nextInt());

                        System.out.println(t.getSearchPath());
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome da pessoa: ");
                    root = t.deleteNode(root, insert.nextInt());
                    break;

                case 4:
                    return console;

                default:
                    System.out.println("Selecione uma opcao valida! (:");
                    break;
            }

            // System.out.println("\n///////////////////////////\n");
            // t.print(root);
            // System.out.println("\n///////////////////////////\n");

        } while (selection != 4);

        insert.close();
        return console;
    }
}
