/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dnanalyze.Transcriber;

/**
 * @author daniel
 */
class TranscriberTest
{

    String dnaString = "";
    Transcriber transcriber = new Transcriber(dnaString);

    @Test
    void testEukCell()
    {
        String result = Transcriber.Transcribe("AAGATGCCGT", true);
        assertFalse(hasChar(result, 'U'));
        assertTrue("AAGAUGCCGU".equals(result));
    }

    @Test
    void testNonEukCell()
    {
        String result = Transcriber.Transcribe("AAGATGCCGT", true);
        assertFalse(hasChar(result, 'U'));
        assertTrue("AAGAUGCCGU".equals(result));
    }

    private boolean hasChar(String s, char c)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == c)
            {
                return true;
            }
        }
        return false;
    }

}
