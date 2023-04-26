package kg.geeks.rvclick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.RVViewHolder> {

    private ArrayList<Animal> arrayList;
    private AnimalClick animalClick;

    public AnimalAdapter(ArrayList<Animal> arrayList, AnimalClick animalClick) {
        this.arrayList = arrayList;
        this.animalClick = animalClick;
    }

    @NonNull
    @Override
    public AnimalAdapter.RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RVViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.RVViewHolder holder, int position) {
        holder.onBind(arrayList.get(position));
        holder.itemView.setOnClickListener(view ->
                animalClick.rvClicked(arrayList.get(position)));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RVViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private ImageView ivItem;

        public RVViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private void initUI() {
            tvName = itemView.findViewById(R.id.tv_item_name);
            ivItem =itemView.findViewById(R.id.iv_item);
        }

        public void onBind(Animal animal){
            initUI();
            tvName.setText(animal.getName());
            ivItem.setImageResource(animal.getImage());
        }
    }
}
