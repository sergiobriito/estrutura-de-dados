import java.util.Scanner;
import java.util.Stack;

public class TestaPilha2 {
    public static void main(String[] args) {
        Stack<Contato> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Verificar tamanho da pilha");
            System.out.println("3 - Imprimir elementos da pilha");
            System.out.println("4 - Exibir o topo da pilha");
            System.out.println("5 - Verificar se um contato existe e retornar a posição");
            System.out.println("6 - Pesquisar por nome");
            System.out.println("7 - Pesquisar por e-mail");
            System.out.println("8 - Pesquisar por telefone");
            System.out.println("9 - Excluir elemento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {  // Adicionar contato
                System.out.print("Digite o nome: ");
                String nome = scanner.next();
                System.out.print("Digite o telefone: ");
                String telefone = scanner.next();
                System.out.print("Digite o e-mail: ");
                String email = scanner.next();
                stack.push(new Contato(nome, telefone, email));
                System.out.println("Contato adicionado.");
            } else if (opcao == 2) {  // Verificar tamanho da pilha
                System.out.println("Tamanho da pilha: " + stack.size());
            } else if (opcao == 3) {  // Imprimir elementos da pilha
                System.out.println("Elementos da pilha:");
                while (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                }
            } else if (opcao == 4) {  // Exibir topo da pilha
                System.out.println("Topo da pilha: " + stack.peek());
            } else if (opcao == 5) {  // Verificar se contato existe e retornar a posição
                System.out.print("Digite o nome do contato para verificar: ");
                String nome = scanner.nextLine();
                Contato contatoBuscado = new Contato(nome, "", "");
                int posicao = stack.search(contatoBuscado);
                if (posicao != -1) {
                    System.out.println("Contato encontrado na posição: " + posicao);
                } else {
                    System.out.println("Contato não encontrado.");
                }
            } else if (opcao == 6) {  // Pesquisar por nome
                System.out.print("Digite o nome: ");
                String nome = scanner.next();
                Contato ct = pesquisarPorNome(stack, nome);
                System.out.println(ct);
            } else if (opcao == 7) {  // Pesquisar por e-mail
                System.out.print("Digite o e-mail: ");
                String email = scanner.next();
                Contato ct = pesquisarPorEmail(stack, email);
                System.out.println(ct);
            } else if (opcao == 8) {  // Pesquisar por telefone
                System.out.print("Digite o telefone: ");
                String telefone = scanner.next();
                Contato ct = pesquisarPorNome(stack, telefone);
                System.out.println(ct);
            } else if (opcao == 9) {  // Excluir elemento
                if (!stack.isEmpty()) {
                    Contato removido = stack.pop();
                    System.out.println("Contato removido: " + removido);
                } else {
                    System.out.println("A pilha está vazia.");
                }
            } else if (opcao == 0) {  // Sair
                break;
            } else {
                System.out.println("Opção invalida");
            }
        }

        scanner.close();
    }

    // Função para pesquisar por nome
    public static Contato pesquisarPorNome(Stack<Contato> stack, String nome) {
        for (Contato contato : stack) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    // Função para pesquisar por e-mail
    public static Contato pesquisarPorEmail(Stack<Contato> stack, String email) {
        for (Contato contato : stack) {
            if (contato.getEmail().equalsIgnoreCase(email)) {
                return contato;
            }
        }
        return null;
    }

    // Função para pesquisar por telefone
    public static Contato pesquisarPorTelefone(Stack<Contato> stack, String telefone) {
        for (Contato contato : stack) {
            if (contato.getTelefone().equalsIgnoreCase(telefone)) {
                return contato;
            }
        }
        return null;
    }

}
