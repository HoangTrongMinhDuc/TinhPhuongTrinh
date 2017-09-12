package com.example.html5.tinhphuongtrinh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tvkq;
    Button btnBack;
    public static String trave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvkq = (TextView)findViewById(R.id.tvkq);
        Intent callerIntent = getIntent();
        Bundle packBundle = callerIntent.getBundleExtra("MyPackage");
        int a = packBundle.getInt("soA");
        int b = packBundle.getInt("soB");
        giaiPT(a,b);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }
    public void back(){
        Intent intent = new Intent();
        intent.putExtra(trave,tvkq.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
    public void giaiPT(int a, int b){
        if(a==0){
            if(b==0) {
                tvkq.setText("Phương trình vô số nghiệm");
            }else {
                tvkq.setText("Phương trình vô nghiệm");
            }
        }else tvkq.setText(String.valueOf((float)-b/a));
    }
}
