package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration){
        var song = findSong(title);
        if (song == null){
            return songs.add(new Song(title, duration));
        }
        else return false;
    }

    private Song findSong(String title){
        Iterator<Song> songIterator = songs.iterator();

        while (songIterator.hasNext()){
            var song = songIterator.next();
            if (song.getTitle().equals(title)){
                return song;
            }
        }

        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        int numberOfSongs = songs.size();
        if(trackNumber < 1 || trackNumber > songs.size()){ return false; }
        Song song = songs.get(trackNumber - 1);
        return playlist.add(song);
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        Song song = findSong(title);
        if(song != null){
           return playlist.add(song);
        } else return false;
    }

}
