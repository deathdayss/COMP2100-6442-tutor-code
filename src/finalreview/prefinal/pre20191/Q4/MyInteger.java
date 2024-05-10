package finalreview.prefinal.pre20191.Q4;

public class MyInteger {

	public static int parseInt(String s) throws NumberFormatException {
		int num = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if ((int) s.charAt(i) >= 48) {
				if ((int) s.charAt(i) <= 57) {
					System.out.println("If 1");
					num = num * 10 + ((int) s.charAt(i) - 48);
				} else {
					System.out.println("If 2");
					throw new NumberFormatException();
				}
			} else {
				System.out.println("If 3");
				throw new NumberFormatException();
			}

		}
		System.out.println("if 4");
		return num;
	}

}
