package com.example.databasetesting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rdiaz on 11/26/18.
 */
public class DatabaseQuery {

	private Context mContext;
	private DatabaseHelper mDatabaseHelper;
	private SQLiteDatabase mSqLiteDatabase;

	public DatabaseQuery(Context context) {
		mContext = context;
		mDatabaseHelper = DatabaseHelper.getInstance(context);
		mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
	}

	public long insert(int elementId, String elementName, int count, int userID) {

		long id = -1;

		ContentValues contentValues = new ContentValues();
		contentValues.put(Config.COLUMN_ELEMENT_ID, elementId);
		contentValues.put(Config.COLUMN_ELEMENT_NAME, elementName);
		contentValues.put(Config.COLUMN_COUNT, count);
		contentValues.put(Config.COLUMN_USER_ID, userID);
		try {
			id = mSqLiteDatabase.insertOrThrow(Config.TABLE_HISTORY, null, contentValues);
		} catch (SQLiteException e) {
			Log.d("DatabaseQuery: ", e.getMessage());
		} finally {
			mSqLiteDatabase.close();
		}

		return id;
	}

	public List<History> getHistories() {
		Cursor cursor = null;
		try {

			cursor = mSqLiteDatabase.query(Config.TABLE_HISTORY, null, null,
					null, null, null, null, null);

			if (cursor != null)
				if (cursor.moveToFirst()) {
					List<History> histories = new ArrayList<>();
					do {
						int id = cursor.getInt(cursor.getColumnIndex(Config.COLUMN_HISTORY_ID));
						int elementId = cursor.getInt(cursor.getColumnIndex(Config.COLUMN_ELEMENT_ID));
						String elementName = cursor.getString(cursor.getColumnIndex(Config.COLUMN_ELEMENT_NAME));
						int count = cursor.getInt(cursor.getColumnIndex(Config.COLUMN_COUNT));
						histories.add(new History(id, elementId, elementName, count));
					} while (cursor.moveToNext());

					return histories;
				}
		} catch (Exception e) {
			Log.d("Databasequery", e.getMessage());
		} finally {
			if (cursor != null) {
				cursor.close();
			}
			mSqLiteDatabase.close();
		}

		return new ArrayList<>();
	}

}
