package android.ay.com.msc.adapter;


import java.util.ArrayList;

import android.app.Activity;
import android.ay.com.msc.R;
import android.ay.com.msc.bean.NavDrawerBean;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NavDrawerListAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<NavDrawerBean> navDrawerItems;
	
	public NavDrawerListAdapter(Context context, ArrayList<NavDrawerBean> navDrawerItems){
		this.context = context;
		this.navDrawerItems = navDrawerItems;
	}

	@Override
	public int getCount() {
		return navDrawerItems.size();
	}

	@Override
	public Object getItem(int position) {		
		return navDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_item_nav, null);
        }
         
        TextView txtTitle = (TextView) convertView.findViewById(R.id.navTile);
        txtTitle.setText(navDrawerItems.get(position).getTitle());
        
        
        TextView notifyCounterTextView = (TextView) convertView.findViewById(R.id.notifyCounterTextView);
        
        if (navDrawerItems.get(position).getCounterVisibility()) {
			
        	notifyCounterTextView.setVisibility(View.VISIBLE);
        	notifyCounterTextView.setText(""+navDrawerItems.get(position).getCount());
        	
        	if (navDrawerItems.get(position).getCount() < 1) {
        		notifyCounterTextView.setVisibility(View.INVISIBLE);
			}
        	
		}else{
			notifyCounterTextView.setVisibility(View.INVISIBLE);
		}
        
        
        return convertView;
	}

}
