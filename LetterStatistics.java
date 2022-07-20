import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class LetterStatistics {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter a text: ");
			String text = scanner.nextLine();
			System.out.println("The text: " + text);

			Map<String, Integer> letterCounts = new TreeMap<>();
			char[] letters = text.toCharArray();
			for (char letter : letters) {
				String letterAsString = Character.toString(letter);
				if (letterCounts.containsKey(letterAsString)) {
					Integer count = letterCounts.get(letterAsString);
					count++;
					letterCounts.put(letterAsString, count);
				} else {
					letterCounts.put(letterAsString, 1);
				}
			} // end foreach
			System.out.println("Word statistics: ");
			for (Entry<String, Integer> entry : letterCounts.entrySet()) {
				System.out.println("'" + entry.getKey() + "' letter -> " + entry.getValue() + " pcs");
			}

			Map<String, Double> letterPercentages = new HashMap<>();
			for (Entry<String, Integer> entry : letterCounts.entrySet()) {
				double percentage = (((double) entry.getValue()) / text.length()) * 100;
				letterPercentages.put(entry.getKey(), percentage);
			}
			System.out.println("Percentage statistics: ");
			for (Entry<String, Double> entry : letterPercentages.entrySet()) {
				System.out.printf("'%s' letter => %6.2f%%%n", entry.getKey(), entry.getValue());
			}

		}

	}

}
