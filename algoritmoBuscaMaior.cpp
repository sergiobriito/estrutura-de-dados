#include <iostream>
#include <chrono>

using namespace std;
using namespace std::chrono;

int* buscarMaiorElemento(int arr[], int n){
    static int res[2];
    auto beg = high_resolution_clock::now();
    int maior = 0;
    for (int i=0;i<n;i++){
        if (arr[i] > maior){
            maior = arr[i];
        };
    };
    auto end = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(end - beg);
    res[0] = duration.count();
    res[1] = maior;
    return res;
};

int main() {
    
    int size = 100;
    cout << "Array de " << size << " elementos: " << endl;
    int arr_cem[size];
    for(int i=0;i<size;i++){
        int randomNum = rand();
        arr_cem[i] = randomNum;
    };
    int* res = buscarMaiorElemento(arr_cem, size);
    cout << "Tempo gasto (microsegundos): " << res[0] << endl;
    cout << "Maior elemento: " << res[1] << endl;
    
    cout << "-----------------" << endl;
    
    size = 100000;
    cout << "Array de " << size << " elementos: " << endl;
    int arr_mil[size];
    for(int i=0;i<size;i++){
        int randomNum = rand();
        arr_mil[i] = randomNum;
    };
    res = buscarMaiorElemento(arr_mil, size);
    cout << "Tempo gasto (microsegundos): " << res[0] << endl;
    cout << "Maior elemento: " << res[1] << endl;
    
    cout << "-----------------" << endl;
    
    size = 1000000;
    cout << "Array de " << size << " elementos: " << endl;
    int arr_mill[size];
    for(int i=0;i<size;i++){
        int randomNum = rand();
        arr_mill[i] = randomNum;
    };
    res = buscarMaiorElemento(arr_mill, size);
    cout << "Tempo gasto (microsegundos): " << res[0] << endl;
    cout << "Maior elemento: " << res[1] << endl;
    
 
    return 0;
} 