import java.util.Scanner;
import java.util.Stack;

public class DesafioStack {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Conversão de bases numéricas (de binário a hexadecimal)");
        System.out.println("2 - Indentificar palavras palíndromas informadas pelo usuário.");
        int opcao = scanner.nextInt();
        
        switch (opcao) {
            case 1:
                conversaoBase(scanner);
                break;
            case 2:
                palindromo(scanner);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void conversaoBase(Scanner scanner) {
        System.out.print("Informe um número decimal: ");
        int numero = scanner.nextInt();

        System.out.print("Informe a base para a qual deseja converter (2 a 16): ");
        int base = scanner.nextInt();

        if (base < 2 || base > 16) {
            System.out.println("Base inválida! Deve ser entre 2 e 16.");
            return;
        }

        Stack<Character> pilha = new Stack<>();
        String caracteres = "0123456789ABCDEF";

        while (numero > 0) {
            int resto = numero % base;
            pilha.push(caracteres.charAt(resto));
            numero /= base;
        }

        StringBuilder resultado = new StringBuilder();
        while (!pilha.isEmpty()) {
            resultado.append(pilha.pop());
        }

        System.out.println("Número: " + resultado.toString());
    }

    public static void palindromo(Scanner scanner) {
        System.out.print("Informe uma palavra para verificar se é palíndroma: ");
        String palavra = scanner.next().replaceAll("\\s+", "").toLowerCase();

        if (isPalindromo(palavra)) {
            System.out.println(palavra + " é um palíndromo.");
        } else {
            System.out.println(palavra + " não é um palíndromo.");
        }
    }

    private static boolean isPalindromo(String palavra) {
        Stack<Character> pilha = new Stack<>();

        for (char c : palavra.toCharArray()) {
            pilha.push(c);
        }

        for (char c : palavra.toCharArray()) {
            if (c != pilha.pop()) {
                return false;
            }
        }
        return true;
    }

}
