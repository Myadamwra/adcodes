package com.example.imageslider;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageSlider ms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ms = findViewById(R.id.is);
        ArrayList<SlideModel> mlist = new ArrayList<>();
        mlist.add(new SlideModel((R.drawable.one) , null));
        mlist.add(new SlideModel((R.drawable.two) , null));
        mlist.add(new SlideModel((R.drawable.three) , null));
        mlist.add(new SlideModel((R.drawable.four) , null));
        mlist.add(new SlideModel((R.drawable.five) , null));
        mlist.add(new SlideModel((R.drawable.six) , null));

        ms.setImageList(mlist);
    }
}
