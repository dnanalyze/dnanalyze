/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnanalyze;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Codon {
    
    private String codon; 
    private String aminoAcid;
    private Map<String,String> dnaTable;	
		
    public Codon ( String sequence ) {
        if ( sequence.length() == 3 ) {
            codon = sequence;
            aminoAcid = "";
            initializeDnaMap();
            aminoAcid = findAminoAcid();
       	}
    }
	
    private void initializeDnaMap() {
	dnaTable = new HashMap<String, String>();
		
	// Builds the DNA Map
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
			
    public String findAminoAcid() {
        
        if ( dnaTable.containsKey(codon) )
        {
            aminoAcid = dnaTable.get(codon);
        }
        return aminoAcid;
    }
    
    public String getAminoAcid()
    {
        return aminoAcid;
    }
	
	@Override
    public String toString() { 
        return aminoAcid; 
    }
}
