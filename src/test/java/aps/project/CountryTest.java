package aps.project;
import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountryTest {
	private Country country1;
	private Country country2;
	private Country country3;
	private List<String> conuntry1Frontier;
	private List<String> conuntry2Frontier;
	private List<String> conuntry3Frontier;
	
	@Before
	public void inicalize() {
		conuntry1Frontier = new  ArrayList<String>();
		conuntry1Frontier.add("Argentina");
		country1 = new Country ("Brasil", conuntry1Frontier);
		conuntry2Frontier = new  ArrayList<String>();
		conuntry2Frontier.add("Brasil");
		country2 = new Country ("Argentina", conuntry2Frontier);
		conuntry3Frontier = new  ArrayList<String>();
		conuntry3Frontier.add("Paraguai");
		country3 = new Country ("Chile", conuntry3Frontier);
		
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
