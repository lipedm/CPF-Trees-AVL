package classes;

import java.io.*;


public class CSVLoader {

    private String file = "C:\\Users\\Felipe Fernandes\\Desktop\\Uni\\CPF-Trees-AVL\\csv\\pessoas.csv" ;
    public void readFile() throws FileNotFoundException, IOException, IndexOutOfBoundsException {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;           
            People people = new People();

            AVLTree t = new AVLTree();
            Node root = null;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                people.setCpf(data[0]);
                people.setRg(data[1]);
                people.setNome(data[2]);
                people.setBirthdate(data[3]);
                people.setCity(data[4]);
                
                t.insert(root, people);
                
            }
            System.out.println(people);
            
        }
    }

}
