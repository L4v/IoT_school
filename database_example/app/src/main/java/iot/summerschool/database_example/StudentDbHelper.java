package iot.summerschool.database_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class StudentDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "students.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "student";
    public static final String COLUMN_FIRST_NAME= "FirstName";
    public static final String COLUMN_LAST_NAME= "LastName";
    public static final String COLUMN_INDEX= "IndexNumber";

    private SQLiteDatabase mDb = null;

    public StudentDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_FIRST_NAME + " TEXT," +
                COLUMN_LAST_NAME + " TEXT," +
                COLUMN_INDEX + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(Student student){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, student.getName());
        values.put(COLUMN_LAST_NAME, student.getSurname());
        values.put(COLUMN_INDEX, student.getIndex());

        db.insert(TABLE_NAME, null, values);

        close();
    }

    public Student[] readStudent(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null,
                null, null, null, null);

        if(cursor.getCount() <= 0)
            return null;

        Student[] students = new Student[cursor.getCount()];
        int i = 0;
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            students[i++] = createStudent(cursor);
            Log.d("STUDENTI", students[i-1].toString());
        }
        close();
        return students;
    }

    public Student readStudent(String index){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_INDEX + "=?",
                new String[]{index}, null, null, null);
        cursor.moveToFirst();

        Student student = createStudent(cursor);

        close();

        return student;
    }

    public void deleteStudent(String index){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_INDEX + "=?", new String[]{index});
        Log.d("[StudentDbHelper]", "[Deleting student with index " + index + "]");
        close();
    }

    // Utility
    private Student createStudent(Cursor c){
        return  new Student(c.getString(c.getColumnIndex(COLUMN_FIRST_NAME)),
                c.getString(c.getColumnIndex(COLUMN_LAST_NAME)),
                c.getString(c.getColumnIndex(COLUMN_INDEX)));
    }
}
