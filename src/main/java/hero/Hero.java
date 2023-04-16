package hero;

public class Hero {

    private String name;
    private int position;
    private String attributeType;
    private String attackType;
    private int complexity;
    private double belowArchonWinRate;
    private double archonWinRate;
    private double legendWinRate;
    private double ancientWinRate;
    private double aboveAncientWinRate;

    // are there any other initial things I need to add here?


    public Hero() {
    }
//HeroName,AttributeType,AttackType,Position,Complexity,WinRateSkill1(UnderArchon),WinrateSkill2(Archon),WinrateSkill3(Legend),WinrateSkill4(Ancient),WinrateSkill5(Divine-Immortal)
    public Hero(String name,String attributeType,  String attackType, int position,  int complexity, double belowArchonWinRate,
                double archonWinRate, double legendWinRate, double ancientWinRate, double aboveAncientWinRate) {
        this.name = name;
        this.attributeType = attributeType;
        this.attackType = attackType;
        this.position = position;
        this.complexity = complexity;
        this.belowArchonWinRate = belowArchonWinRate;
        this.archonWinRate = archonWinRate;
        this.legendWinRate = legendWinRate;
        this.ancientWinRate = ancientWinRate;
        this.aboveAncientWinRate = aboveAncientWinRate;
    }

    public Hero(String heroField, String heroField1, String heroField2, String heroField3, String heroField4, String heroField5, String heroField6, String heroField7, String heroField8, String heroField9) {
    }

    public double getBelowArchonWinRate() {
        return belowArchonWinRate;
    }

    public void setBelowArchonWinRate(double belowArchonWinRate) {
        this.belowArchonWinRate = belowArchonWinRate;
    }

    public double getArchonWinRate() {
        return archonWinRate;
    }

    public void setArchonWinRate(double archonWinRate) {
        this.archonWinRate = archonWinRate;
    }

    public double getLegendWinRate() {
        return legendWinRate;
    }

    public void setLegendWinRate(double legendWinRate) {
        this.legendWinRate = legendWinRate;
    }

    public double getAncientWinRate() {
        return ancientWinRate;
    }

    public void setAncientWinRate(double ancientWinRate) {
        this.ancientWinRate = ancientWinRate;
    }

    public double getAboveAncientWinRate() {
        return aboveAncientWinRate;
    }

    public void setAboveAncientWinRate(double aboveAncientWinRate) {
        this.aboveAncientWinRate = aboveAncientWinRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public double getWinRate() {
        return belowArchonWinRate;
    }

    public void setWinRate(double winRate) {
        this.belowArchonWinRate = winRate;
    }
}

// maybe look into a toString method.
