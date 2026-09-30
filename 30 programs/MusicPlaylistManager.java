import java.util.Scanner;

public class MusicPlaylistManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] songs = {"Song A", "Song B", "Song C"};
        int[] playCounts = new int[3];
        boolean active = true;

        while (active) {
            System.out.println("\n1. Play Song | 2. View Favorites/Stats | 3. Exit");
            System.out.print("Select: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Choose song (1. Song A, 2. Song B, 3. Song C): ");
                    int sIdx = sc.nextInt() - 1;
                    if (sIdx >= 0 && sIdx < 3) {
                        playCounts[sIdx]++;
                        System.out.println("Playing " + songs[sIdx] + "...");
                    }
                    break;
                case 2:
                    System.out.println("\n--- LISTENING STATS ---");
                    for (int i = 0; i < songs.length; i++) {
                        System.out.println(songs[i] + " - Played " + playCounts[i] + " times");
                    }
                    break;
                case 3:
                    active = false;
                    break;
            }
        }
        sc.close();
    }
}