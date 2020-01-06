package com.example.mytodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import timber.log.Timber;

public class ListViewAdapter extends BaseAdapter {

    private List<String> mMassagesList;



    public ListViewAdapter(List<String> mMassagesList) {
        this.mMassagesList = mMassagesList;
    }

    @Override
    public int getCount() {
        return mMassagesList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMassagesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);

            TextView messageTextView = convertView.findViewById(R.id.message_textview);

            viewHolder = new ViewHolder(messageTextView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.getmMessageTextView().setText(mMassagesList.get(position));

        return convertView;
    }

    private static class ViewHolder {

        private TextView mMessageTextView;

        public ViewHolder(TextView mMessageTextView) {
            this.mMessageTextView = mMessageTextView;
        }

        public TextView getmMessageTextView() {
            return mMessageTextView;
        }

    }
}
