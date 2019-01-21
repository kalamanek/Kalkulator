package kalkulator;
import java.util.Scanner;

import equationType.EquationType; 

public class Kalkulator {
	
	
	public double add(double number1 , double number2){	
		return number1 + number2;
	}
	public double minus(double number1 , double number2){	
		return number1 - number2;
	}
	public double multiple(double number1 , double number2){	
		return number1 * number2;
	}
	public double divide(double number1 , double number2){	
		if(number2 == 0)
			throw new IllegalArgumentException();
		else
			return number1 / number2;
	}

	public void execute() {
		Scanner scanner = new Scanner(System.in);
		String text;
		
		do{
			System.out.println("Write a line in format: [number] [+, -, /, *] [number]");
			
			text = scanner.nextLine().replaceAll("\\s", "");
		
		}while ( ! isEquationTypeOperate(text) );

		scanner.close();
	
	}
	public boolean isEquationTypeOperate(String text) {
		
		EquationType eT = textEquationStruct(text) ;
		
		if(eT.operationAmount == 1 && eT.charOperationPosition != 0 && text.length() >= 3 && eT.charOperationPosition != text.length()){
			
			String[] numbers = { text.substring(0,eT.charOperationPosition) ,
					text.substring(eT.charOperationPosition + 1 , text.length()) };
			
			double n1 , n2 ;

			try  
			  {  
			    n1 = Double.parseDouble(numbers[0]);
			    n2 = Double.parseDouble(numbers[1]);  
			  }  
			  catch(IllegalArgumentException nfe)  
			  {  
				  throw nfe;
			  }  

			System.out.println("result is: " + doMath(n1 , eT.operationType , n2));
			
			return true;
			
		}else if(eT.operationAmount > 1)
			System.out.println("too many equation\n");
		else
			System.out.println("there is no correct equation\n");
		
		return false;
	}
	
	private double doMath(double n1 , char eq , double n2 ){
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
	

	
	/*	create new EquationType 
	amount - amount of operators (*,+,-,/)
	position - last position of operation
	equation - type of last equation
	*/
	public EquationType textEquationStruct(String text) {
		int amount = 0;
		int position = 0;
		char equation = ' ';
		for(int i = 0 ; i < text.length() ; i++)
			if(text.charAt(i) == '*' || text.charAt(i) == '-' || text.charAt(i) == '+'  || text.charAt(i) == '/' ){
				amount++;
				position = i;
				equation = text.charAt(i);
			}
		
		return new EquationType(amount ,position , equation );
	}
	


}
