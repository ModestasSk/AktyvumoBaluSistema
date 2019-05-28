package ds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Uzduotis {
    private int kodas;
    private String statusas;
    private String pavadinimas;
    private String aprasymas;
    private String atsiskaitymoData;
    
    private Set<Ikelimas> ikelimai = new HashSet();

    public Uzduotis(int kodas, String pavadinimas, String atsiskaitymoData) {
        this.kodas = kodas;
        this.statusas = "matoma";
        this.pavadinimas = pavadinimas;
        this.atsiskaitymoData = atsiskaitymoData;
    }

    public Set<Ikelimas> getIkelimai() {
        return ikelimai;
    }
    public Ikelimas gautiIkelima(int numeris){
        for(Ikelimas i: getIkelimai()){
            if(i.getNumeris() == numeris){
                return i;
            }
        }
        return null;
    }
    public void setIkelimai(Set<Ikelimas> ikelimai) {
        this.ikelimai = ikelimai;
    }

    public Uzduotis(int kodas, String statusas, String pavadinimas, String aprasymas, String atsiskaitymoData) {
        this.kodas = kodas;
        this.statusas = statusas;
        this.pavadinimas = pavadinimas;
        this.aprasymas = aprasymas;
        this.atsiskaitymoData = atsiskaitymoData;
    }

    public String getStatusas() {
        return statusas;
    }

    public void setStatusas(String statusas) {
        this.statusas = statusas;
    }

    public String getAprasymas() {
        return aprasymas;
    }

    public void setAprasymas(String aprasymas) {
        this.aprasymas = aprasymas;
    }

    public void setKodas(int kodas) {
        this.kodas = kodas;
    }

    public Uzduotis() {
    }

   
  

    public String isUzrakinta() {
        return statusas;
    }

   

    public int getKodas() {
        return kodas;
    }
    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getAtsiskaitymoData() {
        return atsiskaitymoData;
    }

    public void setAtsiskaitymoData(String atsiskaitymoData) {
        this.atsiskaitymoData = atsiskaitymoData;
    }

  
    
    @Override
    public String toString() {
        return kodas + " " + pavadinimas + " " + statusas;
    }
    
    
    
}
