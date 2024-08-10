import model.Jogador;
import model.Tecnico;
import model.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Tecnico> tecnicos = new ArrayList<>();
    private static List<Jogador> bancoDeJogadores = new ArrayList<>();
    private static List<Time> times = new ArrayList<>();

    public static void createTecnico(Scanner scanner) {
        System.out.print("Nome do técnico: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do técnico: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        Tecnico tecnico = new Tecnico(nome, idade);
        tecnicos.add(tecnico);
        System.out.println("Técnico adicionado ao banco com sucesso!");
    }

    public static void createJogador(Scanner scanner) {
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

    public static void createTime(Scanner scanner) {
        System.out.print("Nome do time: ");
        String nome = scanner.nextLine();

        if (tecnicos.isEmpty()) {
            System.out.println("Nenhum técnico disponível no banco. Adicione um técnico primeiro.");
            return;
        }

        System.out.println("Escolha um técnico pelo código:");
        for (int i = 0; i < tecnicos.size(); i++) {
            System.out.println(i + " - " + tecnicos.get(i).getNome());
        }
        int tecnicoIndex = scanner.nextInt();
        scanner.nextLine();
        Tecnico tecnico = tecnicos.get(tecnicoIndex);
        Time time = new Time(nome, tecnico);
        times.add(time);
        System.out.println("Time adicionado com sucesso!");
    }

    private static void escalarJogadorEmTime(Scanner scanner) {
        System.out.println("Escolha um time para adicionar um jogador:");
        if (times.isEmpty()) {
            System.out.println("Nenhum time cadastrado. Adicione um time primeiro.");
            return;
        }
        for (int i = 0; i < times.size(); i++) {
            System.out.println(i + " - " + times.get(i).getNome());
        }
        int timeIndex = scanner.nextInt();
        scanner.nextLine();
        Time time = times.get(timeIndex);

        if (bancoDeJogadores.isEmpty()) {
            System.out.println("Nenhum jogador disponível no banco. Adicione um jogador primeiro.");
            return;
        }

        System.out.println("Escolha um jogador do banco:");
        for (int i = 0; i < bancoDeJogadores.size(); i++) {
            if (!bancoDeJogadores.get(i).isEmTime()) {
                System.out.println(i + " - " + bancoDeJogadores.get(i).getNome());
            }
        }
        int jogadorIndex = scanner.nextInt();
        scanner.nextLine();
        Jogador jogador = bancoDeJogadores.get(jogadorIndex);
        time.adicionarJogador(jogador);
        // adicionar verificação se o jogador ja esta escalado para o time
        // não listar jogadores que ja estao em um time
    }

    private static void removerJogadorDoTime(Scanner scanner) {
        System.out.println("Escolha um time para remover um jogador:");
        if (times.isEmpty()) {
            System.out.println("Nenhum time cadastrado. Adicione um time primeiro.");
            return;
        }
        for (int i = 0; i < times.size(); i++) {
            System.out.println(i + " - " + times.get(i).getNome());
        }
        int timeIndex = scanner.nextInt();
        scanner.nextLine();
        Time time = times.get(timeIndex);

        if (bancoDeJogadores.isEmpty()) {
            System.out.println("Nenhum jogador disponível no banco. Adicione um jogador primeiro.");
            return;
        }
        System.out.println("Escolha um jogador do banco para remover:");
        for (int i = 0; i < bancoDeJogadores.size(); i++) {
            System.out.println(i + " - " + bancoDeJogadores.get(i).getNome());
        }
        int jogadorIndex = scanner.nextInt();
        scanner.nextLine();
        Jogador jogador = bancoDeJogadores.get(jogadorIndex);
        time.removerJogador(jogador);
        System.out.println("Jogador removido do time com sucesso!");
    }



    public static void listarTimes() {
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

    public static void listarBanco() {
        System.out.println("Técnicos no banco:");
        for (Tecnico tecnico : tecnicos) {
            System.out.println("- " + tecnico.getNome());
        }

        System.out.println("Jogadores no banco:");
        for (Jogador jogador : bancoDeJogadores) {
            System.out.println("- " + jogador);
        }
    }

    public static void showMenu() {
        System.out.println("1 - Adicionar técnico ao banco");
        System.out.println("2 - Adicionar jogador ao banco");
        System.out.println("3 - Adicionar time");
        System.out.println("4 - Escalar jogador em um time");
        System.out.println("5 - Remover jogador de um time");
//        System.out.println("6 - Substituir técnico");
        System.out.println("7 - Listar times");
        System.out.println("8 - Listar banco");
        System.out.println("0 - Sair");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> createTecnico(scanner);
                case 2 -> createJogador(scanner);
                case 3 -> createTime(scanner);
                case 4 -> escalarJogadorEmTime(scanner);
                case 5 -> removerJogadorDoTime(scanner);
                case 7 -> listarTimes();
                case 8 -> listarBanco();
                case 0 -> System.out.println("Obrigado por utilizar!");
                default -> System.out.println("Digite uma opção válida");
            }

        } while(option != 0);
    }
}
