package tests;

import dnanalyze.Codon;
import dnanalyze.Translator;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.testng.Assert.assertEquals;

public class TranslatorTest {

    @Test
    public void findStartReturnsTheCorrectIndexOfTheStartCodon () {
        //Test Classes
        Translator testTranslator1 = new Translator( "AUGUAUCUGUAA" );
        Translator testTranslator2 = new Translator( "UGUCCUUAGGGG" );
        testTranslator1.translateSequence();
        testTranslator2.translateSequence();

        //Assert Statements
        assertEquals( testTranslator1.findStart() , 0 );
        assertEquals( testTranslator1.findStart() , -1 );
    }

    @Test
    public void buildSequenceMakesTheCorrectAminoAcidSequence () {
        //Test Classes
        Translator testTranslator1 = new Translator( "AUGUAUCUGUAA" );
        Translator testTranslator2 = new Translator( "AUGCCUUACGGG" );
        testTranslator1.translateSequence();
        testTranslator2.translateSequence();
        List<Codon> testList1 = testTranslator1.aminoAcidSequence;
        String [] testArr1 = testList1.toArray( new String [testList1.size()]);
        List<Codon> testList2 = testTranslator1.aminoAcidSequence;
        String [] testArr2 = testList2.toArray( new String [testList2.size()]);
        //Dummy Arrays
        String[] dummyArr1 = new String[3];
        dummyArr1[0] = "Methionine";
        dummyArr1[1] = "Tyrosine";
        dummyArr1[2] = "Leucine";

        String[] dummyArr2 = new String[4];
        dummyArr2[0] = "Methionine";
        dummyArr2[1] = "Proline";
        dummyArr2[2] = "Tyrosine";
        dummyArr2[3] = "Glycine";

        //Assert Statements
        assertArrayEquals( testArr1, dummyArr1 );
        assertArrayEquals( testArr2, dummyArr2 );
    }
}
