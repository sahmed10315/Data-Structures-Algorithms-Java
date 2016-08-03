package foundation.elementaryalgorithms;

public class DecToBaseConv {

	static String convFrmDecToBase(int num, int base) {
 
	    String res = "";
	    int rem;
	    // Convert input number is given base by repeatedly
	    // dividing it by base and taking remainder
	    while (num > 0)
	    {
	    	rem = num % base;
	    	if(base == 16)
	    	{
	    		if (rem == 10)
	    			res += 'A';
	    		else if(rem == 11)
	    			res += 'B';
	    		else if(rem == 12)
	    			res += 'C';
	    		else if(rem == 13)
	    			res += 'D';
	    		else if(rem == 14)
	    			res += 'E';
	    		else if(rem == 15)
	    			res += 'F';
	    		else
		    		res += rem;
	    	} else
	    		res += rem;
	    	
	        num /= base;
	    } 
	    // Reverse the result
	    return new StringBuffer(res).reverse().toString();
	}
	
	public static void main(String [] args) {
		System.out.println(convFrmDecToBase(6491, 16));

		System.out.println(convFrmDecToBase(6491, 2));
		

		System.out.println(convFrmDecToBase(6491, 8)); 
	}
}
