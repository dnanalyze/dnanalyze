package dnanalyze;

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
    public String Transcribe(String dnaString)
    {
        dnaString = replaceChar(dnaString, 'T', 'U');

        return dnaString;
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
    private String replaceChar(String workingString, char toReplace,
            char toReplaceWith)
    {
        return null;
    }
}
