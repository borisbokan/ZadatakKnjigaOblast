package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import model.Oblast;
import org.omg.DynamicAny.DynAnyOperations;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by androiddevelopment on 20.4.17..
 */
public class Zadatak3IzmenaVrednosti {

    private static baza dbcon;

    private static Dao<Oblast,Integer> DAOOblast;

    public static void main(String[] args){

        dbcon= new baza();

        try {
            DAOOblast=DaoManager.createDao(dbcon.getKonekcija(),Oblast.class);


            List<Oblast> oblasti=DAOOblast.queryForAll();
            System.out.println("Sbe oblasti pre izmene\n-----------------------");
            for (Oblast stavke : oblasti) {
                System.out.printf(stavke.toString());
            }
            System.out.println();


            //Pronaci sve oblasti sa nazivom "Activity klasa"
            QueryBuilder<Oblast,Integer> upit=DAOOblast.queryBuilder();
            Where<Oblast,Integer> where =  upit.where().eq(Oblast.POLJE_NAZIV,"Activity klasa");
            PreparedQuery<Oblast> pripreljen=where.prepare();

            //Izmena vrednosti
            Oblast oblastZaIzmenu=DAOOblast.queryForFirst(pripreljen);
            oblastZaIzmenu.setPocetnaStrana(35);
            DAOOblast.update(oblastZaIzmenu);


            List<Oblast> oblastiNakonIzmene=DAOOblast.queryForAll();
            System.out.println("Sbe oblasti nakon izmene\n-----------------------");
            for (Oblast stavke : oblastiNakonIzmene) {
                System.out.println(stavke.toString());
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
