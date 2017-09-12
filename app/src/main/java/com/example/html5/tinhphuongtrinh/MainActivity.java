package com.example.html5.tinhphuongtrinh;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnTinh;
    EditText edta, edtb;
    public static int khoaxoa=2017;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTinh=(Button) findViewById(R.id.btnTinh);
        edta=(EditText) findViewById(R.id.edta);
        edtb=(EditText) findViewById(R.id.edtb);
        Intent intent = getIntent();
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edta.getText().length()==0 || edtb.getText().length()==0){
                    Toast toast=Toast.makeText(MainActivity.this, "Mời bạn điền đủ số để tính", Toast.LENGTH_LONG);
                    toast.show();
                }else {
                    Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                    int a = Integer.parseInt(edta.getText().toString());
                    int b = Integer.parseInt(edtb.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putInt("soA", a);
                    bundle.putInt("soB", b);
                    myIntent.putExtra("MyPackage", bundle);
                    startActivityForResult(myIntent,khoaxoa);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==khoaxoa){
            if(resultCode==RESULT_OK){
                Toast.makeText(MainActivity.this,
                        "Wellcome back to MainActivity ! Your last edit text : a="+edta.getText().toString()+", b="+edtb.getText().toString()+", nghiem la: ",
                        Toast.LENGTH_LONG).show();
                edta.setText("");
                edtb.setText("");
            }
        }
    }
}
