package ds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Destytojas implements Comparable<Destytojas>{
    private int kodas;
    private String vardas;
    private String pavarde;
    private Set<Kursas> kursai = new HashSet();

    public Destytojas(int kodas, String vardas, String pavarde) {
        this.kodas = kodas;
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public Destytojas() {
    }

    public void setKodas(int kodas) {
        this.kodas = kodas;
    }

    public void setKursai(Set<Kursas> kursai) {
        this.kursai = kursai;
    }

    public Set<Kursas> getKursai() {
        return kursai;
    }
    
    public Kursas pridetiKursa(String pavadinimas) {
        Kursas kursas = new Kursas(pavadinimas, this);
        kursai.add(kursas);
        return kursas;
    }
    public void priskirtiKursa(Kursas kursas) {
        kursai.add(kursas);
    }
    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public int getKodas() {
        return kodas;
    }

    @Override
    public String toString() {
        return vardas + " " + pavarde + " ("+kodas+")";
    }

    @Override
    public int compareTo(Destytojas o) {
        int rez = (vardas + " " + pavarde).compareTo(o.vardas + " " + o.pavarde);
        if(rez==0) {
            return Integer.compare(kodas, o.kodas);
        }
        return rez;
    }
    
    
}
