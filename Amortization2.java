package progProj;
import java.util.Scanner;

public class Amortization2 {
	
		public static void main(String[] args) {
				printLoanTable();
		}
		
	   public static double monthlyPayment (double APR)
		{
			double i;
			i=APR/12;
			return i;
		}
		
	    public static double monthlyPay(double Principal, double APR, int Term)
		{
			int n;
			n = Term*12;
			double MonthlyPay;
			MonthlyPay = Principal * monthlyPayment(APR) * Math.pow(1+monthlyPayment(APR),n)/ (Math.pow(1+monthlyPayment(APR), n)- 1) ;
			return MonthlyPay;
		}
		
		public static double inputPrincipal(Scanner scan)
		{
			System.out.print("Principal (loan amount): ");
			return (scan.nextDouble());
		}
		
		public static int inputLoanTerm(Scanner scan)
		{
			System.out.print("Loan term (in years) : ");
	        return (scan.nextInt());
		}
		
		public static double inputAPR(Scanner scan)
		{
			System.out.print("APR (e.g. 0.04) : ");
			return scan.nextDouble();
		}
		
		
		public static void printLoanTable()
		{   
			double Principal, APR;
			int Term,n;
		    double MonthlyPay,i;
			double MInt, MPrin, YInt=0, YPrin=0;
			
			Scanner scan = new Scanner(System.in);
			System.out.println("This program computes monthly loan payments.");
			Principal = inputPrincipal(scan);
			Term = inputLoanTerm(scan);
			APR = inputAPR(scan);
			
			i = monthlyPayment(APR);
			MonthlyPay = monthlyPay(Principal,APR,Term);
			
			System.out.println();
			System.out.printf("PRINCIPAL: %8.1f\t", Principal);
			System.out.printf(" RATE: %4.2f\t", APR);
			System.out.printf("TERM: %d", Term);
			System.out.println();
			System.out.println("     YEAR     MONTH\t MONTH PAID\tPAID/PRINCIPAL\tPAID/INTEREST ");
			System.out.print("---------------------------------------------------------------------");
			System.out.println();
			
			for (int j=1; j<=Term; j++)
			{
				YPrin=0;
				YInt=0;
				for(int month=1; month<=12; month++)
				{
					MInt = Principal * i;
					MPrin = MonthlyPay - MInt;
					YInt+=MInt;
					YPrin+=MPrin;
					System.out.printf("%8d\t",j);
					System.out.printf("%2d\t",month);
					System.out.printf("%11.5f\t",MonthlyPay);
					System.out.printf("%14.5f\t",MPrin);
					System.out.printf("%13.5f\t",MInt);
					System.out.println();
					Principal-=MPrin;	
				}
				System.out.printf("YEAR PRINCIPAL: %13.2f\n", YPrin);
				System.out.printf("YEAR INTEREST:  %13.2f\n", YInt);
			} 
		}
	}


