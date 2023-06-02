package controller;

import dao.HeroDao;
import model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroController {
    private HeroDao heroDao;
@Autowired
    public HeroController(HeroDao heroDao) {
        this.heroDao = heroDao;
    }

    @RequestMapping(path = "/heroes", method = RequestMethod.GET)
    public List<Hero> getHeroes() {
        List<Hero> heroes = heroDao.getHeroes();
        return heroes;
    }
}
