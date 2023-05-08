package com.lvwanjie.myapplication.androidTest.widget.TestService;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lvwanjie.myapplication.R;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    List<FileState> list;

    public void setData(List list){
        this.list = list;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public TaskAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.MyViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        if(list == null){
            return 0;
        }
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ProgressBar progressBar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progress);
        }

        public void bind(FileState fileState){
            progressBar.setProgress((int) (fileState.getProgress()*1000));
        }
    }
}
