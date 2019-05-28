package ds;
public class Ikelimas {
    private int numeris;
    private int ivertinimas;
    private String komentaras;
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
        String[] strings = studentas.toString().split(" ");
        return numeris + " " + strings[1] + " " +strings[2]; //To change body of generated methods, choose Tools | Templates.
    }
    
}
