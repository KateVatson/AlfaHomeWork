package playlist;

import playlist.Playlist;

public class Winamp {

    public static void main(String[] args) {

        Playlist playlist = new Playlist("Мой плейлист");

        playlist.addSong("Numb");
        playlist.addSong("In The End");
        playlist.addSong("Faint");

        playlist.removeSong(1);

        playlist.updateSong(1, "Breaking The Habit");

        playlist.getSong(0);

        System.out.println();
        System.out.println(playlist);
    }
}