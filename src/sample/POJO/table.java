package sample.POJO;

public class table {
    public Integer idAbit;
    private String fioAbit;
    private String birthdayAbit;
    private String adressAbit;
    private String telAbit;
    private String pasportAbit;
    private String fioMom;
    private String adressMom;
    private String telMom;
    private String workMom;
    private String fioDad;
    private String adressDad;
    private String telDad;
    private String workDad;


    public table(Integer idAbit, String fioAbit, String birthdayAbit, String adressAbit, String telAbit) {
        this.idAbit = idAbit;
        this.fioAbit = fioAbit;
        this.birthdayAbit = birthdayAbit;
        this.adressAbit = adressAbit;
        this.telAbit = telAbit;
    }

    public table() {

    }


    public Integer getIdAbit() {
        return idAbit;
    }

    public void setIdAbit(Integer idAbit) {
        this.idAbit = idAbit;
    }

    public String getFioAbit() {
        return fioAbit;
    }

    public void setFioAbit(String fioAbit) {
        this.fioAbit = fioAbit;
    }

    public String getBirthdayAbit() {
        return birthdayAbit;
    }

    public void setBirthdayAbit(String birthdayAbit) {
        this.birthdayAbit = birthdayAbit;
    }

    public String getAdressAbit() {
        return adressAbit;
    }

    public void setAdressAbit(String adressAbit) {
        this.adressAbit = adressAbit;
    }

    public String getTelAbit() {
        return telAbit;
    }

    public void setTelAbit(String telAbit) {
        this.telAbit = telAbit;
    }

    public String getPasportAbit() {
        return pasportAbit;
    }

    public void setPasportAbit(String pasportAbit) {
        this.pasportAbit = pasportAbit;
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