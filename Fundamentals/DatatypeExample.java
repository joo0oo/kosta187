/**
 * �ڹ� ���������� �׽�Ʈ
 *
 */

class DatatypeExample {
	public static void main(String[] args)	{
		boolean flag = true; //true�� Ű������ ���ÿ� ���ͷ�

		//boolean flag2= 10; //java������ có�� ���ڰ� true�� �ƴ�, ���� true/false�� ����, �� while(1)�Ұ���
		System.out.println(flag);

		//char ����
		char x= '\uD55C'; // '��' �����ڵ� �����Ҵ�
		char y= '\uAE00'; // '��' �����ڵ� �����Ҵ�
		System.out.println(x);
		System.out.println(y);

		//�����
		System.out.println("��\b���� \n�����Դϴ�");
		System.out.println("\"�ڹ�\"�� ���ƿ�");
		System.out.println("C:\\a\\b\\c");

		//byte, short, int, long
		long money = 50000000; //�޸� ������ (4����Ʈ int->8����Ʈ long���� �ڵ� ����ȯ�۾��� ��ġ�� ������) ������ ������ �ƴ�
		long money2 = 50000000L; //long���̶�� �̸� �˷��ֱ⶧���� �ڵ� ����ȯ�۾��� ��ġ�� �����Ƿ� ȿ����


		//java������ ��¹�
		System.out.println(money2);
		System.out.print(money2);
		System.out.printf("%d",money2); //��������� �����ؼ� ���

		// float, double
		// float pi= 3.141592; // error : incompatible types : possible lossy conversion from double to float 
		float pi = 3.141592F; //���� ������
	}
}