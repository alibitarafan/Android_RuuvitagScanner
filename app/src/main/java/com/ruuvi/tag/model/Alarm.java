package com.ruuvi.tag.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.ruuvi.tag.database.LocalDatabase;

import java.util.List;

/**
 * Created by tmakinen on 26.7.2017.
 */

@Table(database = LocalDatabase.class)
public class Alarm extends BaseModel {
    public static final int TEMPERATURE = 0;
    public static final int HUMIDITY = 1;
    public static final int PERSSURE = 2;
    public static final int RSSI = 3;

    @Column
    @PrimaryKey(autoincrement = true)
    public int id;
    @Column
    public String ruuviTagId;
    @Column
    public int low;
    @Column
    public int high;
    @Column
    public int type;

    public Alarm() {
    }

    public Alarm(int low, int high, int type, String tagId) {
        this.low = low;
        this.high = high;
        this.type = type;
        this.ruuviTagId = tagId;
    }

    public static List<Alarm> getForTag(String id) {
        return SQLite.select()
                .from(Alarm.class)
                .where(Alarm_Table.ruuviTagId.eq(id))
                .queryList();
    }
}
