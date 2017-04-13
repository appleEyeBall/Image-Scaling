package com.example.oluwatise.instaslam.BackgroundTasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.example.oluwatise.instaslam.Model.ImageModel;

/**
 * Created by Oluwatise on 4/10/2017.
 */

public class DecodeBitmap extends AsyncTask<Void, Void, Bitmap> {
    ImageModel imageModel;
    ImageView imgView;

    public DecodeBitmap(ImageModel imageModel, ImageView imgView) {
        this.imageModel = imageModel;
        this.imgView = imgView;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        Bitmap bitmap = null;
        // Convert the Uri to String
        String imagelocationString = imageModel.getImageUri().toString();
        // Get the Image dimensions
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagelocationString, options);
        int height = options.outHeight;
        int width = options.outWidth;
        // Get the inSampleSize
        int inSampleSize = 1; //initial value
        // Reduce the size to less than 400 pixels
        if (height >= 400 || width>= 400) {
            int halfHeight = height/2;
            int halfWidth = width/2;
            while ((halfHeight/inSampleSize) >=400 && (halfWidth/inSampleSize) >=400) {
                inSampleSize*=2;
            }
            options.inSampleSize = inSampleSize;
            options.inJustDecodeBounds = false;
            //now decode the file using those options
            bitmap = BitmapFactory.decodeFile(imagelocationString, options);

        }

        if (bitmap != null) {
            return bitmap;
        }
        else {
            return bitmap;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imgView.setImageBitmap(bitmap);
    }
}
