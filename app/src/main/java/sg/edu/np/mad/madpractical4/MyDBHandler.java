package sg.edu.np.mad.madpractical4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    public static final String TABLE_USERS = "user";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "quantity";
    public static final String COLUMN_FOLLOWED = "followed";


    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_USERS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " + COLUMN_DESCRIPTION + " TEXT, " +
                        COLUMN_FOLLOWED + " BOOLEAN);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void addUsers(User user){ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.Name);
        values.put(COLUMN_DESCRIPTION, user.Description);
        values.put(COLUMN_ID, user.Id);
        values.put(COLUMN_FOLLOWED, user.Followed);

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public ArrayList<User> getUsers() {
        String query =
                "SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        ArrayList<User> userArray = new ArrayList<>();

        while (cursor.moveToNext()){
            userArray.add(new User(cursor.getString(1), cursor.getString(2),
                    Integer.parseInt(cursor.getString(0)), Boolean.parseBoolean(cursor.getString(3))));
        }
        db.close();
        return userArray;
    }

    public void updateUser(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, user.Name);
        contentValues.put(COLUMN_DESCRIPTION, user.Description);
        contentValues.put(COLUMN_ID, user.Id);
        contentValues.put(COLUMN_FOLLOWED, user.Followed);

        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_USERS, contentValues, ""+ COLUMN_ID + "=" + user.Id,null);
        db.close();
    }


}
