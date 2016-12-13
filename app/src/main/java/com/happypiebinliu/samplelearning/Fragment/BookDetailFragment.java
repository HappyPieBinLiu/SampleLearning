package com.happypiebinliu.samplelearning.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.happypiebinliu.samplelearning.Model.BookContent;
import com.happypiebinliu.samplelearning.R;

/**
 * 一个简单的Fragment
 * 开发Fragment和Activity有很多相似的地方
 * 显示图书详情
 * 这只是一个片段，是不能单独作为UI进行使用的，必须依附于Activity
 */
public class BookDetailFragment extends Fragment {
    public static final String ITEM_ID = "item_id";
    BookContent.Book book;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ITEM_ID)) {
            book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_book_detail, container, false);
        if (book != null){
            ((TextView)rootView.findViewById(R.id.book_title)).setText(book.title);
            ((TextView)rootView.findViewById(R.id.book_desc)).setText(book.desc);
        }
        return rootView;
    }

}
