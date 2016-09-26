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
public class Newton {
    public static double xn, dxn ,xant, e, erro;
    public static int n;
    
    public static void calcularRaiz(double x0, double erro){
        Newton.xn = x0;
        Newton.xant = 0;
        Newton.erro = erro;
        do{
            Newton.dxn = Newton.derivadaDaFuncao(Newton.xn);
            Newton.e = Newton.calcularErro(Newton.xn, Newton.xant);
            Newton.mostrarResultados();
            Newton.xant = Newton.xn;
            Newton.xn = Newton.calcularXn(Newton.xn);
            
            Newton.n++;
        }while(Newton.e > Newton.erro);
        
    }
    
    public static double funcao(double x){
        return (Math.pow(x, 2) / 2.0) + x * (Math.log(x) - 1);
    }
    
    public static double derivadaDaFuncao(double x){
        return Math.log(x) + x;
    }
    
    public static double segundaDerivadaDaFuncao(double x){
        return (1/x) + 1;
    }
    
    public static void mostrarFuncao(double x){
        System.out.println("f(" + x + "): " + Newton.funcao(x));
    }
    
    public static void mostrarSinalDaMultiplicacaoDaFuncaoPelaSegundaDerivada(double x){
        System.out.println("f(" + x + ") * f''(" + x + "): " + Newton.funcao(x) * Newton.segundaDerivadaDaFuncao(x));
    }
     
    public static void mostrarDerivada(double x){
        System.out.println("f(" + x + "): " + Newton.derivadaDaFuncao(x));
    }
    
    private static  double calcularXn(double x){
        return x - (Newton.funcao(x)/Newton.derivadaDaFuncao(x));
    }
    
     private static double calcularErro(double xn, double xant) {
        return Math.abs(xn - xant);
    }
    
    private static void mostrarResultados() {
        System.out.println("\n");
        System.out.println("n: " + Newton.n);
        System.out.println("xn: " + Newton.xn);
        System.out.println("xant: " + Newton.xant);
        System.out.println("f(xn): " + Newton.funcao(Newton.xn));
        System.out.println("f'(xn): " + Newton.dxn);
        System.out.println("e: " + Newton.e);
    }
    
   
}
