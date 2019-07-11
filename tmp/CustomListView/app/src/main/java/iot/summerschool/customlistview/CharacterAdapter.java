package iot.summerschool.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CharacterAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Character> mCharacters;

    public CharacterAdapter(Context context){
        this.mContext = context;
        this.mCharacters = new ArrayList<Character>();
    }

    public void addCharacter(Character character){
        this.mCharacters.add(character);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.mCharacters.size();
    }

    @Override
    public Object getItem(int i) {
        Object o = null;
        try{
            o = mCharacters.get(i);
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
            holder.image = v.findViewById(R.id.imageView);
            holder.name =  v.findViewById(R.id.textName);
            v.setTag(holder);
        }

            Character character = (Character) getItem(i);
            ViewHolder holder = (ViewHolder)v.getTag();
            holder.image.setImageDrawable(character.getImage());
            holder.name.setText(character.getName());

        return v;
    }

    private class ViewHolder{
        public ImageView image = null;
        public TextView name = null;
    }

}

