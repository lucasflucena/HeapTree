package com.company.lucasflucena;

public class Main {

    public static void main(String[] args) {
        FilaBanco fila = new FilaBanco();
        fila.insert("Fulano", 20);
        fila.insert("Sicrano", 23);
        fila.insert("Beltrano", 45);
        fila.insert("Vovó", 65);
        fila.insert("Tio", 48);
        fila.insert(new Pessoa("Primo", 18));

        while (fila.getSize() > 0) {
            Pessoa p = fila.peek();
            System.out.println("Atendendo " + p.getNome());
            fila.remove();
        }

        /*fila.changeAge("Tio", 67);
        while (fila.getSize() > 0) {
            Pessoa p = fila.peek();
            System.out.println("Atendendo " + p.getNome());
            fila.remove();
        }*/
    }
}
