package view;

import model.Tecnico;

import java.util.Scanner;

public class TimeView {

    private Scanner scanner;

    public TimeView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Tecnico createTecnico() {
        System.out.print("Nome do técnico: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do técnico: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        return new Tecnico(nome, idade);
    }

}
