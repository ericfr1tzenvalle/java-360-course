/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ericfr1tzenvalle.java.course.javaOO;

/**
 *
 * @author Luísa
 */
public class ModificadorStatic {
    public static void main(String[] args) {
        //Fala sobre static e como eles são compartilhados entre os irmaos da 
        //Mesma classe, fala sobre metodos static
        //fala sobre metodos static so pode manusear atributos staticos
        //fala sobre blocos static para inicializar 
        //fala sobre exemplos de elementos static na api do java
        //fala sobre declaracoes de constantes e boas praticas em java
        
        //Exercicio 1:
        Number n1 = new Number(10);
        System.out.println("" + n1.getNumber());
        System.out.println(""+Number.objetosCriados);
        Number n2 = new Number(20);
        System.out.println(""+Number.objetosCriados);
        Number n3 = Number.add(n2, n1);
        System.out.println(""+Number.objetosCriados); // ou pelo get


        
    }
    
    private static class Number{
        private int number;
        private static int objetosCriados;
        static{
            objetosCriados = 0;
        }
        private Number(int number){ // Antes era public para o exercicio 1 agora private
            this.number = number;
            objetosCriados++;
        }
        public void incrementa(){
            number++;
        }
        public int getNumber(){
            return number;
        }
        public static Number add(Number x, Number y){
            return new Number(x.getNumber() + y.getNumber());
        }
        public int getObjetosCriados(){
            return objetosCriados;
        }
        //A classe cria o objeto.
        public static Number newNumber(int n){
            return new Number(n);
        }
        
    }
    
}
