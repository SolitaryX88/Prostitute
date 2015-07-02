package Dummies.First;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.nio.file.Paths;

import sun.misc.URLClassPath;

public class ReadAndWrite {

	public static void main(String args[]) throws IOException,
			ClassNotFoundException {

		final File f = new File(ReadAndWrite.class.getProtectionDomain()
				.getCodeSource().getLocation().getPath());

		String p = f.getAbsolutePath() + "/"
				+ ReadAndWrite.class.getPackage().getName().replace(".", "/")
				+ "/";

		System.out.println("path: " + p);

		Scanner diskScanner = new Scanner(new File(p + "rawData.txt"));
		PrintStream diskWriter = new PrintStream(p + "cookedData.txt");
		double unitPrice, quantity, total;
		unitPrice = diskScanner.nextDouble();
		quantity = diskScanner.nextInt();
		total = unitPrice * quantity;

		diskWriter.println("\t\t --The Res--\t\t");
		diskWriter.println(total);
		diskWriter.println("\t\t --End Res--\t\t");

	}

}
