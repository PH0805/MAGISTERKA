package UTILS;

import DBConnections.DBConnection;
import DBConnections.PytaniaDao;
import Data_Tables.*;
import com.j256.ormlite.dao.*;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class FillDataBase {






   public static  void  fillDatabase() throws SQLException {


       DBConnection.initDataBase();

       Pytania pytanie1 = new Pytania();
       Pytania pytanie2 = new Pytania();
       Pytania pytanie3 = new Pytania();

       pytanie1.setPytanie("Ile jest 2 + 6?");
       pytanie1.setOdpA("5");
       pytanie1.setOdpB("7");
       pytanie1.setOdpC("8");
       pytanie1.setOdpD("9");
       pytanie1.setOdpE("222");
       pytanie1.setOdpPopr(pytanie1.getOdpC());
       pytanie1.setKategoria("Matematyka");


       pytanie2.setPytanie("Na jakim kontyencie leży Kongo");
       pytanie2.setOdpA("Afryka");
       pytanie2.setOdpB("Azja");
       pytanie2.setOdpC("Europa");
       pytanie2.setOdpE("USA");
       pytanie2.setOdpD("Rosja");
       pytanie2.setOdpPopr("Afryka");
       pytanie2.setKategoria("Matematyka");


       pytanie3.setPytanie("Na jakim kontyencie leży Polska");
       pytanie3.setOdpA("Afryka");
       pytanie3.setOdpB("Azja");
       pytanie3.setOdpC("Europa");
       pytanie3.setOdpPopr("Europa");
       pytanie3.setKategoria("Geografia");


       PytaniaDao pytaniaDao = new PytaniaDao(DBConnection.getConnectionSource());

       try {
           pytaniaDao.creatOrUpdate(pytanie1);
           pytaniaDao.creatOrUpdate(pytanie2);
          pytaniaDao.creatOrUpdate(pytanie3);

       } catch (ApplicationException e) {
           e.printStackTrace();
       }



   }
   }


