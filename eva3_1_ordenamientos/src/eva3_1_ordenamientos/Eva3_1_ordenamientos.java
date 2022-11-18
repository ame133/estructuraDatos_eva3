/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_ordenamientos;

/**
 *
 * @author moviles
 */
public class Eva3_1_ordenamientos {
    public static void main(String[] args) {
        // TODO code application logic here
        int [] arregloDatos = new int [15];
        int [] arregloSel = new int [arregloDatos.length];
        llenar(arregloDatos);
        imprimir(arregloDatos);
        copiar(arregloDatos,arregloSel);
        System.out.println("");
        System.out.println("ARREGLO COPIA");
        imprimir(arregloSel);
        selectionSort(arregloSel);
        imprimir(arregloSel);
    }
    //llenar arreglo
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
}
