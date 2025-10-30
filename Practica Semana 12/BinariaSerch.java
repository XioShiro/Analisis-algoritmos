/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binariaserch;

/**
 *
 * @author LAB-USR-AREQUIPA
 */
public class BinariaSerch {
    
    public static int binariaSerch(int[] lista, int objetivo) {
        int bajo = 0;
        int alto = lista.length - 1;
        
        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            
            if (lista[medio] == objetivo) {
                return medio; 
            } else if (lista[medio] < objetivo) {
                bajo = medio + 1; // Buscar en la mitad derecha
            } else {
                alto = medio - 1; // Buscar en la mitad izquierda
            }
        }
        
        return -1; // No encontrado
    }
    
    public static void main(String[] args) {
        int[] lista = {1, 3, 5, 7, 9, 11, 13};
        
        System.out.println(binariaSerch(lista, 7));  // Devuelve 3
        System.out.println(binariaSerch(lista, 4));  // Devuelve -1
    }
}
