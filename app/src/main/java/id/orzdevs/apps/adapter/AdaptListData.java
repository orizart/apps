package id.orzdevs.apps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.orzdevs.apps.R;
import id.orzdevs.apps.models.MData;

public class AdaptListData extends RecyclerView.Adapter<AdaptListData.ListDataViewHolder> {

    private Context mCtx;
    private List<MData> DataList;

    public AdaptListData(Context mCtx, List<MData> DataList) {
        this.mCtx = mCtx;
        this.DataList = DataList;
    }

    @Override
    public AdaptListData.ListDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.mock_data_list, null);
        return new AdaptListData.ListDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdaptListData.ListDataViewHolder holder, final int position) {
        final MData data = DataList.get(position);

        holder.tvIsi.setText(data.getData());

        holder.tvIsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mCtx, data.getData(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return DataList.size();
    }

    class ListDataViewHolder extends RecyclerView.ViewHolder {

        private TextView tvIsi;

        public ListDataViewHolder(View itemView) {
            super(itemView);

            tvIsi = itemView.findViewById(R.id.tvIsi);
        }
    }
}