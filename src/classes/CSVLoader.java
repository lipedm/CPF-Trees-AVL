package classes;

import java.io.*;
import java.util.*;
import java.time.*;


public class CSVLoader {

    private String file = "C:\\Users\\Felipe Fernandes\\Desktop\\Uni\\CPF-Trees-AVL\\csv\\pessoas.csv" ;
    private List<People> peopleList = new ArrayList<>();
    public List<People> readFile() throws FileNotFoundException, IOException, IndexOutOfBoundsException {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            People p = new People();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                p.setCpf(data[0]);
                p.setRg(data[1]);
                p.setName(data[2]);
                p.setBirthdate(data[3]);
                p.setCity(data[4]);
                peopleList.add(p);                               
            }
        }
        return peopleList;
    }
}
