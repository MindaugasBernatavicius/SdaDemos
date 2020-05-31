package cf.mindaugas.sdademos._03_design._02_patterns._01_creational._02_builder.studentquestions;

import java.util.*;


public class OutfitRunner {

    static final List<String> al = new ArrayList<>();
    static final String name = "";

    public static void main(String[] args) {
        Outfit outfit = new Outfit
                    .OutfitBuilder("", Outfit.Size.SMALL)
                    .build();

        System.out.println(outfit);

        // pridėti narius galime, bet re-assigninti negalime jei final
        al.add("Mindaugas");
        // name = "";
        // al = new LinkedList<String>();
        System.out.println(al);
    }
}

class Outfit {
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    private final String name;
    private final Size size;
    private final Boolean withGloves;
    private final Boolean withScarf;
    private final ArrayList<String> pocketContents;

    private Outfit(OutfitBuilder outfitBuilder) {
        this.name = outfitBuilder.name;
        this.size = outfitBuilder.size;
        // this is ugly. how to use Optional here?
        // if (outfitBuilder.withGloves == null) {
        //     this.withGloves = false;
        // } else {
        //     this.withGloves = outfitBuilder.withGloves;
        // }

        // ... maximum kiek galima supaprastinti
        this.withGloves = outfitBuilder.withGloves.orElse(false);

        if (outfitBuilder.withScarf == null) {
            this.withScarf = false;
        } else {
            this.withScarf = outfitBuilder.withScarf;
        }

        this.pocketContents = outfitBuilder.pocketContents;
    }

    @Override
    public String toString() {
        return "Outfit{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", withGloves=" + withGloves +
                ", withScarf=" + withScarf +
                ", pocketContents=" + pocketContents +
                '}';
    }

    public static class OutfitBuilder {
        private String name;
        private Size size;
        private Optional<Boolean> withGloves;
        private Boolean withScarf;
        // private boolean withGloves;
        // private boolean withScarf;
        private ArrayList<String> pocketContents = new ArrayList<>();

        public OutfitBuilder(String name, Size size) {
            this.name = name;
            this.size = size;
            this.withGloves = Optional.of(false);
        }

        public OutfitBuilder and() {
            return this;
        }

        public OutfitBuilder addGloves() {
            this.withGloves = Optional.of(true);
            return this;
        }

        public OutfitBuilder addScarf() {
            this.withScarf = true;
            return this;
        }

        public OutfitBuilder addPocketContents(String... items) {
            this.pocketContents.addAll(Arrays.asList(items));
            return this;
        }

        public Outfit build() {
            return new Outfit(this);
        }
    }
}
