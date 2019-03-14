package dnanalyze;

import java.util.ArrayList;

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
        int aCount;
        ArrayList<String> codingSegments;

        final int numberOfAsToAddToCap = 100;

        // Step 1: Replace the T nucleotides with U
        rnaString = replaceChar(dnaString, 'T', 'U');

        // Step 2:

        // Step 3: Add 1 G nucleotides to the beginning and many A's to the end
        rnaString = "G" + rnaString;
        for (aCount = 0; aCount < numberOfAsToAddToCap; aCount++)
        {
            rnaString = rnaString + "A";
        }

        // TODO
        // Step 4: Noncoding Introns are removed
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
     * @return
     */
    private static String replaceChar(String workingString, char toReplace,
            char toReplaceWith)
    {
        return workingString.replace(toReplace, toReplaceWith);
    }

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

}
