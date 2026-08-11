package org.kamil.Config;

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
            configService.setChaptersPath(promptForStringPath("No chapters path detected, please provide path to chapters for quizzing"));
        }
        if (!configService.hasResultSavePath()) {
            configService.setResultSavePath(promptForStringPath("No result save path detected, please provide path to directory to save quiz results"));
        }
    }

    public void changePathsUser(ConfigService configService) {
        maybeUpdatePath("Path for chapter is " + configService.getChaptersPath(), "Please provide the path for chapters: ", configService::setChaptersPath);
        maybeUpdatePath("Path for results is: " + configService.getResultSavePath(), "Please provide the path for saving the results", configService::setResultSavePath);
    }



     private void maybeUpdatePath(String currentPathMessage, String promptMessage, Consumer<String> setter) {
         System.out.println(currentPathMessage);
         System.out.println("Would you like to change it? Y/n");
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
                System.out.println("Wrong path");
            }
        } while (!checkPath(path));
        return path;
    }



}









