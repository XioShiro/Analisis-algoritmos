/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.recursividad;
  import java.util.Arrays;
/**
 *
 * @author Usuario
 */
public class Recursividad {

    
    static int factorial(int n) {
        if (n <= 1) return 1;            // caso base
        return n * factorial(n - 1);     // progresión hacia el caso base
    }

    // ---------- Memoización (Fibonacci con memo) ----------
    // Evita recomputar subproblemas guardando resultados en un array.
    static long fibMemo(int n, long[] memo) {
        if (n <= 1) return n;            // caso base
        if (memo[n] != -1) return memo[n]; // ya calculado
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo); // llamada recursiva
        return memo[n];
    }

    // ---------- Backtracking + Selección óptima ----------
    static int mejorValor; // variable global para guardar la mejor solución encontrada

    // idx: índice actual; curW: peso acumulado; curV: valor acumulado
    static void mochilaBacktrack(int idx, int[] pesos, int[] valores, int capacidad, int curW, int curV) {
        if (curW > capacidad) return;   // poda: solución inválida (se pasó de capacidad)
        if (idx == pesos.length) {       // caso base: consideramos la solución parcial completa
            if (curV > mejorValor) mejorValor = curV; // selección óptima: guardamos el mejor valor
            return;
        }

        // Opción 1: incluir el objeto idx
        mochilaBacktrack(idx + 1, pesos, valores, capacidad, curW + pesos[idx], curV + valores[idx]);

        // Opción 2: excluir el objeto idx
        mochilaBacktrack(idx + 1, pesos, valores, capacidad, curW, curV);
    }

    // ---------- Main: demostración ----------
    public static void main(String[] args) {
        // Recursión
        System.out.println("Factorial de 5 = " + factorial(5)); // 120

        // Memoización
        int n = 10;
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        System.out.println("Fibonacci(10) con memoización = " + fibMemo(n, memo)); // 55

        // Backtracking + selección óptima (ejemplo mochila muy pequeño)
        int[] pesos = {2, 3, 4, 5};
        int[] valores = {3, 4, 5, 6};
        int capacidad = 5;
        mejorValor = 0;
        mochilaBacktrack(0, pesos, valores, capacidad, 0, 0);
        System.out.println("Mejor valor mochila (capacidad 5) = " + mejorValor); // 7 (objetos 0 + 1)
    }
}


