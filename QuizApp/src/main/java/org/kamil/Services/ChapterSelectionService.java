package org.kamil.Services;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChapterSelectionService {


    public static String chapterSelector(String dir) {
        Map<String, List<String>> grouped = new LinkedHashMap<>();
        Scanner skan = new Scanner(System.in);
        List<String> chapters = Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .map(name -> name.replace(".json", ""))
                .sorted(Comparator.comparing(
                        s -> Arrays.stream(s.split("\\.")).mapToInt(Integer::parseInt).toArray(),
                        Arrays::compare
                ))
                .toList();

        chapters.forEach(s -> {
            String chapter = s.contains(".") ? s.split("\\.")[0] : s;
            grouped.computeIfAbsent(chapter, k -> new ArrayList<>()).add(s);
        });


        for (Map.Entry<String, List<String>> entry : grouped.entrySet()) {
            System.out.print(ConsoleUI.YELLOW + ConsoleUI.BOLD + "Chapter " + entry.getKey() + ": " + ConsoleUI.RESET);
            entry.getValue().forEach(s -> {
                System.out.print(ConsoleUI.CYAN + s + ConsoleUI.RESET);
                System.out.print(ConsoleUI.GRAY + " | " + ConsoleUI.RESET);

            });

            System.out.println();
        }
        System.out.println();
        String userInput = "";


        boolean chapterNotSelected = true;
        while (chapterNotSelected) {
            System.out.println(ConsoleUI.YELLOW + "Pick a chapter to start: " + ConsoleUI.RESET);
            userInput = skan.nextLine();
            if (InputValidationService.validateInput(userInput.trim(), chapters)) {
                chapterNotSelected = false;
            } else {
                System.out.println(ConsoleUI.RED + "Wrong input, please provide proper chapter number: [Number].[Number]" + ConsoleUI.RESET);
            }


        }

        return userInput;
    }
}
