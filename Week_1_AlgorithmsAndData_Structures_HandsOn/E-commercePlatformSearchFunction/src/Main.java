import java.util.*;
//import java.util.Comparator;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Product[] products = {
	            new Product(1, "Laptop", "Electronics"),
	            new Product(2, "Phone", "Electronics"),
	            new Product(3, "Shirt", "Clothing"),
	            new Product(4, "Shoes", "Footwear")
	        };
		System.out.println("Enter the product name to search:");
		String name=sc.nextLine();

	        // Sort before binary search
	        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
	        // Linear Search Time
	        long start1 = System.nanoTime();
	        Product result1 = SearchFunctions.linearSearch(products, name);
	        System.out.println("Linear Search Result: " + result1);
	        long end1 = System.nanoTime();
	        long linearTime = end1 - start1;
	        System.out.println();
	        System.out.println("Linear Search Time");
	        System.out.println("Linear Search Time starts (ns): " + start1);
	        System.out.println("Linear Search Time ends (ns): " + end1);
	        System.out.println("Linear Search  Total Time (ns): " + linearTime);
	        System.out.println();
	        // Binary Search Time
	        long start2 = System.nanoTime();
	        
	        Product result2 = SearchFunctions.binarySearch(products, name);
	        System.out.println("Binary Search Result: " + result2);
	        long end2 = System.nanoTime();
	        long binaryTime = end2 - start2;
	        System.out.println();

	        // Output Results
	        
	        System.out.println("Binary Search Time");
	        System.out.println("Binary Search Time starts (ns): " + start2);
	        System.out.println("Binary Search Time ends (ns): " + end2);
	        System.out.println("Binary Search Total Time (ns): " + binaryTime);
	        System.out.println();
	        if(binaryTime<linearTime) {
	        	System.out.println("Binary search is the optimized one than the linear search");
	        }
	        }
	}


