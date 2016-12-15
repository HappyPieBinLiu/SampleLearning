package com.happypiebinliu.samplelearning.ActivityUI.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.happypiebinliu.samplelearning.R;

public class SimpleAlterDialogActivity extends AppCompatActivity implements View.OnClickListener {

    TextView show;
    Button buttonSimple, buttonList,buttonCheckSimple, buttonCheckMulti, myList, myView;
    String[] items = {"B.LIU", "LIUBIN", "劉斌", "リュウヒン"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_alter_dialog);
        show = (TextView) findViewById(R.id.show);

        buttonSimple = (Button) findViewById(R.id.btnA);
        buttonList = (Button) findViewById(R.id.btnB);
        buttonCheckMulti = (Button) findViewById(R.id.btnC);
        buttonCheckSimple = (Button) findViewById(R.id.btnD);
        myList = (Button) findViewById(R.id.btnF);
        myView= (Button) findViewById(R.id.btnG);

        buttonSimple.setOnClickListener(this);
        buttonList.setOnClickListener(this);
        buttonCheckSimple.setOnClickListener(this);
        buttonCheckMulti.setOnClickListener(this);
        myList.setOnClickListener(this);
        myView.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnA:
                simple(view);
                break;
            case R.id.btnB:
                simpleList(view);
                break;
            case R.id.btnC:
                singleChoice(view);
                break;
            case R.id.btnD:
                multiChoice(view);
                break;
            case R.id.btnF:
                myList(view);
                break;
            case R.id.btnG:
                myView(view);
                break;
            default:
                break;

        }

    }

    private void myView(View view) {
        TableLayout loginForm = (TableLayout) getLayoutInflater().inflate(R.layout.login, null);
        new AlertDialog.Builder(this)
                .setTitle("自定义列表对话框")
                .setIcon(R.drawable.tool)
                .setView(loginForm)
                .setPositiveButton("Login In", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            // login
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create().show();

    }


    private void myList(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("自定义列表对话框")
                .setIcon(R.drawable.tool)
                .setAdapter(new ArrayAdapter<String>(this, R.layout.array_item, items), null);
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();
    }

    private void multiChoice(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("单选列表对话框")
                .setIcon(R.drawable.tool)
                .setMultiChoiceItems(items, new boolean[]{false, true, false, true}, null);
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();
    }

    private void singleChoice(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("单选列表对话框")
                .setIcon(R.drawable.tool)
                .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        show.setText("YOU select the :::" + items[i]);
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();
    }

    private void simpleList(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("简单列表项对话框")
                .setIcon(R.drawable.tool)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        show.setText("YOU select the :::" + items[i]);
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();
    }

    public void simple(View view){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this)
                .setTitle("Simple Dialog")
                .setIcon(R.drawable.tool)
                .setMessage("对话框的测试内容¥n第二行内容");
        setPositiveButton(alertBuilder);
        setNegativeButton(alertBuilder)
        .create()
        .show();
    }

    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder alertBuilder) {
        return alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                show.setText("Cancel is clicked!!");
            }
        });
    }

    public AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {

        return builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                show.setText("OK is clicked!!");
            }
        });
    }


}
