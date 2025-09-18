/*
 * Demonstração de Herança em Java
 * Curso Java 360 - Herança, subclasses, @Override, construtores e visibilidade
 *
 * Aborda:
 * - Motivação da herança: reutilização e extensão de código
 * - Como estender classes com `extends`
 * - Subclasses podem reutilizar, sobrescrever ou adicionar comportamentos
 * - Uso da anotação @Override
 * - Construtores em herança e chamada a `super`
 * - Visibilidade protected: permite acesso em subclasses, mas quebra encapsulamento
 * - Classe Object: toda classe em Java herda implicitamente de Object
 * - Uso de final: impedir herança ou sobrescrita de métodos
 */
package com.ericfr1tzenvalle.java.course.javaOO;

public class Heranca {
    public static void main(String[] args) {
        //Exericio
        EarthPet dog = new Dog("Marrom");
        dog.falar();
        dog.walk();
        System.out.println(dog.printCor());

        EarthPet cat = new Cat("Branco");
        cat.falar();
        cat.walk();
        System.out.println(cat.printCor());
        cat.setCor("Azul");
        System.out.println(cat.printCor());

        WaterPet fish = new Fish("Laranja");
        fish.nadar();
        System.out.println(fish.printCor());
    }

    // Classe base (superclasse)
    private static class Pet {
        private String cor;

        public Pet(String cor) {
            this.cor = cor;
        }

        public void setCor(String cor) {
            this.cor = cor;
        }

        public String printCor() {
            return "Sua cor é: " + cor;
        }
    }

    // Subclasse abstrata: animais terrestres (preferi utilizar classe abstrata)
    private abstract static class EarthPet extends Pet {
        public EarthPet(String cor) {
            super(cor);
        }

        public abstract void falar();
        public abstract void walk();
    }

    // Subclasse abstrata: animais aquáticos
    private abstract static class WaterPet extends Pet {
        public WaterPet(String cor) {
            super(cor);
        }
        public abstract void nadar();
    }

    // Subclasse concreta: Cachorro
    private static class Dog extends EarthPet {
        public Dog(String cor) {
            super(cor);
        }

        @Override
        public void falar() {
            System.out.println("Au au");
        }

        @Override
        public void walk() {
            System.out.println("Cachorro está andando");
        }
    }

    // Subclasse concreta: Gato
    private static class Cat extends EarthPet {
        public Cat(String cor) {
            super(cor);
        }

        @Override
        public void falar() {
            System.out.println("Miau");
        }

        @Override
        public void walk() {
            System.out.println("Gato está andando");
        }
    }

    // Subclasse concreta: Peixe
    private static class Fish extends WaterPet {
        public Fish(String cor) {
            super(cor);
        }

        @Override
        public void nadar() {
            System.out.println("Peixe está nadando");
        }
    }
}

/*
 * Resumo do que foi abordado:
 *
 * - Herança permite criar uma hierarquia de classes, evitando duplicação
 *   de código e facilitando a manutenção.
 *
 * - O uso de classes abstratas (EarthPet, WaterPet) obriga subclasses a
 *   implementar métodos específicos (falar, walk, nadar).
 *
 * - A anotação @Override garante que um método sobrescreve corretamente
 *   um da superclasse, evitando erros de digitação.
 *
 * - Construtores de subclasses chamam `super()` para inicializar a parte
 *   herdada (no caso, a cor do Pet).
 *
 * - Visibilidade protected: permite que atributos e métodos sejam visíveis
 *   para subclasses, mas pode expor detalhes internos — deve ser usado
 *   com cautela.
 *
 * - Toda classe herda implicitamente de Object, mesmo que não seja declarado.
 *
 * - Modificador final:
 *   - final em classe → não pode ser herdada.
 *   - final em método → não pode ser sobrescrito.
 *   - final em atributo → vira constante após inicialização.
 */
