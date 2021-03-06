package aps.project;

import java.lang.reflect.Constructor;

import org.junit.Assert;
import org.junit.Test;

public class GameBoardTest {
	@Test
	public void test01InstanceIsNotNull() {
		GameBoardSingleton instance =GameBoardSingleton.getInstance();
		Assert.assertTrue(instance != null);
	}

	@Test
	public void test02TwoSingletonsSameInstance() {
		GameBoardSingleton s1 = GameBoardSingleton.getInstance();
		GameBoardSingleton s2 = GameBoardSingleton.getInstance();
		Assert.assertTrue(s1 == s2);
		Assert.assertEquals(s1, s2);
	}

	@Test
	public void test03ConstructorIsNotPublic() {
		Class<GameBoardSingleton> aClass = GameBoardSingleton.class;
		Constructor<GameBoardSingleton> constructor;
		try {
			constructor = aClass.getConstructor();
			constructor.newInstance();
			Assert.fail("Constructor is public");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	public void test04MapExists() {
		GameBoardSingleton instance =GameBoardSingleton.getInstance();
		Map gameTest = instance.getGameMap();
		Assert.assertTrue(gameTest != null);
	}
}
