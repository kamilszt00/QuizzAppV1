package org.kamil.Config;

import org.kamil.Services.ConsoleUI;

import java.io.Console;
import java.io.File;
import java.util.Scanner;
import java.util.function.Consumer;


public class ConfigCheck {
    Scanner skan = new Scanner(System.in);

    public void checkConfig(ConfigService configService) {
        firstPathCheck(configService);
        changePathsUser(configService);
    }


    public boolean checkPath(String path) {
        return new File(path).exists();
    }



    public void firstPathCheck(ConfigService configService) {
        if (!configService.hasChaptersPath()) {
            configService.setChaptersPath(promptForStringPath(ConsoleUI.RED + ConsoleUI.BOLD + "No chapters path detected, please provide path to chapters for quizzing" + ConsoleUI.RESET));
        }
        if (!configService.hasResultSavePath()) {
            configService.setResultSavePath(promptForStringPath(ConsoleUI.RED + ConsoleUI.BOLD + "No result save path detected, please provide path to directory to save quiz results" + ConsoleUI.RESET));
        }
    }

    public void changePathsUser(ConfigService configService) {
        maybeUpdatePath(ConsoleUI.GREEN + ConsoleUI.BOLD + "Path for chapter is " + configService.getChaptersPath() + ConsoleUI.RESET, ConsoleUI.ORANGE + ConsoleUI.BOLD + "Please provide the path for chapters to quiz on (absolute path): " + ConsoleUI.RESET, configService::setChaptersPath);
        maybeUpdatePath(ConsoleUI.GREEN + ConsoleUI.BOLD + "Path for results is: " + configService.getResultSavePath() + ConsoleUI.RESET, ConsoleUI.ORANGE + ConsoleUI.BOLD + "Please provide the path to save results of quizzes (absolute path): " + ConsoleUI.RESET, configService::setResultSavePath);
    }



     private void maybeUpdatePath(String currentPathMessage, String promptMessage, Consumer<String> setter) {
         System.out.println(currentPathMessage);
         System.out.println(ConsoleUI.GREEN + "Would you like to change the path? Y/n" + ConsoleUI.RESET);
         if (skan.nextLine().equalsIgnoreCase("y")) {
             setter.accept(promptForStringPath(promptMessage));
         }
     }


    private String promptForStringPath(String promptMessage) {
        String path;
        do  {
            System.out.println(promptMessage);
            path = skan.nextLine();
            if (!checkPath(path)) {
                System.out.println(ConsoleUI.RED + ConsoleUI.BOLD + "Wrong path" + ConsoleUI.RED);
            }
        } while (!checkPath(path));
        return path;
    }



}









