package com.happypiebinliu.samplelearning.Activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.happypiebinliu.samplelearning.Fragment.BookDetailFragment;
import com.happypiebinliu.samplelearning.Fragment.BookListFragment;
import com.happypiebinliu.samplelearning.R;

public class BookListActivity extends Activity implements BookListFragment.Callbacks {

    private boolean mTwopane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        if (findViewById(R.id.book_detail_container) != null){
            mTwopane = true;
            ((BookListFragment)getFragmentManager().findFragmentById(R.id.book_list)).setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(Integer id) {
        if (mTwopane){
            // 创建用于传递数据的Bundle
            Bundle arguments = new Bundle();
            arguments.putInt(BookDetailFragment.ITEM_ID, id);
            BookDetailFragment fragment = new BookDetailFragment();
            fragment.setArguments(arguments);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.book_detail_container, fragment);
            fragmentTransaction.commit();
        }else {
            Intent detailIntent = new Intent(this, BookDetailActivity.class);
            detailIntent.putExtra(BookDetailFragment.ITEM_ID, id);
            startActivity(detailIntent);
        }

    }
}
