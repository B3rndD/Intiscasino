package model;

public class gluecksspiel {

    static void add(gluecksspiel s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int Glueckspieltyp_ID;
    private String Spielname;
    private String Spieltyp;


    public gluecksspiel(int Gluecksspiel_ID, String Spielname, String Spieltyp) {
        this.Glueckspieltyp_ID = Gluecksspiel_ID;
        this.Spielname = Spielname;
        this.Spieltyp = Spieltyp;

    }

    public gluecksspiel(int i, String agg, String stefan, double d, String aut, String h, String j, String j0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getGlueckspieltyp_ID() {
        return Glueckspieltyp_ID;
    }

    public void setGlueckspieltyp_ID(int Gluecksspiel_ID) {
        this.Glueckspieltyp_ID = Glueckspieltyp_ID;
    }

    public String getSpielname() {
        return Spielname;
    }

    public void setSpielname(String Spielname) {
        this.Spielname = Spielname;
    }

    public String getSpieltyp() {
        return Spieltyp;
    }

    public void setSpieltyp(String Spieltyp) {
        this.Spieltyp = Spieltyp;
    }

    @Override
    public String toString() {
        return "gluecksspiel{" + "Glueckspieltyp_ID=" + Glueckspieltyp_ID + ", Spielname=" + Spielname + ", Spieltyp=" + Spieltyp + '}';
    }


}