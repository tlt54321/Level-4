package ShapeUML;

public class EqTriPyramid extends Shape3D{
	private float sideLength;
	
	public EqTriPyramid(float sideLength){
		this.sideLength = sideLength;
	}
	
	public float getArea(){
		float base = (float)(Math.sqrt((Math.pow(sideLength, 2) - Math.pow((sideLength / 2), 2))));
		float height = (float)(Math.sqrt((2/3) * base));
		return ((1/3) * base * height);
	}
	
	public float getSurfaceArea(){
		float base = (float)(Math.sqrt((Math.pow(sideLength, 2) - Math.pow((sideLength / 2), 2))));
		return base * 4;
	}
	
	public float getSideLength(){
		return sideLength;
	}
	
}
