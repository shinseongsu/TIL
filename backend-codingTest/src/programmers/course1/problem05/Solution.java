package programmers.course1.problem05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// 시간 복잡도: O(nlogn)
public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) { // O(nlogn) 시간
            String genreName = genres[i];
            int playCount = plays[i];

            Genre genre = genreMap.getOrDefault(genreName, new Genre(genreName));
            genre.playCount += playCount;
            genre.songs.add(new Song(i, playCount)); // // PriorityQueue에서 add()은 O(logn) 시간
            genreMap.put(genreName, genre);
        }

        List<Integer> bestAlbum = new ArrayList<>();
        Genre[] sortedGenres = genreMap.values().toArray(new Genre[genreMap.size()]);
        Arrays.sort(sortedGenres, (a, b) -> b.playCount - a.playCount); // O(nlogn) 시간

        for (Genre genre : sortedGenres) { // O(nlogn) 시간
            PriorityQueue<Song> songs = genre.songs;
            int songsToAdd = Math.min(songs.size(), 2);
            while (!songs.isEmpty() && songsToAdd-- > 0) { // 최대 2번 돌기 때문에 O(logn) 시간으로 봅니다
                bestAlbum.add(songs.poll().id); // PriorityQueue에서 poll()은 O(logn) 시간
            }
        }

        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }

    class Genre {
        String name;
        int playCount;
        PriorityQueue<Song> songs; // Max Heap으로 사용

        public Genre(String name) {
            this.name = name;
            this.playCount = 0;
            this.songs = new PriorityQueue<>((a, b) -> b.playCount - a.playCount);
        }
    }

    class Song {
        int id;
        int playCount;

        public Song(int id, int playCount) {
            this.id = id;
            this.playCount = playCount;
        }
    }
}
