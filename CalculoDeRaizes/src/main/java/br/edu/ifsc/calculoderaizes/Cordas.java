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
public class Cordas {
    public static double c, xn, xant, e, erro;
    public static int n;
    
    public static void calcularRaiz(double c, double xn, double erro){
        Cordas.c = c;
        Cordas.xn = xn;
        Cordas.erro = erro;
        Cordas.n = 0;
        do{
            if(n == 0){
                xant = Cordas.xn;
                e = xant;
                
                System.out.println("\n");
                System.out.println("n: " + Cordas.n);
                System.out.println("xn: " + Cordas.xn);
                System.out.println("xant: " + Cordas.xant);
                System.out.println("f(xn): " + Cordas.funcao(Cordas.xn));
                System.out.println("e: " + Cordas.e);
                
            }else{
                Cordas.xant = Cordas.xn;
                Cordas.xn = Cordas.calcularXn(Cordas.xn, Cordas.xant, Cordas.c);
                System.out.println("\n");
                System.out.println("n: " + Cordas.n);
                System.out.println("xn: " + Cordas.xn);
                System.out.println("xant: " + Cordas.xant);
                System.out.println("f(xn): " + Cordas.funcao(Cordas.xn));
                e = Cordas.calcularErro(Cordas.xn, Cordas.xant);
                System.out.println("e: " + Cordas.e);
                
            }
            n++;
        }while(e > erro);
    }
    
    private static  double funcao(double x){
        return Math.pow(Math.E, x) - Math.tan(x);
    }
    
    private static  double calcularXn(double xn, double xant, double c){
        return xn - ((funcao(xn) * (xn - c))/(funcao(xn) - funcao(c)));
    }
    
     private static  double calcularErro(double xn, double xant){
        return Math.abs(xn - xant);
    }
     
    public static double derivadaDaFuncao(double x){
        return Math.pow(Math.E, x) - Math.pow((1/Math.cos(x)), 2);
    }
    
    public static double segundaDerivadaDaFuncao(double x){
        return Math.pow(Math.E, x) - Math.pow((1/Math.cos(x)), 2) * Math.tan(x);
    }
    
    public static void mostrarDerivadaFuncao(double x) {
        System.out.println("f'(" + x + "): " + Cordas.derivadaDaFuncao(x));
    }
    
    public static void mostrarSegundaDerivadaDaFuncao(double x){
        System.out.println("f''(" + x + "): " + Cordas.segundaDerivadaDaFuncao(x));
    }
    
     public static void mostrarSinalDaMultiplicacaoDaFuncaoPelaSegundaDerivada(double x){
        System.out.println("f(" + x + ") * f''(" + x + "): " + Cordas.funcao(x) * Cordas.segundaDerivadaDaFuncao(x));
    }
}
