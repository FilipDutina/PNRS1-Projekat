package rtrk.pnrs1.ra43_2014;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by student on 11.4.2017.
 */

public class MyAdapter extends BaseAdapter{

    private Context myContext;
    private ArrayList<ListElement> myTaskList;

    public MyAdapter(Context context)
    {
        myContext = context;
        myTaskList = new ArrayList<ListElement>();
    }

    public void addTask(ListElement listElement)
    {
        myTaskList.add(listElement);
        notifyDataSetChanged();
    }

    public void removeTask(int position)
    {
        myTaskList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return myTaskList.size();
    }

    @Override
    public Object getItem(int position) {
        Object returnValue = null;
        try
        {
            returnValue = myTaskList.get(position);
        }
        catch(IndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }

        return returnValue;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myView = convertView;
        if(myView == null)
        {
            LayoutInflater myInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = myInflater.inflate(R.layout.list_element, null);   //my .xml file
            ViewHolder myViewHolder = new ViewHolder();
            myViewHolder.name = (TextView) myView.findViewById(R.id.task_name1);
            myViewHolder.time = (TextView) myView.findViewById(R.id.task_time1);
            myViewHolder.date = (TextView) myView.findViewById(R.id.task_date1);
            myViewHolder.priority = (Button) myView.findViewById(R.id.button9);
            myViewHolder.checked = (CheckBox) myView.findViewById(R.id.checkBox3);
            myViewHolder.alarm = (ImageView) myView.findViewById(R.id.imageView2);
            myView.setTag(myViewHolder);
        }

        ListElement myListElementEntry = (ListElement) getItem(position);
        final ViewHolder myViewHolder = (ViewHolder) myView.getTag();
        myViewHolder.name.setText(myListElementEntry.imeZadatka);
        myViewHolder.time.setText(myListElementEntry.vreme);
        myViewHolder.date.setText(myListElementEntry.datum);

        if(myListElementEntry.prioritet == 2)
            myViewHolder.priority.setBackgroundColor(Color.YELLOW);
        else if(myListElementEntry.prioritet == 1)
            myViewHolder.priority.setBackgroundColor(Color.GREEN);
        else
            myViewHolder.priority.setBackgroundColor(Color.RED);

        myViewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    myViewHolder.name.setPaintFlags(myViewHolder.name.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else
                {
                    myViewHolder.name.setPaintFlags(myViewHolder.name.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        });

        if(myListElementEntry.podsetnik == 0)
        {
            myViewHolder.alarm.setColorFilter(Color.rgb(238, 238, 238));
        }

        return myView;
    }

    private class ViewHolder
    {
        public TextView name = null;
        public TextView time = null;
        public TextView date = null;
        public Button priority = null;
        public CheckBox checked = null;
        public ImageView alarm = null;
    }
}
