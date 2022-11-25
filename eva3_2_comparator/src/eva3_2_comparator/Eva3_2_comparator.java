/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_2_comparator;

import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author moviles
 */
public class Eva3_2_comparator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //LISTA
        LinkedList<Integer> miLista = new <Integer> LinkedList();
        miLista.add((int)(Math.random()*100));
        miLista.add((int)(Math.random()*100));
        miLista.add((int)(Math.random()*100));
        miLista.add((int)(Math.random()*100));
        miLista.add((int)(Math.random()*100));
        miLista.add((int)(Math.random()*100));
        miLista.add((int)(Math.random()*100));
        miLista.add((int)(Math.random()*100));
        System.out.println(miLista);
        //ordenar ---> comparator
        //comparator es una interfaz
        Comparator ordenar = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                Integer val1 = (Integer)o1;
                Integer val2 = (Integer)o2;
                return val1-val2;
            }
        };
        
        miLista.sort(ordenar);
        System.out.println("ORDENADA:");
        System.out.println(miLista);
        
        LinkedList <Persona> listaPersonas = new <Persona>LinkedList();
        listaPersonas.add(new Persona("Juan","Chavez","Martinez",30,500));
        listaPersonas.add(new Persona("Hailey","Bieber","Monge",23,1000));
        listaPersonas.add(new Persona("Kevin","Barragan","Chavez",20,200));
        listaPersonas.add(new Persona("Jose","Renteria","Alvarez",50,300));
        listaPersonas.add(new Persona("Paulina","Villegas","Treviño",19,600));
        listaPersonas.add(new Persona("Jesus","Jacquez","Loona",28,400));
        
        for (int Iterator<Persona> iterator) {
            
        }
        
        
        
        
        Comparator aMaterno = new Comparator() {
            
            @Override
            public int compare(Object o1, Object o2) {
                String val1 = o1.toString();
                String val2 = o2.toString();
                return val1.compareTo(val2);
            }
        };
        listaPersonas.sort(aMaterno);
        System.out.println(listaPersonas);
    }
    
    
}
class Persona{
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;
    private double salario;
    
    

    public Persona(String nombre, String paterno, String materno, int edad, double salario) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
        this.salario = salario;
    }
    
    
}
