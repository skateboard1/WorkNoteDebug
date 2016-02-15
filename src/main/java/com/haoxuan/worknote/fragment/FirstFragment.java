package com.haoxuan.worknote.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.haoxuan.worknote.R;
import com.haoxuan.worknote.activity.ArticleDetailActivity;
import com.haoxuan.worknote.fragment.dialog.CardDetailFragment;

import java.util.ArrayList;

/**
 * Created by skateboard on 2016/1/4.
 */
public class FirstFragment extends NoteBaseFragment {
   private RecyclerView contentList;
   private  ArrayList<String> data;

    private void initComponent(View view)
    {
        data=new ArrayList<>();
        for(int i=0;i<50;i++)
        {
            data.add("The String number is "+i);
        }
        contentList= (RecyclerView) view.findViewById(R.id.list);
        contentList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        contentList.setAdapter(adapter);
    }

    private RecyclerView.Adapter adapter=new RecyclerView.Adapter() {
        class Holder extends RecyclerView.ViewHolder
        {
           TextView description;
            CardView card;
            public Holder(View itemView) {
                super(itemView);
                description= (TextView) itemView.findViewById(R.id.description);
                card= (CardView) itemView.findViewById(R.id.card);
            }
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            View view=null;
            view=inflater.inflate(R.layout.cotent_list_item_layout,parent,false);
            Holder holder=new Holder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((Holder)(holder)).description.setText(data.get(position));
            ((Holder)(holder)).card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent arDetail=new Intent(getActivity(),ArticleDetailActivity.class);
                    startActivity(arDetail);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    protected void loadingFinished() {
        View rootView=getView();
        initComponent(rootView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.first_fragment_layout;
    }
}
