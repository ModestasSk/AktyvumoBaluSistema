package lab2;

import ds.AktyvumoBaluSistema;
import ds.Grupe;
import ds.Kursas;
import ds.Uzduotis;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {
        AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
        Login UI = new Login(abs);
        UI.setVisible(true);
    }
}
