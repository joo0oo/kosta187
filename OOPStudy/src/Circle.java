
public class Circle extends Shape {
	private double radian;

	public Circle() {
		//super(); //안써도 자동호출됨 VM에 의해 double형 0.0으로 자동초기화
		this(0.0,0.0,0.0);
	}

	public Circle(double x, double y, double radian) {
		//super(x, y); //이건 꼭 써야함 
		this.x=x;
		this.y=y;
		this.radian = radian;
	}

	public double getRadian() {
		return radian;
	}

	public void setRadian(double radian) {
		this.radian = radian;
	}
	
	@Override
	public void draw() {
		System.out.println(this.x+" , "+this.y+" , "+getRadian()+" 의 원입니다.. ");
	}
	
	@Override
	public double getLength() {
		return 2*Math.PI*getRadian();
	}
	
	@Override
	public double getArea() {
		return Math.PI*Math.pow(getRadian(), 2);
	}

	@Override
	public String toString() {
		/*
		return "Circle [radian=" + radian + ", getX()=" + getX() + ", getY()=" + getY() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
				*/
		return "Circle [radian=" + radian + ", toString()="
		+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
