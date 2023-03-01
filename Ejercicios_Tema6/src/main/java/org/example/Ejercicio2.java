package org.example;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();
    private static int TAMAÑO = 4;

    public static void inicializarTablero(char tablero[][]){
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                tablero[i][j] = '?';
            }
        }
    }

    public static void mostrarTablero(char tablero[][]){
        System.out.println("  0 1 2 3 ");
        for (int i = 0; i < TAMAÑO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMAÑO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int introducirEnteroEntreLimites(){
        int numero;
        do {
            numero = sc.nextInt();
            if (numero < 0 || numero > TAMAÑO) {
                System.out.println("Introduce un número entre 0 y " + (TAMAÑO-1));
            }
        } while (numero < 0 || numero > TAMAÑO);
        return numero;
    }

    public static boolean disparar(char tablero[][], int filaB, int columnaB, int fila, int columna){
        if (fila == filaB && columna == columnaB) {
            System.out.println("Tocado y hundido");
            return true;
        } else {
            tablero[fila][columna] = 'X';
            return false;
        }
    }

    public static void main(String[] args) {
        char tablero[][] = new char[TAMAÑO][TAMAÑO];
        int filaB = r.nextInt(TAMAÑO);
        int columnaB = r.nextInt(TAMAÑO);
        boolean salir = false;
        inicializarTablero(tablero);
        do {
            mostrarTablero(tablero);
            System.out.println("Introduce una fila: ");
            int fila = introducirEnteroEntreLimites();
            System.out.println("Introduce una columna: ");
            int columna = introducirEnteroEntreLimites();
            salir = disparar(tablero, filaB, columnaB, fila, columna);
        } while (!salir);
        System.out.println("Has ganado, felicidades!!");
    }
}