package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 20.4.17..
 */
@DatabaseTable(tableName = "oblast")
public class Oblast {

    public static final String POLJE_NAZIV="naziv";
    public static final String POLJE_POCETNA_STRANA="pocetna_strana";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_NAZIV)
    private String naziv;
    @DatabaseField(columnName = POLJE_POCETNA_STRANA)
    private int pocetnaStrana;

    @DatabaseField(foreign = true,foreignAutoRefresh = true,canBeNull = true)
    private Knjiga knjiga;


    public Oblast(){
    }
    public Oblast(String _naziv,int _trenutnaStrana){
        this.naziv=_naziv;
        this.pocetnaStrana=_trenutnaStrana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPocetnaStrana() {
        return pocetnaStrana;
    }

    public void setPocetnaStrana(int pocetnaStrana) {
        this.pocetnaStrana = pocetnaStrana;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }


    public String toString(){
        return this.id  + "" + this.naziv + "" + this.pocetnaStrana;
    }

}
