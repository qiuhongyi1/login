package com.example.qiuhongyi.login;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.qiuhongyi.login.R.id.et1;
import static com.example.qiuhongyi.login.R.id.et2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button) this.findViewById(R.id.help);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("帮助").setMessage("输入正确的用户名密码");
                builder.show();



            }
        });
        Button btn2=(Button) findViewById(R.id.login);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater=getLayoutInflater();
                final View textEntryView = inflater.inflate(R.layout.login_dialog, null);
                builder.setView(textEntryView).setTitle("login")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog,int id){
                                final EditText etU = (EditText)textEntryView.findViewById(et1);
                                final EditText etP = (EditText)textEntryView.findViewById(et2);
                                String userName = etU.getText().toString().trim();
                                String password = etP.getText().toString().trim();
                                if(userName.equals("abc") && password.equals("123")){
                                    Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();

                                }else{
                                    Toast.makeText(MainActivity.this, "密码或用户名错误", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                builder.show();
            }
        });
    }
}
