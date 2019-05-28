
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ds.AktyvumoBaluSistema;
import ds.Destytojas;
import ds.Grupe;
import ds.Ikelimas;
import ds.Kursas;
import ds.Studentas;
import ds.Uzduotis;
import static java.lang.reflect.Modifier.TRANSIENT;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Kontroleris {

    @RequestMapping(value = "studentas={studid}")
    @ResponseBody
    public String studentas(@PathVariable int studid) {
        AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
        Set<Kursas> list = abs.gautiKursusPagalStudenta(studid);
        System.out.println(list);
        final Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .excludeFieldsWithModifiers(TRANSIENT) // STATIC|TRANSIENT in the default configuration
                .create();
        String json = gson.toJson(list);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "kursas={kursid}")
    @ResponseBody
    public String kursas(@PathVariable String kursid) {
        AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
        Kursas kursas = abs.gautiKursa(kursid);
        Set<Uzduotis> list = kursas.getUzduotys();
        final Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .excludeFieldsWithModifiers(TRANSIENT) // STATIC|TRANSIENT in the default configuration
                .create();
        String json = gson.toJson(list);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "uzduotis={uzdid}")
    @ResponseBody
    public String uzduotis(@PathVariable int uzdid) {
        AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
        Uzduotis uzduotis = abs.gautiUzduoti(uzdid);

        final Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation().serializeNulls()
                .create();
        String json = gson.toJson(uzduotis);
        System.out.println(json);

        return json;
    }

    @RequestMapping(value = "ikelimas={ikelimoid}")
    @ResponseBody
    public String ikelimas(@PathVariable int ikelimoid) {
        AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
        Ikelimas ikelimas = abs.gautiIkelima(ikelimoid);
        return ikelimas.toString();
    }
}
