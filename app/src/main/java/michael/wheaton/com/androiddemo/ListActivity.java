package michael.wheaton.com.androiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by michaelliu on 2/16/17.
 */

public class ListActivity extends AppCompatActivity implements ValueEventListener{

    private ListView listView;
    private ArrayList<Post> posts;
    private String[] data = new String[0];
    private ArrayAdapter<String> itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        posts = new ArrayList<>();

        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.data);
        listView = (ListView) findViewById(R.id.listview);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("messages");
        ref.addValueEventListener(this);
        listView.setAdapter(itemsAdapter);
    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        posts.removeAll(posts);
        for (DataSnapshot child : dataSnapshot.getChildren()) {
            Post post = new Post();
            for(DataSnapshot elem: child.getChildren()){
                if (elem.getKey().equals("title")){
                    post.title = (String) elem.getValue();
                }
            }
            posts.add(post);
        }
        int count = 0;
        for (Post post : posts){
            count++;
        }
        String[] array = new String[count];
        int i = 0;
        for (Post post : posts){
            array[i] = post.title;
            i++;
        }
        this.data = array;
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.data);
        listView.setAdapter(itemsAdapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
