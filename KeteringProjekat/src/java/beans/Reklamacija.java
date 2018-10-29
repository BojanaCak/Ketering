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
public class Reklamacija {
    private String telefon;
    private String opis;
    private int IdReklamacije;
    private int IdNarudzbenice;
    private String username;
    
    public int getIdReklamacije() {
        return IdReklamacije;
    }

    public void setIdReklamacije(int IdReklamacije) {
        this.IdReklamacije = IdReklamacije;
    }

    public int getIdNarudzbenice() {
        return IdNarudzbenice;
    }

    public void setIdNarudzbenice(int IdNarudzbenice) {
        this.IdNarudzbenice = IdNarudzbenice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

}
