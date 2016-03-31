package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka tp;

	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testSetKorisnikOk() {
		tp.setKorisnik("Zika");
		assertEquals("Zika", tp.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmpty() {
		tp.setKorisnik("");
	}
	
	@Test
	public void testSetPorukaOk() {
		tp.setPoruka("yo");
		assertEquals("yo", tp.getPoruka());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaOver9k() {
		String poruka = "Hello, it's me\n"
						+ "I was wondering"
						+ " if after all these years you'd like to meet"
						+ "\nTo go over everything\n"
						+ "They say that time's supposed to heal ya\n"
						+ "But I ain't done much healing\n"
						+ "Hello, can you hear me?\n"
						+ "I'm in California dreaming about who we used to be\n"
						+ "When we were younger and free\n"
						+ "I've forgotten how it felt before the world fell at our feet";
		//System.out.println(poruka.length());
		tp.setPoruka(poruka);
	}
	

	@Test
	public void testToStringOk() {
		tp.setKorisnik("Adele");
		tp.setPoruka("Hello");
		assertEquals("KORISNIK:" + tp.getKorisnik() + " PORUKA:" + tp.getPoruka(), tp.toString());
	}

}
