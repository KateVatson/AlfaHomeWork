package playlist;

import java.util.ArrayList;

public class Playlist {

    private String playlistName;
    private ArrayList<String> songs;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.songs = new ArrayList<>();
    }

    public void addSong(String song) {
        songs.add(song);
        System.out.println("Добавлена песня: " + song);
    }

    public void removeSong(int index) {
        String removedSong = songs.remove(index);
        System.out.println("Удалена песня: " + removedSong);
    }

    public void updateSong(int index, String newSong) {
        String oldSong = songs.set(index, newSong);
        System.out.println("Песня \"" + oldSong + "\" заменена на \"" + newSong + "\"");
    }

    public String getSong(int index) {
        String song = songs.get(index);
        System.out.println("Получена песня: " + song);
        return song;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistName='" + playlistName + '\'' +
                ", songs=" + songs +
                '}';
    }
}