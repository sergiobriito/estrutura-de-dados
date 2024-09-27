import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Disco implements Comparable<Disco>{
      Integer index;
      String movimento;
      Disco(int index,String movimento){
         this.index=index;
         this.movimento=movimento;
      }
    public int compareTo(Disco o) {
        return index.compareTo(o.index);
    }
}
public class HanoiIterativo {
    private int qtDiscos;
    private String sequenciaImpares[] =   {"A-->C", "C-->B", "B-->A"};//para impares
    private String sequenciaPares  [] =   {"A-->B", "B-->C", "C-->A"};//para pares
    private List<Disco> arrayDiscos = new ArrayList<Disco>();
    public void lerDados() {
        System.out.println("Digite a quantidade de  discos");
        Scanner rc = new Scanner(System.in);
        try{
         qtDiscos = rc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Amigão! É fácil! Digite o número de discos por favor!");
            lerDados();
        }
    }
    public void hanoi() {
            int maxP=(int) Math.pow(2, qtDiscos);
            int y  = 1;
            int pos =1;
            while(y <= qtDiscos ){
                 int ctPulos = (int) Math.pow(2, y);
                 pos*=2;
                 if(y==1){
                     pos=1;
                 }
                 if(qtDiscos%2==0){
                  populaArrayPares(pos,ctPulos,maxP,y);
                 }else{
                  populaArrayImpares(pos,ctPulos,maxP,y);
                 }
                 y++;
           }
    }
    private void populaArrayPares(int pos,int intervalos, int maxP,int y){
           int index = 0;
           if(y%2==0){
               for (int i = pos; i <= maxP; i+=intervalos) {
                   Disco d = new Disco(i, sequenciaPares[index]);
                   arrayDiscos.add(d);
                   index++;
                   if(index>2){
                      index=0;
                   }
               }
           }else{
               for (int i = pos; i < maxP; i+=intervalos) {
                   Disco d = new Disco(i, sequenciaImpares[index]);
                   arrayDiscos.add(d);
                   index++;
                   if(index>2){
                      index=0;
                   }
               }
           }
        }
    private void populaArrayImpares(int pos,int intervalos, int maxP,int y){
       int index = 0;
       if(y%2==0){
           for (int i = pos; i < maxP; i+=intervalos) {
               Disco d = new Disco(i, sequenciaImpares[index]);
                   arrayDiscos.add(d);
                   index++;
                   if(index>2){
                      index=0;
                   }
               }
       }else{
          for (int i = pos; i <= maxP; i+=intervalos) {
               Disco d = new Disco(i, sequenciaPares[index]);
               arrayDiscos.add(d);
           index++;
           if(index>2){
              index=0;
           }
           }
       }
        }
    public static void main(String[] args) {
        HanoiIterativo h = new HanoiIterativo();
        h.lerDados();
        h.hanoi();
        Collections.sort(h.arrayDiscos);
        for (Disco d : h.arrayDiscos) {
             System.out.println("execute: "+d.index+"  "+d.movimento);
        }
    }
}