import banco.Banco;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Banco banco;
    private static Scanner scanner;
    public static void main(String[] args) {
        banco = new Banco("Banco POO Digital");
        scanner = new Scanner(System.in);
    

    }
}