package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Hero {

    private int id;
    private String name;
    private String attributeType;
    private String attackType;
    private BigDecimal heraldWinRate;
    private BigDecimal guardianWinRate;
    private BigDecimal crusaderWinRate;
    private BigDecimal archonRate;
    private BigDecimal legendWinRate;
    private BigDecimal ancientWinRate;
    private BigDecimal divineWinRate;
    private BigDecimal immortalWinRate;
    private BigDecimal proWinRate;
    private int heroComplexity;
    private int heroPosition;


    public Hero() {
    }

    public Hero(int id, String name, String attributeType, String attackType, BigDecimal heraldWinRate, BigDecimal guardianWinRate,
                BigDecimal crusaderWinRate, BigDecimal archonRate, BigDecimal legendWinRate, BigDecimal ancientWinRate, BigDecimal divineWinRate, BigDecimal immortalWinRate, BigDecimal proWinRate, int heroComplexity, int heroPosition) {
        this.id = id;
        this.name = name;
        this.attributeType = attributeType;
        this.attackType = attackType;
        this.heraldWinRate = heraldWinRate;
        this.guardianWinRate = guardianWinRate;
        this.crusaderWinRate = crusaderWinRate;
        this.archonRate = archonRate;
        this.legendWinRate = legendWinRate;
        this.ancientWinRate = ancientWinRate;
        this.divineWinRate = divineWinRate;
        this.immortalWinRate = immortalWinRate;
        this.proWinRate = proWinRate;
        this.heroComplexity = heroComplexity;
        this.heroPosition = heroPosition;
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

    public BigDecimal getHeraldWinRate() {
        return heraldWinRate;
    }

    public void setHeraldWinRate(BigDecimal heraldWinRate) {
        this.heraldWinRate = heraldWinRate.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getGuardianWinRate() {
        return guardianWinRate;
    }

    public void setGuardianWinRate(BigDecimal guardianWinRate) {
        this.guardianWinRate = guardianWinRate.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getCrusaderWinRate() {
        return crusaderWinRate;
    }

    public void setCrusaderWinRate(BigDecimal crusaderWinRate) {
        this.crusaderWinRate = crusaderWinRate.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getArchonRate() {
        return archonRate;
    }

    public void setArchonRate(BigDecimal archonRate) {
        this.archonRate = archonRate.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getLegendWinRate() {
        return legendWinRate;
    }

    public void setLegendWinRate(BigDecimal legendWinRate) {
        this.legendWinRate = legendWinRate.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getAncientWinRate() {
        return ancientWinRate;
    }

    public void setAncientWinRate(BigDecimal ancientWinRate) {
        this.ancientWinRate = ancientWinRate.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getDivineWinRate() {
        return divineWinRate;
    }

    public void setDivineWinRate(BigDecimal divineWinRate) {
        this.divineWinRate = divineWinRate.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getImmortalWinRate() {
        return immortalWinRate;
    }

    public void setImmortalWinRate(BigDecimal immortalWinRate) {
        this.immortalWinRate = immortalWinRate.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getProWinRate() {
        return proWinRate;
    }

    public void setProWinRate(BigDecimal proWinRate) {
        this.proWinRate = proWinRate.setScale(2, RoundingMode.HALF_UP);
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
}


