package sk.upjs.ics.paz1c.debilnicek;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UlohaController {
    @Autowired
    private UlohaDao ulohaDao;
    
    @GetMapping("/ulohy")
    public List<Uloha> dajVsetky() {
        return ulohaDao.dajUlohy();
    }
    
    @PostMapping("/ulohy")
    public void pridaj(@RequestBody Uloha uloha) {
        ulohaDao.saveOrUpdate(uloha);
    }
    
    @GetMapping("/ulohy/{id}")
    public Uloha dajUlohu(@PathVariable Long id) {
        List<Uloha> ulohy = ulohaDao.dajUlohy();
        for(Uloha u : ulohy) {
            if(u.getId().equals(id)) {
                return u;
            }
        }
        throw new UlohaNotFoundException("Uloha " + id + " neexistuje");
    }

    public void setUlohaDao(UlohaDao ulohaDao) {
        this.ulohaDao = ulohaDao;
    }
    
    
}
