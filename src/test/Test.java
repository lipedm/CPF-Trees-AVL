package test;

import classes.*;
import java.io.*;

public class Test {

    public Test() {
    }

    public static void main(String args[]) {
        AVLTree t = new AVLTree();
        Node root = null;
        while (true) {
            System.out.println("(1) Inserir");
            System.out.println("(2) Deletar");
            System.out.println("(3) Buscar");

            try {
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferRead.readLine();

                if (Integer.parseInt(s) == 1) {
                    System.out.print("Valor para inserir: ");
                    root = t.insert(root, Integer.parseInt(bufferRead.readLine()));
                } else if (Integer.parseInt(s) == 2) {
                    System.out.print("Valor para deletar: ");
                    root = t.deleteNode(root, Integer.parseInt(bufferRead.readLine()));
                } else if (Integer.parseInt(s) == 3) {
                    System.out.println("Valor para pesquisa");
                    root = t.search(root, Integer.parseInt(bufferRead.readLine()));
                } else {
                    System.out.println("Escolha inválida, tente novamente!");
                    continue;
                }

                t.print(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
