package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Dna {
    private StringBuffer dna;

    public Dna(String dna) {
        this.dna = new StringBuffer(dna.toUpperCase());

    }

    public String getDna() {
        return dna.toString();
    }

    public void setDna(String dna) {
        this.dna = new StringBuffer(dna);
    }

    public String getFirstGene() {
        int startIndex = this.dna.indexOf("ATG");
        int endIndex = this.dna.indexOf("TAA", startIndex);

        return (startIndex == -1 || endIndex == -1) ? "No Gene" : (this.dna.substring(startIndex, endIndex + 3).length() % 3 == 0) ? this.dna.substring(startIndex, endIndex + 3) : "No Gene";
    }


    public Boolean twoOccurrences(String stringA, String stringB) {
        int occ = 0;
        System.out.println(stringB);

        while (stringB.length() > 0) {
            if (stringB.indexOf(stringA) != -1) {
                occ++;
                stringB = stringB.substring(stringB.indexOf(stringA) + stringA.length());
                System.out.println(occ);
                System.out.println(stringB);
            } else {
                break;
            }

        }
        return (occ > 1);
    }

    public String lastPart(String stringA, String stringB) {
        if (stringB.indexOf(stringA) != -1) {
            stringB = stringB.substring(stringB.indexOf(stringA) + stringA.length());
        }
        return stringB;
    }



    //fonctionne très bien
    public int countCTG(String dna) {
        int count = 0;
        int start = dna.indexOf("CTG", 0);
        while (start != -1) {
            count++;
            start = dna.indexOf("CTG", start + 3);

        }
        return count;
    }

    //fonctionne très bien
    public int minimum (int a , int b ){
        if(a == -1 && b==-1) return -1 ;
        if(a == -1 && b!=-1) return b ;
        if(a != -1 && b==-1) return a ;
        return Math.min(a , b);
    }
    //fonctionne très bien
    public double cgRapport(String dna , char a , char b) {


        if (dna.indexOf(a, 0) == -1 && dna.indexOf(b, 0) == -1) return 0.0;
        int start = minimum(dna.indexOf(a, 0), dna.indexOf(b, 0));
        System.out.println(start);
        int count = 0;
        while (start!= -1) {
            count++;
            start = minimum(dna.indexOf(a, start + 1), dna.indexOf(b, start + 1));
            System.out.println(start);
        }
        return (double) count / dna.length();
        // JJJCTGOOOOOOOOOOOOCTGKAKAKAKAKAKCTGGGGGCTGGCGCTGCTCGCTCGCTCGCTCGCTCGCTCGCTCGCTCCGCTCGCGCTCGCTCGCT
        // 0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456
    }
    //fonctionne très bien
    public ArrayList<String> findListGene(String dna) {
        ArrayList<String> list = new ArrayList<String>();
        String gene = findGene(dna, 0);
        int start = 0;
        while (gene.length() != 0) {
            list.add(gene);
            start = dna.indexOf(gene, start) + gene.length();
            gene = findGene(dna, start);
        }
        return list;
    }
    //fonctionne très bien
    public String findGene(String dna, int wehre) {
        int startIndex = dna.indexOf("ATG", wehre);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = 0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }

        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    //fonctionne très bien
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
        }
        return -1;
    }
    //fonctionne très bien
    @Override
    public String toString() {
        return "DNA = '" + dna + '\'';
    }

    public ArrayList<Integer> listOfLengthGene (ArrayList<String> list){
        ArrayList<Integer> listLengths = list.stream().map(String::length).collect(Collectors.toCollection(ArrayList::new));
        return listLengths ;
    }

    public int maxLength (ArrayList<Integer> list){
        return Collections.max(list);
    }

    public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1 || index >= input.length() - 1) {
                break;
            }
            String found = input.substring(index + 1, index + 4);
            System.out.println(index);
            System.out.println(found);
            index = input.indexOf("abc", index + 4);
            System.out.println(index);
        }
    }
}
