package com.divide.ibitech.divide_ibitech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.divide.ibitech.divide_ibitech.Adapter.MyAdapter;
import com.divide.ibitech.divide_ibitech.Models.TitleChild;
import com.divide.ibitech.divide_ibitech.Models.TitleCreator;
import com.divide.ibitech.divide_ibitech.Models.TitleParent;

import java.util.ArrayList;
import java.util.List;

public class ManageSymptoms extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_symptoms);

        recyclerView = findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(this, initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(adapter);

    }

    private List<ParentObject> initData() {
        TitleCreator titleCreator = TitleCreator.get(this);
        List<TitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObject = new ArrayList<>();
        for(TitleParent title:titles){
            List<Object> childList = new ArrayList<>();
            childList.add(new TitleChild("Treatment","Date added : 2018-08-30"));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;
    }
}
