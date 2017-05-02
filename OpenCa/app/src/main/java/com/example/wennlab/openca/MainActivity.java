package com.example.wennlab.openca;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import android.widget.ImageView;
import android.support.design.widget.FloatingActionButton;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.imageView)
    ImageView imageView;

    Bundle extras=data.getExtras();
    Bitmap bmp=(Bitmap)extras.get("data");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        FloatActionButton fab = (FloatActionButton)findViewById(R.id.fab);
    }


    public static String BitmapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);
        byte[]b=baos.toByteArray();

        return Base64.encodeToString(b,Base64.DEFAULT);
    }
    public static Bitmap StringToBitmap(String encodedString){
        try{
            byte []encodeByte=Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte,0,encodeByte.length);
            return  bitmap;
        }catch (Exception e){
            e.getMessage();
            return  null;
        }

    }
}
