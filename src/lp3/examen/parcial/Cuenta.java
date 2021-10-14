/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lp3.examen.parcial;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Cuenta {
    double sueldo;

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    void añadirmonto(double n){
        sueldo = sueldo + n; 
    }
    void retirarmonto(double n){
        sueldo = sueldo - n;
    }
}
