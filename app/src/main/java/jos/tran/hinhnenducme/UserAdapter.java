package jos.tran.hinhnenducme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.FullScreenContentCallback;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private ArrayList<String> arrayList;
    private Context context;

    public UserAdapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder,@SuppressLint("RecyclerView") int position) {

        Glide.with(context).load(arrayList.get(position)).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                              Intent intent = new Intent(context,SetWallPaper.class);
                            intent.putExtra("images",arrayList.get(position));
                            context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

            return arrayList.size();

    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_user);
        }
    }
}
