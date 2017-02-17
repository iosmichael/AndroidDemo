package michael.wheaton.com.androiddemo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by michaelliu on 2/17/17.
 */

public class PostAdapter extends BaseAdapter {

    private Post[] array;

    public PostAdapter(Post[] array){
        this.array = array;
    }
    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public Object getItem(int position) {
        return array[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }
}
