package api.endpoints;

public class testClass1 {
	
	/*
	Task description
	Write a function solution that, given an integer N, returns the maximum possible value obtained by inserting one '5' digit inside the decimal representation of
	integer N.

	Examples:
	1. Given N = 268, the function should return 5268.
	e.g. there are 4 possible number by insert 5 : 5268 2568 2658 2685, the max is 5268 and should be retured.
	2. Given N = 670, the function should return 6750.
	3. Given N = 0, the function should return 50.
	4. Given N = −999, the function should return −5999.

	Assume that:
	N is an integer within the range [−8,000..8,000].
	In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

	You need to :
	1. Write & test the function solution in 45 min totally
	2. Write down test cases for your solution code and make all of them passed.
	3. You can google any lib/utils if you forget not familiar.
	*/

	    static int maxNum(int num){
	        //task1: write your code here

	        int maxVal = 0; String num1 = "5";

	        for(int i = 0 ; i<=String.valueOf(num).length(); i++)
	        {
	            StringBuffer stringBuffer = new StringBuffer(String.valueOf(num));
	            StringBuffer stringBuffer1 = new StringBuffer(String.valueOf(num));
	            String fisrtValue = stringBuffer.insert(i,num1).toString();
	            String secondValue = stringBuffer1.insert(i+1,num1).toString();
	            if(Integer.parseInt(fisrtValue) > Integer.parseInt(secondValue))
	            {
	                maxVal = Integer.parseInt(fisrtValue);
	            }
	            
	        }
	        return maxVal;
	    }
	    
	    public static void main(String []args){
	        // test cases from example
	        System.out.println(maxNum(268) + " = " + 5268);
	        System.out.println(maxNum(670) + " = " + 6750);
	        System.out.println(maxNum(0) + " = " + 50);
	        System.out.println(maxNum(-999) + " = " + -5999);

	        // task2: please design more test cases by using the format bellow
	        //System.out.println(maxNum(-999) + " = " + -5999);

	     }
	}
