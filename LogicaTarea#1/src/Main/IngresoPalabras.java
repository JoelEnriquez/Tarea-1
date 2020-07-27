/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Logica.DecodificadorADN;
import java.util.Scanner;

/**
 *
 * @author joel
 */
public class IngresoPalabras {

    private Scanner leer;
    private String cadena1 = "";
    private String cadena2 = "";
    private boolean avanzar = false;

    public IngresoPalabras() {
        leer = new Scanner(System.in);
    }

    public void pedirCadenas() {

        do {
            System.out.println("Ingrese la cadena 1");
            cadena1 = leer.nextLine();
            cadenaPermitida(cadena1); //Comprobar si es permitida la cadena
        } while (!avanzar);

        avanzar = false; //Reiniciar el booleano
        System.out.println("");
        
        do {
            System.out.println("Ingrese la cadena 2");
            cadena2 = leer.nextLine();
            cadenaPermitida(cadena2); //Comprobar si es permitida la cadena
        } while (!avanzar);
        
        DecodificadorADN decodificadorADN = new DecodificadorADN(cadena1, cadena2);
        System.out.println(decodificadorADN.ejecutarDecodificador());
        
        
    }

    public void cadenaPermitida(String cadena){
        if (cadena.length()<2) {
            System.out.println("\nCadena muy corta. Escriba una cadena mas grande");
        }
        else if (contieneEspaciosOSimbolos(cadena)) {
            System.out.println("\nIngrese solo letras");
        }
        else{
            avanzar=true;
        }
    }
    
    /**
     * Sirve para comprobar si hay simbolos, numeros o espacios en blanco y no permitir una cadena asi.
     * @param cadena
     * @return 
     */
    private boolean contieneEspaciosOSimbolos(String cadena){
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isLetter(cadena.charAt(i))) {
                return true;
            }
            else if (cadena.charAt(i)==' ') {
                return true;
            }
        }
        return false;
    }
}
