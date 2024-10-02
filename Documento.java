public class Documento implements Runnable {
    String nome;
    int quantFolhas;

    public Documento(String nome, int quantFolhas){
        this.nome = nome;
        this.quantFolhas = quantFolhas;
    };

    @Override
    public void run() {
        for (int i=0;i<quantFolhas;i++){ 
            System.out.println(Thread.currentThread().getName() + " | " +" Doc: " + this.nome + " | Folha: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    };
}
