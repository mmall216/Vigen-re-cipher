import java.io.IOException;
import java.util.*;

public class Main {
		public static void main (String [] args) throws IOException{
			
			String plainText= null;
			String cipherText= null;
			Scanner userInput= new Scanner (System.in);
			int choice = 0;
			
			Encryption userEncryption = new Encryption();
			System.out.println("Please Enter Your Name: ");
			plainText = userInput.next();
			System.out.println("Hello " + plainText + " Welcome to the Program");
			
			do {
				System.out.println(" ");
				System.out.println("Please Choose From The Following Options: ");
				System.out.println("1 - Alice's View");
				System.out.println("2 - Bob's View");
				System.out.println("3 - Eve's View");
				System.out.println("4 - Exit The Program");
				choice = userInput.nextInt();
			
				switch(choice) {
					case 1:
						System.out.println(" ");
						System.out.println("Alice's View: ");
						System.out.println(" ");
						System.out.println("Here You Will Be Able To Encrypt Any PlainText. ");
						System.out.println("Enter The Following PlainText You Would Like To Encrypt: ");
						plainText = userInput.next();
						System.out.println(userEncryption.runEncryption(plainText));
						break;
						
					case 2:
						System.out.println(" ");
						System.out.println("Bob's View");
						System.out.println("Here You Will Be Able To Decrypt Any CipherText. ");
						System.out.println("Enter The Following CipherText You Would Like To Decrypt: ");
						cipherText = userInput.next();
						System.out.println(userEncryption.runDecryption(cipherText));
						break;
					
					case 3:
						System.out.println(" ");
						System.out.println("Eve's View");
						userEncryption.runEve();
						break;
					
					case 4:
						System.out.println("Thank You... Exiting Program");
						userInput.close();
						break;
						
					default:
						System.out.println("Invalid Choice Entered!");
				}
					
			} while (choice !=4);	
			
			
			
			
			
	}
}
