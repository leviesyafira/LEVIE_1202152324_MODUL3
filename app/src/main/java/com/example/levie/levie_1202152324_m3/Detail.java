package com.example.levie.levie_1202152324_m3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends AppCompatActivity {
    ImageView battery;
    int container = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView = findViewById(R.id.titleDetail);
        ImageView imageView = findViewById(R.id.header);
        TextView lorem = findViewById(R.id.detail);

        textView.setText(getIntent().getStringExtra("title"));
        imageView.setImageResource(getIntent().getIntExtra("image", 0));
        lorem.setText(getIntent().getStringExtra("detail"));

        battery = findViewById(R.id.imageView3);
        battery.setImageResource(R.drawable.ic_battery_20);

    }
    //method yang berfungsi untuk menurunkan air galon
    public void decrease(View view) {
        if (between(container--, 1, 3))
            level(container);
    }
    //method yang berfungsi untuk menaikan air galon
    public void increase(View view) {
        if (between(container++, 1, 3))
            level(container);
    }

    public boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        if (i >= minValueInclusive && i <= maxValueInclusive)
            return true;
        else
            return false;
    }
    //method untuk membuat level dari isi air galin
    public void level(int lvl) {
        switch (lvl) {
            case 1:
                battery.setImageResource(R.drawable.ic_battery_20); //set image level1
            break;
            case 2:
                battery.setImageResource(R.drawable.ic_battery_50_black_24dp);//set image level2
                Toast.makeText(this, "Air Sedikit", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                battery.setImageResource(R.drawable.ic_barrey_full_black_24dp); //set image level3
                Toast.makeText(this, "Air Sudah Full", Toast.LENGTH_SHORT).show();
                break;
            default:
                if (lvl > 3) {
                    container = 3; //container atau air galon akan penuh saat mencapai level 3
                } else if(lvl < 1) {
                    container = 1; ///container atau air galon paling rendah terisi di level 1
                }
        }
    }

}

