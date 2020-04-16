package com.example.app05;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    public final int REQUEST_OPEN_IMAGE=203;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                String text=((EditText)(findViewById(R.id.editText))).getText().toString();
                intent.putExtra("texto",text);
                startActivity(intent);

            }
        });
        ImageButton btn2 = findViewById(R.id.imageButton);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent in=new Intent();
                in.setType("*/*");
                in.putExtra(Intent.EXTRA_MIME_TYPES,new String[]{"image/jpg","image/png"});
                in.setAction(Intent.ACTION_GET_CONTENT);
                in.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(in,REQUEST_OPEN_IMAGE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_OPEN_IMAGE:
                if(resultCode== Activity.RESULT_OK){
                    InputStream stream=null;
                    try{
                        stream=getContentResolver().openInputStream(data.getData());
                        Bitmap bitmap= BitmapFactory.decodeStream(stream);
                        //imageView.setImageBitmap(bitmap);
                        ((ImageView)findViewById(R.id.imageView)).setImageBitmap(bitmap);
                    }catch (Exception e){

                    }finally{
                        if(stream!=null){
                            try{
                                stream.close();
                            }catch (Exception e){

                            }
                        }
                    }
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }
}
