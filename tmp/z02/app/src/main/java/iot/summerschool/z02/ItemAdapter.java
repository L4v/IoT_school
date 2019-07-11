package iot.summerschool.z02;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Item> mItems;

    public ItemAdapter(Context context){
        this.mContext = context;
        this.mItems = new ArrayList<Item>();
    }

    public void addItem(Item i){
        this.mItems.add(i);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return this.mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if(v == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
            ViewHolder holder = new ViewHolder();
            holder.image = v.findViewById(R.id.imageView);
            holder.text1 = v.findViewById(R.id.textView1);
            holder.text2 = v.findViewById(R.id.textView2);
            v.setTag(holder);

        }

        Item item = (Item) getItem(i);
        ViewHolder holder = (ViewHolder) v.getTag();
        holder.image.setImageDrawable(item.getImage());
        holder.text1.setText(item.getText1());
        holder.text2.setText(item.getText2());


        return v;
    }

    private class ViewHolder{
        private ImageView image = null;
        private TextView text1 = null, text2 = null;
    }

}
