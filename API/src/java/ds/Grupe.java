package ds;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grupe {
    @Expose
    private String kodas;
    @Expose
    private int stojimoMetai;
    private Set<Studentas> studentai = new HashSet();
    private Set<Kursas> kursai = new HashSet();

    public void setStudentai(Set<Studentas> studentai) {
        this.studentai = studentai;
    }

    public Grupe() {
    }

    public Set<Kursas> getKursai() {
        return kursai;
    }

    public void setKursai(Set<Kursas> kursai) {
        this.kursai = kursai;
    }

    public String getKodas() {
        return kodas;
    }

    public void salintiStudenta(int kodas) {
        studentai.remove(gautiStudenta(kodas));
    }

    public Studentas gautiStudenta(long kodas) {
        for (Studentas s : studentai) {
            if (s.getKodas() == kodas) {
                return s;
            }
        }
        return null;
    }

    public void setKodas(String kodas) {
        this.kodas = kodas;
    }

    public int getStojimoMetai() {
        return stojimoMetai;
    }

    public void setStojimoMetai(int stojimoMetai) {
        this.stojimoMetai = stojimoMetai;
    }

    public Grupe(String kodas, int stojimoMetai) {
        this.kodas = kodas;
        this.stojimoMetai = stojimoMetai;
    }

    public Set<Studentas> getStudentai() {
        return studentai;
    }

    @Override
    public String toString() {
        return kodas;
    }

}
