package com.example.dota2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Hero{
    private int id;
    @JsonProperty("img")
    private String img;
    @JsonProperty("localized_name")
    private String name;
    @JsonProperty("primary_attr")
    private String primaryAttr;
    @JsonProperty("attack_type")
    private String attackType;
    @JsonProperty("1_pick")
    //Herald = 1
    private double pick1;
    @JsonProperty("2_pick")
    //Guardian = 2
    private double pick2;
    @JsonProperty("3_pick")
    //Crusader = 3
    private double pick3;
    @JsonProperty("4_pick")
    //Archon = 4
    private double pick4;
    @JsonProperty("5_pick")
    //Legend = 5
    private double pick5;
    @JsonProperty("6_pick")
    //Ancient = 6
    private double pick6;
    @JsonProperty("7_pick")
    //Divine = 7
    private double pick7;
    @JsonProperty("8_pick")
    //Immortal = 8
    private double pick8;
    @JsonProperty("pro_pick")
    private double proPicked;
    @JsonProperty("pro_win")
    private double proWins;
    @JsonProperty("1_win")
    private double win1;
    @JsonProperty("2_win")
    private double win2;
    @JsonProperty("3_win")
    private double win3;
    @JsonProperty("4_win")
    private double win4;
    @JsonProperty("5_win")
    private double win5;
    @JsonProperty("6_win")
    private double win6;
    @JsonProperty("7_win")
    private double win7;
    @JsonProperty("8_win")
    private double win8;
    @JsonProperty("heroComplexity")
    private int heroComplexity;
    @JsonProperty("heroPosition")
    private List<Integer> heroPosition;

    public Hero(int id, String img, String name, String primaryAttr, String attackType, int heroComplexity, List<Integer> heroPosition) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.primaryAttr=primaryAttr;
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

    public String getPrimaryAttr() {
        return primaryAttr;
    }

    public void setPrimaryAttr(String primaryAttr) {
        this.primaryAttr = primaryAttr;
    }


    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public double getPick1() {
        return pick1;
    }

    public double getPick2() {
        return pick2;
    }

    public double getPick3() {
        return pick3;
    }

    public double getPick4() {
        return pick4;
    }

    public double getPick5() {
        return pick5;
    }

    public double getPick6() {
        return pick6;
    }

    public double getPick7() {
        return pick7;
    }

    public double getPick8() {
        return pick8;
    }

    public double getProPicked() {
        return proPicked;
    }

    public double getProWins() {
        return proWins;
    }

    public double getWin1() {
        return win1;
    }

    public double getWin2() {
        return win2;
    }

    public double getWin3() {
        return win3;
    }

    public double getWin4() {
        return win4;
    }

    public double getWin5() {
        return win5;
    }

    public double getWin6() {
        return win6;
    }

    public double getWin7() {
        return win7;
    }

    public double getWin8() {
        return win8;
    }

    public int getHeroComplexity() {
        return heroComplexity;
    }

    public void setHeroComplexity(int heroComplexity) {
        this.heroComplexity = heroComplexity;
    }

    public List<Integer> getHeroPosition() {
        return heroPosition;
    }

    public void setHeroPosition(List<Integer> heroPosition) {
        this.heroPosition = heroPosition;
    }

    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attributeType='" + primaryAttr + '\'' +
                ", attackType='" + attackType + '\'' +
                ", pick1=" + pick1 +
                ", win1=" + win1 +
                ", pick2=" + pick2 +
                ", win2=" + win2 +
                ", pick3=" + pick3 +
                ", win3=" + win3 +
                ", pick4=" + pick4 +
                ", win4=" + win4 +
                ", pick5=" + pick5 +
                ", win5=" + win5 +
                ", pick6=" + pick6 +
                ", win6=" + win6 +
                ", pick7=" + pick7 +
                ", win7=" + win7 +
                ", pick8=" + pick8 +
                ", win8=" + win8 +
                ", proPicked=" + proPicked +
                ", proWins=" + proWins +
                ", heroComplexity=" + heroComplexity +
                ", heroPosition=" + heroPosition +
                '}';
    }

    public double getHeraldWinRate(){
        return getWin1()/getPick1()*100;
    }
    public double getGuardianWinRate(){
        return getWin2()/getPick2()*100;
    }
    public double getCrusaderWinRate(){
        return getWin3()/getPick3()*100;
    }
    public double getArchonWinRate(){
        return getWin4()/getPick4()*100;
    }
    public double getLegendWinRate(){
        return getWin5()/getPick5()*100;
    }
    public double getAncientWinRate(){
        return getWin6()/getPick6()*100;
    }
    public double getDivineWinRate(){
        return getWin7()/getPick7()*100;
    }
    public double getImmortalWinRate(){
        return getWin8()/getPick8()*100;
    }
    public double getProWinRate(){
        return getProWins()/getProPicked()*100;
    }


}



