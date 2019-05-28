package ds;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AktyvumoBaluSistema {

    private ArrayList<Destytojas> destytojai = new ArrayList();
    private ArrayList<Grupe> grupes = new ArrayList();
    private ArrayList<Kursas> kursai = new ArrayList();
    private Destytojas destytojas = new Destytojas();
    SessionFactory sf = null;

    public AktyvumoBaluSistema() {
        sf = new Configuration().configure().buildSessionFactory();
    }

    public Studentas gautiStudenta(int kodas) {
        Studentas stud = new Studentas();
        for (Grupe g : getGrupes()) {
            for (Studentas s : g.getStudentai()) {
                if (s.getKodas() == kodas) {
                    return s;
                }
            }
        }
        return null;
    }

    public Uzduotis gautiUzduoti(int kodas) {
        Session s = sf.openSession();
        ArrayList<Uzduotis> uzduotys = null;
        try {
            uzduotys = new ArrayList<Uzduotis>(s.createQuery("FROM Uzduotis").list());
            for (Uzduotis u : uzduotys) {
                if (u.getKodas() == kodas) {
                    System.out.println(u);
                    return u;
                }
            }
        } catch (Exception e) {
        }
        s.close();
        return null;
    }

    public Destytojas getDestytojas() {
        return destytojas;
    }

    public void setDestytojas(Destytojas destytojas) {
        this.destytojas = destytojas;
    }

    public void pridetiDestytoja(int kodas, String vardas, String pavarde) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        try {
            Destytojas destytojas = new Destytojas(kodas, vardas, pavarde);
            s.save(destytojas);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        s.close();
    }

    public Grupe pridetiGrupe(int metai, String kodas) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Grupe grupe = null;
        try {
            grupe = new Grupe(kodas, metai);
            s.save(grupe);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        s.close();
        return grupe;
    }

    public Kursas pridetiKursa(String pavadinimas, String trumpasPav, String aprasymas) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Kursas kursas = null;
        try {
            kursas = new Kursas(trumpasPav, pavadinimas, aprasymas);
            s.save(kursas);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        s.close();
        return kursas;
    }

    public void priskirtiStudentaPrieGrupes(Grupe g, Studentas stud) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        g.getStudentai().add(stud);
        try {
            s.save(stud);
            s.update(g);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        s.close();
    }

    public void priskirtiUzduotiPrieKurso(Uzduotis uzd, Kursas kurs) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        try {
            s.save(uzd);
            s.merge(kurs);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
        s.close();
    }

    public void priskirtiGrupePrieKurso(Grupe g, Kursas k) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        k.getGrupes().add(g);
        try {
            s.merge(k);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
        s.close();
    }

    public void pridetiIkelima(Studentas stud, Uzduotis uzd) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Ikelimas ikelimas = new Ikelimas(2, stud);
        uzd.getIkelimai().add(ikelimas);
        try {
            s.save(ikelimas);
            s.merge(uzd);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
        s.close();
    }

    public void priskirtiDestytojaPrieKurso(Destytojas d, Kursas k) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        d.getKursai().add(k);
        try {
            s.saveOrUpdate(d);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
        s.close();
    }

    public void AtnaujintiUzduoti(Uzduotis u) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        try {
            s.merge(u);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        s.close();
    }

    public void AtnaujintiIvertinima(Ikelimas i) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        try {
            s.merge(i);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        s.close();
    }

    public void salintiDestytoja(int kodas) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Destytojas destytojas = null;
        try {
            destytojas = gautiDestytoja(kodas);
            s.delete(destytojas);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        s.close();
    }

    public void salintiGrupe(String kodas) {
        grupes.remove(gautiGrupe(kodas));
    }

    public void salintiKursa(String kodas) {
        kursai.remove(gautiKursa(kodas));
    }

    public Destytojas gautiDestytoja(int kodas) {
        for (Destytojas d : getDestytojai()) {
            if (d.getKodas() == kodas) {
                return d;
            }
        }
        return null;
    }

    public Grupe gautiGrupe(String kodas) {
        for (Grupe g : getGrupes()) {
            if (g.getKodas().equals(kodas)) {
                return g;
            }
        }
        return null;
    }

    public Kursas gautiKursa(String kodas) {
        for (Kursas k : getKursai()) {
            if (k.getTrumpasPav().equals(kodas)) {
                return k;
            }
        }
        return null;
    }

    public ArrayList<Grupe> getGrupes() {
        Session s = sf.openSession();
        ArrayList<Grupe> grupiuSarasas = null;
        try {
            grupiuSarasas = new ArrayList<Grupe>(s.createQuery("FROM Grupe").list());
        } catch (Exception e) {
        }
        s.close();
        return grupiuSarasas;
    }

    public int GautiDestytojuSkaiciu() {
        Session s = sf.openSession();
        int destytojuSkaicius = 0;
        try {
            destytojuSkaicius = (s.createQuery("FROM Destytojas").list().size());
        } catch (Exception e) {
        }
        s.close();
        return destytojuSkaicius;
    }

    public ArrayList<Destytojas> getDestytojai() {
        Session s = sf.openSession();
        ArrayList<Destytojas> destytojuSarasas = null;
        try {
            destytojuSarasas = new ArrayList<Destytojas>(s.createQuery("FROM Destytojas").list());
        } catch (Exception e) {
        }
        s.close();
        return destytojuSarasas;
    }

    public ArrayList<Kursas> getKursai() {
        Session s = sf.openSession();
        ArrayList<Kursas> kursuSarasas = null;
        try {
            kursuSarasas = new ArrayList<Kursas>(s.createQuery("FROM Kursas").list());
        } catch (Exception e) {
        }
        s.close();
        return kursuSarasas;
    }

    public ArrayList<Administratorius> getAdministratoriai() {
        Session s = sf.openSession();
        ArrayList<Administratorius> administratoriuSarasas = null;
        try {
            administratoriuSarasas = new ArrayList<Administratorius>(s.createQuery("FROM Administratorius").list());
        } catch (Exception e) {
        }
        s.close();
        return administratoriuSarasas;
    }

    public Administratorius gautiAdministratoriu(int kodas) {
        for (Administratorius a : getAdministratoriai()) {
            if (a.getKodas() == kodas) {
                return a;
            }
        }
        return null;
    }

}
