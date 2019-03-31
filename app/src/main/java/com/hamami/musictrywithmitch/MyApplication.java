package com.hamami.musictrywithmitch;

import android.app.Application;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    private static MyApplication mInstance;
    private List<MediaBrowserCompat.MediaItem> mMediaItems = new ArrayList<>();
    private TreeMap<String, MediaMetadataCompat> mTreeMap = new TreeMap<>();

    public static MyApplication getInstance()
    {
        if (mInstance == null)
        {
            Log.d(TAG, "getInstance:  new instance of my application , so last instance will removed");
            mInstance = new MyApplication();
        }
        return mInstance;
    }
    public void setMediaItems(List<MediaMetadataCompat> mediaItems)
    {
        mMediaItems.clear();
        for(MediaMetadataCompat item: mediaItems)
        {
            Log.d(TAG, "setMediaItems: called: adding media item: " + item.getDescription());

            mMediaItems.add(
                    new MediaBrowserCompat.MediaItem(
                            item.getDescription(),MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
                    )
            );
            mTreeMap.put(item.getDescription().getMediaId(),item);
        }
    }

    public  List<MediaBrowserCompat.MediaItem> getMediaItems()
    {
        return mMediaItems;
    }

    public TreeMap<String,MediaMetadataCompat> getTreeMap()
    {
        return mTreeMap;
    }

    public MediaMetadataCompat getMediaItem(String mediaId)
    {
        return mTreeMap.get(mediaId);
    }

    public void removeSongFromListMedia(MediaMetadataCompat mediaId)
    {
        Log.d(TAG, "removeSongFromListMedia: remove song From list: "+mediaId.getDescription().getMediaId());

        mTreeMap.remove(mediaId.getDescription().getMediaId());
        for(int i=0; i<mMediaItems.size();i++)
        {
            if(mMediaItems.get(i).getDescription().getMediaId().equals(mediaId.getDescription().getMediaId()))
            {
                mMediaItems.remove(i);
                return;
            }
        }
//        mMediaItems.remove(
//                new MediaBrowserCompat.MediaItem(
//                        mediaId.getDescription(),MediaBrowserCompat.MediaItem.FLAG_PLAYABLE)
//
//        );
    }

}
