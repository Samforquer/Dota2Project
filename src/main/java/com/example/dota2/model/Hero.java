package com.example.dota2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public class Hero {

    private int id;
    @JsonProperty("localized_name")
    private String name;
    @JsonProperty("primary_attr")
    private String primaryAttr;
    @JsonProperty("attack_type")
    private String attackType;
    @JsonProperty("1_pick")
    //Herald = 1
    private int pick1;
    @JsonProperty("2_pick")
    //Guardian = 2
    private int pick2;
    @JsonProperty("3_pick")
    //Crusader = 3
    private int pick3;
    @JsonProperty("4_pick")
    //Archon = 4
    private int pick4;
    @JsonProperty("5_pick")
    //Legend = 5
    private int pick5;
    @JsonProperty("6_pick")
    //Ancient = 6
    private int pick6;
    @JsonProperty("7_pick")
    //Divine = 7
    private int pick7;
    @JsonProperty("8_pick")
    //Immortal = 8
    private int pick8;
    @JsonProperty("pro_pick")
    private int proPicked;
    @JsonProperty("pro_win")
    private int proWins;
    @JsonProperty("1_win")
    private int win1;
    @JsonProperty("2_win")
    private int win2;
    @JsonProperty("3_win")
    private int win3;
    @JsonProperty("4_win")
    private int win4;
    @JsonProperty("5_win")
    private int win5;
    @JsonProperty("6_win")
    private int win6;
    @JsonProperty("7_win")
    private int win7;
    @JsonProperty("8_win")
    private int win8;
    @JsonProperty("heroComplexity")
    private int heroComplexity;
    @JsonProperty("heroPosition")
    private List<Integer> heroPosition;

    public Hero(int id, String name, String primaryAttr, String attackType, int heroComplexity, List<Integer> heroPosition) {
        this.id = id;
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
}



