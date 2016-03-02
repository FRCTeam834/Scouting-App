package org.team834.testproject33333;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class QRCode extends AppCompatActivity {

    public final static int WHITE = 0xFFFFFFFF;
    public final static int BLACK = 0xFF000000;
    public final static int WIDTH = 400;
    public final static int HEIGHT = 400;

    Bitmap code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        Bundle sentStuff = getIntent().getExtras();
        String STR = sentStuff.getString("key");

        ImageView imageView = (ImageView) findViewById(R.id.myImage);
        try {
            Bitmap bitmap = encodeAsBitmap(STR);
            Log.d("sdf", STR);
            imageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        try {
            code = encodeAsBitmap(STR);
        } catch (WriterException e) {
            e.printStackTrace();
        }




    }

    Bitmap encodeAsBitmap(String str) throws WriterException {
        BitMatrix result;
        try {
            result = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, null);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }

        int width = result.getWidth();
        int height = result.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

    public static final int REQUEST_CODE_ASK_PERMISSIONS = 1002;

    public void saveImageWrapper(View v) {
        if (Build.VERSION.SDK_INT >= 23) {
            int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }
        saveImage();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    saveImage();
                } else {
                    // Permission Denied
                    Toast.makeText(this, "WRITE_EXTERNAL_STORAGE Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void saveImage() {

        //MediaStore.Images.Media.insertImage(getContentResolver(), code, "QRCode", "");


        //File sdCardDirectory = Environment.getExternalStorageDirectory();
        //File image = new File(sdCardDirectory, "test.png");
        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath().toString()+"/QRCodes", "QR #"+".png");
        if(!folder.exists())
            folder.mkdirs();


        if(folder.exists()){
            Toast.makeText(getApplicationContext(),"exists",Toast.LENGTH_LONG).show();
        }else{

            Toast.makeText(getApplicationContext()," not exists",Toast.LENGTH_LONG).show();
        }

        FileOutputStream outStream;
        try {

            outStream = new FileOutputStream(folder);
            code.compress(Bitmap.CompressFormat.PNG, 100, outStream);
        /* 100 to keep full quality of the image */

            outStream.flush();
            outStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/


/*
    public static void saveImage() {

        OutputStream output;
        // Find the SD Card path
        File filepath = Environment.getExternalStorageDirectory();

        // Create a new folder in SD Card
        File dir = new File(filepath.getAbsolutePath()
                + "/WhatSappIMG/");
        dir.mkdirs();

        // Retrieve the image from the res folder
        BitmapDrawable drawable = (BitmapDrawable) principal.getDrawable();
        Bitmap bitmap1 = drawable.getBitmap();

        // Create a name for the saved image
        File file = new File(dir, "Wallpaper.jpg" );

        try {

            output = new FileOutputStream(file);

            // Compress into png format image from 0% - 100%
            bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, output);
            output.flush();
            output.close();

        }

        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }



    public static void addImageToGallery(final String filePath, final Context context) {

        ContentValues values = new ContentValues();

        values.put(Images.Media.DATE_TAKEN, System.currentTimeMillis());
        values.put(Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.MediaColumns.DATA, filePath);

        context.getContentResolver().insert(Images.Media.EXTERNAL_CONTENT_URI, values);
    }

}*/