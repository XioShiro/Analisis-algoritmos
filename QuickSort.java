/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QuickSort;

/**
 *
 * @author Usuario
 */

    /**
     */
public class QuickSort {

    public static void quickSort(int[] arr, int izq, int der) {
        if (izq < der) {
            int pivote = particion(arr, izq, der);
            quickSort(arr, izq, pivote - 1);   // ordena la izquierda
            quickSort(arr, pivote + 1, der);   // ordena la derecha
        }
    }

    private static int particion(int[] arr, int izq, int der) {
        int pivote = arr[der];  // elegimos el último como pivote
        int i = izq - 1;        // índice para los elementos pequeños

        for (int j = izq; j < der; j++) {
            if (arr[j] <= pivote) {
                i++;
                // intercambiar arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // ponemos el pivote en su lugar correcto
        int temp = arr[i + 1];
        arr[i + 1] = arr[der];
        arr[der] = temp;

        return i + 1;
    }

    // Para probarlo fácil
    public static void main(String[] args) {
        int[] numeros = {10, 7, 8, 9, 1, 5};
        
        System.out.print("Antes: ");
        for (int n : numeros) System.out.print(n + " ");
        
        quickSort(numeros, 0, numeros.length - 1);
        
        System.out.print("\nDespués: ");
        for (int n : numeros) System.out.print(n + " ");
    }
}

