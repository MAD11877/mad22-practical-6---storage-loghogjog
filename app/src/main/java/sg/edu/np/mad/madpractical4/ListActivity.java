package sg.edu.np.mad.madpractical4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MyDBHandler myDBHandler = new MyDBHandler(this, MyDBHandler.TABLE_USERS, null, 1);
        //ArrayList<User> userArray = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int rand = random.nextInt();
            int rand1 = random.nextInt();
            int rand2 = random.nextInt(2);
            if (rand2 == 1) {
                myDBHandler.addUsers(new User(("Name"+rand),("Description " + rand1), i,true));
            }
            else {
                myDBHandler.addUsers(new User(("Name"+rand),("Description " + rand1), i,false));
            }
        }

        RecyclerView rv = findViewById(R.id.recycleView);
        MessageAdapter adapter = new MessageAdapter(myDBHandler.getUsers(),ListActivity.this);
        LinearLayoutManager layout = new LinearLayoutManager(this);

        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);
    }
}