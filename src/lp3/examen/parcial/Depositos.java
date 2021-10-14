/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lp3.examen.parcial;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Depositos extends Thread{
    
    Cuenta cuenta;
    JTable tabla;
    JTextField text;
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    @Override
    public void run(){
        /* Fecha */
        Calendar calendar=new GregorianCalendar();
        /* Lista de filas para añadir a la tabla */
        Object[] ob=new Object[5];
        modelo=(DefaultTableModel)tabla.getModel();
        /* Darle formato de 2 decimales al monto*/
        DecimalFormat df=new DecimalFormat("#.##");
        String es = "REALIZADO";
        for (int i = 0; i < 5; i++) {
            /* Hora local */
            LocalDateTime locaDate = LocalDateTime.now();
            /* Creamos las filas para añadir a la tabla */
            ob[0]="DEPOSITO";
            double a =(double) (Math.random() * 11000);
            ob[1]= df.format(a);
            ob[2]= ""+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)
                    +" "+ locaDate.getHour() +":"+ locaDate.getMinute()+":"+ locaDate.getSecond();
            ob[3]= es;
            /*Añadimos el monto random a la cuenta*/
            cuenta.añadirmonto(a);
            /*Añadimos las filas a la tabla*/
            modelo.addRow(ob);
            text.setText(String.valueOf(df.format(cuenta.sueldo)));
            try {
                
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException ex) {
                
            }
            /*Pasamos el modelo a la tabla */
            tabla.setModel(modelo);
            /*Autoscroll de la tabla */
            tabla.scrollRectToVisible(tabla.getCellRect(tabla.getRowCount()-1, tabla.getColumnCount(), true));
        }
    }

    public Depositos(Cuenta cuenta, JTable tabla, JTextField text) {
        this.cuenta = cuenta;
        this.tabla = tabla;
        this.text = text;
    }
    
    
    
    public Cuenta getCuenta() {
        return cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JTextField getText() {
        return text;
    }

    public void setText(JTextField text) {
        this.text = text;
    }
    
}
