package com.happypiebinliu.samplelearning.ActivityUI.Others;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.happypiebinliu.samplelearning.R;

public class SearchViewActivity extends AppCompatActivity {

    private SearchView searchView;
    private ListView listView;

    private String[] mString = {
            "aaaaaaaa", "bbbbbbb", "cccccccc"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mString));
        listView.setTextFilterEnabled(true);

        searchView = (SearchView) findViewById(R.id.searchView);
        // 设置是否默认自动缩小为图标
        searchView.setIconifiedByDefault(false);
        // 显示搜索按钮
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(SearchViewActivity.this, "Your select is " + query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    listView.clearTextFilter();
                }else {
                    listView.setFilterText(newText);
                }
                return true;
            }
        });
    }
}
