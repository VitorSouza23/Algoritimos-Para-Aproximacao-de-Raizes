/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.calculoderaizes;

/**
 *
 * @author Vitor
 */
public class PosicaoFalsa {

    public static double a, b, xn, e, erro, fafnx, xant;
    public static int n;

    public static void calcularRaiz(double a, double b, double erro) {
        PosicaoFalsa.a = a;
        PosicaoFalsa.b = b;
        PosicaoFalsa.erro = erro;
        PosicaoFalsa.n = 0;
        PosicaoFalsa.xant = 0;
        do {
            PosicaoFalsa.xn = PosicaoFalsa.calcularXn(PosicaoFalsa.a, PosicaoFalsa.b);
            PosicaoFalsa.fafnx = PosicaoFalsa.funcao(PosicaoFalsa.a) * PosicaoFalsa.funcao(xn);
            PosicaoFalsa.e = PosicaoFalsa.calcularErro(xn, xant);
            PosicaoFalsa.mostrarResultados();
            if(PosicaoFalsa.fafnx > 0){
                PosicaoFalsa.a = PosicaoFalsa.xn;
            }else{
                PosicaoFalsa.b = PosicaoFalsa.xn;
            }
            PosicaoFalsa.xant = PosicaoFalsa.xn;
            PosicaoFalsa.n++;

        } while (PosicaoFalsa.e > PosicaoFalsa.erro);

    }

    private static double funcao(double x) {
        return Math.pow(Math.E, x) - Math.tan(x);

    }

    private static double calcularXn(double a, double b) {
        return (((a * PosicaoFalsa.funcao(b)) - (b * PosicaoFalsa.funcao(a)))/(PosicaoFalsa.funcao(b) - PosicaoFalsa.funcao(a)));
    }
    
    private static double calcularErro(double xn, double xant) {
        return Math.abs(xn - xant);
    }

    private static void mostrarResultados() {
        System.out.println("\n");
        System.out.println("n: " + PosicaoFalsa.n);
        System.out.println("a: " + PosicaoFalsa.a);
        System.out.println("b: " + PosicaoFalsa.b);
        System.out.println("xn: " + PosicaoFalsa.xn);
        System.out.println("xant: " + PosicaoFalsa.xant);
        System.out.println("f(xn): " + PosicaoFalsa.funcao(PosicaoFalsa.xn));
        System.out.println("f(a): " + PosicaoFalsa.funcao(PosicaoFalsa.a));
        System.out.println("f(a)*f(xn): " + PosicaoFalsa.fafnx);
        System.out.println("e: " + PosicaoFalsa.e);
    }
}
