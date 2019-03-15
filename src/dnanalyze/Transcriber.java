package dnanalyze;

import java.util.ArrayList;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Transcriber
{
    private String dnaString;

    /**
     * Constructor
     *
     * @param dnaString
     *            A string of the DNA that needs to be transcribed
     */
    public Transcriber(String dnaString)
    {
        this.dnaString = dnaString.toUpperCase();
    }

    /**
     * Transcribes the DNA
     *
     * @return The class' DNA string transcribed
     */
    public String Transcribe()
    {
        return Transcribe(dnaString);
    }

    /**
     * Transcribes the DNA
     *
     * @param dnaString
     *            A string of the DNA that needs to be transcribed
     * @return The transcribed DNA
     */
    public static String Transcribe(String dnaString)
    {
        String rnaString;
        ArrayList<String> codingSegments;

        final int numberOfAsToAddToCap = 100;

        // Step 1: Replace the T nucleotides with U
        rnaString = replaceChar(dnaString, 'T', 'U');


        // Step 2: Invert the DNA String usinng String Builder to reverse string
        StringBuilder rnaStringInvert = new StringBuilder();
        rnaStringInvert.append(rnaString);
        rnaStringInvert=rnaStringInvert.reverse();
        rnaString =rnaStringInvert.toString();

        // Step 3: Add 1 G nucleotide to the beginning and many A's to the end
        rnaString = "G" + rnaString+ repeatString("A", numberOfAsToAddToCap);

        // TODO
        // Step 4: Noncoding Introns are removed (ONLY OCCURS IN EUKARYOTIC CELLS - NOT NEEDED FOR MVP)
        codingSegments = new ArrayList<>();

        // Step 5: The remaining coding segments are joined together
        rnaString = ArrayLstToString(codingSegments);

        // Step 6: The mRNA can leave
        return rnaString;
    }

    /**
     * Replaces all occurrences of one char with another in the string
     *
     * @param workingString
     *            The string to replace the char in
     * @param toReplace
     *            The char in the string to replace
     * @param toReplaceWith
     *            The char to replace it with
     * @return The string with replaced char
     */
    private static String replaceChar(String workingString, char toReplace,
            char toReplaceWith)
    {
        return workingString.replace(toReplace, toReplaceWith);
    }

    /**
     * Takes an arraylist of strings and makes them into 1 string
     *
     * @param toCombine
     *            the arraylist that needs to be combined
     * @return the combined string
     */
    private static String ArrayLstToString(ArrayList<String> toCombine)
    {
        String combinedString;

        combinedString = "";
        for (String segment : toCombine)
        {
            combinedString = combinedString + segment;
        }
        return combinedString;
    }

    /**
     * Repeats a string multiple times
     *
     * @param toRepeat
     *            The string to repeat
     * @param timesToRepeat
     *            The number of times to repeat the string
     * @return The repeated string
     */
    private static String repeatString(String toRepeat, int timesToRepeat)
    {
        int count;
        String repeated = "";

        for (count = 0; count < timesToRepeat; count++)
        {
            repeated += toRepeat;
        }
        return toRepeat;
    }

}
