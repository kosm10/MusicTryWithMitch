package com.hamami.musictrywithmitch;

import android.support.v4.media.MediaMetadataCompat;

import com.hamami.musictrywithmitch.Models.Playlist;
import com.hamami.musictrywithmitch.Models.Songs;
import com.hamami.musictrywithmitch.util.MyPreferenceManager;

import java.io.File;
import java.util.ArrayList;

public interface IMainActivity {


    void playPause();

    void playNext();

    void playPrev();

    MyApplication getMyApplicationInstance();

    void onMediaSelected(String playlistId,MediaMetadataCompat mediaItem,int queuePosition);

    void onAddPlaylistMenuSelected(Songs songSelected);

    void addSongToPlaylist(Songs song,String playlistTitle);

    MyPreferenceManager getMyPreferenceManager();

    void insertToDatabase(Playlist playlist);

    void updateToDatabase(Playlist playlist);

    void removePlaylistFromDatabase(Playlist playlist);

    void removeSongFromQueueList(MediaMetadataCompat mediaId);

    void removePlaylistFragment(Playlist playlist);

    void onFinishedDragInQueueFragment(ArrayList<MediaMetadataCompat> mediaList);

    void shufflePlayingPlaylist(boolean isShuffle);

    void setFirstShuffle();

//    void  setupViewPager(ViewPager viewPager );

    void addNewPlaylist(Songs song,String playlistTitle);

    void addSongToPlaylistFromSelectFragment(Songs song,String playlistTitle);

    void setRootFolder(File rootFolder);

    }
