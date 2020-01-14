package com.example.lastest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lastest.db.City;
import com.example.lastest.db.County;
import com.example.lastest.db.Province;
import com.example.lastest.util.HttpUtill;
import com.example.lastest.util.Utility;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static org.litepal.LitePalApplication.getContext;

public class Selectcity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final EditText searchInput;
        setContentView(R.layout.select);
        searchInput = (EditText)findViewById(R.id.writecity);
        final String string = searchInput.getText().toString();
        Button button;
        button=(Button)findViewById(R.id.nav_button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("hw",searchInput.getText().toString());
                setResult(RESULT_OK, intent);//设置resultCode，onActivityResult()中能获取到
                finish();//使用完成后结束当前Activity的生命周期
                //startActivity(intent);

            }
        });
    }

}

