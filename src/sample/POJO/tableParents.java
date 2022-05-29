package sample.POJO;

public class tableParents {
    public Integer idAbit;
    private String fioMom;
    private String adressMom;
    private String telMom;
    private String workMom;
    private String fioDad;
    private String adressDad;
    private String telDad;
    private String workDad;


    public tableParents(Integer idAbit, String fioMom, String adressMom,
                        String telMom, String workMom, String fioDad, String adressDad,
                 String telDad, String workDad) {
        this.idAbit = idAbit;
        this.fioMom = fioMom;
        this.adressMom = adressMom;
        this.telMom = telMom;
        this.workMom = workMom;
        this.fioDad = fioDad;
        this.adressDad = adressDad;
        this.telDad = telDad;
        this.workDad = workDad;
    }

    public tableParents() {

    }


    public Integer getIdAbit() {
        return idAbit;
    }

    public void setIdAbit(Integer idAbit) {
        this.idAbit = idAbit;
    }

    public String getFioMom() {
        return fioMom;
    }

    public void setFioMom(String fioMom) {
        this.fioMom = fioMom;
    }

    public String getAdressMom() {
        return adressMom;
    }

    public void setAdressMom(String adressMom) {
        this.adressMom = adressMom;
    }

    public String getTelMom() {
        return telMom;
    }

    public void setTelMom(String telMom) {
        this.telMom = telMom;
    }

    public String getWorkMom() {
        return workMom;
    }

    public void setWorkMom(String workMom) {
        this.workMom = workMom;
    }

    public String getFioDad() {
        return fioDad;
    }

    public void setFioDad(String fioDad) {
        this.fioDad = fioDad;
    }

    public String getAdressDad() {
        return adressDad;
    }

    public void setAdressDad(String adressDad) {
        this.adressDad = adressDad;
    }

    public String getTelDad() {
        return telDad;
    }

    public void setTelDad(String telDad) {
        this.telDad = telDad;
    }

    public String getWorkDad() {
        return workDad;
    }

    public void setWorkDad(String workDad) {
        this.workDad = workDad;
    }
}