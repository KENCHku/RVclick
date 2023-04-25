package kg.geeks.rvclick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolder> {

    private ArrayList<Animal> arrayList;
    private RVClick rvClick;

    public RVAdapter(ArrayList<Animal> arrayList, RVClick rvClick) {
        this.arrayList = arrayList;
        this.rvClick =rvClick;
    }

    @NonNull
    @Override
    public RVAdapter.RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RVViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.RVViewHolder holder, int position) {
        holder.onBind(arrayList.get(position));
        holder.itemView.setOnClickListener(view ->
                rvClick.rvClicked(arrayList.get(position)));
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
