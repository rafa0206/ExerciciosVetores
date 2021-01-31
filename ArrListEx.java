/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arrlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JFernandes
 */
public class ArrListEx {
    
    //AULA 22/10/20
    //recebe um ArrayList<Integer> xs e devolve a soma dos elementos que fazem parte de xs
    public static int sum(ArrayList<Integer> xs) {
        int acc = 0;
        for (int x : xs){
            acc += x;
        }
        return acc;
        
    }
        
    //recebe um ArrayList<Integer> xs e um int y e devolve o número de ocorrências de y em xs
    public static int count(ArrayList<Integer> xs, int y) {
        int contagem = 0;
        for (int x : xs){
            if(x == y){
            ++contagem;
        }        
    }
        return contagem;    
    }
    
    //recebe uma String numbers que contem ints e devolve um ArrayList<Integer>
    //cujos os elementos são os ints de numbers na mesma ordem em que ocorrem em numbers.
    public static ArrayList<Integer> listOf(String numbers) {
        Scanner scanner = new Scanner(numbers);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            int x = scanner.nextInt();
            list.add(x);
        }
        scanner.close();
        return list;
    }

    /*
    public static void main(String[] args) {
        ArrayList<Integer> xs = listOf("5 7 2 8 9 12 12 5 3 14 -9 12 19 0 -1");
        System.out.println(xs);
        System.out.println(sum(xs));
        
        // 
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> xs = new ArrayList<>();
        for (int i = 0;i < 10; ++i){
            System.out.print("Entre com um numero: ");
            int x = in.nextInt();
            xs.add(x);
        }
        System.out.println(xs);
        //  
    
    }*/
    
    //AULA 29/10/20
    
    //Exercicio 01
    public static ArrayList<Integer> divisores(int n) {
        ArrayList<Integer>divs = new ArrayList<>();
        for(int d = 1; d <= n; ++d){
            if(n % d == 0){
                divs.add(d);
            }
        }
        return divs;
    }
    
    //Exercicio 02
    public static ArrayList<Integer> fatoresPrimos(int n) {
        ArrayList<Integer> fPrimos = new ArrayList<>();
        int d = 2;
        while(n > 1) {
            if(n % d == 0){
                if(!fPrimos.contains(d)){
                    fPrimos.add(d);
                }
                n /= d; //n = n/d; 
            }else {++d; }
        }
        return fPrimos;
    }
    
    //Exercicio 02 com HashSet
    
    public static HashSet<Integer> fatPrimos(int n) {
        HashSet<Integer>fPrimos = new HashSet<>();
        int d = 2;
        while (n > 1){
            if (n % 1 == 0){
                fPrimos.add(d);
                n/= d;
            }else {++d;}
        }
        return fPrimos;
    }
    
    //Exercicio 03
    public static boolean ordenada(ArrayList<Integer> v){
        for(int i = 0; i < v.size() - 1; ++i){
            if(v.get(i) > v.get(i+1)) return false;
        }
        return true;
    }
    
    //Exercicio 04
    public static ArrayList<Integer> filtraPares(ArrayList<Integer> v){
        ArrayList<Integer> pares = new ArrayList <> ();
        for (int e: v){
            if (e % 2 == 0){
                pares.add(e);
            }
        }
        return pares;
    }
        
    //Exrercicio 05
    public static int comprimentoMaior(ArrayList<String> v){
        if(v == null || v.isEmpty()) throw new IllegalArgumentException();
        String maior = v.get(0);
        for(String s: v){
            if(s.length() > maior.length()){
                maior = s;
            }
        }
        return maior.length();
    }
    
    //Exrercicio 06
    public static String stringMaior(ArrayList<String> v){
        if(v == null || v.isEmpty()) throw new IllegalArgumentException();
        String maior = v.get(0);
        for(String s: v){
            if(s.length() > maior.length()){
                maior = s;
            }
        }
        return maior;       
    }
    
    //Exercicio 07
    public static boolean  estaContido(ArrayList<Integer> v, ArrayList<Integer> w){
        for(int e: v){
            if(!w.contains(e)) return false;
        }
        return true;              
    }
        
    public static boolean saoIguais(ArrayList<Integer> v, ArrayList<Integer> w){
        return estaContido(v, w) && estaContido(w, v);
    }
    
    //Exercicio 08
    
    public static ArrayList<Integer> eliminaRepeticoes (ArrayList<Integer> v){
        ArrayList<Integer> semRep = new ArrayList<>();
        for (int e : v){
            if (!semRep.contains(e)){
                semRep.add(e);
            }
        }
        return semRep;
    }
           
    //Exercicio 09 - a)
    
    public static int ocorrencias(int e, ArrayList<Integer> v){
        int contador = 0;
        for(int x : v){
            if(e == x) ++contador;
        }
        return contador;
    }
        
    public static ArrayList<Integer>multiplicidades(ArrayList<Integer> v){
        ArrayList<Integer> m = new ArrayList<>();
        for(int e : v){
            m.add(ocorrencias(e, v));
        }
        return m;
    }
    
    //Exercicio 09 - b)
    
    public static ArrayList<Integer>filtraMultiplicidade(ArrayList<Integer> v, int k){
        ArrayList<Integer>elmtDeMultk = new ArrayList <>();
        ArrayList<Integer>mults = multiplicidades(v);
        for(int i = 0; i < mults.size(); ++i){
            if(mults.get(i) == k && !elmtDeMultk.contains(v.get(i))){
            elmtDeMultk.add(v.get(i));
            }
            /*//mesa coisa, porem mais trabalhoso
            if(mults.get(i) == k){
                if(!elmtDeMultk.contains(v.get(i))){
                    elmtDeMultk.add(v.get(i));
                }
            }    
            */            
        }
        return elmtDeMultk;
    }
            
    //Exercicio 09 - b) outra maneira
    
    public static ArrayList<Integer>filtraPorMultiplicidade(ArrayList<Integer> v, int k){
        ArrayList<Integer>elmtDeMultk = new ArrayList<>();
        for(int e: v){
            if(ocorrencias(e, v) == k && !elmtDeMultk.contains(e)){
                elmtDeMultk.add(e);
            }
        }
        return elmtDeMultk;
    }
            
    public static void main(String[] args) {
        System.out.println(divisores(6));
        System.out.println(fatoresPrimos(60));
        ArrayList<String> list = new ArrayList<>(List.of("aaa", "bbbb", "eeeee", "rrr"));
        System.out.println(comprimentoMaior(list));
        
        ArrayList<Integer> v = new ArrayList<>(List.of(1, 4, 5, 2, 6, 2, 5));
        ArrayList<Integer> w = new ArrayList<>(List.of(4, 1, 4, 5, 2, 6, 6, 2, 5, 5));
        System.out.println(saoIguais(v, w));
        System.out.println(eliminaRepeticoes(w));
        System.out.println(w);
        System.out.println(multiplicidades(w));
        System.out.println(filtraMultiplicidade(w, 2));
    }    
}

