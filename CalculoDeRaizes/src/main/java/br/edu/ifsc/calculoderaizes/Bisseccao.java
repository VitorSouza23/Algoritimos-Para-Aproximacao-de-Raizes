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
public class Bisseccao {

    public static double a, b, xn, e, erro, fafnx;
    public static int n;

    public static void calcularRaiz(double a, double b, double erro) {
        Bisseccao.a = a;
        Bisseccao.b = b;
        Bisseccao.erro = erro;
        Bisseccao.n = 0;
        do {

            Bisseccao.xn = Bisseccao.calcularXn(Bisseccao.a, Bisseccao.b);
            Bisseccao.fafnx = Bisseccao.funcao(Bisseccao.a) * Bisseccao.funcao(Bisseccao.xn);
            Bisseccao.e = Bisseccao.calcularErro(Bisseccao.a, Bisseccao.b);
            Bisseccao.mostrarResultados();
            if (Bisseccao.fafnx > 0) {
                Bisseccao.a = Bisseccao.xn;
            } else {
                Bisseccao.b = Bisseccao.xn;
            }
            Bisseccao.n++;
        } while (Bisseccao.e > Bisseccao.erro);

    }

    public static double funcao(double x) {
        return Math.pow(Math.E, x) - Math.tan(x);
    }
    
    public static double derivadaFuncao(double x) {
        return Math.pow(Math.E, x) - Math.pow((1/Math.cos(x)), 2);
    }
    
    public static void mostrarFuncao(double x) {
        System.out.println("f(" + x + "): " + Bisseccao.funcao(x));
    }
    
    public static void mostrarDerivadaFuncao(double x) {
        System.out.println("f'(" + x + "): " + Bisseccao.derivadaFuncao(x));
    }

    private static double calcularErro(double a, double b) {
        return Math.abs((b - a) / 2);
    }

    private static double calcularXn(double a, double b) {
        return (a + b) / 2;
    }

    private static void mostrarResultados() {
        System.out.println("\n");
        System.out.println("n: " + Bisseccao.n);
        System.out.println("a: " + Bisseccao.a);
        System.out.println("b: " + Bisseccao.b);
        System.out.println("xn: " + Bisseccao.xn);
        System.out.println("f(xn):" + Bisseccao.funcao(Bisseccao.xn));
        System.out.println("f(a):" + Bisseccao.funcao(Bisseccao.a));
        System.out.println("f(a)*f(xn): " + Bisseccao.fafnx);
        System.out.println("e: " + Bisseccao.e);
    }
}
