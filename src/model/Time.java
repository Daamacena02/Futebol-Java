package model;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private Tecnico tecnico;
    private List<Jogador> jogadores = new ArrayList<>();

    private int vitorias;
    private int derrotas;
    private int empates;

    public Time() {
    }

    public Time(String nome, Tecnico tecnico) {
        this.nome = nome;
        this.tecnico = tecnico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void adicionarJogador(Jogador jogador) {
        if (!jogador.isEmTime()) {
            jogadores.add(jogador);
            jogador.setEmTime(true); // Marca o jogador como estando em um time
            System.out.println("Jogador adicionado ao time com sucesso!");
        } else {
            System.out.println("Jogador já está em um time.");
        }
    }

    public void removerJogador(Jogador jogador) {
        if (jogadores.remove(jogador)) {
            jogador.setEmTime(false); // Marca o jogador como não estando mais em um time
        } else {
            System.out.println("Jogador não encontrado no time.");
        }
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

}
