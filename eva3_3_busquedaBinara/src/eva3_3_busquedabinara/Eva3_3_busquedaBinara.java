/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_3_busquedabinara;

import java.util.Scanner;

/**
 *
 * @author moviles
 */
public class Eva3_3_busquedaBinara {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] arregloDatos = new int [15];
        int [] arregloSel = new int [arregloDatos.length];
        System.out.println("ARREGLO ORIGINAL");
        llenar(arregloDatos);
        imprimir(arregloDatos);
        System.out.println("");
        System.out.println("SELECTION SORT");
        copiar(arregloDatos,arregloSel);
        selectionSort(arregloSel);
        imprimir(arregloSel);
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.print("Introduce el valor a buscar: ");
        int buscar = sc.nextInt();
        System.out.println("");
        System.out.println("El valor está en: " + busquedaBinaria(arregloSel, buscar));
    }
    
    public static void llenar(int [] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int)(Math.random()*100);
        }
    }
    
    public static void imprimir(int [] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] < 10) {
                System.out.print("[" + arreglo[i] + "]");
            }else{
                System.out.print("[" + arreglo[i] + "]");
            }
            System.out.print("");
        }
    }
    public static void copiar(int [] arreglo, int [] copia){
        for (int i = 0; i < arreglo.length; i++) {
            copia[i] = arreglo[i];
        }
    }
    public static void selectionSort(int [] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            int min = i;
            //busco el elemento (posicion) mas pequeño
            for (int j = i+1; j < arreglo.length; j++) {
                //buscar el mas pequeño
                if (arreglo[min] > arreglo[j]) {
                    min = j;
                }
            }
            //SWAP intercambiar
            if (min != i) {
                int temp = arreglo[i];
                arreglo[i] = arreglo[min];
                arreglo[min] = temp;
            }
        }
    }
    public static void insertionSort(int[] arreglo){
        for (int i = 1; i < arreglo.length; i++) {
            int temp = arreglo[i];
            int insP = i;
            //buscamos en que punto debde de quedar temp
            //esa posicion queda almacenada en insP
            for (int prev = i-1; prev >=0; prev--) {
                if (arreglo[prev]>temp) {
                    //swap
                    arreglo [insP] = arreglo[prev];
                    insP--;
                }else{
                    break;
                }
            }
            arreglo[insP] = temp;
        }
    }
    
    //BUSQUEDA BINARIA
    public static int busquedaBinaria(int [] datos, int valor){
        return busquedaBinRec(datos,0,datos.length-1,valor);
    }
    
    private static int busquedaBinRec(int[] datos, int ini, int fin, int valor){
        int mid;
        mid = ini + ((fin-ini)/2);
        int resu = -1;
        if(ini < fin){ //aqui hacemos la busqueda binaria recursiva
            if (valor == datos[mid]) { //lo encontramos
                resu = mid; //posicion donde esta el elemento que buscamos
            }else if (valor < datos[mid]) { //menos que la mitad, está a la izq
                resu = busquedaBinRec(datos,0,mid-1,valor);
            }else{ //mayor a la mitad, esta a la derecha
                resu = busquedaBinRec(datos,mid+1,fin,valor);
            }
        }
        return resu;
        
    }
}
