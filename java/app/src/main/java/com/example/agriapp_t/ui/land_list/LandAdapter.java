package com.example.agriapp_t.ui.land_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriapp_t.R;
import com.example.agriapp_t.data.model.Land;

public class LandAdapter extends ListAdapter<Land, LandAdapter.LandHolder> {

    private static final DiffUtil.ItemCallback<Land> DIFF_CALLBACK = new DiffUtil.ItemCallback<Land>() {
        @Override
        public boolean areItemsTheSame(@NonNull Land oldItem, @NonNull Land newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Land oldItem, @NonNull Land newItem) {
            return false;
        }
    };

    private OnItemClickListener listener;

    public LandAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public LandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.land_card, parent, false);
        return new LandHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LandHolder holder, int position) {
        Land currentLand = getItem(position);
        holder.textViewTitle.setText(currentLand.getTitle());
        holder.textViewArea.setText(String.valueOf(currentLand.getLandArea()));
        holder.textViewType.setText(currentLand.getLandType());
    }

    class LandHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewArea;
        TextView textViewType;

        public LandHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.landTitleCard);
            textViewArea = itemView.findViewById(R.id.landAreaCard);
            textViewType = itemView.findViewById(R.id.landTypeCard);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(Land land);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
