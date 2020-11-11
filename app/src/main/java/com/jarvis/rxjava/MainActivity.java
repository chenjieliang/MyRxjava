package com.jarvis.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jarvis.rxjava.rx.Emitter;
import com.jarvis.rxjava.rx.Observable;
import com.jarvis.rxjava.rx.ObservableOnSubscribe;
import com.jarvis.rxjava.rx.Observer;
import com.jarvis.rxjava.rx.operators.Function;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(Emitter<String> emitter) {
                String data = "一条新的数据来了";
                emitter.onNext(data);
            }
        }).map(new Function<String, String>() {

            @Override
            public String apply(String s) {
                s += "哈哈哈哈";
                return s;
            }
        }).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe() {
                Log.i(TAG,"已加入订阅");
            }

            @Override
            public void onNext(Integer s) {
                Log.i(TAG,"接收消息长度" + s);
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
