package service;

import model.Jogador;
import model.Tecnico;
import model.Time;
import view.TimeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeService {
    private final List<Tecnico> bancoDeTecnicos = new ArrayList<>();
    private final List<Jogador> bancoDeJogadores = new ArrayList<>();
    private final List<Time> times = new ArrayList<>();
    private final TimeView timeView;

    public TimeService(Scanner scanner) {
        this.timeView = new TimeView(scanner);
    }

    public void createTecnico() {
        Tecnico tecnico = timeView.insertNewTecnico();
        bancoDeTecnicos.add(tecnico);
        System.out.println("Técnico adicionado ao banco com sucesso!");
    }

    public void createJogador() {
        Jogador jogador = timeView.insertNewJogador();
        bancoDeJogadores.add(jogador);
        System.out.println("Jogador adicionado ao banco com sucesso!");
    }

    public void createTime() {
        if (bancoDeTecnicos.isEmpty()) {
            throw new RuntimeException("Nenhum técnico disponível no banco. Adicione um técnico primeiro.");
        }

        Time time = timeView.insertNewTime(bancoDeTecnicos);
        Tecnico tecnicoEscolhido = time.getTecnico();
        bancoDeTecnicos.remove(tecnicoEscolhido);

        times.add(time);
        System.out.println("Time adicionado com sucesso!");
    }

    public  void escalarJogadorEmTime() {
        if (times.isEmpty()) {
            throw new RuntimeException("não há times disponíveis");
        }

        if (bancoDeJogadores.isEmpty()) {
            throw new RuntimeException("não há jogadores disponíveis no banco");
        }

        Time time = timeView.chooseSomeTime(times);
        Jogador jogador = timeView.chooseSomeJogador(bancoDeJogadores);

        time.adicionarJogador(jogador);
        bancoDeJogadores.remove(jogador);
        System.out.println("Jogador escalado com sucesso");
    }

    public void removerJogadorDoTime() {
        if (times.isEmpty()) {
            throw new RuntimeException("Nenhum time cadastrado. Adicione um time primeiro.");
        }

        Time time = timeView.chooseSomeTime(times);

        if (time.estaSemJogadores()) {
            throw new RuntimeException("Nenhum jogador disponível no time. Adicione um jogador primeiro.");
        }

        List<Jogador> jogadoresParaEscolher = time.getJogadores();
        Jogador jogador = timeView.chooseSomeJogador(jogadoresParaEscolher);

        time.removerJogador(jogador);
        bancoDeJogadores.add(jogador);
        System.out.println("Jogador removido do time com sucesso!");
    }

    public void substituirTecnicoDoTime() {
        if (times.isEmpty()) {
            throw new RuntimeException("Nenhum time cadastrado. Adicione um time primeiro.");
        }

        if (bancoDeTecnicos.isEmpty()) {
            throw new RuntimeException("Nenhum tecnico no banco. Adicione algum tecnico primeiro.");
        }

        Time timeParaSubstituicao = timeView.chooseSomeTime(times);
        Tecnico novoTecnico = timeView.chooseSomeTecnico(bancoDeTecnicos);
        Tecnico tecnicoParaRemover = timeParaSubstituicao.getTecnico();

        bancoDeTecnicos.add(tecnicoParaRemover);
        timeParaSubstituicao.setTecnico(novoTecnico);
        bancoDeTecnicos.remove(novoTecnico);
        System.out.println("Técnico removido do time com sucesso!");
    }


    public void listarTimes() {
        if (times.isEmpty()) {
            throw new RuntimeException("Não há times criados para mostrar.");
        }

        for (Time time : times) {
            timeView.showTime(time);
        }
    }

    public void listarBanco() {
        System.out.println("Técnicos no banco:");
        timeView.showTecnicos(bancoDeTecnicos);

        System.out.println("Jogadores no banco:");
        timeView.showJogadores(bancoDeJogadores);
    }

    private void showOptionsSelectFromList(List<?> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " - " + list.get(i));
        }
    }

}
