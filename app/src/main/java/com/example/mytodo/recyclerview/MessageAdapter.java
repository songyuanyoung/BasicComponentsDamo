package com.example.mytodo.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytodo.MainActivity;
import com.example.mytodo.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    public interface OnDetailsButtonClickListener {

        void onDetailsButtonClick();

    }

    private List<String> mMessageList;

    private Context mContext;

    private OnDetailsButtonClickListener mOnDetailsButtonClickListener;

    public MessageAdapter(List<String> messageList, OnDetailsButtonClickListener onDetailsButtonClickListener) {
        mMessageList = messageList;
        mOnDetailsButtonClickListener = onDetailsButtonClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final String message = mMessageList.get(position);
        holder.mMessageTextView.setText(message);
        holder.mDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mOnDetailsButtonClickListener != null) {
                    mOnDetailsButtonClickListener.onDetailsButtonClick();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mMessageTextView;
        private Button mDetailsButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mMessageTextView = (TextView) itemView.findViewById(R.id.message_textview);
            mDetailsButton = (Button) itemView.findViewById(R.id.detail_button);
        }
    }

}
