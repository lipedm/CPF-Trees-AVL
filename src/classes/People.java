package classes;

public class People {
    private String cpf;
    private String rg;
    private String Nome ;
    private String birthdate;
    private String city;

    public People() {
    }

    public People(String cpf, String rg, String Nome, String birthdate, String city) {
        this.cpf = cpf;
        this.rg = rg;
        this.Nome = Nome;
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

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public People cpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public People rg(String rg) {
        setRg(rg);
        return this;
    }

    public People Nome(String Nome) {
        setNome(Nome);
        return this;
    }

    public People birthdate(String birthdate) {
        setBirthdate(birthdate);
        return this;
    }

    public People city(String city) {
        setCity(city);
        return this;
    }

    
    public String toString() {
        return "{" +
            " cpf='" + getCpf() + "'" +
            ", rg='" + getRg() + "'" +
            ", Nome='" + getNome() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }
    
}
