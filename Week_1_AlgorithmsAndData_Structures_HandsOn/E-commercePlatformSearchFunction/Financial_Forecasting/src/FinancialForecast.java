import java.util.*;
public class FinancialForecast {

		    // Recursive method to calculate future value
		    public static double calculateFutureValue(double presentValue, double rate, int years) {
		        if (years == 0) {
		            return presentValue;
		        }
		        return calculateFutureValue(presentValue * (1 + rate), rate, years - 1);
		    }
		    public static double futureValueIterative(double presentValue, double rate, int years) {
                for (int i = 0; i < years; i++) {
                	presentValue *= (1 + rate);
                }
                return presentValue;
            }

		    public static void main(String[] args) {
		    	Scanner sc=new Scanner(System.in);
		    	System.out.println("Enter the present value to calculate future values:");
		        double presentValue = sc.nextDouble(); // ₹10,000
		        System.out.println("Enter the rate value to calculate future values:");
		        double rate = sc.nextDouble();          // 7% annual growth
		        System.out.println("Enter the years to calculate future values:");//5
		        int years = sc.nextInt();

//		        double futureValue = calculateFutureValue(presentValue, rate, years);
//		        System.out.printf("Future Value after %d years: ₹%.2f%n", years, futureValue);
		    
		        System.out.println("Recursive operation");
	            long start1 = System.nanoTime();
	            double result1 = calculateFutureValue(presentValue, rate, years);
	            long end1 = System.nanoTime();
	            System.out.printf("Recursive Result: ₹%.2f",result1);
	            System.out.println("");
	            System.out.printf("The required for doing the operation: %d ns%n", (end1 - start1));
	            System.out.println("");
	            System.out.println("Iterative operation");
	            long start2 = System.nanoTime();
	            double result2 = futureValueIterative(presentValue, rate, years);
	            long end2 = System.nanoTime();
	            System.out.printf("Iterative Result: ₹%.2f", result2);
	            System.out.println("");
	            System.out.printf("The required for doing the operatio: %d ns%n",  (end2 - start2));
                if((end2 - start2)<(end1 - start1)) {
                	System.out.println("Iterative operation is better than recursive operation");
                }
	        }
		    
		    
		


	}


