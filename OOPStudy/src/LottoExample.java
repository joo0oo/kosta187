import java.util.Scanner;

public class LottoExample {

	/*
	 * 로또 번호 랜덤으로 6가지 뽑기
	 * 1~45 중에서 임의의 6가지 수를 뽑는 크기 6의 1차원 배열
	 * 숫자 출력은 오름차순으로 출력
	 * 
	 * 메소드 3가지
	 * 1. 금액 투입 
	 * 		1천원 ->1회 2천원->2회... 5천원->5회
	 * 		n회일때 크기 6의 1차원 배열을 n개 만들기 (높이 n의 2차원 배열이 됨)
	 * 2. 랜덤 추출
	 * 		1~45중에서 임의의 6가지 숫자 뽑기
	 * 		이미 뽑은 숫자는 중복해서 뽑지 않는다	ex) 1,2,15,45,45,45 불가능
	 * 3. 출력
	 * 		뽑힌 숫자들을 오름차순으로 출력
	 * 
	 */
	
	private int[][]lottoNum; //랜덤추출된 로또번호 6가지
	private int money; //투입금액
	private int count;
	
	//생성자
	LottoExample(){
		this.lottoNum=null;
		this.money=0;
		this.count=0;
	}
	
	
	
	//금액 투입
	public void insertMoney(int money) {
		this.money = money;
		this.count=money/1000; //넣은 돈으로 가능한 횟수 		
		if(money < 1000) {
			System.out.println("돈이 부족해서 진행불가");
			return;
		}
		System.out.println("투입 금액 : "+this.money);
		System.out.println("가능 횟수 : "+this.count+" 회");
	}
	
	public void setLotto() { //배열 생성
		this.lottoNum = new int[this.count][6];		
	}
	
	public void setRandNum() { //랜덤 6가지 숫자 추출
		int count=this.count;
				
		// 로또 번호(1~45범위의 6개)
		for(int j=0; j<count; j++) {
			for (int i = 0; i < 6; i++) {
			     int num =(int)((Math.random()*45) + 1);
			    // System.out.println("num : "+num);
			     if(!isExist(num,i,j)) {
			    	 lottoNum[j][i]=num;
			     }
			     else {
			    	 i--;
			     }
			}
		}
	}
	
	public boolean isExist(int num, int len, int count) { //중복검사 
		for(int i=0; i<len; i++) {
			if(this.lottoNum[count][i]==num) {
				return true; //중복임
			}
		}
		return false; //중복아님
	}
		
	public void sorting() { //배열 오름차순 정렬하기 (print를 위해)		
		for(int n=0; n<this.count; n++) {
			
			for(int i=0; i<lottoNum[n].length-1; i++) {
				for(int j=0; j<6-i-1; j++) {
					//System.out.println("n : "+n+"/   i : "+i+"/   j : "+j);
					if(this.lottoNum[n][j] > this.lottoNum[n][j+1]) {
						int tmp=this.lottoNum[n][j];
						this.lottoNum[n][j]= this.lottoNum[n][j+1];
						this.lottoNum[n][j+1]=tmp;
					}
				}
			}
			
		}
	}
	
	public void print() {
		this.sorting();
		for(int j=0; j<count; j++) {
			System.out.print((j+1)+" 회차 : ");
			for (int i = 0; i < 6; i++) {
			     System.out.print(this.lottoNum[j][i]+"\t");
			}
			System.out.println();
		}
	}
	
	public void lottoStart() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("!!LOTTO START!!");
		System.out.println("!**1000원당 1회 가능**!");
		System.out.println("Insert Money : ");
		int money= scanner.nextInt();		
		this.insertMoney(money);
		this.setLotto();
	}
	
	
}
