class Gugudan {

	static void printGugudan(int num){
		
		for(int dan=2; dan<=num; dan++){
			for(int i=1; i<10; i++){
				System.out.println(dan+" * "+i+" = "+(dan*i));
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args)	{
		printGugudan(5);
	}
}
