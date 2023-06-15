public class Person {
    private int Mitarbeiter_ID;
    private String vorname;
    private String nachname;
    private double gehalt;
    private String Adresse;
    private String HausNR;
    private String PLZ;

    public Person(int Mitarbeiter_ID, String vorname, String nachname, double gehalt, String Adresse, String HausNR, String PLZ) {
        this.Mitarbeiter_ID = Mitarbeiter_ID;
        this.vorname = vorname;
        this.nachname = nachname;
        this.gehalt = gehalt;
        this.Adresse = Adresse;
        this.HausNR = HausNR;
        this.PLZ = PLZ;
    }

    public int getMitarbeiter_ID() {
        return Mitarbeiter_ID;
    }

    public void setMitarbeiter_ID(int Mitarbeiter_ID) {
        this.Mitarbeiter_ID = Mitarbeiter_ID;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getHausNR() {
        return HausNR;
    }

    public void setHausNR(String HausNR) {
        this.HausNR = HausNR;
    }

    public String getPLZ() {
        return PLZ;
    }

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
    }

    @Override
    public String toString() {
        return vorname + " " + nachname + " " + gehalt + " " + Adresse + " " + HausNR + " " + PLZ;
    }
}
