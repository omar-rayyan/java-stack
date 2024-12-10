package art.project.com;

import java.util.ArrayList;
import java.util.Collections;

public class Museum {
    public static void main(String[] args) {
        Painting painting1 = new Painting("Starry Night", "Vincent van Gogh", "A famous oil painting of a night sky.", "Oil");
        Painting painting2 = new Painting("The Persistence of Memory", "Salvador Dalí", "A surreal depiction of melting clocks.", "Oil");
        Painting painting3 = new Painting("Water Lilies", "Claude Monet", "A series of beautiful water landscapes.", "Watercolor");

        Sculpture sculpture1 = new Sculpture("David", "Michelangelo", "A marble masterpiece of a biblical hero.", "Marble");
        Sculpture sculpture2 = new Sculpture("The Thinker", "Auguste Rodin", "A bronze sculpture of a pensive man.", "Bronze");

        ArrayList<Art> museum = new ArrayList<>();
        museum.add(painting1);
        museum.add(painting2);
        museum.add(painting3);
        museum.add(sculpture1);
        museum.add(sculpture2);

        Collections.shuffle(museum);

        for (Art artwork : museum) {
            artwork.viewArt();
        }
    }
}