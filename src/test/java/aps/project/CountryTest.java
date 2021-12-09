package aps.project;
import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountryTest {
	private Country country1;
	private Country country2;
	private Country country3;
	private List<String> country1Frontier;
	private List<String> country2Frontier;
	private List<String> country3Frontier;
	
	@Before
	public void inicalize() {
		country1Frontier = new  ArrayList<String>();
		country1Frontier.add("Argentina");
		country1 = new Country ("Brasil", country1Frontier);
		country2Frontier = new  ArrayList<String>();
		country2Frontier.add("Brasil");
		country2 = new Country ("Argentina", country2Frontier);
		country3Frontier = new  ArrayList<String>();
		country3Frontier.add("Paraguai");
		country3 = new Country ("Chile", country3Frontier);
		
	}
	
	@Test //verificar se são vizinhos
	public void test01IsNeighbour() { 
		boolean actual, expected = true;
		actual = country1.isNeighbour(country2);
		Assert.assertEquals(expected, actual);
	}
	@Test //verificar se não são vizinhos
	public void test02IsntNeighbour() { 
		boolean actual, expected = false;
		actual = country1.isNeighbour(country3);
		Assert.assertEquals(expected, actual);
	}
}
