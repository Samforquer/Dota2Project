package controller;
import dao.HeroDao;
import model.Hero;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroController {
    private HeroDao heroDao;

    public HeroController(HeroDao heroDao){
        this.heroDao = heroDao;
    }
    @RequestMapping(path = "/heroes", method = RequestMethod.GET)
    public List<Hero> getHeroes(){
        return heroDao.getHeroes();
    }
}
