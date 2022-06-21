package sg.edu.np.mad.madpractical4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);
        Button grp1 = findViewById(R.id.group1);
        Button grp2 = findViewById(R.id.group2);

        grp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView grp1txt = findViewById(R.id.group1);
                ImageView imageView = findViewById(R.id.androidimage);
                imageView.setVisibility(View.INVISIBLE);
                grp1txt.setText("Group 1");
            }
        });
        grp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = findViewById(R.id.androidimage);
                imageView.setVisibility(View.VISIBLE);
            }
        });
    }
}