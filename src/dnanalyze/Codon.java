package dnanalyze;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for storing information for Codons used in Translation Class
 */
public class Codon {

    // Stores the value of the original codon sequence for later use
    private String codon;
    // Stores the matching amino acid
    private String aminoAcid;
    // Table containing the possible codon - amino acid pairings
    private Map<String,String> dnaTable;

    /**
     * Constructor for Codon class
     *
     * @param sequence String representation of Codon sequence
     */
    public Codon ( String sequence ) {
        if ( sequence.length() == 3 ) {
            codon = sequence;
            aminoAcid = "";
            initializeDnaMap();
            aminoAcid = findAminoAcid();
       	}
    }

    /**
     * Initializes the DNA map to allow for the degenerative matching of codons to amino acids
     */
    private void initializeDnaMap() {
        dnaTable = new HashMap<String, String>();

        // Initializes the DNA Map
        dnaTable.put("AUG","Methionine");
        dnaTable.put("UAA","Stop");
        dnaTable.put("UAG","Stop");
        dnaTable.put("UGA","Stop");
        dnaTable.put("UUU","Phenylalanine");
        dnaTable.put("UUC","Phenylalanine");
        dnaTable.put("UUA","Leucine");
        dnaTable.put("UUG","Leucine");
        dnaTable.put("UCU","Serine");
        dnaTable.put("UCC","Serine");
        dnaTable.put("UCA","Serine");
        dnaTable.put("UCG","Serine");
        dnaTable.put("UAU","Tyrosine");
        dnaTable.put("UAC","Tyrosine");
        dnaTable.put("UGU","Cysteine");
        dnaTable.put("UGC","Cysteine");
        dnaTable.put("UGG","Tryptophan");
        dnaTable.put("CUU","Leucine");
        dnaTable.put("CUC","Leucine");
        dnaTable.put("CUA","Leucine");
        dnaTable.put("CUG","Leucine");
        dnaTable.put("CCU","Proline");
        dnaTable.put("CCC","Proline");
        dnaTable.put("CCA","Proline");
        dnaTable.put("CCG","Proline");
        dnaTable.put("CAU","Histidine");
        dnaTable.put("CAC","Histidine");
        dnaTable.put("CAA","Glutamine");
        dnaTable.put("CAG","Glutamine");
        dnaTable.put("CGU","Arginine");
        dnaTable.put("CGC","Arginine");
        dnaTable.put("CGA","Arginine");
        dnaTable.put("CGG","Arginine");
        dnaTable.put("AUU","Isoleucine");
        dnaTable.put("AUC","Isoleucine");
        dnaTable.put("AUA","Isoleucine");
        dnaTable.put("ACU","Threonine");
        dnaTable.put("ACC","Threonine");
        dnaTable.put("ACA","Threonine");
        dnaTable.put("ACG","Threonine");
        dnaTable.put("AAU","Asparagine");
        dnaTable.put("AAC","Asparagine");
        dnaTable.put("AAA","Lysine");
        dnaTable.put("AAG","Lysine");
        dnaTable.put("AGU","Serine");
        dnaTable.put("AGC","Serine");
        dnaTable.put("AGA","Arginine");
        dnaTable.put("AGG","Arginine");
        dnaTable.put("GUU","Valine");
        dnaTable.put("GUC","Valine");
        dnaTable.put("GUA","Valine");
        dnaTable.put("GUG","Valine");
        dnaTable.put("GCU","Alanine");
        dnaTable.put("GCC","Alanine");
        dnaTable.put("GCA","Alanine");
        dnaTable.put("GCG","Alanine");
        dnaTable.put("GAU","Aspartic Acid");
        dnaTable.put("GAC","Aspartic Acid");
        dnaTable.put("GAA","Glutamic Acid");
        dnaTable.put("GAG","Glutamic Acid");
        dnaTable.put("GGU","Glycine");
        dnaTable.put("GGC","Glycine");
        dnaTable.put("GGA","Glycine");
        dnaTable.put("GGG","Glycine");
    }

    /**
     * Matches the Codon to its respective amino acid
     *
     * @return String representation of amino acid
     */
    public String findAminoAcid() {
        
        if ( dnaTable.containsKey(codon) )
        {
            aminoAcid = dnaTable.get(codon);
        }
        return aminoAcid;
    }

    /**
     * Gets the amino acid
     *
     * @return String representation of the amino acid
     */
    public String getAminoAcid()
    {
        return aminoAcid;
    }
	
	@Override
    /**
     * Overrides toString method for resulting amino acid
     */
    public String toString() { 
        return aminoAcid; 
    }
}
