package com.codyy.wideschool.wideschoolexample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWebView();
    }

    @SuppressLint({"JavascriptInterface","SetJavaScriptEnabled"})
    private void initWebView(){
        mWebView = findViewById(R.id.webview);
        mButton = findViewById(R.id.btn_js);
        mWebView.getSettings().setDefaultTextEncodingName("utf-8");
        mWebView.getSettings().setJavaScriptEnabled(true);

        final Student student = new Student();
        student.setName("陆东海");
        student.setAge(28);
        student.setSex("男");
        student.setSchoolName("阔地小学");
        student.setClickListener(new Contact() {
            @JavascriptInterface
            @Override
            public void callAndroid(String phone) {
                Toast.makeText(MainActivity.this,phone,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Html2Activity.class);
                startActivity(intent);
            }
        });
        mWebView.addJavascriptInterface(student,"myObj");
        mWebView.loadUrl("file:///android_asset/test.html");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.loadUrl("javascript:callH5('Android OK!')");

            }
        });

    }

    interface Contact{
        @JavascriptInterface
        void callAndroid(String phone);
    }

    class Student{
        private String name;
        private int age;
        private String sex;
        private String schoolName;
        private Contact contact;

        public void setClickListener(Contact listener){
            contact = listener;
        }

        @JavascriptInterface
        public Contact getClickListener(){
            return contact;
        }

        @JavascriptInterface
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @JavascriptInterface
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @JavascriptInterface
        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }
    }
}
