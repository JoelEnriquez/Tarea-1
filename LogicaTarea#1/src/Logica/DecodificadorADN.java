package Logica;

/**
 *
 * @author joel
 */
public class DecodificadorADN {

    private String cadena1;
    private String cadena2;
    private String cadenaRepetida;
    private int tamañoRepetida;
    private int pivotC1;
    private int pivotC2;
    //private int pivotCadena1;

    public DecodificadorADN(String cadena1, String cadena2) {
        this.cadena1 = cadena1;
        this.cadena2 = cadena2;
        tamañoRepetida = 0;
        cadenaRepetida = "";
    }

    public String ejecutarDecodificador() {
        for (int i = 0; i < cadena2.length() - 1; i++) { //Las veces que se ejecutara en base a la cadena 2
            String auxCadena = "";
            pivotC1 = 0;
            pivotC2 = i;
            
            while (cadena1.length()>pivotC1 && cadena2.length()>pivotC2) {
                if (hayRepeticion(cadena1.substring(pivotC1, pivotC1 + 1), cadena2.substring(pivotC2, pivotC2 + 1))) {                 
                    tamañoRepetida++;
                    if (tamañoRepetida >= 2) {
                        auxCadena = cadena2.substring(i, pivotC2 + 1); //Extraer los caracteres repetidos hasta el momento
                        if (auxCadena.length() > cadenaRepetida.length()) {
                            cadenaRepetida = auxCadena;
                        }
                    }
                    pivotC1++;
                    pivotC2++;
                } else {
                    pivotC1++;
                    pivotC2 = i;
                    tamañoRepetida = 0;
                }
            }
        }

        if (cadenaRepetida.equals("")) {
            return "No hay cadenas repetidas";
        } else {
            return cadenaRepetida;
        }
    }

    private boolean hayRepeticion(String c1, String c2) {
        return c1.equalsIgnoreCase(c2);
    }

}
