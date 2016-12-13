package com.happypiebinliu.samplelearning.Activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.happypiebinliu.samplelearning.Fragment.BookDetailFragment;
import com.happypiebinliu.samplelearning.Fragment.BookListFragment;
import com.happypiebinliu.samplelearning.R;

public class BookTwopaneActivity extends Activity implements BookListFragment.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_twopane);
    }

    @Override
    public void onItemSelected(Integer id) {
        // 创建用于传递数据的Bundle
        Bundle arguments = new Bundle();
        arguments.putInt(BookDetailFragment.ITEM_ID, id);
        BookDetailFragment fragment = new BookDetailFragment();
        fragment.setArguments(arguments);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.book_detail_container,fragment);
        // 可以通过back键返回到替换之前的状态
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
