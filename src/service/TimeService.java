package service;

import model.Jogador;
import model.Tecnico;
import model.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeService {
    private List<Tecnico> bancoDeTecnicos = new ArrayList<>();
    private List<Jogador> bancoDeJogadores = new ArrayList<>();
    private List<Time> times = new ArrayList<>();
    private Scanner scanner;

    public TimeService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createTecnico() {
        System.out.print("Nome do técnico: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do técnico: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        Tecnico tecnico = new Tecnico(nome, idade);
        bancoDeTecnicos.add(tecnico);
        System.out.println("Técnico adicionado ao banco com sucesso!");
    }

    public void createJogador() {
        System.out.print("Nome do jogador: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do jogador: ");
        int idade = scanner.nextInt();
        System.out.print("Número da camisa do jogador: ");
        int numCamisa = scanner.nextInt();
        scanner.nextLine();

        Jogador jogador = new Jogador(nome, idade, numCamisa);
        bancoDeJogadores.add(jogador);
        System.out.println("Jogador adicionado ao banco com sucesso!");
    }

    public void createTime() {
        System.out.print("Nome do time: ");
        String nome = scanner.nextLine();

        if (bancoDeTecnicos.isEmpty()) {
            System.out.println("Nenhum técnico disponível no banco. Adicione um técnico primeiro.");
            return;
        }

        System.out.println("Escolha um técnico pelo código:");
        showOptionsSelectFromList(bancoDeTecnicos);
        int tecnicoIndex = scanner.nextInt();
        scanner.nextLine();
        Tecnico tecnico = bancoDeTecnicos.get(tecnicoIndex);
        bancoDeTecnicos.remove(tecnico);
        Time time = new Time(nome, tecnico);
        times.add(time);
        System.out.println("Time adicionado com sucesso!");
    }

    public  void escalarJogadorEmTime() {
        System.out.println("Escolha um time para adicionar um jogador:");
        if (times.isEmpty()) {
            System.out.println("Nenhum time cadastrado. Adicione um time primeiro.");
            return;
        }
        showOptionsSelectFromList(times);
        int timeIndex = scanner.nextInt();
        scanner.nextLine();
        Time time = times.get(timeIndex);

        if (bancoDeJogadores.isEmpty()) {
            System.out.println("Nenhum jogador disponível no banco. Adicione um jogador primeiro.");
            return;
        }

        System.out.println("Escolha um jogador do banco:");
        showOptionsSelectFromList(bancoDeJogadores);
        int jogadorIndex = scanner.nextInt();
        scanner.nextLine();
        Jogador jogador = bancoDeJogadores.get(jogadorIndex);
        time.adicionarJogador(jogador);
        bancoDeJogadores.remove(jogador);

    }

    public void removerJogadorDoTime() {
        System.out.println("Escolha um time para remover um jogador:");
        if (times.isEmpty()) {
            System.out.println("Nenhum time cadastrado. Adicione um time primeiro.");
            return;
            // tirar do time e adicionar o jogador no banco
        }
        showOptionsSelectFromList(times);
        int timeIndex = scanner.nextInt();
        scanner.nextLine();
        Time time = times.get(timeIndex);

        if (time.estaSemJogadores()) {
            System.out.println("Nenhum jogador disponível no time. Adicione um jogador primeiro.");
            return;
        }
        System.out.println("Escolha um jogador do time para remover:");
        for (int i = 0; i < time.getJogadores().size(); i++) {
            System.out.println(i + " - " + time.getJogadores().get(i).getNome());
        }
        int jogadorIndex = scanner.nextInt();
        scanner.nextLine();
        Jogador jogador = time.getJogadores().get(jogadorIndex);
        time.removerJogador(jogador);
        bancoDeJogadores.add(jogador);
        System.out.println("Jogador removido do time com sucesso!");
    }

    public void substituirTecnicoDoTime() {
        System.out.println("Escolha um time para substituir o técnico:");
        if (times.isEmpty()) {
            System.out.println("Nenhum time cadastrado. Adicione um time primeiro.");
            return;
        }
        if (bancoDeTecnicos.isEmpty()) {
            System.out.println("Nenhum tecnico no banco. Adicione algum tecnico primeiro.");
            return;
        }
        showOptionsSelectFromList(times);
        int timeIndex = scanner.nextInt();
        scanner.nextLine();
        Time timeParaSubstituicao = times.get(timeIndex);

        System.out.println("Escolha um tecnico do banco para substitir o atual:");
        showOptionsSelectFromList(bancoDeTecnicos);
        int tecnicoIndex = scanner.nextInt();
        scanner.nextLine();
        Tecnico novoTecnico = bancoDeTecnicos.get(tecnicoIndex);

        bancoDeTecnicos.add(timeParaSubstituicao.getTecnico());
        timeParaSubstituicao.setTecnico(novoTecnico);
        bancoDeTecnicos.remove(novoTecnico);
        System.out.println("Técnico removido do time com sucesso!");
    }


    public void listarTimes() {
        if (times.isEmpty()) {
            System.out.println("Nenhum time cadastrado.");
            return;
        }

        for (Time time : times) {
            System.out.println("Time: " + time.getNome());
            System.out.println("Técnico: " + time.getTecnico().getNome());
            System.out.println("Jogadores:");
            for (Jogador jogador : time.getJogadores()) {
                System.out.println("- " + jogador);
            }
            System.out.println();
        }
    }

    public void listarBanco() {
        System.out.println("Técnicos no banco:");
        for (Tecnico tecnico : bancoDeTecnicos) {
            System.out.println("- " + tecnico.getNome());
        }

        System.out.println("Jogadores no banco:");
        for (Jogador jogador : bancoDeJogadores) {
            System.out.println("- " + jogador);
        }
    }

    private void showOptionsSelectFromList(List<?> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i));
        }
    }

}
