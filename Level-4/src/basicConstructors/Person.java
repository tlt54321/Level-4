package basicConstructors;

public class Person{
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getFirstName(){
		String temp = "";
		for(int i = 0; i < name.length() - 1; i++){
			if(name.charAt(i) == ' '){
				break;
			}
			temp += name.charAt(i);
		}
		return temp;
	}
	
	public String getLastName(){
		String temp = "";
		int startPos = 0;
		for(int i = 0; i < name.length() - 1; i++){
			if(name.charAt(i) == ' '){
				startPos = i + 1;
			}
		}
		for(int i = startPos; i < name.length(); i++){
			temp += name.charAt(i);
		}
		return temp;
	}
	
}