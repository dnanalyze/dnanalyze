package CS386;
import java.util.Scanner;  // Import the Scanner class

public class DNAInput
{
    public static void main( String[] args )
    {
        String str = getDNAString();
        
        Boolean val = validateDNAString( str );

    }

    private static String getDNAString()
    {
        Scanner input = new Scanner( System.in );  // Create a Scanner object
        System.out.println("Enter string: ");
    
        String DNAString = input.nextLine();  // Read user input
        System.out.println( "DNA sequence is: " + DNAString );  // Output user input
        
        return DNAString;
    }

    private static Boolean validateDNAString( String DNAString )
    {
        
        if( DNAString.matches( "([aAcCgGtT])+" ) )
        {
            System.out.println( "String is valid" );
            return true;
        }
        
        System.out.println( "String is not valid" );
        return false;
    }

}