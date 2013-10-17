package onlinejudgeproblems.sphere.classical;

import java.util.Scanner;

class problemCodePRIME1 {

	/**
	 * @param args
	 */

	private static final long MEGABYTE = 1024L * 1024L;

	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int data_size = Integer.parseInt(in.nextLine());

		while (in.hasNext()) {
			String next = in.nextLine();
			String[] next_items = next.split(" ");

			int x = Integer.parseInt(next_items[0]);
			int y = Integer.parseInt(next_items[1]);

		}
	}

}
