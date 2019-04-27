/**
 * class to change RNA into an amino acid sequence
 */

package dnanalyze;

import java.util.ArrayList;
import java.util.List;

public class Translator
{
    private String RNA_sequence;
    private String[] stop_codons = new String[] { "UAA", "UAG", "UGA" };
    private String start_codon = "AUG";
    private int total_codons;
    public List<Codon> aminoAcidSequence;
    
    /**
     * Constructor class
     * @param RNA 
     * the RNA string to be changed into amino acid sequence
     */
    public Translator(String RNA)
    {
        RNA = RNA.toUpperCase();
        RNA_sequence = RNA;
        aminoAcidSequence = new ArrayList<>();
    }
    
    /**
     * function to find the start codon "aug" in the RNA string
     * @return index of the first letter of the start codon
     * or -1 on failure to find start codon
     */
    public int findStart()
    {
        if (RNA_sequence.contains(start_codon))
        {
            {
                return RNA_sequence.indexOf(start_codon);
            }
        }
        return -1;
    }
    
    /**
     * function to find if the current codon is one of the 3 
     * stop codons
     * 
     * @param codon string containing a codon
     * 
     * @return returns ture if the codon is a stop codon false otherwise
     */
    private Boolean isStopCodon(String codon)
    {
        if (codon.equals(stop_codons[0]) || codon.equals(stop_codons[1])
                || codon.equals(stop_codons[2]))
        {
            return true;
        }

        return false;
    }

    /**
     * builds the amino acid list
     * 
     * @param start_index starting index of the RNA string
     */
    private void buildSequence(int start_index)
    {
        String[] codon_array = findCodons(start_index);
        int index;

        for (index = 0; index < total_codons; index++)
        {
            Codon new_codon = new Codon(codon_array[index]);
            aminoAcidSequence.add(new_codon);
        }

    }

    /**
     * separates individual codons from the RNA string
     * 
     * @param start_index index of the first letter of the start codon
     * 
     * @return a string array contaning the individual codons
     */
    private String[] findCodons(int start_index)
    {
        int working_index = start_index;
        int length = RNA_sequence.length() - start_index;
        int num_codons = length / 3;
        int codons_found = 0;
        Boolean found_end = false;
        String[] codon_array = new String[num_codons];

        while (!found_end && codons_found < num_codons)
        {
            String codon = "";
            int count;

            for (count = 0; count <= 2; count++)
            {
                codon += RNA_sequence.charAt(working_index);
                working_index++;
            }

            if (isStopCodon(codon))
            {
                found_end = true;
            }

            else
            {
                codon_array[codons_found] = codon;
                codons_found++;
            }

        }
        total_codons = codons_found;
        return codon_array;
    }

    /**
     * main function called to start the translate process
     */
    public void translateSequence()
    {
        int index;

        index = findStart();
        if (index >= 0)
        {
            buildSequence(index);
        }
        else
        {
            System.out.println("start codon not found");
        }

    }

    /**
     * overridden toString method for formating amino acid sequence
     * for display
     * 
     * @return 
     */
    @Override
    public String toString()
    {
        String protein_string = "";
        int index;

        for (index = 0; index < aminoAcidSequence.size(); index++)
        {
            protein_string += aminoAcidSequence.get(index).findAminoAcid();
            if (index < aminoAcidSequence.size() - 1)
            {
                protein_string += " - ";
            }
        }
        return protein_string;
    }
}
