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
        printHeroItems(heroes);
        return heroes;
    }

    private void printHeroItems(List<Hero> heroes) {
        for (Hero hero : heroes) {
            System.out.println("ID: " + hero.getId());
            System.out.println("Name: " + hero.getName());
            System.out.println("Attribute Type: " + hero.getPrimaryAttr());
            System.out.println("Attack Type: " + hero.getAttackType());
            System.out.println("Pick1: " + hero.getPick1());
            System.out.println("Pick2: " + hero.getPick2());
            // Print other hero properties as needed
            System.out.println("-----------------------------");
        }
    }
}
