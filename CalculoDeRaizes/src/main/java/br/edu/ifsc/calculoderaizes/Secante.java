/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.calculoderaizes;

/**
 *
 * @author Aluno
 */
public class Secante {
    public static double xn, auxn ,xant, e, erro;
    public static int n;
    
    public static void calcularRaiz(double x0, double xant, double erro){
        Secante.xn = x0;
        Secante.xant = xant;
        Secante.erro = erro;
        Secante.mostrarFuncao(xant);
        do{
           
            Secante.e = Secante.calcularErro(Secante.xn, Secante.xant);
            Secante.mostrarResultados();
            Secante.auxn = Secante.xn;
            Secante.xn = Secante.calcularXn(Secante.xn, Secante.xant);
            Secante.xant = Secante.auxn;
            
            Secante.n++;
        }while(Secante.e > Secante.erro);
        
    }
    
    public static double funcao(double x){
        return Math.pow(Math.E, x) - Math.tan(x);
    }
    
    public static void mostrarFuncao(double x){
        System.out.println("f(" + x + "): " + Secante.funcao(x));
    }
    
    private static  double calcularXn(double xn, double xant){
        return (((xant * Secante.funcao(xn))-(xn * Secante.funcao(xant)))/(Secante.funcao(xn) - Secante.funcao(xant)));
    }
    
     private static double calcularErro(double xn, double xant) {
        return Math.abs(xn - xant);
    }
    
    private static void mostrarResultados() {
        System.out.println("\n");
        System.out.println("n: " + Secante.n);
        System.out.println("xn: " + Secante.xn);
        System.out.println("xant: " + Secante.xant);
        System.out.println("f(x): " + Secante.funcao(Secante.xn));
        System.out.println("e: " + Secante.e);
    }
}
