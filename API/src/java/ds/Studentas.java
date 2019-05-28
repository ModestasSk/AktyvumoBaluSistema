package ds;

import com.google.gson.annotations.Expose;

public class Studentas {
    @Expose
    private int kodas;
    @Expose
    private String vardas;
    @Expose
    private String pavarde;
    
    public Studentas() {
    }
    public Studentas(int kodas, String vardas, String pavarde) {
        this.kodas = kodas;
        this.vardas = vardas;
        this.pavarde = pavarde;
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

    public void setKodas(int kodas) {
        this.kodas = kodas;
    }

   

    @Override
    public String toString() {
        return kodas + " " + vardas + ". " + pavarde;
    }
    
    
}
