package com.example.databasetesting;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.logging.Logger;

/**
 * Created by rdiaz on 11/26/18.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	private static DatabaseHelper mDatabaseHelper;

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = Config.DATABASE_NAME;

	private DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public static DatabaseHelper getInstance(Context context) {
		if (mDatabaseHelper == null) {
			synchronized (DatabaseHelper.class) {
				if (mDatabaseHelper == null)
					mDatabaseHelper = new DatabaseHelper(context);
			}
		}
		return mDatabaseHelper;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String CREATE_USER_TABLE = "CREATE TABLE " + Config.TABLE_USER + "("
				+ Config.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ Config.COLUMN_USERNAME + " TEXT NOT NULL "
				+ ")";

		String CREATE_HISTORY_TABLE = "CREATE TABLE " + Config.TABLE_HISTORY + "("
				+ Config.COLUMN_HISTORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ Config.COLUMN_ELEMENT_ID + " INTEGER NOT NULL, "
				+ Config.COLUMN_USER_ID + " INTEGER NOT NULL, "
				+ Config.COLUMN_ELEMENT_NAME + " TEXT NOT NULL, "
				+ Config.COLUMN_COUNT + " INTEGER NOT NULL "
				+ ")";

		db.execSQL(CREATE_USER_TABLE);
		db.execSQL(CREATE_HISTORY_TABLE);

		Log.d("DATABASEHELPER", "DB created!");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int i, int i1) {
		db.execSQL("DROP TABLE IF EXISTS " + Config.TABLE_USER);
		db.execSQL("DROP TABLE IF EXISTS " + Config.TABLE_HISTORY);

		onCreate(db);
	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);

		db.execSQL("PRAGMA foreign_keys=ON;");
	}
}
