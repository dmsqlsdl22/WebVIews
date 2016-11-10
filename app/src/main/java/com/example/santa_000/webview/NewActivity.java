package com.example.santa_000.webview;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import static com.example.santa_000.webview.R.id.img1;
import static com.example.santa_000.webview.R.id.img2;

public class NewActivity extends AppCompatActivity {
    ListView m_ListView;
    CustomAdapter m_Adapter;
    ImageButton im1,im2;
    TextView bs1,bs2,bs3,bs4,bs5;
    TabHost tabHost ;
    LinearLayout linear1,linear2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#EA1365"));
        }

        im1 = (ImageButton) findViewById(img1);
        im2 = (ImageButton) findViewById(img2);

        bs1 = (TextView) findViewById(R.id.textView);
        bs2 = (TextView) findViewById(R.id.textView1);
        bs3 = (TextView) findViewById(R.id.textView2);
        bs4 = (TextView) findViewById(R.id.textView3);
        bs5 = (TextView) findViewById(R.id.textView4);
        linear1= (LinearLayout) findViewById(R.id.lay1);



       bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear1.setVisibility(View.VISIBLE);
                linear2.setVisibility(View.INVISIBLE);
            }
        });
        bs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear1.setVisibility(View.INVISIBLE);
                linear2.setVisibility(View.VISIBLE);
            }
        });
        TabHost.TabSpec tabSpec1= tabHost.newTabSpec("Tab1").setIndicator("게임",getResources().getDrawable(R.drawable.i_1));

        tabSpec1.setContent(R.id.tab1);
        tabHost.addTab(tabSpec1);

        //Tab2 Setting
        TabHost.TabSpec tabSpec2= tabHost.newTabSpec("Tab2");
        tabSpec2.setIndicator("플레");
        tabSpec2.setContent(R.id.tab2);
        tabHost.addTab(tabSpec2);

        //Tab3 Setting
        TabHost.TabSpec tabSpec3= tabHost.newTabSpec("Tab3");
        tabSpec3.setIndicator("?");
        tabSpec3.setContent(R.id.tab3);
        tabHost.addTab(tabSpec3);
        for(int i = 0;i<tabHost.getTabWidget().getChildCount(); i++){
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#F6F6F6"));
        }

        m_Adapter = new CustomAdapter();

        m_ListView = (ListView) findViewById(R.id.listView1);

        m_ListView.setAdapter(m_Adapter);

        m_Adapter.add("2016/11/08",2);
        m_Adapter.add("강남에서",1);
        m_Adapter.add("혼밥하시는분~~",1);
        m_Adapter.add("저요",0);
        m_Adapter.add("저두요",1);
        m_Adapter.add("뭐드세요??",1);
        m_Adapter.add("밥버거 먹습니다ㅜ",0);


        findViewById(R.id.button1).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText1) ;
                String inputValue = editText.getText().toString() ;
                editText.setText("");
                refresh(inputValue,1);
            }
        });

    }

/* public void mOnClick(View v) {    // 15행.
        switch (v.getId()) {
            case R.id.textView:
                .setVisibility(View.VISIBLE);
                mScrollV1.setVisibility(View.INVISIBLE);
                break;
            case R.id.textView1:
                mScrollV.setVisibility(View.INVISIBLE);
                mScrollV1.setVisibility(View.VISIBLE);
                break;
           case R.id.textView2:
                setContentView(R.layout.activity_gyeng1);
                break;
            case R.id.textView3:
                setContentView(R.layout.activity_gyeng2);
                break;
            case R.id.textView4:
                setContentView(R.layout.activity_incheon);
                break;//스크롤뷰
        }
    }*/
    public void WonClick(View v){
        switch (v.getId()){
            case img1:
                setContentView(R.layout.activity_main);
                Intent ints = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ints);
                break;//웹뷰

        }
    }

    private void refresh (String inputValue, int _str) {
        m_Adapter.add(inputValue,_str) ;
        m_Adapter.notifyDataSetChanged();//채팅
    }
}


