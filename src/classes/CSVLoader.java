package classes;

import java.io.*;
import java.util.*;


public class CSVLoader {

    private String file = "csv\\pessoas.csv" ;
    private List<People> peopleList = new ArrayList<>();
    public List<People> readFile() throws FileNotFoundException, IOException, IndexOutOfBoundsException {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                People p = new People();
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
