class WhileExample {
	public static void main(String[] args)	{
		
		int i=0;

		while(i<10){
			System.out.println(" 코스타 187기 화이팅 ");
			i++;
		}

		i=0;
		int sum=0;
		while(i<=100){
			//sum = sum+i;
			sum += i;
			i++;
		}
		System.out.println(" 합: "+sum);
		
		i=0;
		int evenSum=0, oddSum=0;
		while(i <100){
			i++;
			if((i%2) ==0){
				evenSum += i;
			}
			else{
				oddSum += i;			
			}
		}
		System.out.println("짝수합 : "+evenSum);
		System.out.println("홀수합 : "+oddSum);

	}
}
