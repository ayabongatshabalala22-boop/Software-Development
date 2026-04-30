import java.util.Scanner;
import java.util.Locale;

public class BmiCalculator{
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);
		String name;
		String surname;
		char repeat =0;
		
		do{
			System.out.println("Enter your Name: ");
			name=scanner.nextLine();
			System.out.println("Enter your Surname:  ");
				surname=scanner.nextLine();
		int unitChoice = getUnitChoice(scanner);
		
		double weight = (unitChoice==1) ? getValidInput(scanner,"Enter weight in Kilograms(kg)",10,600) :getValidInput(scanner,"Enter weight in Pounds(lbs)",22,1300);
		
		double height =(unitChoice==1) ? getValidInput(scanner,"Enter height in meters(m)",0.5,2.5): getValidInput(scanner,"Enter weight in inches(in)",20,100);
		
		double bmi =calculateBMI(unitChoice,weight,height);
		
		System.out.println("=======================================================================================================================");
		System.out.println("Hey "+ name+ "  " + surname +" Your BMI is:" +bmi);
		if(bmi<18.5){System.out.println("UNDERWEIGHT which is Corncerning: eat foods with alot of fats, proteins and get on the body Scale more often to track your body gain process (+_+) ");}
		else if(bmi>=18.5 && bmi <25){System.out.println("NORMAL WEIGHT  which is Good: Exercise 1-3 times a week  to maintain   ^_^" );}
		else if(bmi>=25 && bmi<30 ){System.out.println ("OVERWEIGHT! which is Corncerning, it might lead to Obessity: Excersice and diet to lose some weight, dont forget to climb the scale! >.<");}
		else if(bmi>=30 && bmi <35){System.out.println("OBESE!! which is too Corncerning :Join Earobix classes and diet to healthy foods to lose weight :o");}
		else { System.out.println("SEVELY OBESE!!! which is EXTREMELY Corncerning: Consult Medical proffetionals");} 
		}while (repeat == 'Y' || repeat == 'y');
		
		System.out.println("======================================================================================================================= ");
		scanner.close();
	
	}
	
	public static int getUnitChoice(Scanner scanner){
		int choice;
		
		while(true){
			System.out.println("Select a preffered unit:\n"
			+ "1.Metric(kg,m)\n"
			+ "2.Imperial(lbs,in)\n"
			+ "Please select preferred unit of measurement.Option1 or Option 2");
			
			if(scanner.hasNextInt()){
				choice=scanner.nextInt();
				if(choice==1||choice==2){
					break;
				}else{System.out.println("Invalid choice. Please choose between Option 1 or Option 2");
			}
		}
	}
	return choice;	
	}
		
				public static double getValidInput(Scanner scanner,String prompt,double min,double max){
					double value=0.0d;
					
					while(true){
						System.out.println(prompt);
						
						if(scanner.hasNextDouble()){
							value=scanner.nextDouble();
							if(value>=min && value <=max){
								break;
							}else{
								System.out.printf("Please enter a value between%1f and%1f.\n",min,max);
							}
						}else{
							System.out.println("Invalid input. Please enter a value");
							scanner.next();
						}
						
					}
					return value;
				}
				
				public static double calculateBMI(int unitChoice,double weight,double height){
					double totalBMI;
					
					if(unitChoice==1){
						totalBMI=weight/(height*height);
					}else{
						totalBMI=(703*weight)/(height/height);
					}
					return totalBMI;
				}
			}
			
	
	
	
	
