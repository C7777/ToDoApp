package com.lovishsoftware.chinmay.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Chinmay on 20-05-2017.
 */

public class SecondActivity extends AppCompatActivity{

    Button button;
    EditText editText;
    DbListHelper dbListHelper;
    String list;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText= (EditText) findViewById(R.id.edittext);
        list=editText.getText().toString();
        Log.e("SecondActivity", "list: "+list.toString());
        dbListHelper=new DbListHelper(this);

        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SecondActivity", "Inside SecondActivity");
                boolean result=dbListHelper.inserData(editText.getText().toString());
                if(result == true)
                {
                    Toast.makeText(SecondActivity.this, "Data Inserted" , Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(SecondActivity.this, "Data Not Inserted" , Toast.LENGTH_LONG).show();
                }
                Intent intent=new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
