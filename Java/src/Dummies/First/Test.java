package Dummies.First;


import java.util.Scanner;

class Test {
	public static void main(String args[]) {
		Scanner myScanner = new Scanner(System.in);
		double unitPrice, quantity, total;
		unitPrice = myScanner.nextDouble();
		quantity = myScanner.nextInt();
		total = unitPrice * quantity;
		System.out.println(total);
	}
}