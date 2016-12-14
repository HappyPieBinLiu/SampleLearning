package com.happypiebinliu.samplelearning.Activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.happypiebinliu.samplelearning.Fragment.BookDetailFragment;
import com.happypiebinliu.samplelearning.R;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        // 将ActionBar上的图转换成可以单击的按纽
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null){
            // 创建用于传递数据的Bundle
            Bundle arguments = new Bundle();
            arguments.putInt(BookDetailFragment.ITEM_ID, getIntent().getIntExtra(BookDetailFragment.ITEM_ID, 0));
            BookDetailFragment fragment = new BookDetailFragment();
            fragment.setArguments(arguments);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.book_detail_container,fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(this, BookListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
