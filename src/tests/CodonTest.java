package tests;

import dnanalyze.Codon;
import org.junit.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CodonTest {

    @Test
    public void codonSequenceLengthShouldBeThree () {
        //Test Class
        Codon testCodon = new Codon("AUG");

        //assert statements
        assertEquals( testCodon.getCodon().length(), 3, "Codons should be no more than three characters long" );
    }

    @Test
    public void codonSequenceAndAminoAcidShouldMatch () {
        //Test Class
        Codon testCodon1 = new Codon("AUG");
        Codon testCodon2 = new Codon("UAU");
        Codon testCodon3 = new Codon("CUG");

        //assert statements
        assertTrue( testCodon1.findAminoAcid().equals("Methionine") );
        assertTrue( testCodon1.findAminoAcid().equals("Tyrosine") );
        assertTrue( testCodon1.findAminoAcid().equals("Leucine") );
    }
}
