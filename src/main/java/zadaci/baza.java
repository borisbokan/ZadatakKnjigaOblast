package zadaci;


import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by androiddevelopment on 20.4.17..
 */
public class baza {


            private ConnectionSource conn=null;


            public baza(){
                try {
                    conn=new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            public ConnectionSource konekcija(){
                return conn;
            }


            public void zatvoriKonekciju(){
                try {
                    conn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


}
