package kg.geeks.rvclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tvName, tvWeight, tvColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initUI();
        getObject();
    }

    private void initUI() {
        imageView = findViewById(R.id.iv_detail);
        tvName = findViewById(R.id.tv_name_detail);
        tvWeight = findViewById(R.id.tv_weight_detail);
        tvColor = findViewById(R.id.tv_color_detail);
    }

    private void getObject() {
        Animal animal = (Animal) getIntent().getSerializableExtra("RV");
        tvName.setText(animal.getName());
        tvColor.setText(animal.getColor());
        tvWeight.setText(String.valueOf(animal.getWeight()));
        imageView.setImageResource(animal.getImage());
    }



}