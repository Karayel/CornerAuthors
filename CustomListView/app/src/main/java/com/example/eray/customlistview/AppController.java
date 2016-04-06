package com.example.eray.customlistview;


import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    /**
     * Just return something
     * @param unused This is the first parameter to AppController method
     * @return type is syncronized
     */
    public static synchronized AppController getInstance() {
        return mInstance;
    }

    /**
     * According to queue add the new request
     * @param args unused This is the first parameter to getRequestQueue method
     * @return type is RequestQueue
     */
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }
    /**
     * Loading the image
     * @return type is ImageLoader
     */
    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    /**
     * Setting the default tag if tag is empty
     * @param req This is the first parameter to addToRequestQueue method
     * @param tag This is the second parameter to addToRequestQueue method
     * @param <T> This is the third parameter to addToRequestQueue method
     * @return Nothing
     */
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    /**
     * Setting the default tag if tag is empty
     * @param req This is the first parameter to addToRequestQueue method
     * @param tag This is the second parameter to addToRequestQueue method
     * @param <T> This is the third parameter to addToRequestQueue method
     * @return Nothing
     */
    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    /**
     * Canceling the request
     * @param tag This is the first parameter to cancelPendingRequests method
     * @return Nothing
     */
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

}
