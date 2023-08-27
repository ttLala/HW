package org.example.hw9;
import java.lang.reflect.Array;
import  java.util.Arrays;

import static java.sql.JDBCType.NULL;

public class MyArrayList<K> {
    private K[] mass = null;
    public MyArrayList() {
    }
    public MyArrayList(K[] mass){
        this.mass = mass;
    }


    public void add(K element){
        if(mass == null){
            mass = (K[]) Array.newInstance(element.getClass(), 0);
        }
        K[] newMass  = Arrays.copyOf(mass, mass.length + 1);
        newMass[mass.length] = element;
        mass = newMass;
    }

    public void remove(int index){
        K[] newMass = Arrays.copyOf(mass, mass.length - 1);
        int j = 0;
        for (int i = 0; i < mass.length; i++){
            if(i != index){
                newMass[j] = mass[i];
                j++;
            }
        }
        mass = newMass;
    }

    public void clear(){
        mass = null;
    }

    public int size(){
        if (mass != null){
            return mass.length;
        }else {
            return 0;
        }
    }

    public K get(int index)
    {
        try {
            return mass[index];
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
