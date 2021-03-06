package com.hamami.musictrywithmitch.persistence;

import com.hamami.musictrywithmitch.Models.Playlist;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PlaylistDao {

    @Insert
    long[] insertPlaylist(Playlist... playlist);

    @Query("SELECT * FROM playlists")
    LiveData<List<Playlist>> getPlaylists();

    @Query("SELECT * FROM playlists")
    List<Playlist> getPlaylistsAsArrayList();
//
//    @Query("SELECT * FROM playlists WHERE title LIKE :title")
//    List<Playlist> getSpecificPlaylist(String title);
//
//    @Query("SELECT title FROM playlists")
//    List<String> getPlaylistTitles();

    @Delete
    int delete(Playlist... playlist);

    @Update
    int update(Playlist... playlist);

}
