package com.happypiebinliu.samplelearning.Fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.happypiebinliu.samplelearning.Model.BookContent;

import static com.happypiebinliu.samplelearning.R.menu.context;

/**
 * 简单列表Fragment
 * 自动生成 通过ListFragment
 */
public class BookListFragment extends ListFragment {

    private Callbacks mCallbacks;

    // 定义一个用于和Activity通信的回调接口，在Activity中需要实现该接口
    public interface Callbacks{
        public void onItemSelected(Integer id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Adapter
        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1,
                BookContent.ITEMS));
    }

    /**
     * 当被加载和显示在Activity的时候，回调这个方法
     * @param context
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof Callbacks)){
            throw  new IllegalStateException("Callbacks is need!!!");
        }
        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallbacks.onItemSelected(BookContent.ITEMS.get(position).id);
    }
    public void setActivateOnItemClick(boolean activateOnItemClick){
        getListView().setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
    }
}
