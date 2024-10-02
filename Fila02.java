import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Fila02 {
    public static void main(String[] args) {
        PriorityQueue<Pessoa> queue = new PriorityQueue<>();
        Queue<Pessoa> queuePrio = new ArrayDeque<>();

        // Enfileirando pessoas na fila
        queue.add(new Pessoa("Sergio", Senha.NORMAL));
        queue.add(new Pessoa("Wilson", Senha.PRIORIDADE));
        queue.add(new Pessoa("ROSA", Senha.PRIORIDADE));
        queue.add(new Pessoa("Gustavo", Senha.PRIORIDADE));
        queue.add(new Pessoa("Fabricio", Senha.PRIORIDADE));
        queue.add(new Pessoa("Brito", Senha.NORMAL));
        queue.add(new Pessoa("Lais", Senha.PRIORIDADE));
        queue.add(new Pessoa("Vieira", Senha.PRIORIDADE));
        queue.add(new Pessoa("Joao", Senha.PRIORIDADE));
        queue.add(new Pessoa("Marcos", Senha.PRIORIDADE));
        
        // Desenfileirando pessoas da fila
        int countPri = 0;
        while (!queue.isEmpty()) {
            if (!queuePrio.isEmpty() && countPri < 3){
                    Pessoa pessoa = queuePrio.poll();
                    queue.add(pessoa);
            }

            if (queue.peek().senha == Senha.PRIORIDADE){
                Pessoa pessoa = queue.poll();
                if (countPri == 3){
                    queuePrio.add(pessoa);
                }else{
                    System.out.println("Atendendo: " + pessoa.nome + " | " + pessoa.senha);
                    countPri++;
                };
            }else {
                Pessoa pessoa = queue.poll();
                System.out.println("Atendendo: " + pessoa.nome + " | " + pessoa.senha);
                countPri = 0;
            };
        }

    }
    


}
