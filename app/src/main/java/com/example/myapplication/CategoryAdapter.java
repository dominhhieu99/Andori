package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.Chat;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;


    public boolean isOnLoadMore() {
        return onLoadMore;
    }

    public void setOnLoadMore(boolean onLoadMore) {
        this.onLoadMore = onLoadMore;
    }

    private boolean onLoadMore = true;

    private List<Chat> categories;

    public CategoryAdapter(Context context, List<Chat> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == ITEM) {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.item_layout, parent, false);
            return new CateHolder(view);
        } else {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.loadmore, parent, false);
            return new LoadHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CateHolder) {
            Chat category = categories.get(position);
            if (category.getAuthor() == 1){
                ((CateHolder) holder).tvAdmin.setVisibility(View.VISIBLE);
                ((CateHolder) holder).tvAdmin.setText(category.getContent().getRendered());
                ((CateHolder) holder).tvHuyNguyen.setVisibility(View.GONE);
                ((CateHolder) holder).imgHuyNguyen.setVisibility(View.GONE);
            }
            if (category.getAuthor() == 0){
                ((CateHolder) holder).tvAdmin.setVisibility(View.GONE);
                ((CateHolder) holder).tvHuyNguyen.setVisibility(View.VISIBLE);
                ((CateHolder) holder).imgHuyNguyen.setVisibility(View.VISIBLE);
                Picasso.get().load(category.getAuthorAvatarUrls().get48())
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(((CateHolder) holder).imgHuyNguyen);
            }

        } else if (holder instanceof LoadHolder){

        }
    }

    int ITEM = 1;
    int LOAD_MORE = 2;

    @Override
    public int getItemViewType(int position) {

        if (onLoadMore){
            if (position == categories.size() - 1)
                return LOAD_MORE;
            else return ITEM;
        }else return ITEM;
      }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
