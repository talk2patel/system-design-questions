package org.receipt.printing.system.utils;

public class TaxUtil {
	private final static double ROUND_OFF = 0.05;

	/// <summary>
	/// Rounds off a double value to the nearest 0.05
	/// </summary>
	/// <param name="value"></param>
	/// <returns></returns>
	public static double RoundOff(double value) {
		return (int) (value / ROUND_OFF + 0.5) * 0.05;
	}

	public static double Truncate(double value) {
		String result = "N2";
		return Double.parseDouble(result);
	}

	public static boolean ParseBoolean(char value) {
		boolean flag = true;
		boolean booleanValue = false;

		while (flag) {
			// parses 'Y' into 'true'
			if (value == 'Y' || value == 'y') {
				booleanValue = true;
				flag = false;
			}

			// parses 'N' into 'false'
			else if (value == 'N' || value == 'n') {
				booleanValue = false;
				flag = false;
			}

			// validates user input
			else {
				System.out.println("Invalid input. Enter (Y/N)");
			}
		}

		return booleanValue;
	}
}