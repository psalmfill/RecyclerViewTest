package com.example.samfield.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv);
        String[] names = {
                "Janet","Utibe","Ada","Mark","Okon","Samfield","Melody","Felicia",
                "Fabulous","Sherg","Bassey","Nsikak", "Tom", "Vincent",
                "Loverth","Sherg","Fortune","Nsikak", "Gate", "Linus",
                "Agnes","John","Fortune","James", "Tom", "Jane",
                "Bassey","Gabriel","Fortune","Nsikak", "Tom", "Vincent",
                "Moses","Sherg","Bright","Margrete", "Tom", "Weeks",
                "Fabulous","Sherg","Kate","Maggi", "Tom", "Lui",
        };

        List<Person> people = new ArrayList<>();


        for(int np =0; np < names.length; np++){

            Person person = new Person();
            person.setName(names[np]);
            person.setAge((int) (Math.random() * 49 + 1));
            person.setHeight((Math.random() * 49 + 1)/2);
            if(np %2 ==0){
                person.setGender("female");
            }else {
                person.setGender("male");
            }
            people.add(person);
        }

        MyAdapter myAdapter = new MyAdapter(this,people);

        mRecyclerView.setAdapter(myAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL);
        mRecyclerView.addItemDecoration(decoration);


    }

    public class MyAdapter extends  RecyclerView.Adapter<MyHolder>{

        LayoutInflater mInflater;
        List<Person> names;

        public MyAdapter(Context context,  List<Person> people){
            mInflater = LayoutInflater.from(context);
            names = people;
        }
        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view = mInflater.inflate(R.layout.single_row,viewGroup,false);
            MyHolder myHolder = new MyHolder(view);

            return myHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder myHolder, int position) {
            Person person = names.get(position);
            myHolder.mPerson.setText("Name: "+ person.getName());
            myHolder.mGender.setText("Gender: "+ person.getGender());
            myHolder.mAge.setText("Age: "+ person.getAge());
            myHolder.mHeight.setText("Height: "+String.valueOf(person.getHeight()));

        }

        @Override
        public int getItemCount() {
            return names.size();
        }
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView mPerson;
        TextView mGender;
        TextView mAge;
        TextView mHeight;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mPerson = itemView.findViewById(R.id.name_of_people);
            mGender = itemView.findViewById(R.id.person_gender);
            mAge = itemView.findViewById(R.id.person_age);
            mHeight = itemView.findViewById(R.id.person_height);
        }
    }


}
