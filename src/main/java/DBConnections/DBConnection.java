package DBConnections;

import Data_Tables.*;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.IOException;
import java.sql.SQLException;

public class DBConnection {

    private static final String Sterownik = "jdbc:sqlite:BazaDanych6";
    private static ConnectionSource connectionSource;

    //// Nie wiem co to jest ten Logger, Jeszcze
    public static final Logger LOGGER = LoggerFactory.getLogger(DBConnection.class);



    public static void initDataBase(){
        createConnection();
    dropTable();
        createTable();
        closeConnectionSource();
    }

    public static void createConnection(){

        try {
            connectionSource = new JdbcConnectionSource(Sterownik);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource == null){
            createConnection();
        }
        return  connectionSource;
    }

    public static void closeConnectionSource(){
        if(connectionSource!=null){
            try {
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createTable(){

        try {

        TableUtils.createTableIfNotExists(connectionSource, Pytania.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static  void dropTable(){

        try {
            TableUtils.dropTable(connectionSource, Pytania.class, true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
