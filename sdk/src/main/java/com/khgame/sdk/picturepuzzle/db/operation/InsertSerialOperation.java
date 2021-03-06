package com.khgame.sdk.picturepuzzle.db.operation;

import android.content.ContentValues;

import com.khgame.sdk.picturepuzzle.core.GameLevel;
import com.khgame.sdk.picturepuzzle.model.Serial;
import com.khgame.sdk.picturepuzzle.db.table.SerialTable;

/**
 * Created by zkang on 2017/2/24.
 */

public class InsertSerialOperation extends DBOperation<Serial, Void> {

    private Serial serial;

    public InsertSerialOperation(Serial serial) {
        this.serial = serial;
    }

    @Override
    protected void doWork() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SerialTable.Cols.UUID, serial.uuid);
        contentValues.put(SerialTable.Cols.NAME, serial.name);
        contentValues.put(SerialTable.Cols.GAMELEVEL, GameLevel.EASY); // default EASY
        contentValues.put(SerialTable.Cols.PRIMARYCOLOR, serial.primaryColor);
        contentValues.put(SerialTable.Cols.SECONDARYCOLOR, serial.secondaryColor);
        long id = db.insert(SerialTable.NAME, null, contentValues);
        if (id == -1) {
            postFailure(null);
            return;
        }
        postSuccess(serial);
    }
}
