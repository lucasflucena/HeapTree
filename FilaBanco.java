package com.company.lucasflucena;
import java.util.Arrays;

public class FilaBanco {
    private static Pessoa[] pessoas;
    private static int size;//quantos elementos tem
    private static int capacity;//quantos elementos cabem

    public FilaBanco() {
        this(10);
    }

    public FilaBanco(int capacity) {
        pessoas = new Pessoa[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void insert(String nome, int idade) {
        insert(new Pessoa(nome, idade));
    }

    public void insert(Pessoa pessoa) {
        ensureCapacity();
        pessoas[getSize()] = pessoa;
        heapifyUp(getSize());
        size++;
    }

    private static void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex < 0) {
            return;
        }

        Pessoa pai    = pessoas[parentIndex];
        Pessoa pessoa = pessoas[index];

        if (pessoa.getIdade() > pai.getIdade()) {
            pessoas[index]   = pai;
            pessoas[parentIndex] = pessoa;
            heapifyUp(parentIndex);
        }
    }

    public static int getParentIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    private void ensureCapacity() {
        if (size == capacity) {
            pessoas = Arrays.copyOf(pessoas, capacity * 2);
            capacity = capacity * 2;
        }
    }

    public static int getSize() {
        return size;
    }

    public Pessoa peek() {
        if (getSize() == 0) {
            return null;
        }
        return pessoas[0];
    }

    public void remove() {
        for(int i = 0; i < getSize(); i++){
            pessoas[i] = pessoas[i+1];
        }
        size--;
    }

    public static void priorityChange(Pessoa pessoa)
    {
        int index = -1;
        String name = pessoa.getNome();
        for (int i = 0; i < FilaBanco.getSize(); i++) {
            if(FilaBanco.pessoas[i].getNome() == name)
            {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Não existe nenhuma pessoa com esse nome na fila!");
        }
        else
        {
            heapifyUp(index);
        }

    }

}

