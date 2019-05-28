package ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AktyvumoBaluSistema {

    private ArrayList<Destytojas> destytojai = new ArrayList();
    private ArrayList<Grupe> grupes = new ArrayList();
    private ArrayList<Kursas> kursai = new ArrayList();
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
    public Set<Kursas> gautiKursusPagalStudenta(int stud) {
        for (Grupe g : getGrupes()) {
            for (Studentas s : g.getStudentai()) {
                if (s.getKodas() == stud) {
                    System.out.println(g + "---" + s + "----" + g.getKursai());
                    return g.getKursai();
                }
            }
        }
        return null;
    }
    
    public void pridetiIkelima(Studentas stud, Uzduotis uzd) {
          Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Ikelimas ikelimas = new Ikelimas(1, stud);
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
          Session s = sf.openSession();
        // Transaction t = s.beginTransaction();
        ArrayList<Kursas> kursuSarasas = null;
        try {
            kursuSarasas = new ArrayList<Kursas>(s.createQuery("FROM Kursas").list());
            for (Kursas k : kursuSarasas) {
                if (k.getTrumpasPav().equals(kodas)) {
                    return k;
                }
            }
            //  t.commit();

        } catch (Exception e) {
            //  t.rollback();
        }
          s.close();
        return null;
    }

     public Uzduotis gautiUzduoti(int kodas) {
         Session s = sf.openSession();
        // Transaction t = s.beginTransaction();
        ArrayList<Uzduotis> uzduotys = null;
        try {
            uzduotys = new ArrayList<Uzduotis>(s.createQuery("FROM Uzduotis").list());
            for (Uzduotis u : uzduotys) {
                if (u.getKodas()==kodas) {
                    System.out.println(u);
                    return u;
                }
            }
            //  t.commit();

        } catch (Exception e) {
            //  t.rollback();
        }
          s.close();
        return null;
    }
    public Ikelimas gautiIkelima(int kodas) {
          Session s = sf.openSession();
        // Transaction t = s.beginTransaction();
        ArrayList<Ikelimas> ikelimai = null;
        try {
            ikelimai = new ArrayList<Ikelimas>(s.createQuery("FROM Ikelimas").list());
            for (Ikelimas u : ikelimai) {
                if (u.getNumeris()==kodas) {
                   // System.out.println(u);
                    return u;
                }
            }
            //  t.commit();

        } catch (Exception e) {
            //  t.rollback();
        }
          s.close();
        return null;
    }
    public ArrayList<Grupe> getGrupes() {
          Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        ArrayList<Grupe> grupiuSarasas = null;
        try {
            grupiuSarasas = new ArrayList<Grupe>(s.createQuery("FROM Grupe").list());
            // t.commit();
        } catch (Exception e) {
            //  t.rollback();
        }
         s.close();
        return grupiuSarasas;
    }

    public int GautiDestytojuSkaiciu() {
           Session s = sf.openSession();
        // Transaction t = s.beginTransaction();
        int destytojuSkaicius = 0;
        try {
            destytojuSkaicius = (s.createQuery("FROM Destytojas").list().size());
            //   t.commit();
        } catch (Exception e) {
            //   t.rollback();
        }
          s.close();
        return destytojuSkaicius;
    }

    public ArrayList<Destytojas> getDestytojai() {
        Session s = sf.openSession();
        //  Transaction t = s.beginTransaction();
        ArrayList<Destytojas> destytojuSarasas = null;
        try {
            destytojuSarasas = new ArrayList<Destytojas>(s.createQuery("FROM Destytojas").list());
            //    t.commit();
        } catch (Exception e) {
            //   t.rollback();
        }
          s.close();
        return destytojuSarasas;
    }

  
    
    public ArrayList<Kursas> getKursai() {
         Session s = sf.openSession();
        //  Transaction t = s.beginTransaction();
        ArrayList<Kursas> kursuSarasas = null;
        try {
            kursuSarasas = new ArrayList<Kursas>(s.createQuery("FROM Kursas").list());
            //    t.commit();
        } catch (Exception e) {
            //    t.rollback();
        }
         s.close();
        return kursuSarasas;
    }

}
