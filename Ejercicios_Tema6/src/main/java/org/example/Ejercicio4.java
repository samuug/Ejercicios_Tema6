package org.example;

import java.util.Scanner;

public class Ejercicio4 {
    static Scanner sc = new Scanner(System.in);
    public static void inicializarTabla(char[] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            if (i<3){
                tablero[i] = '>';
            } else if (i>3) {
                tablero[i] = '<';
            }else {
                tablero[i] = ' ';
            }
        }
    }

    public static void mostrarTablero(char[] tablero) {
        System.out.println(" 0 1 2 3 4 5 6");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("|"+tablero[i]);
        }
        System.out.println("|");
    }

    public static void reglas(char[] tablero, int posicion){
        if (tablero[posicion]=='>'&&posicion<5){
            if (tablero[posicion+1]==' '){
                tablero[posicion+1]='>';
                tablero[posicion]=' ';
            }else if (tablero[posicion+1]=='<' && tablero[posicion+2]==' '){
                tablero[posicion+2]='>';
                tablero[posicion]=' ';
            } else{
                System.out.println("Movimiento no valido");
            }
        } else if (tablero[posicion]=='>'&&posicion==5) {
            if (tablero[posicion + 1] == ' ') {
                tablero[posicion + 1] = '>';
                tablero[posicion] = ' ';
            } else {
                System.out.println("Movimiento no valido");
            }
        }else if (tablero[posicion]=='>'&&posicion==6){
            System.out.println("Movimiento no valido");
            }
        if (tablero[posicion]=='<'&&posicion>1){
            if (tablero[posicion-1]==' '){
                tablero[posicion-1]='<';
                tablero[posicion]=' ';
            }else if (tablero[posicion-1]=='>' && tablero[posicion-2]==' '){
                tablero[posicion-2]='<';
                tablero[posicion]=' ';
            } else{
                System.out.println("Movimiento no valido");
            }
        } else if (tablero[posicion]=='<'&&posicion==1) {
            if (tablero[posicion - 1] == ' ') {
                tablero[posicion - 1] = '<';
                tablero[posicion] = ' ';
            } else {
                System.out.println("Movimiento no valido");
            }
        }else if (tablero[posicion]=='<'&&posicion==0){
            System.out.println("Movimiento no valido");
        }
    }

    public static boolean ganador(char[] tablero){
        int cont=0;
        for (int i = 0; i < tablero.length; i++) {
            if (i<3 && tablero[i]=='<'){
                cont++;
            } else if (i>3 && tablero[i]=='>') {
                cont++;
            }else if (i==3 && tablero[i]==' '){
                cont++;
            }
        }
        if (cont==7){
            System.out.println("Has terminado el juego, enorabuena");
            return true;
        }
        return false;
    }

    public static boolean puedoMover(char[] tablero){
        int nMovimientos=0;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i]=='>'&&i<5){
                if (tablero[i+1]==' '){
                    nMovimientos++;
                }else if (tablero[i+1]=='<' && tablero[i+2]==' '){
                    nMovimientos++;
                }
            } else if (tablero[i]=='>'&&i==5) {
                if (tablero[i + 1] == ' ') {
                    nMovimientos++;
                }
            }
            if (tablero[i]=='<'&&i>1){
                if (tablero[i-1]==' '){
                    nMovimientos++;
                }else if (tablero[i-1]=='>' && tablero[i-2]==' '){
                    nMovimientos++;
                }
            } else if (tablero[i]=='<'&&i==1) {
                if (tablero[i - 1] == ' ') {
                    nMovimientos++;
                }
            }
        }
        if (nMovimientos!=0){
            return true;
        } else{
            System.out.println("No tienes movimientos disponibles, has perdido :(");
            return false;
        }
    }

    public static void mover(char[] tablero){
        System.out.println("Introduce la posicion de la ovejita que quieres mover:");
        int posicion = sc.nextInt();
        reglas(tablero, posicion);
    }
    public static void main(String[] args) {
        char[] tablero = new char[7];
        inicializarTabla(tablero);
        mostrarTablero(tablero);
        puedoMover(tablero);
        do {
            mover(tablero);
            mostrarTablero(tablero);
        } while (!ganador(tablero)&&puedoMover(tablero));


    }
}
