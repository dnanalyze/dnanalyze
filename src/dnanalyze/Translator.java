/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.ArrayList;

public class Translator {
    private String RNA_sequence;
    private String[] stop_codons = new String[]{"UAA", "UAG", "UGA"};
    private String start_codon = "AUG";
    private int total_codons;
    List<Codon> aminoAcidSequence;

    Translator(String RNA) {
        RNA = RNA.toUpperCase();
        RNA_sequence = RNA;
        aminoAcidSequence = new ArrayList<>();
    }

    private int findStart() {
        if (RNA_sequence.contains(start_codon)) {
            {
                return RNA_sequence.indexOf(start_codon);
            }
        }
        return -1;
    }

    private Boolean isStopCodon(String codon) {
        if (codon.equals(stop_codons[0]) || codon.equals(stop_codons[1])
                || codon.equals(stop_codons[2])) {
            return true;
        }

        return false;
    }

    private void terminateSequence() {

    }

    private void buildSequence(int start_index) {
        String[] codon_array = findCodons(start_index);
        int index;

        for (index = 0; index < total_codons; index++) {
            Codon new_codon = new Codon(codon_array[index]);
            aminoAcidSequence.add(new_codon);
        }


    }

    private String[] findCodons(int start_index) {
        int working_index = start_index;
        int length = RNA_sequence.length() - start_index;
        int num_codons = length / 3;
        int codons_found = 0;
        Boolean found_end = false;
        String[] codon_array = new String[num_codons];

        while (!found_end && codons_found < num_codons) {
            String codon = "";
            int count;

            for (count = 0; count <= 2; count++) {
                codon += RNA_sequence.charAt(working_index);
                working_index++;
            }

            if (isStopCodon(codon)) {
                found_end = true;
            } else {
                codon_array[codons_found] = codon;
                codons_found++;
            }

        }
        total_codons = codons_found;
        return codon_array;
    }

    public void translateSequence() {
        int index;

        index = findStart();
        if (index >= 0) {
            buildSequence(index);
        } else {
            System.out.println("start codon not found");
        }

    }

    @Override
    public String toString() {
        String protein_string = "";
        int index;

        for (index = 0; index < aminoAcidSequence.size(); index++) {
            protein_string += aminoAcidSequence.get(index).findAminoAcid();
            if (index < aminoAcidSequence.size() - 1) {
                protein_string += " - ";
            }
        }
        return protein_string;
    }
}