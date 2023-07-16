package model;

public class Rebelde {
    private Long idRebelde;
    private String nome;
    private int idade;
    private String genero;
    private String base;
    private boolean traidor ;
    private int numReports;

    public Rebelde(Long idRebelde, String nome, int idade, String genero, String base, boolean traidor, int numReports) {
        this.idRebelde = idRebelde;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.base = base;
        this.traidor = traidor;
        this.numReports = numReports;
    }

    public Rebelde(String nome, int idade, String genero, String base, boolean traidor, int numReports) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.base = base;
        this.traidor = traidor;
        this.numReports = numReports;
    }

    public Rebelde(String nome, int idade, String genero, String base) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.base = base;
        this.traidor = false;
        this.numReports = 0;
    }

    public Rebelde (){

        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.base = base;
        this.traidor = traidor;
        this.numReports = numReports;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getBase() {
        return this.base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public boolean isTraidor() {
        return traidor;
    }

    public void setTraidor(boolean traidor) {
        this.traidor = traidor;
    }

    public Long getIdRebelde() {
        return idRebelde;
    }

    public void setIdRebelde(Long idRebelde) {
        this.idRebelde = idRebelde;
    }

    public int getNumReports() {
        return numReports;
    }

    public void setNumReports(int numReports) {
        this.numReports = numReports;
    }

    @Override
    public String toString() {
        return "Rebelde{" +
                "idRebelde=" + idRebelde +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", genero='" + genero + '\'' +
                ", base='" + base + '\'' +
                ", traidor=" + traidor +
                ", numReports=" + numReports +
                '}';
    }


}
