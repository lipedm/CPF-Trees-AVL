package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.*;

public class CSVLoader {

    public void readFile() throws IOException {

        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Felipe Fernandes\\Desktop\\Uni\\CPF-Trees-AVL\\csv\\pessoas.csv"));

        List<People> peoples = new ArrayList<People>();

        String[] record = null;

        try {
            while ((record = reader.readNext()) != null) {
                People people = new People();
                people.setCpf(record[0]);
                people.setRg(record[1]);
                people.setNome(record[2]);
                people.setBirthdate(record[3]);
                people.setCity(record[3]);
                peoples.add(people);
            }
        } catch (Exception e) {
            System.out.println(e);
        }       

        System.out.println(peoples);

        reader.close();
    }

}
