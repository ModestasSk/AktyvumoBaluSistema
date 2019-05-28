package ds;

import com.google.gson.annotations.Expose;

public class Ikelimas {
    @Expose
    private int numeris;
    @Expose
    private int ivertinimas;
    @Expose
    private String komentaras;
    @Expose
    private Studentas studentas;
    
    public Ikelimas(int kodas, Studentas studentas) {
        this.numeris = kodas;
        this.studentas = studentas;
    }

    
 
    public int getNumeris() {
        return numeris;
    }

    public void setNumeris(int numeris) {
        this.numeris = numeris;
    }

    public int getIvertinimas() {
        return ivertinimas;
    }

 

    public void setStudentas(Studentas studentas) {
        this.studentas = studentas;
    }

    public Ikelimas() {
    }

    public String getKomentaras() {
        return komentaras;
    }

    public void setKomentaras(String komentaras) {
        this.komentaras = komentaras;
    }

    public void setIvertinimas(int ivertinimas) {
        this.ivertinimas = ivertinimas;
    }
    
    public Studentas getStudentas() {
        return studentas;
    }

    @Override
    public String toString() {
        
        return "{\"numeris\":"+numeris+",\"ivertinimas\":"+ivertinimas+",\"komentaras\":"+"\""+komentaras+"\""+",\"studentas\":"+studentas.getKodas()+"}";
    }
    
}
