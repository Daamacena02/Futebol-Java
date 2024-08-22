import model.Jogador;
import model.Tecnico;
import model.Time;
import service.TimeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void showMenu() {
        System.out.println("1 - Adicionar técnico ao banco");
        System.out.println("2 - Adicionar jogador ao banco");
        System.out.println("3 - Adicionar time");
        System.out.println("4 - Escalar jogador em um time");
        System.out.println("5 - Remover jogador de um time");
        System.out.println("6 - Substituir técnico");
        System.out.println("7 - Listar times");
        System.out.println("8 - Listar banco");
        System.out.println("0 - Sair");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeService timeService = new TimeService(scanner);

        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> timeService.createTecnico();
                case 2 -> timeService.createJogador();
                case 3 -> timeService.createTime();
                case 4 -> timeService.escalarJogadorEmTime();
                case 5 -> timeService.removerJogadorDoTime();
                case 6 -> timeService.substituirTecnicoDoTime();
                case 7 -> timeService.listarTimes();
                case 8 -> timeService.listarBanco();
                case 0 -> System.out.println("Obrigado por utilizar!");
                default -> System.out.println("Digite uma opção válida");
            }

        } while (option != 0);
    }
}
