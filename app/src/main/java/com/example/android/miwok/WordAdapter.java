package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;

    public WordAdapter(Context context, ArrayList<Word> words, int backgroundColor) {
        super(context, 0, words);
        mBackgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        listItemView.setBackgroundColor(ContextCompat.getColor(getContext(), mBackgroundColor));

        Word currentWord = getItem(position);

        if (currentWord != null) {
            TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_translation);
            miwokTranslation.setText(currentWord.getMiwokTranslation());

            TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.default_translation);
            defaultTranslation.setText(currentWord.getDefaultTranslation());

            ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
            if (currentWord.getImageResourceId() != -1) {
                imageView.setImageResource(currentWord.getImageResourceId());
                imageView.setVisibility(View.VISIBLE);
            } else
                imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
