class SwitchExample {
	public static void main(String[] args)	{
		
		int a= 3;
		
		switch(a){
			case 1: System.out.println(" 1"); break;
			case 2: System.out.println(" 2"); break;
			case 3: System.out.println(" 3"); break;
			case 4: System.out.println(" 4"); break;
			case 5: System.out.println(" 5"); break;
		}

		int x=70, y=25;
		String opp = "+";
		
		switch(opp){
			case "+" : System.out.println(x+y); break;
			case "-" : System.out.println(x-y); break;
			case "*" : System.out.println(x*y); break;
			case "/" : System.out.println(x/y); break;
			default : System.out.println("지원되지 않는 연산자입니다");
		}
	}
}
