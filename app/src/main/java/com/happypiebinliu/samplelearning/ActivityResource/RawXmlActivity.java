package com.happypiebinliu.samplelearning.ActivityResource;

import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.happypiebinliu.samplelearning.R;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class RawXmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raw_xml);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取Xml的资源
                XmlResourceParser xmlResourceParser = getResources().getXml(R.xml.books);
                StringBuilder stringBuilder = new StringBuilder("");
                try {
                    while (xmlResourceParser.getEventType() != XmlResourceParser.END_DOCUMENT){
                        if (xmlResourceParser.getEventType() == XmlResourceParser.START_TAG){
                            String tagName = xmlResourceParser.getName();
                            if (tagName.equals("book")){
                                String bookName = xmlResourceParser.getAttributeValue(null, "price");
                                stringBuilder.append("price:");
                                stringBuilder.append(bookName);
                                String bookPrice = xmlResourceParser.getAttributeValue(null, "time");
                                stringBuilder.append("Time :");
                                stringBuilder.append(bookPrice);
                                stringBuilder.append("BookName:");
                                stringBuilder.append(xmlResourceParser.nextText());
                            }
                            stringBuilder.append("\n");
                        }
                        xmlResourceParser.next();
                    }
                    EditText show = (EditText) findViewById(R.id.show);
                    show.setText(stringBuilder.toString());
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
