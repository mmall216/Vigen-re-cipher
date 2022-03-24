import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Scanner;
public class Encryption {

	char alphabet []= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	String key = "COOKIES";
	String manualKey;
	int choice;
	int letterPosition;
	
	
	Scanner userInput = new Scanner(System.in);
	
	public Encryption(){
	}
	
	public String runEncryption (String plainText) {
		do {
			System.out.println(" ");
			System.out.println("Please Choose From The Following Options: ");
			System.out.println("1 - Encrypt Using Manual Encryption");
			System.out.println("2 - Encrypt Using Preloaded Key");
			int choice = userInput.nextInt();
		
			switch(choice) {
				case 1:
					System.out.println(" ");
					System.out.println("Enter The Manual Key You Would Like To Use For Encryption.");
					System.out.println("Please Do Not Use Spaces");
					manualKey = userInput.next().toLowerCase();
					key = manualKey.toUpperCase();
			
					String cipherText = ("");
					plainText = plainText.toUpperCase();
			        
					
					for (int i = 0, m = 0 ; i < plainText.length(); i++){
						
			            char character = plainText.charAt(i);
			           
			            if (character < 'A' || character > 'Z')
			                continue;
			            cipherText += (char) ((character + key.charAt(m) - 2 * 'A') % 26 + 'A');
			            m = ++m % key.length();
			        }
			        return cipherText;
					
				case 2:
					System.out.println("Encrypting the Following Text: ");
					System.out.println(plainText);
					System.out.println("Encrypted Message: ");
					
					String cipherTexts = ("");
					plainText = plainText.toUpperCase();
			        
					
					for (int i = 0, m = 0 ; i < plainText.length(); i++){
						
			            char character = plainText.charAt(i);
			           
			            if (character < 'A' || character > 'Z')
			                continue;
			            cipherTexts += (char) ((character + key.charAt(m) - 2 * 'A') % 26 + 'A');
			            m = ++m % key.length();
			        }
			        return cipherTexts;
			        
				default:
					System.out.println("Invalid Choice Entered!");
			}
				
		} while (choice !=3);
		return " ";	
	}
	
	public String runDecryption (String cipherText) {
		
		System.out.println("Decrypting The Following Text: ");
		System.out.println(cipherText);
		System.out.println("Decryption: ");
		
		String plainText = ("");
		cipherText = cipherText.toUpperCase();
		
		
        for (int i = 0, m = 0; i < cipherText.length(); i++){
            
        	char character = cipherText.charAt(i);
            
        	if (character < 'A' || character > 'Z')
                continue;
            plainText += (char) ((character - key.charAt(m) + 26) % 26 + 'A');
            m = ++ m % key.length();
        }
        	return plainText;
	}

	
	public void runEve() throws IOException {
			
		File myFile = new File ("corpus.txt");
		Scanner file = new Scanner (myFile);
		
		String stringofFile = "";
		
		while (file.hasNext()){
			stringofFile = stringofFile + file.nextLine();
		}
		
		String finalString = stringofFile.replaceAll("[^a-zA-Z]","").toUpperCase();
		
//this is just to trouble shoot program not important to code.		
		System.out.println(finalString);
		String encryptedfinalString = encrypt(finalString);
		System.out.println(encryptedfinalString);

//Here we are getting the Occurrences of the CipherText that Eve has access to. We will also find the frequencies here.
		encryptedfinalString.toCharArray();
		double letterFrequency[] = new double[26];
		double totalofLetter = 0;
		double size = encryptedfinalString.length();
		boolean foundChar = false;
			
			for (int i=0;i<size;i++) {
				for (int j=0; j<alphabet.length;j++) {
					if (!(encryptedfinalString.charAt(i) == alphabet [j])) {
						foundChar = false;
					} 
					else {
						foundChar = true;
						letterFrequency [j] = letterFrequency [j]+1;
						totalofLetter++;
					}
				}
			}
			System.out.println(" ");
			System.out.println("Total Letters Counted: " + totalofLetter);
			System.out.println(" ");
//Printing Occurrences	
			System.out.println("Letter Occurrences for Cipher Text: ");
			for (int i=0; i < letterFrequency.length;i++) {
				System.out.println(alphabet[i] + " = " + letterFrequency[i]);	
			
			}
//Printing Frequencies			
			System.out.println(" ");
			System.out.println("Letter Frequencies of CipherText: ");
			for (int i=0; i < letterFrequency.length;i++) {
				letterFrequency[i] = letterFrequency[i]/totalofLetter;
				System.out.println(alphabet[i] + " = " + letterFrequency[i]);	
			
			}
	
			
//Here we use this to get the Occurrences of the plainText and the frequencies. This is not something Eve Will Have Access to. 
//This is for purposes to show Eve cannot decrypt using Frequency Analysis.
			finalString.toCharArray();
			double letterFrequency1[] = new double[26];
			double totalofLetter1 = 0;
			double size1 = encryptedfinalString.length();
			boolean foundChar1 = false;
			
			for (int i1=0;i1<size;i1++) {
				for (int j1=0; j1<alphabet.length;j1++) {
					if (!(finalString.charAt(i1) == alphabet [j1])) {
						foundChar = false;
					} 
					else {
						foundChar = true;
						letterFrequency1 [j1] = letterFrequency1 [j1]+1;
						totalofLetter1++;
					}
				}
			}
			System.out.println(" ");
			System.out.println("Total Letters Counted: " + totalofLetter1);
			System.out.println(" ");
//Printing Occurrences	
			System.out.println("Letter Occurrences For PlainText (EVE CANNOT ACCESS THIS): ");
			for (int i=0; i < letterFrequency1.length;i++) {
				System.out.println(alphabet[i] + " = " + letterFrequency1[i]);	
			}
//Printing Frequencies		
			System.out.println(" ");
			System.out.println("Letter Frequencies of PlainText (NOT WHAT YOU CAN SEE IN EVE'S VIEW): ");
	
			for (int i=0; i < letterFrequency1.length;i++) {
				letterFrequency1[i] = letterFrequency1[i]/totalofLetter;
				System.out.println(alphabet[i] + " = " + letterFrequency1[i]);	
			
			}
	
			
			
			
			
			
			
	}

	public String encrypt (String plainText) {
		String cipherText = ("");
		plainText = plainText.toUpperCase();
		
		for (int i = 0, m = 0 ; i < plainText.length(); i++){
			
            char character = plainText.charAt(i);
           
            if (character < 'A' || character > 'Z')
                continue;
            cipherText += (char) ((character + key.charAt(m) - 2 * 'A') % 26 + 'A');
            m = ++m % key.length();
        }
        return cipherText;
	}

	
			

	
	
	
	
}
