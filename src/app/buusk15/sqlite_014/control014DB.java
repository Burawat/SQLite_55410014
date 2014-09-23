package app.buusk15.sqlite_014;

import java.security.PublicKey;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

import android.R.array;
import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler.Value;
import android.util.Log;

public class control014DB extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "mydata014";
	private static final String TABLE_MEMBER = "members";
	private static final int DATABASE_VERSION = 1;

	public control014DB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE_MEMBER
				+ "(MemberId INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " Name TEXT(100)," + " Tel TEXT(100));");

		Log.d("CREATE TABLE", "Create Table Successfully");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
		onCreate(db);

	}

	public long InserData(String strName, String strTel) {
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("Name", strName);
			values.put("Tel", strTel);
			long l = db.insert(TABLE_MEMBER, null, values);
			db.close();
			return l;
		} catch (Exception e) {
			return -1;
		}
	}

	public String[] CheckData(String strMemberID) {
		try {
			String[] arrData = null;
			SQLiteDatabase db;
			db = this.getReadableDatabase();

			Cursor cursor = db.query(TABLE_MEMBER, new String[] { "*" },
					"MemberID=?", new String[] { String.valueOf(strMemberID) },
					null, null, null);
			if (cursor != null) {
				if (cursor.moveToFirst()) {
					arrData = new String[cursor.getColumnCount()];
					arrData[0] = cursor.getString(0);
					arrData[1] = cursor.getString(1);
					arrData[2] = cursor.getString(2);
					
				}
			}
			cursor.close();
			db.close();
			return arrData;

		} catch (Exception e) {
			return null;
		}
	}

	public ArrayList<HashMap<String, String>> SelectAllData() {
		try {
			ArrayList<HashMap<String, String>> MyArrayList = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map;

			SQLiteDatabase db;
			db = this.getReadableDatabase();

			String strSQL = "SELECT * FROM " + TABLE_MEMBER;
			Cursor cursor = db.rawQuery(strSQL, null);

			if (cursor != null) {
				if (cursor.moveToFirst()) {
					do {
						map = new HashMap<String, String>();
						map.put("MemberID", cursor.getString(0));
						map.put("Name", cursor.getString(1));
						map.put("Tel", cursor.getString(2));
						MyArrayList.add(map);

					} while (cursor.moveToNext());
				}
			}
			cursor.close();
			db.close();
			return MyArrayList;

		} catch (Exception e) {

		}
		return null;
	}
}
