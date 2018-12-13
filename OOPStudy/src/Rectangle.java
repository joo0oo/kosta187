
public class Rectangle extends Shape {
	
	private double width, height;
	
	Rectangle(){
		this(0.0, 0.0, 0.0, 0.0);
	}
	
	Rectangle(double x, double y,double wid, double hei){
		//super(x,y);
		this.x=x;
		this.y=y;
		this.width=wid;
		this.height=hei;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println(this.x+" , "+this.y+" , "+getWidth()+" , "+getHeight()+ " 의 사각형입니다.. ");
	}
	
	@Override
	public double getLength() {
		return (getWidth()+getHeight())*2;
	}
	
	@Override
	public double getArea() {
		return getWidth()*getHeight();
	}

	@Override
	public String toString() {
		/*
		return "Rectangle [width=" + width + ", height=" + height + ", getX()=" + getX() + ", getY()=" + getY()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
				*/
		return "Rectangle [width=" + width + ", height=" + height 
		+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
		+ "]";
	}
	
	

}
