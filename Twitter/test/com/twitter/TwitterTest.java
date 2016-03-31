package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	Twitter t;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t=null;
	}

	@Test
	public void testUnesi() {
		t.unesi("Adele", "Hello");
		assertEquals("Adele", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Hello", t.vratiSvePoruke().getLast().getPoruka());
	}
	
	@Test
	public void testVratiSvePoruke() {
		t.unesi("Adele", "Hello");
		assertEquals("Adele", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Hello", t.vratiSvePoruke().getLast().getPoruka());
	}
	
	@Test
	public void testVratiPorukeOk() {
		t.unesi("asd", "adsafa");
		t.unesi("afa", "adsafagdaa");
		t.unesi("aasfasd", "agagagag");
		assertArrayEquals(t.vratiSvePoruke().toArray(), t.vratiPoruke(3, "a"));
	}
	
	@Test
	public void testVratiPorukeMax() {
		assertEquals(100, t.vratiPoruke(-5, "a").length);
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(5, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmpty() {
		t.vratiPoruke(5, "");
	}
	
	
	

}
