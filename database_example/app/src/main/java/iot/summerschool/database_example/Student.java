package iot.summerschool.database_example;

public class Student {
    private String mIme, mPrezime, mIndeks;

    public Student(String ime, String prezime, String indeks){
        mIme = ime;
        mPrezime = prezime;
        mIndeks = indeks;
    }

    public String getName() {
        return mIme;
    }

    public void setName(String mIme) {
        this.mIme = mIme;
    }

    public String getSurname() {
        return mPrezime;
    }

    public void setSurname(String mPrezime) {
        this.mPrezime = mPrezime;
    }

    public String getIndex() {
        return mIndeks;
    }

    public void setIndex(String mIndeks) {
        this.mIndeks = mIndeks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mIme='" + mIme + '\'' +
                ", mPrezime='" + mPrezime + '\'' +
                ", mIndeks='" + mIndeks + '\'' +
                '}';
    }
}
