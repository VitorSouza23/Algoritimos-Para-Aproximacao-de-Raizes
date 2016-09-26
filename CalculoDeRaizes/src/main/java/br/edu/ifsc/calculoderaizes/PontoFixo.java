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
public class PontoFixo {
    public static double xn, fi, xant, e, erro;
    public static int n;
    
    public static void calcularRaiz(double x0, double erro){
        PontoFixo.xn = x0;
        PontoFixo.xant = -1;
        PontoFixo.erro = erro;
        do{
            PontoFixo.fi = PontoFixo.funcaoEquivalente(PontoFixo.xn);
            if(PontoFixo.xant < 0){
                PontoFixo.e = Double.MAX_VALUE;
                PontoFixo.xant = 0;
            }else{
                PontoFixo.e = PontoFixo.calcularErro(PontoFixo.xn, PontoFixo.xant);
            }
            
            PontoFixo.mostrarResultados();
            PontoFixo.xant = PontoFixo.xn;
            PontoFixo.xn = PontoFixo.fi;
            
            PontoFixo.n++;
        }while(PontoFixo.e > PontoFixo.erro);
        
    }
    public static double funcao(double x){
        return Math.pow(x, 3) - x - 1;
    }
    
    public static double funcaoEquivalente(double x){
        return (Math.pow(x, 3.0) + 1.0)/3.0;
    } 
    
     private static double calcularErro(double xn, double xant) {
        return Math.abs(xn - xant);
    }
     
    public static double derivadaDaFuncaoequivalente(double x){
        return -(1/Math.pow(x, 2)) - (2/Math.pow(x, 3));
    }
    
    public static double segundaDerivadaDaFuncaoequivalente(double x){
        return (2/Math.pow(x, 3)) + (6/Math.pow(x, 4));
    }
    
    public static void mostrarSinalDaMultiplicacaoDaFuncaoPelaSegundaDerivada(double x){
        System.out.println("O(" + x + ") * O''(" + x + "): " + PontoFixo.funcaoEquivalente(x) * PontoFixo.segundaDerivadaDaFuncaoequivalente(x));
    }
     
    public static void mostrarFuncaoEquivalente(double x){
        System.out.println("O(" + x + "): " + PontoFixo.funcaoEquivalente(x));
    }
    
     public static void mostrarFuncao(double x){
        System.out.println("f(" + x + "): " + PontoFixo.funcao(x));
    }
    
    public static void mostrarDerivadaEqivalente(double x){
        System.out.println("O'(" + x + "): " + PontoFixo.derivadaDaFuncaoequivalente(x));
    }
    
    private static void mostrarResultados() {
        System.out.println("\n");
        System.out.println("n: " + PontoFixo.n);
        System.out.println("xn: " + PontoFixo.xn);
        System.out.println("xant: " + PontoFixo.xant);
        System.out.println("O(xn): " + PontoFixo.fi);
        System.out.println("e: " + PontoFixo.e);
    }
    
    
}
