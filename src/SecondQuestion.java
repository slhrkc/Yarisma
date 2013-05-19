import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class SecondQuestion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			Scanner in = new Scanner(new FileReader("metin.txt"));

			// Clear duplicate white spaces
			String temp = new Scanner(new File("metin.txt"), "UTF-8")
					.useDelimiter("\\A").next();

			temp = temp.replaceAll("\\s+", " ");
			System.out.println(temp);
			
			
			temp = removeDuplicate(temp);
			System.out.println(temp);
			
			
			temp = capitalLetter(temp);
			System.out.println(temp);
			
			temp = singleLetter(temp);
			System.out.println(temp);
			
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("cikti.txt"));
			out.write(temp.getBytes());
			out.close();
			
			


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String removeDuplicate(String s) {
		StringBuilder temp = new StringBuilder(s);
		char x;
		char y;
		for (int i = 1; i < temp.length(); i++) {
			x = Character.toLowerCase(temp.charAt(i));
			y = Character.toLowerCase(temp.charAt(i-1));

			if(x==y){
				temp.deleteCharAt(i);
				i--;
				
			}
		}
		return temp.toString();

	}
	
	public static String capitalLetter(String s){
		StringBuilder temp = new StringBuilder(s);
		char x;
		
		for(int i = 0;i<temp.length();i++){
			x = Character.toLowerCase(temp.charAt(i));
			temp.replace(i, i+1, Character.toString(x));
		}
		
		for(int i = 2;i<temp.length();i++){
			if(temp.charAt(i-2) == '.'){
				x = Character.toUpperCase(temp.charAt(i));
				temp.replace(i, i+1, Character.toString(x));
			}
		}
		
		
		
		
		
		x =Character.toUpperCase(temp.charAt(0));
		temp.replace(0, 1, Character.toString(x));
		return temp.toString();

		
	}
	
	public static String singleLetter(String s){
		StringBuilder temp = new StringBuilder(s);
		char x;
		
		for(int i = 2;i<temp.length();i++){
			if((temp.charAt(i-1) == ' ' || temp.charAt(i-1)== '.') && (temp.charAt(i+1) == ' ' || temp.charAt(i+1) == '.')){
				x = temp.charAt(i);
				temp.replace(i-1, i+1, Character.toString(x));
				
			}
		}
		
		return temp.toString();

	}

}
