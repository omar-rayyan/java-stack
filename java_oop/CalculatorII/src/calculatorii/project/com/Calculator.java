package calculatorii.project.com;

import java.util.Scanner;

public class Calculator {
	String operation;
    double operandOne;
    double operandTwo;
    double currentTotal;

    public Calculator() {
    	operandOne = 0;
    	operandTwo = 0;
    	currentTotal = 0;
    	operation = null;
    }
    
    public void startApp() {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please enter an operand");
        String firstOperand = scanner.nextLine();
        setOperandOne(Double.parseDouble(firstOperand));
        
        System.out.println("Please set the operation (+, -, *, /)");
        String operation = scanner.nextLine();
        this.operation = operation;
        
        if (operation.equals("=")) {
        	System.out.println(firstOperand);
        } else {
        	System.out.println("Please enter an operand");
            String secondOperand = scanner.nextLine();
            setOperandTwo(Double.parseDouble(secondOperand));
            
            performOperation();
        }
    }
    
    public void continueApp(double currentTotal) {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please set the operation (+, -, *, /, =)");
        String operation = scanner.nextLine();
        this.operation = operation;
        
        if (operation.equals("=")) {
        	System.out.println(currentTotal);
        } else {
	        System.out.println("Please enter an operand");
	        String secondOperand = scanner.nextLine();
	        setOperandTwo(Double.parseDouble(secondOperand));
	        
	        performNewOperation();
        }
    }
    
    public void performOperation() {
    	continueApp(getResult());
    }
    
    public void performNewOperation() {
    	continueApp(getNewResult());
    }
    
    public double getNewResult() {
    	if (operation.equals("+")) {
    		currentTotal += operandTwo;
    		return currentTotal;
    	} else if (operation.equals("-")) {
    		currentTotal -=  operandTwo;
    		return currentTotal;
    	} else if (operation.equals("*")) {
    		currentTotal *= operandTwo;
    		return currentTotal;
    	} else {
    		currentTotal /= operandTwo;
    		return currentTotal;
    	}
    }
    
    public double getResult() {
    	if (operation.equals("+")) {
    		currentTotal += operandOne + operandTwo;
    		return currentTotal;
    	} else if (operation.equals("-")) {
    		currentTotal += operandOne - operandTwo;
    		return currentTotal;
    	} else if (operation.equals("*")) {
    		currentTotal += operandOne * operandTwo;
    		return currentTotal;
    	} else {
    		currentTotal += operandOne / operandTwo;
    		return currentTotal;
    	}
    }
    
    public void setOperandOne(double operand) {
    	operandOne = operand;
    }
    
    public void setOperandTwo(double operand) {
    	operandTwo = operand;
    }
}
