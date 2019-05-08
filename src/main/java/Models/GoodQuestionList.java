package Models;

public class GoodQuestionList {

    private String NazwaPytania;
    private String WybranaOdpowiedz;
    private boolean isGood;
    private String wynik;

    public GoodQuestionList(String nazwaPytania, String wybranaOdpowiedz, boolean isGood) {
        this.NazwaPytania = nazwaPytania;
        this.WybranaOdpowiedz = wybranaOdpowiedz;
        this.isGood = isGood;
        if(this.isGood) {
            this.wynik = "Poprawna odpowiedz";
        }
        else{
            this.wynik = "Zła odpwiedz";
        }
    }

    public GoodQuestionList() {

        this.NazwaPytania = "Unknow";
        this.WybranaOdpowiedz = "Unknow";
        this.isGood = false;
        if(this.isGood) {
            this.wynik = "Poprawna odpowiedz";
        }
        else{
            this.wynik = "Zła odpwiedz";
        }

    }

    public String getNazwaPytania() {
        return NazwaPytania;
    }

    public void setNazwaPytania(String nazwaPytania) {
        NazwaPytania = nazwaPytania;
    }

    public String getWybranaOdpowiedz() {
        return WybranaOdpowiedz;
    }

    public void setWybranaOdpowiedz(String wybranaOdpowiedz) {
        WybranaOdpowiedz = wybranaOdpowiedz;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public String getWynik() {
        return wynik;
    }

    public void setWynik(String wynik) {
        this.wynik = wynik;
    }

    @Override
    public String toString() {
        return "GoodQuestionList{" +
                "NazwaPytania='" + NazwaPytania + '\'' +
                ", WybranaOdpowiedz='" + WybranaOdpowiedz + '\'' +
                ", wynik='" + wynik + '\'' +
                '}';
    }
}
