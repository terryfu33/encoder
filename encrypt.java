import java.util.Scanner;  

public class encrypt{

	
	
	//returns location of letter
    public static int getPlace(char l){

        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int counter = 0;
        for(char c: alpha.toCharArray()){
            if( c == l){
                return counter;
            }
            counter ++;
        }   
        return 0;

    }
    public static char getLetter(int n) {
    	String alpha = "abcdefghijklmnopqrstuvwxyz";
        
        return alpha.charAt(n);
          
    }
    public static int getPlaceCode(char l){

        String alpha = "encrypt";
        int counter = 0;
        for(char c: alpha.toCharArray()){
            if( c == l){
                return counter;
            }
            counter ++;
        }   
        return 0;

    }
    
    //get new code in length of the original code
    public static String getNewCode(String code) {
    	
    	String newCode = "";
    	String data = "encrypt";
    	int counter = 0;
    	for(int i= 0;i<code.length();i++) {
    		
    		if(counter == 7) {
    			counter = 0;
    		}
    		newCode += data.charAt(counter);
    		counter++;
    		
    	}
    	return newCode;
    	
    }
    
    public static String code(String c, String nc, String[][] coder) {
    	
    	String newCode = "";
    	int cn;
    	int ncn;
    	for(int i =0;i< c.length();i++) {
    		
    		char current = c.charAt(i);
    		cn = getPlace(current);
    		current = nc.charAt(i);
    		ncn = getPlaceCode(current);
    		newCode += coder[cn][ncn];
    		
    	}
    	
    	return newCode;
    }
    
    public static String deCode(String c, String nc, String[][] coder) {
    	
    	String newCode = "";
    	int cn;
    	int ncn;
    	for(int i =0;i< c.length();i++) {
    		
    		char ccurrent = c.charAt(i);
    		char current = nc.charAt(i);
    		ncn = getPlaceCode(current);
    		
    		for(int j = 0;j< 25;j++) {
    			
    			if(Character.toString(ccurrent).equals(coder[j][ncn])) {
    				
    				newCode += getLetter(j);
    				break;
    			}
    		}
    	}
    	
    	return newCode;
    	
    }
    public static void main(String[] args0){
    	
    	String [][] coder = new String[][]{
    		  { "z", "1", "a", "q", "y", "d", "u"},
    		  { "y", "2", "b", "1", "z", "e", "v"},
    		  { "x", "3", "c", "r", "a", "f", "w"},
    		  { "w", "4", "d", "2", "b", "g", "x"},
    		  { "v", "5", "e", "s", "c", "h", "y"},
    		  { "u", "6", "f", "3", "d", "i", "z"},
    		  { "t", "7", "g", "t", "e", "j", "1"},
    		  { "s", "8", "h", "4", "f", "k", "2"},
    		  { "r", "9", "i", "u", "g", "1", "3"},
    		  { "q", "0", "j", "v", "h", "2", "4"},
    		  { "p", "a", "k", "5", "i", "3", "5"},
    		  { "o", "b", "l", "w", "j", "4", "6"},
    		  { "n", "c", "m", "6", "k", "5", "7"},
    		  { "m", "d", "n", "x", "l", "6", "8"},
    		  { "l", "e", "o", "7", "m", "8", "9"},
    		  { "k", "f", "p", "y", "n", "9", "a"},
    		  { "j", "g", "q", "8", "o", "l", "b"},
    		  { "i", "h", "r", "z", "p", "m", "c"},
    		  { "h", "i", "s", "9", "q", "n", "d"},
    		  { "g", "j", "t", "a", "r", "o", "e"},
    		  { "f", "k", "u", "0", "s", "p", "f"},
    		  { "e", "l", "v", "b", "t", "q", "g"},
    		  { "d", "m", "w", "c", "u", "r", "h"},
    		  { "c", "n", "x", "d", "v", "s", "i"},
    		  { "b", "o", "y", "e", "w", "t", "j"},
    		  { "a", "p", "z", "f", "x", "u", "k"},
    	
    	};
    	Scanner myObj = new Scanner(System.in);
    	System.out.println("enter e(encode) or d(decode)");
    	String choice = myObj.nextLine(); 
    	
    	if(choice.equals("e")) {
    		System.out.println("enter word(no capitals, spaces or number) to encode");
    		String c = myObj.nextLine(); 
            String nc = getNewCode(c);
            
            
            System.out.println(code(c,nc,coder));
    		
    	}
    	else {
    		System.out.println("enter word(no capitals, spaces or number) to decode");
    		String c = myObj.nextLine(); 
            String nc = getNewCode(c);
            
            
            System.out.println(deCode(c,nc,coder));
    	}
    	
        
    }





}