package kg.geeks.rvclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalClick {

    private ArrayList<Animal> arrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();
        initAdapter();
    }

    private void initList() {
        arrayList = new ArrayList<>();
        arrayList.add(new Animal("Elephant", "Grey", 4000, R.drawable.img));
        arrayList.add(new Animal("Bear", "Brown", 2000, R.drawable.img_1));
        arrayList.add(new Animal("Snake", "Green", 1, R.drawable.img_2));
        arrayList.add(new Animal("Dog", "Grey", 20, R.drawable.img_3));
        arrayList.add(new Animal("Cat", "Black", 2, R.drawable.img_4));
        arrayList.add(new Animal("Camel", "Beige", 1000, R.drawable.img_3));
        arrayList.add(new Animal("Rat", "Grey", 1, R.drawable.img_6));
        arrayList.add(new Animal("Jaguar", "Yellow", 100, R.drawable.img_7));
        arrayList.add(new Animal("Lion", "Orange", 300, R.drawable.img_8));
    }

    private void initAdapter() {
        recyclerView = findViewById(R.id.recyclerView);
        AnimalAdapter animalAdapter = new AnimalAdapter(arrayList, this);
        recyclerView.setAdapter(animalAdapter);
    }

    @Override
    public void rvClicked(Animal animal) {
        System.out.println(animal.getName());
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("animal", animal);
        startActivity(intent);
    }
}