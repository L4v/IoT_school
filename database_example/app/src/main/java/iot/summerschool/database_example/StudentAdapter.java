package iot.summerschool.database_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Student> mStudents;

    public StudentAdapter(Context context){
        this.mContext = context;
        this.mStudents = new ArrayList<Student>();
    }

    public void addStudent(Student student){
        this.mStudents.add(student);
        notifyDataSetChanged();
    }

    public void update(Student[] students){
        this.mStudents.clear();

        for(Student s : students)
            addStudent(s);
    }

    public void clear(){
        this.mStudents.clear();
    }

    @Override
    public int getCount() {
        return this.mStudents.size();
    }

    @Override
    public Object getItem(int i) {
        Object o = null;
        try{
            o = mStudents.get(i);
        } catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if(v == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.element_row, null);
            ViewHolder holder = new ViewHolder();
            holder.name = v.findViewById(R.id.ename);
            holder.surname = v.findViewById(R.id.esurname);
            holder.index = v.findViewById(R.id.eindex);
            v.setTag(holder);
        }

        Student student = (Student) getItem(i);
        ViewHolder holder = (ViewHolder)v.getTag();
        holder.name.setText(student.getName());
        holder.surname.setText(student.getSurname());
        holder.index.setText(student.getIndex());

        return v;
    }

    private class ViewHolder{
        public TextView name = null,
                surname = null,
                index = null;
    }
}
