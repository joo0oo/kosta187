class OperatorExample {
	public static void main(String[] args)	{
		
		int x=50, y=20;
		//���������
		System.out.println(" ��� : " + x + y); //���ڿ� ���̱�
		System.out.println(" ��� : " + (x + y)); //�켱������ ����
		System.out.println(" ��� : " + (x % y)); //������ ���ϱ�

		//���� ���Կ�����
		// x = x+y;
		x += y; 

		//����ȯ ������
		double weight = 78.34343;
		System.out.println(weight); //�Ҽ��� �״�� ���
		System.out.println((int)weight); //�Ҽ��� �ڸ��� ��� 


		//����������
		x=100;
		System.out.println(x++); //100��� : ���� ���� �� ����
		System.out.println(++x); //102��� : ���� �� ���� ����

		//��Ʈ ������
		x = 10;
		System.out.println(x*2*2*2);
		x=10;
		System.out.println(x << 3); 

		//���� ���׿�����
		int a=1, b=20, c=3;
		int max= (a>b)? a:b; //������ ���̸� a, �����̸� b�� ����
		int min= (b<c)? b:c; //������ ���̸� b, �����̸� c�� ����
		System.out.println(max);
		System.out.println(min);

	}
}