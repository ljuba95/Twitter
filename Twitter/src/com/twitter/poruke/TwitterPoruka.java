package com.twitter.poruke;
/**
 * Klasa predstavlja Twitter poruku.
 * Ima naziv korisnika i sadrzaj poruke.
 * @author ljuba95
 *
 */
public class TwitterPoruka {
	/**
	 * Ime korisnika kao string.
	 */
	private String korisnik;
	/**
	 * Sadrzaj poruke kao string.
	 */
	private String poruka;
	
	/**
	 * Metoda vraca ime korisnika.
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Metoda postavlja novu vrednost za atribut korisnik.
	 * @param korisnik Novo ime korisnika
	 * @throws java.lang.RuntimeException ako je uneto ime:
	 * <ul>
	 * 	<li>
	 *  null
	 *  </li>
	 *  <li>
	 * 	prazan String.
	 * 	</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * Metoda vraca sadrzaj poruke.
	 * @return sadrzaj poruke
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 * Metoda postavlja novu vrednost za atribut poruka.
	 * @param poruka Nova poruka
	 * @throws java.lang.RuntimeException ako je uneta poruka:
	 * <ul>
	 * 	<li>
	 *  null
	 *  </li>
	 *  <li>
	 * 	duza od 140 karaktera.
	 * 	</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || this.poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * Redefinisana metoda toString.
	 * @return korisnik + poruka
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
