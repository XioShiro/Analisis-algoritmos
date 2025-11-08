/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prubit;

/**
 *
 * @author Usuario
 */
public class Prubit {

// 1) Factorial (recursivo)
    public static long factorialRec(int n) {
        if (n == 0 || n == 1) return 1L; // caso base
        return n * factorialRec(n - 1); // llamada recursiva
    }

    // 2) Factorial (iterativo)
    public static long factorialIt(int n) {
        long res = 1L;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    // 3) Mostrar pila simple (prints) para entender llamadas
    public static long demoPila(int n, int depth) {
        String indent = "  ".repeat(Math.max(0, depth));
        System.out.println(indent + "entra " + n);
        if (n <= 1) {
            System.out.println(indent + "caso base " + n);
            return 1L;
        }
        long r = n * demoPila(n - 1, depth + 1);
        System.out.println(indent + "sale " + n + " -> " + r);
        return r;
    }

    // 4) Recursividad indirecta (A <-> B)
    public static String A(int x) {
        System.out.println("A " + x);
        if (x <= 0) return "fin";
        return B(x - 1);
    }

    public static String B(int x) {
        System.out.println("B " + x);
        if (x <= 0) return "fin";
        return A(x - 2);
    }

    // 5) Backtracking mínimo (laberinto)
    // grid: 0 = libre, 1 = muro
    public static boolean backtrack(int[][] grid, int r, int c, int tr, int tc, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols) return false;
        if (grid[r][c] == 1 || visited[r][c]) return false;
        if (r == tr && c == tc) return true;

        visited[r][c] = true;

        // intentar 4 direcciones: abajo, arriba, derecha, izquierda
        if (backtrack(grid, r + 1, c, tr, tc, visited)) return true;
        if (backtrack(grid, r - 1, c, tr, tc, visited)) return true;
        if (backtrack(grid, r, c + 1, tr, tc, visited)) return true;
        if (backtrack(grid, r, c - 1, tr, tc, visited)) return true;

        // backtrack: desmarcar para permitir otras rutas si se reutiliza la llamada
        visited[r][c] = false;
        return false;
    }

    // método helper para iniciar backtracking sin que el usuario cree visited
    public static boolean hayCamino(int[][] grid, int sr, int sc, int tr, int tc) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return backtrack(grid, sr, sc, tr, tc, visited);
    }

    // Main - ejemplo de uso simple
    public static void main(String[] args) {
        int n = 5;
        System.out.println("fact_rec: " + factorialRec(n));
        System.out.println("fact_it : " + factorialIt(n));

        System.out.println("\n=== demo pila ===");
        demoPila(4, 0);

        System.out.println("\n=== recursividad indirecta ===");
        System.out.println("resultado: " + A(5));

        System.out.println("\n=== backtracking (laberinto 2x2) ===");
        int[][] lab = {
            {0, 0},
            {1, 0}
        }; // inicio (0,0) salida (1,1)
        System.out.println("hay camino? " + hayCamino(lab, 0, 0, 1, 1));
    }
    
}
