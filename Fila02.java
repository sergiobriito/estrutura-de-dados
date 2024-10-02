import java.util.ArrayDeque;
import java.util.Queue;

public class Fila02 {
    public static void main(String[] args) {
        Queue<Pessoa> priority = new ArrayDeque<>();
        Queue<Pessoa> normal = new ArrayDeque<>();

        // Enfileirando pessoas na fila
        normal.add(new Pessoa("Sergio", Senha.NORMAL));
        priority.add(new Pessoa("Wilson", Senha.PRIORIDADE));
        priority.add(new Pessoa("ROSA", Senha.PRIORIDADE));
        priority.add(new Pessoa("Gustavo", Senha.PRIORIDADE));
        priority.add(new Pessoa("Fabricio", Senha.PRIORIDADE));
        normal.add(new Pessoa("Brito", Senha.NORMAL));
        priority.add(new Pessoa("Lais", Senha.PRIORIDADE));
        priority.add(new Pessoa("Vieira", Senha.PRIORIDADE));
        priority.add(new Pessoa("Joao", Senha.PRIORIDADE));
        priority.add(new Pessoa("Marcos", Senha.PRIORIDADE));
        
        // Desenfileirando pessoas da fila
        while (!normal.isEmpty() || !priority.isEmpty()) {
            for (int i=0;i<3;i++){
                if (!priority.isEmpty()){
                    Pessoa pessoa = priority.poll();
                    System.out.println("Atendendo: " + pessoa.nome + " | " + pessoa.senha);
                };
            };

            if (!normal.isEmpty()){
                Pessoa pessoa = normal.poll();
                System.out.println("Atendendo: " + pessoa.nome + " | " + pessoa.senha);
            };


        }

    }
    


}
