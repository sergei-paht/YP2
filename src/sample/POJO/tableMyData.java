package sample.POJO;

public class tableMyData {


    public Integer idAbit;
    private String pasportAbit;


    public tableMyData(Integer idAbit, String pasportAbit) {
        this.idAbit = idAbit;
        this.pasportAbit = pasportAbit;
    }

    public tableMyData() {

    }


    public Integer getIdAbit() {
        return idAbit;
    }

    public void setIdAbit(Integer idAbit) {
        this.idAbit = idAbit;
    }

    public String getPasportAbit() {
        return pasportAbit;
    }

    public void setPasportAbit(String pasportAbit) {
        this.pasportAbit = pasportAbit;
    }


}