package Data_Tables;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
@DatabaseTable(tableName = "PYTANIA")
public class Pytania implements BaseModel {


    public Pytania() {
    }



    @DatabaseField(generatedId = true)
    private int id;


    @DatabaseField(columnName = "Pytanie", canBeNull = true)
    private String Pytanie;

    @DatabaseField(columnName = "ODP_A", canBeNull = true)
    private String OdpA;

    @DatabaseField(columnName = "ODP_B", canBeNull = true)
    private String OdpB;

    @DatabaseField(columnName = "ODP_C", canBeNull = true)
    private String OdpC;

    @DatabaseField(columnName = "ODP_D", canBeNull = true)
    private String OdpD;

    @DatabaseField(columnName = "ODP_E", canBeNull = true)
    private String OdpE;

    @DatabaseField(columnName = "Popr_ODP", canBeNull = true)
    private String OdpPopr;

    @DatabaseField(columnName = "KATEGORIA", canBeNull = true)
    private String Kategoria;

    public String getOdpD() {
        return OdpD;
    }

    public void setOdpD(String odpD) {
        OdpD = odpD;
    }

    public String getOdpE() {
        return OdpE;
    }

    public void setOdpE(String odpE) {
        OdpE = odpE;
    }

    public String getKategoria() {
        return Kategoria;
    }

    public void setKategoria(String kategoria) {
        Kategoria = kategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPytanie() {
        return Pytanie;
    }

    public void setPytanie(String pytanie) {
        Pytanie = pytanie;
    }

    public String getOdpA() {
        return OdpA;
    }

    public void setOdpA(String odpA) {
        OdpA = odpA;
    }

    public String getOdpB() {
        return OdpB;
    }

    public void setOdpB(String odpB) {
        OdpB = odpB;
    }

    public String getOdpC() {
        return OdpC;
    }

    public void setOdpC(String odpC) {
        OdpC = odpC;
    }

    public String getOdpPopr() {
        return OdpPopr;
    }

    public void setOdpPopr(String odpPopr) {
        OdpPopr = odpPopr;
    }


}

