import java.util.Scanner;

class IfExample {
	public static void main(String[] args)	{
		
		int score= 99;
		if( score< 100){ //한줄짜리 if문도 괄호 써주는게 좋음 (공동작업)
			System.out.println(score);
		}

		if(score>=60){
			System.out.println("Pass");

		}else{
			System.out.println("Fail");
		}

		if( (score%2) ==0){
			System.out.println("짝수");
		}else{
			System.out.println("홀수");
		}

		
		System.out.print("점수 : ");
		Scanner scanner = new Scanner(System.in);
		score= scanner.nextInt();

		if(score>= 90){
			System.out.println("수");
		}else if(score >= 80){
			System.out.println("우");

		}else if(score >= 70){
			System.out.println("미");

		}else if(score >= 60){
			System.out.println("양");

		}else {
			System.out.println("가");

		}
		
	}
}
