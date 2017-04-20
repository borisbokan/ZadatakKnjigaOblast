package zadaci;

import com.j256.ormlite.table.TableUtils;
import model.Knjiga;
import model.Oblast;

import java.sql.SQLException;

/**
 * Created by androiddevelopment on 20.4.17..
 */
public class Zadatak1KreiranjeTabela {

    static baza dbcon;

    public static void main(String[] args){

           dbcon= new baza();

        try {

            //Brisem tabele
            TableUtils.dropTable(dbcon.getKonekcija(), Oblast.class,true);
            TableUtils.dropTable(dbcon.getKonekcija(), Knjiga.class,true);


            //Pravim tabele
            TableUtils.createTable(dbcon.getKonekcija(),Knjiga.class);
            TableUtils.createTable(dbcon.getKonekcija(),Oblast.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbcon.zatvoriKonekciju();
        }





    }
}
