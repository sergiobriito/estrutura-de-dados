import java.util.*;

public class Fila01 {

    public static void main(String[] args) {

        Queue<Thread> queue = new ArrayDeque<>();
        
        // Enfileirando os documentos na fila
        int quantDocumentos = 5;
        for (int i=0;i<quantDocumentos;i++){
            Thread doc = new Thread(new Documento(String.valueOf(i), (i+1)*5));
            queue.add(doc);
        };
        
        // Desenfileirando os documentos da fila
        while(!queue.isEmpty()){
            Thread doc = queue.poll();
            doc.start();
        };

    }
}