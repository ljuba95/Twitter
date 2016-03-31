package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa Twitter.
 * Sadrzi listu twitter poruka.
 * @author ljuba95
 *
 */
public class Twitter {
	/**
	 * Lista objekata klase TwitterPoruka kao {@link LinkedList}
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * Get metoda koja vraca listu poruka.
	 * @return Lista TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	/**
	 * Metoda za unos nove poruke u listu.
	 * @param korisnik Ime korisnika
	 * @param poruka Sadrzaj poruke
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda koja vraca sve poruke koje sadrze uneti tag.
	 * @throws java.lang.RuntimeException ako je uneti tag:
	 * <ul>
	 * 	<li>
	 *  null
	 *  </li>
	 *  <li>
	 * 	prazan String.
	 * 	</li>
	 * </ul>
	 * @param maxBroj Maksimalan broj poruka koje vraca.
	 * @param tag Tag na osnovu kog se pretrazuje.
	 * @return Niz TwitterPoruka
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++){
			if (poruke.get(i).getPoruka().contains(tag))
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else{
					break;
				}
		}
		return rezultat;
	}
}