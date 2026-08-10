package org.kamil.Config;

import java.io.File;
import java.util.Scanner;
import java.util.function.Predicate;

public class ConfigCheck {
    Scanner skan = new Scanner(System.in);

    public void checkConfig(ConfigService configService) {

    }


    public boolean checkPath(String path) {
        return new File(path).exists();
    }


    //path changer with prompt message!!!


    //path changer if user wants to



}









