class ForMission {
	public static void main(String[] args)	{
		
		for(int i=0; i<5; i++){
			for(int j=0; j<=i; j++){
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println();

		for(int i=5; i>0; i--){
			for(int j=1; j<=i; j++){
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println();

		for(int i=0; i<5; i++){
			for(int j=5-i-1; j>0; j--){
				System.out.print(' ');
			}
			for(int j=0; j<=i; j++){
				System.out.print('*');
			}
			System.out.println();			
		}
		System.out.println();

		for(int i=0; i<5; i++){
			for(int j=0; j<i; j++){
				System.out.print(' ');
			}
			for(int j=5-i; j>0; j--){
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println();

		
		for(int i=0; i<10; i++){
			if(i%2==1){
				for (int k= (10-i)/2; k>0 ;k-- ){
					System.out.print(' ');
				}
				for(int j=0; j<i; j++){
					System.out.print('*');
				}
				for (int k= (10-i)/2; k>0 ;k-- ){
					System.out.print(' ');
				}
				System.out.println();
			}
		}
		System.out.println();

		
		//모래시계
		for(int i=10; i>0; i--){
			if(i%2==1){
				for (int k= (10-i)/2; k>0 ;k-- ){
					System.out.print(' ');
				}
				for(int j=0; j<i; j++){
					System.out.print('*');
				}
				for (int k= (10-i)/2; k>0 ;k-- ){
					System.out.print(' ');
				}
				System.out.println();
			}
		}		
		for(int i=0; i<10; i++){
			if(i%2==1){
				for (int k= (10-i)/2; k>0 ;k-- ){
					System.out.print(' ');
				}
				for(int j=0; j<i; j++){
					System.out.print('*');
				}
				for (int k= (10-i)/2; k>0 ;k-- ){
					System.out.print(' ');
				}
				System.out.println();
			}
		}
		System.out.println();

		
		//구구단
		for(int dan=2; dan<10; dan++){
			for(int i=1; i<=9; i++){
				System.out.println(dan+" * "+i+" = "+(dan*i));
			}
			System.out.println();
		}


		
	}
}
