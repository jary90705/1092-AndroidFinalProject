package com.example.a109_2_final_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{

    //參考04.5
    private final LinkedList<String> mTypeList;
    private final LinkedList<String> mValueList;
    private final LinkedList<String> mDescribeList;
    private final LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordTypeView;
        public final TextView wordValueView;
        public final TextView wordDesView;
        final WordListAdapter mAdapter;


        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordTypeView = itemView.findViewById(R.id.word_type);
            wordValueView = itemView.findViewById(R.id.word_value);
            wordDesView = itemView.findViewById(R.id.word_describe);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            /*// Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element_title = mTitleList.get(mPosition);
            String element_content = mWordList.get(mPosition);
            // Change the word in the mWordList.
            //mWordList.set(mPosition, "Clicked! " + element);
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
            Intent intent = new Intent(view.getContext(), MainActivity2.class);
            intent.putExtra("Title", element_title);
            intent.putExtra("Content", element_content);
            view.getContext().startActivity(intent);*/
        }
    }

    public WordListAdapter(Context context, LinkedList<String> wordList_type, LinkedList<String> wordList_value, LinkedList<String> wordList_describe) {
        mInflater = LayoutInflater.from(context);
        this.mTypeList = wordList_type;
        this.mValueList = wordList_value;
        this.mDescribeList = wordList_describe;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }



    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent_type = mTypeList.get(position);
        String mCurrent_value = mValueList.get(position);
        String mCurrent_describe = mDescribeList.get(position);
        holder.wordTypeView.setText(mCurrent_type);
        holder.wordValueView.setText(mCurrent_value);
        holder.wordDesView.setText(mCurrent_describe);
    }

    @Override
    public int getItemCount() {
        return mTypeList.size();
    }
}
