package edu.pasadena.cs.cs03b;
import java.util.Scanner;

public class Dummy {

	public static void main(String[] args) {
		// TODO: add you logic here
	    Scanner scanner = new Scanner(System.in);
	    double userInput;
		double taxRate;
		double incomeAfterTax;
	    int[] salaryTable = {0,  11601,  47151,  100526,  191951,  243726,  609351};
	    double[] taxRateTable = {.1, .12, .22, .24, .32, .35, .37};

	    
	    while(true) {
	    	System.out.println("Enter annual income (-1 to exit):");
	    	userInput = scanner.nextDouble();

	    	if(userInput == -1) {
	    		break;
	    	}
	    	
	    	//System.out.print(userInput);
		
	    	taxRate = dummy(userInput, salaryTable, taxRateTable);
	    	incomeAfterTax = userInput * taxRate;
		
	    	System.out.println("Annual Income: " + userInput + " Tax rate: " + taxRate + 
	    			" Tax to pay: " + incomeAfterTax);
	    	System.out.println("");
	    }
	}

	public static double dummy(double userInputPar, int[] salaryTablePar, double[] taxRateTablePar) {
		// TOOD: add your logic here
		TaxTableTools userIncomeAfterTax = new TaxTableTools(/*userInputPar, salaryTablePar, taxRateTablePar*/);
		userIncomeAfterTax.setSalaryTable(salaryTablePar);
		userIncomeAfterTax.setTaxRateTable(taxRateTablePar);
		userIncomeAfterTax.setUserSalary(userInputPar);
		return userIncomeAfterTax.getUserTaxRate();
		
	}
	
	public static class TaxTableTools 
	{
		private double userSalary;
		private int[] currentSalaryTable;
		private double[] currentTaxRateTable;
	    
	    public TaxTableTools ()
	    {
	    	userSalary = 0;
	    	currentSalaryTable = new int[10];
	    	currentTaxRateTable = new double[10];
	    }
	    public TaxTableTools (double userInputPar, int[] salaryTablePar, double[] taxRateTablePar)
	    {
	    	userSalary = userInputPar;
	    	currentSalaryTable = salaryTablePar;
	    	currentTaxRateTable = taxRateTablePar;
	    }
	    
	    public void setUserSalary(double userInputPar) {
	    	userSalary = userInputPar;
	    }
	    public void setSalaryTable(int[] salaryTablePar) {
	    	currentSalaryTable = salaryTablePar;
	    }
	    
	    public void setTaxRateTable(double[] taxRateTablePar) {
	    	currentTaxRateTable = taxRateTablePar;
	    }
	    
	    public double getUserTaxRate() {
	    	
	    	if(userSalary >= currentSalaryTable[0] && userSalary < currentSalaryTable[1]) {
	    		return currentTaxRateTable[0];
	    	}
	    	else if(userSalary >= currentSalaryTable[1] && userSalary < currentSalaryTable[2]) {
	    		return currentTaxRateTable[1];
	    	}
	    	else if(userSalary >= currentSalaryTable[2] && userSalary < currentSalaryTable[3]) {
	    		return currentTaxRateTable[2];
	    	}
	    	else if(userSalary >= currentSalaryTable[3] && userSalary < currentSalaryTable[4]) {
	    		return currentTaxRateTable[3];
	    	}
	    	else if(userSalary >= currentSalaryTable[4] && userSalary < currentSalaryTable[5]) {
	    		return currentTaxRateTable[4];
	    	}
	    	else if(userSalary >= currentSalaryTable[5] && userSalary < currentSalaryTable[6]) {
	    		return currentTaxRateTable[5];
	    	}
	    	else if(userSalary >= currentSalaryTable[6]) {
	    		return currentTaxRateTable[6];
	    	}
	    	
	    	return 0;
	    }
	}
}
