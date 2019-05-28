
package ds;

public class Administratorius {
    private int kodas;
    private String slaptazodis;

    public int getKodas() {
        return kodas;
    }

    public void setKodas(int kodas) {
        this.kodas = kodas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    public Administratorius() {
    }

    @Override
    public String toString() {
        return ""+kodas;
    }
    
}
