import java.util.Stack;

public class TestaPilha {
    public static void main(String[] args) {
        Stack<Contato> stack = new Stack<>();

        // Adicionar alguns contatos à pilha
        stack.push(new Contato("Contato 1", "1111-1111", "contato1@email.com"));
        stack.push(new Contato("Contato 2", "2222-2222", "contato2@email.com"));
        stack.push(new Contato("Contato 3", "3333-3333", "contato3@email.com"));

        // Tamanho da pilha
        System.out.println("Tamanho da pilha: " + stack.size());

        // Imprimir elementos da pilha
        System.out.println("Elementos na pilha:");
        for (Contato ct : stack) {
            System.out.println(ct.getNome());
        }

        // Topo da pilha 
        System.out.println(stack.peek());

        // Verificar se um elemento existe
        System.out.println("Posição: " + stack.search(new Contato("Contato 1", "1111-1111", "contato1@email.com")));

        // Excluir elemento - Desempilhar
        Contato removido = stack.pop();
        System.out.println("Contato removido: " + removido.getNome());

        // Imprimir a pilha após desempilhar
        System.out.println("Elementos :");
        for (Contato ct : stack) {
            System.out.println(ct.getNome());
        }
    }
}