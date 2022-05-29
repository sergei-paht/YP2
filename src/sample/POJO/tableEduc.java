package sample.POJO;

public class tableEduc {
    public Integer idAbit;
    private String levelLastEducation;
    private String numberAtestat;
    private String defoultBallAtestat;
    private String specialnost;

    public tableEduc(Integer idAbit, String levelLastEducation, String numberAtestat, String defoultBallAtestat, String specialnost) {
        this.idAbit = idAbit;
        this.levelLastEducation = levelLastEducation;
        this.numberAtestat = numberAtestat;
        this.defoultBallAtestat = defoultBallAtestat;
        this.specialnost = specialnost;
    }

    public tableEduc() {

    }

    public Integer getIdAbit() {
        return idAbit;
    }

    public void setIdAbit(Integer idAbit) {
        this.idAbit = idAbit;
    }
    public String getLevelLastEducation() {
        return levelLastEducation;
    }

    public void setLevelLastEducation(String levelLastEducation) {
        this.levelLastEducation = levelLastEducation;
    }

    public String getNumberAtestat() {
        return numberAtestat;
    }

    public void setNumberAtestat(String numberAtestat) {
        this.numberAtestat = numberAtestat;
    }

    public String getDefoultBallAtestat() {
        return defoultBallAtestat;
    }

    public void setDefoultBallAtestat(String defoultBallAtestat) {
        this.defoultBallAtestat = defoultBallAtestat;
    }

    public String getSpecialnost() {
        return specialnost;
    }

    public void setSpecialnost(String specialnost) {
        this.specialnost = specialnost;
    }


}
