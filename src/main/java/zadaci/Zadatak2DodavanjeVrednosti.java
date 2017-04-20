package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import model.Knjiga;
import model.Oblast;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by androiddevelopment on 20.4.17..
 */
public class Zadatak2DodavanjeVrednosti {

    private static baza dbcon;
    private static Dao<Knjiga,Integer> DAOKnjiga;
    private static Dao<Oblast,Integer> DAOOblast;

    public static void main(String[] args){

        dbcon= new baza();

        try {
            DAOKnjiga= DaoManager.createDao(dbcon.getKonekcija(),Knjiga.class);
            DAOOblast=DaoManager.createDao(dbcon.getKonekcija(),Oblast.class);


        Knjiga knji1=new Knjiga("Java programiranje", 650,  new Date());
        DAOKnjiga.create(knji1);
        
        Knjiga knji2=new Knjiga("Android programiranje", 500,  new Date());
        DAOKnjiga.create(knji2);

        Oblast oblast1=new Oblast("Uvod",2);
        oblast1.setKnjiga(knji1);
        DAOOblast.create(oblast1);

        Oblast oblast2=new Oblast("Naredbe",10);
        oblast2.setKnjiga(knji1);
        DAOOblast.create(oblast2);

        Oblast oblast3=new Oblast("Aritmeticki operatori",20);
        oblast3.setKnjiga(knji1);
        DAOOblast.create(oblast3);

        Oblast oblast4=new Oblast("Android operativni sistem",2);
        oblast4.setKnjiga(knji2);
        DAOOblast.create(oblast4);

        Oblast oblast5=new Oblast("Activity klasa",30);
        oblast5.setKnjiga(knji2);
        DAOOblast.create(oblast5);



            List<Oblast> oblast =DAOOblast.queryForAll();
            List<Knjiga> knjiga =DAOKnjiga.queryForAll();

            for (Oblast stavka : oblast) {
                System.out.println(stavka.toString());
            }

            for (Knjiga stavka : knjiga ) {
                System.out.println(stavka.toString());
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


        dbcon.zatvoriKonekciju();


    }
}
