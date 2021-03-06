package basicConstructors;

// Copyright Wintriss Technical Schools 2013
import static org.junit.Assert.*;
import org.junit.Test;

public class EasyConstructorQuiz {

	@Test
	public void testBasicConstruction() {
		Person vic = new Person("vic wintriss", 81);
		assertEquals("vic", vic.getFirstName());
		assertEquals("wintriss", vic.getLastName());
		assertEquals(81, vic.getAge());
	}

	
	@Test
	public void testConstruction1() {
		Superhero ironMan = new Superhero("iron man", "armor");
		assertEquals("iron man", ironMan.getName());
		assertEquals("armor", ironMan.getSuperpower());

		Superhero hulk = new Superhero("incredible hulk", "strength");
		assertEquals("incredible hulk", hulk.getName());
		assertEquals("strength", hulk.getSuperpower());
	}

	
	@Test
	//Make a new class called Character and make Superhero extend it
	public void testConstruction2() {
		Character darthVadar = new Character("darth vader", true);
		assertEquals("darth vader", darthVadar.getName());
		assertEquals(true, darthVadar.isEvil());
	}

	
	@Test
	public void testConstruction3() throws Exception {
		Superhero lukeSkywalker = new Superhero("luke skywalker",
				"jedi mind tricks", false);
		assertEquals("luke skywalker", lukeSkywalker.getName());
		assertEquals("jedi mind tricks", lukeSkywalker.getSuperpower());
		assertEquals(false, lukeSkywalker.isEvil());
	}
	
	@Test
	public void testHighestIntInArray(){
		int[] arr = {3, 6, 12, 37, 5, 17, 6};
		assertEquals(37, IntArray.getHighestIntInArray(arr));
	}
	
	@Test
	public void testIncrementIntArray(){
		int[] arr1 = {3, 6, 9, 12, 15, 18, 21};
		int[] arr2 = {4, 7, 10, 13, 16, 19, 22};
		assertArrayEquals(arr2, IntArray.incrementIntArray(arr1));
	}
}