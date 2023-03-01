package org.example;

import java.util.Scanner;

public class Ejercicio5 {
    static Scanner sc = new Scanner(System.in);
    static final int FILAS = 10;
    static final int COMLUMNAS = 40;

    public static void inicializarLienzo(char[][] lienzo) {
        for (int i = 0; i < lienzo.length; i++) {
            for (int j = 0; j < lienzo[i].length; j++) {
                lienzo[i][j] = ' ';
            }
        }
    }

    public static void mostrarLienzo(char[][] lienzo) {
        System.out.println("____________________________________________");
        for (int i = 0; i < lienzo.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < lienzo[i].length; j++) {
                System.out.print(lienzo[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("--------------------------------------------");
    }

    public static void dibujarCaracter(char[][] lienzo, int fila, int columna, char caracter){
        for (int i = 0; i < lienzo.length; i++) {
            for (int j = 0; j < lienzo[i].length; j++) {
                if (i == fila && j == columna){
                    lienzo[i][j] = caracter;
                }
            }
        }
    }

    public static void dibujarRectangulo(char[][] lienzo, int fila, int columna, char caracter, int ancho, int alto){
        for (int i = 0; i < lienzo.length; i++) {
            for (int j = 0; j < lienzo[i].length; j++) {
                if (i >= fila && i <= fila + ancho && j >= columna && j <= columna + alto){
                    lienzo[i][j] = caracter;
                }
            }
        }
    }

    public static void cambiarColor(char[][] lienzo, char caracter){
        for (int i = 0; i < lienzo.length; i++) {
            for (int j = 0; j < lienzo[i].length; j++) {
                if (lienzo[i][j] != ' '){
                    lienzo[i][j] = caracter;
                }
            }
        }
    }


    public static void menu(){
        char[][] lienzo = new char[FILAS][COMLUMNAS];
        boolean salir = false;
        inicializarLienzo(lienzo);
        mostrarLienzo(lienzo);
        do {
            System.out.println("1.- Dibujar caracter");
            System.out.println("2.- Dibujar rectangulo con un conjunto de caracteres");
            System.out.println("3.- Cambiar el color (es decir, el carácter)");
            System.out.println("4.- Cambiar de lienzo");
            System.out.println("5.- Salir");
            int opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Introduce la fila");
                    int fila = sc.nextInt();
                    System.out.println("Introduce la columna");
                    int columna = sc.nextInt();
                    System.out.println("Introduce el caracter");
                    char caracter = sc.next().charAt(0);
                    dibujarCaracter(lienzo, fila, columna, caracter);
                    mostrarLienzo(lienzo);
                    System.out.println("Lo simple es lo mejor");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Introduce la fila");
                    int fila1 = sc.nextInt();
                    System.out.println("Introduce la columna");
                    int columna1 = sc.nextInt();
                    System.out.println("Introduce el caracter");
                    char caracter1 = sc.next().charAt(0);
                    System.out.println("Introduce el ancho");
                    int ancho = sc.nextInt();
                    System.out.println("Introduce el alto");
                    int alto = sc.nextInt();
                    dibujarRectangulo(lienzo, fila1, columna1, caracter1, ancho, alto);
                    mostrarLienzo(lienzo);
                    System.out.println("Estás hecho un artista!!");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Introduce el caracter");
                    char caracter2 = sc.next().charAt(0);
                    cambiarColor(lienzo, caracter2);
                    mostrarLienzo(lienzo);
                    System.out.println("La proxima vez piensalo antes de pintar, que te has liado");
                    System.out.println();
                    break;
                case 4:
                    inicializarLienzo(lienzo);
                    mostrarLienzo(lienzo);
                    System.out.println("Cojo un lienzo lo tiro por el retrete y ya son 200 los retretes");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (!salir);
    }

    public static void main(String[] args) {
        menu();
    }

}
