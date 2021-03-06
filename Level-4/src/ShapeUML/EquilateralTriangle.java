package ShapeUML;

public class EquilateralTriangle extends Shape2D{
	private float base;
	private float height;
	
	public EquilateralTriangle(float base, float height){
		this.base = base;
		this.height = height;
	}
	
	public float getBase(){
		return base;
	}
	
	public float getHeight(){
		return height;
	}
}
