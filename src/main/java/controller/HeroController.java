package controller;


import dao.HeroDao;
import hero.Hero;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroController {
    private HeroDao heroDao;

    @RequestMapping(path = "https://api.opendota.com/api/heroes", method = RequestMethod.GET)
    public List<Hero> getHeroes(){
        return heroDao.getHeroes();
    }
}
