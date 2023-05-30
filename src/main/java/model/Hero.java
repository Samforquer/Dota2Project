package model;
public class Hero {

    private int id;
    private String name;
    private String attributeType;
    private String attackType;
    private int pick1;
    private int pick2;
    private int pick3;
    private int pick4;
    private int pick5;
    private int pick6;
    private int pick7;
    private int pick8;
    private int proPicked;
    private int proWins;
    private int win1;
    private int win2;
    private int win3;
    private int win4;
    private int win5;
    private int win6;
    private int win7;
    private int win8;
    private int heroComplexity;
    private int heroPosition;

    public Hero(int id, String name, String attributeType, String attackType, int heroComplexity, int heroPosition) {
        this.id = id;
        this.name = name;
        this.attributeType = attributeType;
        this.attackType = attackType;
        this.heroComplexity = heroComplexity;
        this.heroPosition = heroPosition;
    }
    public Hero() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public int getPick1() {
        return pick1;
    }

    public void setPick1(int pick1) {
        this.pick1 = pick1;
    }

    public int getPick2() {
        return pick2;
    }

    public void setPick2(int pick2) {
        this.pick2 = pick2;
    }

    public int getPick3() {
        return pick3;
    }

    public void setPick3(int pick3) {
        this.pick3 = pick3;
    }

    public int getPick4() {
        return pick4;
    }

    public void setPick4(int pick4) {
        this.pick4 = pick4;
    }

    public int getPick5() {
        return pick5;
    }

    public void setPick5(int pick5) {
        this.pick5 = pick5;
    }

    public int getPick6() {
        return pick6;
    }

    public void setPick6(int pick6) {
        this.pick6 = pick6;
    }

    public int getPick7() {
        return pick7;
    }

    public void setPick7(int pick7) {
        this.pick7 = pick7;
    }

    public int getPick8() {
        return pick8;
    }

    public void setPick8(int pick8) {
        this.pick8 = pick8;
    }

    public int getProPicked() {
        return proPicked;
    }

    public void setProPicked(int proPicked) {
        this.proPicked = proPicked;
    }

    public int getProWins() {
        return proWins;
    }

    public void setProWins(int proWins) {
        this.proWins = proWins;
    }

    public int getWin1() {
        return win1;
    }

    public void setWin1(int win1) {
        this.win1 = win1;
    }

    public int getWin2() {
        return win2;
    }

    public void setWin2(int win2) {
        this.win2 = win2;
    }

    public int getWin3() {
        return win3;
    }

    public void setWin3(int win3) {
        this.win3 = win3;
    }

    public int getWin4() {
        return win4;
    }

    public void setWin4(int win4) {
        this.win4 = win4;
    }

    public int getWin5() {
        return win5;
    }

    public void setWin5(int win5) {
        this.win5 = win5;
    }

    public int getWin6() {
        return win6;
    }

    public void setWin6(int win6) {
        this.win6 = win6;
    }

    public int getWin7() {
        return win7;
    }

    public void setWin7(int win7) {
        this.win7 = win7;
    }

    public int getWin8() {
        return win8;
    }

    public void setWin8(int win8) {
        this.win8 = win8;
    }

    public int getHeroComplexity() {
        return heroComplexity;
    }

    public void setHeroComplexity(int heroComplexity) {
        this.heroComplexity = heroComplexity;
    }

    public int getHeroPosition() {
        return heroPosition;
    }

    public void setHeroPosition(int heroPosition) {
        this.heroPosition = heroPosition;
    }
//TODO add toString()
}



