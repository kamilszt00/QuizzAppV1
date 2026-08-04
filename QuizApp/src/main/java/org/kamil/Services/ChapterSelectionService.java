package org.kamil.Services;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChapterSelectionService {

    public static String chapterSelector(String dir) {
        Scanner skan = new Scanner(System.in);
        List<String> chapters = Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .map(name -> name.replace(".json", ""))
                .sorted()
                .toList();


        chapters.forEach(s -> {
            System.out.print(s + " | ");
        });
        System.out.println("Pick one chapter please: ");
        return skan.nextLine();
    }
}
