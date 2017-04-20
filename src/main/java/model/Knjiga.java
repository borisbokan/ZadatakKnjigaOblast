package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by androiddevelopment on 20.4.17..
 */
@DatabaseTable(tableName = "knjiga")
public class Knjiga {

        public static final String POLJE_NASLOV="naslov";
        public static final String POLJE_BROJ_STRANA="broj_strana";
        public static final String POLJE_DATUM_IZDAVANJA="datum_izdavanja";


        @DatabaseField(generatedId = true)
        private int id;
        @DatabaseField(columnName = POLJE_NASLOV)
        private String naslov;
        @DatabaseField(columnName = POLJE_BROJ_STRANA)
        private int brojStrana;
        @DatabaseField(columnName = POLJE_DATUM_IZDAVANJA)
        private Date datumIzdanja;

        //Nije u bazi
        private boolean prisutan;//ne cuva se u bazi

        //TODO: Uradi posle
        //ArrayList<Oblast> oblasti;


        public Knjiga(String _naslov, int _brojStrana, Date _datumIzdavanja){
            this.naslov=_naslov;
            this.brojStrana=_brojStrana;
            this.datumIzdanja=_datumIzdavanja;

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNaslov() {
            return naslov;
        }

        public void setNaslov(String naslov) {
            this.naslov = naslov;
        }

        public int getBrojStrana() {
            return brojStrana;
        }

        public void setBrojStrana(int brojStrana) {
            this.brojStrana = brojStrana;
        }

        public Date getDatumIzdanja() {
            return datumIzdanja;
        }

        public void setDatumIzdanja(Date datumIzdanja) {
            this.datumIzdanja = datumIzdanja;
        }

        public boolean isPrisutan() {
            return prisutan;
        }

        public void setPrisutan(boolean prisutan) {
            this.prisutan = prisutan;
        }

        public String toString(){
            return this.id + " " + this.naslov + " " + this.brojStrana + " " + this.datumIzdanja;
        }
}
