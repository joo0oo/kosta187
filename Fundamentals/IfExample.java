import java.util.Scanner;

class IfExample {
	public static void main(String[] args)	{
		
		int score= 99;
		if( score< 100){ //����¥�� if���� ��ȣ ���ִ°� ���� (�����۾�)
			System.out.println(score);
		}

		if(score>=60){
			System.out.println("Pass");

		}else{
			System.out.println("Fail");
		}

		if( (score%2) ==0){
			System.out.println("¦��");
		}else{
			System.out.println("Ȧ��");
		}

		
		System.out.print("���� : ");
		Scanner scanner = new Scanner(System.in);
		score= scanner.nextInt();

		if(score>= 90){
			System.out.println("��");
		}else if(score >= 80){
			System.out.println("��");

		}else if(score >= 70){
			System.out.println("��");

		}else if(score >= 60){
			System.out.println("��");

		}else {
			System.out.println("��");

		}
		
	}
}