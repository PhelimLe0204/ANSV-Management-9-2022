package vn.ansv.management.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO - Plain Object Java Object
@Entity
@Table(name = "tbl_currency_unit")
public class CurrencyUnit {
    @Id
    private int id;
    private String uid;
    private String currency_unit;
    private String description;

    public CurrencyUnit() {
    }

    public CurrencyUnit(int id, String uid, String currency_unit, String description) {
        this.id = id;
        this.uid = uid;
        this.currency_unit = currency_unit;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCurrency_unit() {
        return this.currency_unit;
    }

    public void setCurrency_unit(String currency_unit) {
        this.currency_unit = currency_unit;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
