package org.example;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dna dna = new Dna("ATGXXXYYYZZZTAA");
        ArrayList<String> list = dna.findListGene(dna.getDna());
        int count = (int) list.stream().filter(i -> i.length() > 60).count();
        System.out.println(count);

        System.out.println("CTG = " +dna.countCTG(dna.getDna()));
        System.out.println("CG rapport = " +dna.cgRapport(dna.getDna() ,'C' , 'G'));
        System.out.println(list.size());
        System.out.println(dna.listOfLengthGene(list));
        System.out.println("MAX = "+dna.maxLength(dna.listOfLengthGene(list)));





    }
}