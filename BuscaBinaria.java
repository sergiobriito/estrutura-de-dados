class BuscaBinaria{

    static int contador = 0;

    public static void main(String[] args) {
        int n = 100;
        int target = 101;

        int[] arr = new int[n];

        for (int i=0;i<n;i++){
            arr[i] = i;
        };   

        System.out.println("Encontrado: " + buscaBinaria(arr, target) + " | Quantidade de vezes executadas no algoritmo: " + contador);

    }

    public static boolean buscaBinaria(int[] arr, int target){
        int esquerda = 0;
        int direita = arr.length - 1;
        while (esquerda <= direita){
            contador++;
            int mid = esquerda + (direita - esquerda) / 2;
            if (arr[mid] == target){
                return true;
            }else if (arr[mid] < target){
                esquerda = mid + 1;
            }else{
                direita = mid - 1;
            };
        };
        return false;
    };
};