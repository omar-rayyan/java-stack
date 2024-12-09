:import java.util.HashMap;
import java.util.Map;

public class TrackList {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<>();

        trackList.put("Uprising", "They will not force us, they will stop degrading us...");
        trackList.put("Supermassive Black Hole", "You caught me under false pretenses...");
        trackList.put("Starlight", "Far away, this ship is taking me far away...");
        trackList.put("Plug In Baby", "My plug in baby, crucifies my enemies...");

        String trackTitle = "Starlight";
        String lyrics = trackList.get(trackTitle);
        System.out.println("Lyrics for '" + trackTitle + "': " + lyrics);
        System.out.println();

        System.out.println("Track List:");
        for (Map.Entry<String, String> track : trackList.entrySet()) {
            System.out.println("Track: " + track.getKey() + " | Lyrics: " + track.getValue());
        }
    }
}
