package com.example.myapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.Model.Person;
import com.example.myapp.R;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder>{
    private Context context;
    private List<Person>personList;
    private RecycleViewClickListener listener;

    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    public void setListenerOnRecycleView(RecycleViewClickListener listener)
    {
        this.listener = listener;
    }


    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.demoforadduser,parent,false);
        PersonViewHolder holder = new PersonViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.textViewId.setText(person.getId());
        holder.textViewName.setText(person.getName());
        holder.textViewMobileNumber.setText(person.getMobileNumber());
        holder.textViewStatus.setText(person.getProfession());
        Glide.with(context).load(person.getImageUrl()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textViewId;
        TextView textViewName;
        TextView textViewMobileNumber;
        TextView textViewStatus;
        ImageView imageView;


        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.serialIdDemoAddUser);
            textViewName = itemView.findViewById(R.id.nameIdDemoAddUser);
            textViewMobileNumber = itemView.findViewById(R.id.mobNumberIdDemoAddUser);
            textViewStatus = itemView.findViewById(R.id.professionIdListDemo);
            imageView = itemView.findViewById(R.id.imageIdDemoAddUser);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(listener!=null && position!=RecyclerView.NO_POSITION)
            {
                listener.onItemClickListenerOnRecycleView(position);
            }

        }
    }

    public interface RecycleViewClickListener
    {
        void onItemClickListenerOnRecycleView(int position);
    }
}
