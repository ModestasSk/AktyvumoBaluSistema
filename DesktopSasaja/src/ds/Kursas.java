package ds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

public class Kursas {

    private String trumpasPav;

    private String pavadinimas;

    private String aprasas;
    private Set<Grupe> grupes = new HashSet();
    private Set<Destytojas> destytojai = new HashSet();
    private Set<Uzduotis> uzduotys = new HashSet();

    public Set<Destytojas> getDestytojai() {
        return destytojai;
    }

    public void setDestytojai(Set<Destytojas> destytojai) {
        this.destytojai = destytojai;
    }

    public Kursas(String pavadinimas, String trumpasPav) {
        this.pavadinimas = pavadinimas;
        this.trumpasPav = trumpasPav;
    }

    public Kursas() {
    }

    public void setGrupes(Set<Grupe> grupes) {
        this.grupes = grupes;
    }

    public Uzduotis gautiUzduoti(int kodas) {
        for (Uzduotis u : getUzduotys()) {
            if (u.getKodas() == kodas) {
                return u;
            }
        }
        return null;
    }

    public void setUzduotys(Set<Uzduotis> uzduotys) {
        this.uzduotys = uzduotys;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public void setTrumpasPav(String trumpasPav) {
        this.trumpasPav = trumpasPav;
    }

    public void setAprasas(String aprasas) {
        this.aprasas = aprasas;
    }

    public Kursas(String pavadinimas, Destytojas destytojas) {
        this.pavadinimas = pavadinimas;
        this.destytojai.add(destytojas);
    }

    public Kursas(String trmpPav, String pav, String ap) {
        pavadinimas = pav;
        trumpasPav = trmpPav;
        aprasas = ap;
    }

    public String getTrumpasPav() {
        return trumpasPav;
    }

    public void pridetiGrupe(Grupe grupe) {
        grupes.add(grupe);
    }

    public void salintiUzduoti(Uzduotis uzduotis) {
        this.uzduotys.remove(uzduotis);
    }

    public Set<Uzduotis> getUzduotys() {
        return uzduotys;
    }

    public void pridetiDestytoja(Destytojas destytojas) {
        this.destytojai.add(destytojas);
    }

    @Override
    public String toString() {
        return pavadinimas + " (" + trumpasPav + ")";
    }

    public Set<Grupe> getGrupes() {
        return grupes;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public String getAprasas() {
        return aprasas;
    }

}
