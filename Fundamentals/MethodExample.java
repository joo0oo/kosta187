class MethodExample {

	static void printMessage(String name, String message){
		System.out.println("["+name+"] :  "+message);		
	}

	static int sum(int x, int y, int z){
		return x+y+z; 
	}

	public static void main(String[] args)	{
		String name= "김기정";
		String message= "조금 쉬었다 해요...";
		printMessage(name, message); //함수 호출

		int result= sum(50, 29, 19);
		System.out.println(result);
	}
}
