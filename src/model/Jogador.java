package model;

public class Jogador {
    private  String nome;
    private int idade;
    private int gols;
    private int numCamisa;

    public Jogador() {
    }

    public Jogador(String nome, int idade, int numCamisa) {
        this.nome = nome;
        this.idade = idade;
        this.numCamisa = numCamisa;
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

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getNumCamisa() {
        return numCamisa;
    }

    public void setNumCamisa(int numCamisa) {
        this.numCamisa = numCamisa;
    }

    @Override
    public String toString() {
        return  "nome: '" + nome + '\'' +
                ", idade: " + idade +
                ", Número gols: " + gols +
                ", Número camisa:" + numCamisa;
    }
}
