class ReturnExample {

	public static void main(String[] args)	{
		System.out.println("���α׷� ����");

		for( int i=0; i<100; i++ ){
			System.out.println(" �ڽ�Ÿ 187 �� ������");
			if(i==50){
				return; //���α׷� �ٷ� ����
			}
		}

		System.out.println("���α׷� ����");
	}
}
