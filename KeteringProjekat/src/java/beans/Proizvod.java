/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author korisnik
 */
public class Proizvod {

    
    private String imeProizvoda;
    private int kolicina;
    private int zalihe;
    private int cena;
    private String kategorija;
    private int idProizvoda;
    
    public Proizvod(String imeProizvoda, int kolicina, int cena, String kategorija, int idProizvoda,int zalihe) {
        this.imeProizvoda = imeProizvoda;
        this.kolicina = kolicina;
        this.cena = cena;
        this.kategorija = kategorija;
        this.idProizvoda = idProizvoda;
        this.zalihe = zalihe;
    }
    public Proizvod(){}
    
    public int getIdProizvoda() {
        return idProizvoda;
    }

    public void setIdProizvoda(int idProizvoda) {
        this.idProizvoda = idProizvoda;
    }
    
    
    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }
    
    
       
    public String getImeProizvoda() {
        return imeProizvoda;
    }

    public void setImeProizvoda(String imeProizvoda) {
        this.imeProizvoda = imeProizvoda;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getZalihe() {
        return zalihe;
    }

    public void setZalihe(int zalihe) {
        this.zalihe = zalihe;
    }
    
    public int getCena() {
        return cena;
    }
    
    public void setCena(int cena) {
        this.cena = cena;
    }
}
