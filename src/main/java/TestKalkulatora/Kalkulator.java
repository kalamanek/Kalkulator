package TestKalkulatora;
import java.util.Scanner; 

public class Kalkulator {
	//container for first - amount of + - * /  second is position , and third is equation type
	
	public static class equationType{
		public 
		int first;
		int second;
		char third;
		equationType(int first , int second , char third){
			this.first = first;
			this.second = second;
			this.third = third;
		};
	}
	
	public static double add(double number1 , double number2){	
		return number1 + number2;
	}
	public static double minus(double number1 , double number2){	
		return number1 - number2;
	}
	public static double multiple(double number1 , double number2){	
		return number1 * number2;
	}
	public static double divide(double number1 , double number2){	
		if(number2 == 0)
			throw new IllegalArgumentException();
		else
			return number1 / number2;
	}

	private static void Execute() {
		Scanner scanner = new Scanner(System.in);
		String text;
		equationType eT;
		do{
			System.out.println("Write a line in format: [number] [+, -, /, *] [number]");
			
			text = scanner.nextLine().replaceAll("\\s", "");
			eT = textEquationStruct(text);
			
			if(eT.first == 1 || eT.second != 0 ||text.length() >= 3 || eT.second != text.length()){
				String[] numbers = new String[2];
				numbers[0] = text.substring(0,eT.second);
				numbers[1] = text.substring(eT.second + 1,text.length());
				double n1 , n2 ;

				try  
				  {  
				    n1 = Double.parseDouble(numbers[0]);
				    n2 = Double.parseDouble(numbers[1]);  
				  }  
				  catch(IllegalArgumentException nfe)  
				  {  
					  throw new IllegalArgumentException();
				  }  

				System.out.println("result is: " + doMath(n1 , eT.third , n2));
				scanner.close();
				
			}else if(eT.first > 1)
				System.out.println("too many equation\n");
			else
				System.out.println("there is no correct equation\n");
			

		}while(eT.first != 1);
	
	}
	public static double doMath(double n1 , char eq , double n2 ){
		switch(eq){
			case '+':
			return add(n1,n2);
			
			case '-':
			return minus(n1,n2);
			
			case '*':
			return multiple(n1,n2);	
			
			case '/':
			return divide(n1,n2);
			
			default:
			throw new IllegalArgumentException();
		}
	}
	

	//calculate amount of + - / * symbols and return position of last and type
	
	public static equationType textEquationStruct(String text) {
		int amount = 0;
		int position =0;
		char equation = ' ';
		for(int i = 0 ; i < text.length() ; i++)
			if(text.charAt(i) == '*' || text.charAt(i) == '-' || text.charAt(i) == '+'  || text.charAt(i) == '/' ){
				amount++;
				position = i;
				equation = text.charAt(i);
			}
		
		return new equationType(amount ,position , equation );
	}
	
	
	public static void main(String[] args) {
        Execute();
	}

}
