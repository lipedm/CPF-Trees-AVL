package classes;

import java.time.LocalDate;

public class People {
    private String cpf;
    private String rg;
    private String name;
    private LocalDate birthdate;
    private String city;

    public People() {
    }

    public People(String cpf, String rg, String name, LocalDate birthdate, String city) {
        this.cpf = cpf;
        this.rg = rg;
        this.name = name;
        this.birthdate = birthdate;
        this.city = city;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        LocalDate lt = LocalDate.parse(birthdate);
        this.birthdate = lt;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String toString() {
        return "{" + " cpf='" + getCpf() + "'" + ", rg='" + getRg() + "'" + ", name='" + getName() + "'"
                + ", birthdate='" + getBirthdate() + "'" + ", city='" + getCity() + "'" + "}";
    }

}
