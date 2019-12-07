package cf.mindaugas.sdademos.javaadvanced._18_streamsandcollectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class BabyName{
    public int year;
    public String name;
    public float perc;
    public String sex;
    public BabyName(int year, String name, float perc, String sex){
        this.year = year;
        this.name = name;
        this.perc = perc;
        this.sex = sex;
    }
}

public class BabyNamesExample {
    public static void main(String[] args) throws IOException {
        Path fpath = Paths.get("baby-names.csv");
        List<String> lines = Files.readAllLines(fpath);
        List<BabyName> babies = lines
                .stream()
                .skip(1)
                .map(l -> {
                    String[] buff = l.replace("\"", "").split(",");
                    return new BabyName(
                            Integer.parseInt(buff[0]),
                            buff[1],
                            Float.parseFloat(buff[2]),
                            buff[3]);
                })
                .collect(Collectors.toList());


        long boys = babies.stream().filter(b -> b.sex.equals("boy")).count();
        long girls = babies.stream().filter(b -> b.sex.equals("girl")).count();
        System.out.println(boys + " boys in dataset");
        System.out.println(girls + " girls in dataset");

        Optional<BabyName> popularName = babies.stream().parallel().max((x, y) -> Float.compare(x.perc, y.perc));

        popularName.ifPresent(b -> System.out.println(b.name + " " + b.perc));

        boolean anyGillete = babies.stream().anyMatch(b -> b.name.equals("Gillete"));
        System.out.println("Gillete found? " + anyGillete);

        List<BabyName> babiesByName = babies
                .stream()
                .sorted((x, y) -> x.name.compareTo(y.name))
                .collect(Collectors.toList());

        Optional<BabyName> longestName = babies.stream().max((a, b) -> Integer.compare(a.name.length(), b.name.length()));
        System.out.println(longestName.get().name);
    }
}
