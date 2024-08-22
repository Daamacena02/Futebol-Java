package view;

import model.Jogador;
import model.Tecnico;
import model.Time;

import java.util.List;
import java.util.Scanner;

public class TimeView {

    private Scanner scanner;

    public TimeView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Tecnico insertNewTecnico() {
        System.out.print("Nome do técnico: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do técnico: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        return new Tecnico(nome, idade);
    }

    public Jogador insertNewJogador() {
        System.out.print("Nome do jogador: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do jogador: ");
        int idade = scanner.nextInt();
        System.out.print("Número da camisa do jogador: ");
        int numCamisa = scanner.nextInt();
        scanner.nextLine();

        return new Jogador(nome, idade, numCamisa);
    }

    public Time insertNewTime(List<Tecnico> bancoDeTecnicos) {
        System.out.print("Nome do time: ");
        String nome = scanner.nextLine();

        Tecnico tecnicoEscolhido = chooseSomeTecnico(bancoDeTecnicos);

        return new Time(nome, tecnicoEscolhido);
    }

    public Time chooseSomeTime(List<Time> times) {
        System.out.println("Escolha um time pelo código:");
        showOptionsSelectFromList(times);

        int timeIndex = scanner.nextInt();
        scanner.nextLine();
        return times.get(timeIndex);
    }

    public Jogador chooseSomeJogador(List<Jogador> jogadores) {
        System.out.println("Escolha um jogador:");
        showOptionsSelectFromList(jogadores);

        int jogadorIndex = scanner.nextInt();
        scanner.nextLine();
        return jogadores.get(jogadorIndex);
    }

    public Tecnico chooseSomeTecnico(List<Tecnico> tecnicos) {
        System.out.println("Escolha um técnico pelo código:");
        showOptionsSelectFromList(tecnicos);

        int tecnicoIndex = scanner.nextInt();
        scanner.nextLine();
        return tecnicos.get(tecnicoIndex);
    }

    public void showTime(Time time) {
        System.out.println("Time: " + time.getNome());
        System.out.println("Técnico: " + time.getTecnico().getNome());
        System.out.println("Jogadores:");
        showJogadores(time.getJogadores());
        System.out.println();
    }

    public void showTecnicos(List<Tecnico> tecnicos) {
        for (Tecnico tecnico : tecnicos) {
            System.out.println("- " + tecnico.getNome());
        }
    }

    public void showJogadores(List<Jogador> jogadores) {
        for (Jogador jogador : jogadores) {
            System.out.println("- " + jogador);
        }
    }



    private void showOptionsSelectFromList(List<?> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i));
        }
    }
}
