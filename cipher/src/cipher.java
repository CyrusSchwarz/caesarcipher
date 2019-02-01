//Do whatever you want with this. I made this as a proof of concept and so people can see how this would work. All I ask is you keep the line below unchanged. 
//Originally made by Cyrus @technophyte.com. Had some help from my friend Bit regarding the deciphering bit. That was a bit difficult. (Unintentional pun) 


import java.util.*;
public class cipher 
{

	public static void main (String[]args)
	{
		
		Scanner scan = new Scanner(System.in);
		
		//Initializes variables 
		String eod,pte,ptd,ptds,ciphertext, deciphertext, pts;
		int key;
		char ch;
		ciphertext = "";
		deciphertext = "";
		
	
		
		//Asks the user if they would like to encode or decode and goes to the appropriate loop
		System.out.println("Would you like to encode or decode?");
		eod = scan.nextLine();
		//This is the loop for encoding
		if (eod.equalsIgnoreCase("encode"))
		{
			//Asks for the phrase to encode.
			System.out.println("What phrase would you like to encode? (No spaces!)");
			pts = scan.nextLine();
			pte = pts.replace(" ", "");
			//Asks for the key (shift) size. If the key is larger than 25 or lower than 1, it will show an error and close. 
			System.out.println("What is the key you want to use? (1-25)");
			key = scan.nextInt();
			if (key > 25 || key < 1)
			{
				System.out.println("Invalid key - Try again");
				System.exit(0);
			}
			
			//This is what actually does the encoding
			if (key < 25 || key > 1)
			{
				
				int len = pte.length(); //the integer length is given the value of the message
				for(int x = 0; x < len; x++) //the loop repeats for the length of the message
				{ 
				    char c = (char)(pte.charAt(x) + key); //this adds the key value to each letter
				    if (c > 'z')
				        ciphertext += (char)(pte.charAt(x) - (26-key)); //if the character value is bigger than z the value is key minus 26
				    else
				        ciphertext += (char)(pte.charAt(x) + key); //if the character value is less than Z it is added normally
				}
				System.out.println(pte+" encoded with a key (Shift) of "+ key +" is " + ciphertext);
                 System.exit(0); 

			}
		}
	
		//This is the loop for decoding
		if (eod.equalsIgnoreCase("decode"))
		{
			System.out.println("Enter the phrase to decode");
			ptd = scan.nextLine();
			ptds = ptd.replace(" ", ""); //this bit removes the spaces from the phrase. The current encryption/decryption method doesn't play too nicely with spaces.
			for(key = 1; key < 26; key++) //The loop repeats 25 times so the program can run through all the possible keys
			{ 
				for(char c : ptds.toCharArray()) 
				{
			    int c_test = (char)(Character.toLowerCase(c) - key); // This changes all the characters to lowercase. Uppercase ascii values are different than lowercase ones. 
			    if (c_test < 'a') {//Flips the order the characters are manipulated
			        ciphertext += (char)('z' + (c_test - 'a')); // calculates the offset from the test value to 'a' (always negative) and adds it to 'z'
                } else
			        ciphertext += (char)(c - key); //if the character value is less than Z it is added normally
				}
			    System.out.format("%02d -> %s\n", key, ciphertext);
                /*  - java's standard method for printing formatted text -
                    %02d = integer (key) that takes up at least two spaces
                    %s   = string substitution (ciphertext)
                    \n   = newline char
                */
			    ciphertext = "";
			}
		}
        else 
        {
            System.out.println("Invalid Answer - Try again");
            System.exit(0); 
        }
	}
}