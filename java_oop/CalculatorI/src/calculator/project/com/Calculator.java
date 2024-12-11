package calculator.project.com;

import java.util.Scanner;

public class Calculator {
	String operation;
    double operandOne;
    double operandTwo;

    public Calculator() {
    	operandOne = 0;
    	operandTwo = 0;
    	operation = null;
    }
    
    public void startApp() {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please enter the first operand");
        String firstOperand = scanner.nextLine();
        setOperandOne(Double.parseDouble(firstOperand));
        
        System.out.println("Please set the operation (+/-)");
        String operation = scanner.nextLine();
        this.operation = operation;
        
        System.out.println("Please enter the second operand");
        String secondOperand = scanner.nextLine();
        setOperandTwo(Double.parseDouble(secondOperand));
        
        performOperation();
    }
    
    public void performOperation() {
    	System.out.println(getResult());
    }
    
    public double getResult() {
    	if (operation.equals("+")) {
    		return operandOne + operandTwo;
    	} else {
    		return operandOne - operandTwo;
    	}
    }
    
    public void setOperandOne(double operand) {
    	operandOne = operand;
    }
    
    public void setOperandTwo(double operand) {
    	operandTwo = operand;
    }
}
