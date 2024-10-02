import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;

public class Fila03 {
    static Queue<PessoaSocorro> vermelho = new ArrayDeque<>();
    static Queue<PessoaSocorro> amarelo = new ArrayDeque<>();
    static Queue<PessoaSocorro> verde = new ArrayDeque<>();
    static Random gerador = new Random();

    public static void enfileirar(PessoaSocorro pessoaSocorro){
        if (pessoaSocorro.senha == SenhaProSoc.VERMELHO){
            vermelho.add(pessoaSocorro);
        }else if (pessoaSocorro.senha == SenhaProSoc.AMARELO){
            amarelo.add(pessoaSocorro);
        }else{
            verde.add(pessoaSocorro);
        };
    };

    public static void atender(String queueType){
        if (queueType.equals("vermelho")){
            PessoaSocorro pessoa = vermelho.poll();
            System.out.println("Atendendo: " + pessoa.nome + " | " + pessoa.senha);
        }else if (queueType.equals("amarelo")){
            PessoaSocorro pessoa = amarelo.poll();
            System.out.println("Atendendo: " + pessoa.nome + " | " + pessoa.senha);
        }else{
            PessoaSocorro pessoa = verde.poll();
            System.out.println("Atendendo: " + pessoa.nome + " | " + pessoa.senha);
        };
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public static String identificadorPessoa() {
        String random = UUID.randomUUID()
                    .toString()
                    .substring(0, 5);
        return random;
    }

    public static void adicionarPessoasNaFila(){
        while (true){
            int senha = gerador.nextInt(3);
            SenhaProSoc senhaProSoc;
            if (senha == 0){
                senhaProSoc = SenhaProSoc.VERMELHO;
            }else if (senha == 1){
                senhaProSoc = SenhaProSoc.AMARELO;
            }else{
                senhaProSoc = SenhaProSoc.VERDE;
            };
            PessoaSocorro pessoaSocorro = new PessoaSocorro(identificadorPessoa(), senhaProSoc);
            enfileirar(pessoaSocorro);
            try {
                Thread.sleep(7000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {
        Thread thread = new Thread(() -> adicionarPessoasNaFila());
        thread.start();
        
        // Enfileirando pessoas na fila
        enfileirar(new PessoaSocorro("Sergio", SenhaProSoc.VERDE));
        enfileirar(new PessoaSocorro("Brito", SenhaProSoc.VERMELHO));
        enfileirar(new PessoaSocorro("Wilson", SenhaProSoc.AMARELO));
        enfileirar(new PessoaSocorro("ROSA", SenhaProSoc.VERDE));
        enfileirar(new PessoaSocorro("Lais", SenhaProSoc.AMARELO));
        enfileirar(new PessoaSocorro("Vieira", SenhaProSoc.VERMELHO)); 

        
        // Desenfileirando pessoas da fila
        while (!vermelho.isEmpty() || !amarelo.isEmpty() || !verde.isEmpty()) {
            System.out.println("Tamanho das filas: " + (vermelho.size() + amarelo.size() + verde.size()));
            for (int i=0;i<3;i++){
                if (!vermelho.isEmpty()){
                    atender("vermelho");
                };
            };

            for (int i=0;i<2;i++){
                if (!amarelo.isEmpty()){
                    atender("amarelo");
                };
            };

            if (!verde.isEmpty()){
                atender("verde");
            };


        }

    }
    


}