import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{

	public static long howMuch(long number) {
		List<Integer> test2 = new ArrayList<Integer>();
		long temp = number;
		for (int i = 1; i < 100; i++) {
			test2.add((int) (temp - (temp / 10) * 10));
			temp = temp / 10;
			if (temp == 0) {
				break;
			}
		}
		//System.out.println(test2);
		long count = 0;
		for (int i = 0; i < test2.size(); i++) {
			int temp2 = test2.get(i);
			temp2 = temp2 > 4 ? temp2 - 1 : temp2;
			count += temp2 * (long) Math.pow(9, i);
		}
		return count;
	}

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			long A= sc.nextLong();
			long B= sc.nextLong();
			//System.out.println("A : "+A);
			//System.out.println("B : "+B);
			
			
			System.out.println("#"+test_case+" "+ (howMuch(A*(-1)) + howMuch(B) - 1));
		   // System.out.println("4의 개수 :" + (howMuch(A*(-1)) + howMuch(B) - 1));
		}
	}
}