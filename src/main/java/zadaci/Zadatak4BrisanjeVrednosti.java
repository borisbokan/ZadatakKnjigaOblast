package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.TableUtils;
import model.Oblast;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by androiddevelopment on 20.4.17..
 */
public class Zadatak4BrisanjeVrednosti {

    private static baza dbcon;
    private static Dao<Oblast,Integer> DAOObalsti;


    public static void main(String[] args){
            dbcon= new baza();

        try {
            DAOObalsti= DaoManager.createDao(dbcon.getKonekcija(),Oblast.class);


            List<Oblast> oblasti=DAOObalsti.queryForAll();

            System.out.println("Sve pre brisanja");
            for (Oblast stavka : oblasti) {
                System.out.println(stavka.toString());
            }
            System.out.println();


            //Brisanje oblasti za trazeni kriterijum
            QueryBuilder<Oblast,Integer> upit=DAOObalsti.queryBuilder();
            Where<Oblast,Integer> where = upit.where();
            where.eq(Oblast.POLJE_NAZIV,"Aritmeticki operatori");
            //PreparedQuery<Oblast> priprema=upit.prepare();

            //Brisanje
            Oblast oblastZaBrisanje=where.queryForFirst();
            DAOObalsti.delete(oblastZaBrisanje);


            //Ponovni prikaz nakon brisanja
            System.out.println("Nakon brisanja");
            for (Oblast stavka : oblasti) {
                System.out.println(stavka.toString());
            }
            System.out.println();




        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {

            dbcon.zatvoriKonekciju();
        }

        }
}
