package InterfacePractice;

import javax.swing.JOptionPane;

public class Tester{

	public static void main(String[] args) {
		new Tester();
	}
	
	public Tester(){
		String first = JOptionPane.showInputDialog("Put a string");
		String second = JOptionPane.showInputDialog("Input another string");
		System.out.println("The longer string is: " + betterString(first, second, (String fs, String s2) -> {
			if(fs.length() >= s2.length()){
				return true;
			}
			return false;
		}));
		System.out.println("The shorter string is: " + betterString(first, second, (String fs, String s2) -> {
			if(fs.length() <= s2.length()){
				return true;
			}else{
				return false;
			}
		}));
		System.out.println("The string that's lexigraphically smaller is: " + betterString(first, second, (String fs, String s2) -> {
			if(fs.compareTo(s2) < 0){
				return true;
			}else{
				return false;
			}
		}));
		System.out.println("The string that's lexigraphically larger is: " +betterString(first, second, (String fs, String s2) -> {
			if(fs.compareTo(s2) > 0){
				return true;
			}else{
				return false;
			}
		}));
		System.out.println("The string with more vowels is: " + betterString(first, second, (String fs, String s2) -> {
			int vow1 = 0;
			int vow2 = 0;
			for(char c: fs.toCharArray()){
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
					vow1++;
				}
			}
			for(char c: s2.toCharArray()){
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
					vow2++;
				}
			}
			if(vow1 >= vow2){
				return true;
			}
			return false;
		}));
		System.out.println("The string with more consonants is: " + betterString(first, second, (String fs, String s2) -> {
			int vow1 = 0;
			int vow2 = 0;
			for(char c: fs.toCharArray()){
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
				}
				else{
					vow1++;
				}
			}
			for(char c: s2.toCharArray()){
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
				}
				else{
					vow2++;
				}
			}
			if(vow1 <= vow2){
				return true;
			}
			return false;
		}));
	}

	public static String betterString(String s1, String s2, Sorter s){
		if(s.sort(s1, s2)){
			return s1;
		}else{
			return s2;
		}
	}
	
}
