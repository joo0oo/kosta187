class WhileExample {
	public static void main(String[] args)	{
		
		int i=0;

		while(i<10){
			System.out.println(" �ڽ�Ÿ 187�� ȭ���� ");
			i++;
		}

		i=0;
		int sum=0;
		while(i<=100){
			//sum = sum+i;
			sum += i;
			i++;
		}
		System.out.println(" ��: "+sum);
		
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
		System.out.println("¦���� : "+evenSum);
		System.out.println("Ȧ���� : "+oddSum);

	}
}