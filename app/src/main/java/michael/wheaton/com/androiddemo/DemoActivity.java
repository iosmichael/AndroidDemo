package michael.wheaton.com.androiddemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by michaelliu on 2/3/17.
 */

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {


    public Button postBtn;
    public EditText content;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.demo);
        postBtn = (Button) findViewById(R.id.post_button);
        content = (EditText) findViewById(R.id.editText);
        postBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(content.getText().toString().isEmpty()){
            return;
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("messages");
        ref.push().setValue(new Post("Your Name", content.getText().toString()));
    }
}
