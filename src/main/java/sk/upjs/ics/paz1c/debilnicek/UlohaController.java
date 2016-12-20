package sk.upjs.ics.paz1c.debilnicek;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UlohaController {
    private UlohaDao ulohaDao = UlohaDaoFactory.INSTANCE.getUlohaDao();
    
    @GetMapping("/ulohy")
    public List<Uloha> dajVsetky() {
        return ulohaDao.dajUlohy();
    }
    
    @PostMapping("/ulohy")
    public void pridaj(Uloha uloha) {
        ulohaDao.saveOrUpdate(uloha);
    }
}
