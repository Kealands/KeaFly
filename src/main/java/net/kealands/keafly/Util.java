package net.kealands.keafly;

public class Util {

    public static String transferTime(int s) {
        int sec = s % 60;
        int min = (s / 60) % 60;

        String strSec = (sec < 10) ? "0" + Integer.toString(sec) : Integer.toString(sec);
        String strmin = (min < 10) ? "0" + Integer.toString(min) : Integer.toString(min);

        return strmin + "m, " + strSec + "s";
    }
}
