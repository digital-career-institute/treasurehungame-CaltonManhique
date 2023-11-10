package treasurehuntgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TreasureHuntGame {

	private Scanner scanner = new Scanner(System.in);

	private Map<String, Location> locations = new HashMap<>();
	private List<Treasure> treasures = new ArrayList<>();
	private Set<Treasure> inventory = new HashSet<>();
	private int calculateTotalValue = 0;

	private String getCurrentLocation(Map<String, Location> locations, String currentLocation) {
		return locations.get(currentLocation).getName() + " - " + locations.get(currentLocation).getDescription();
	}

	public void pickUpTreasue(List<Treasure> treasures, int coin) {
		Treasure temp = null;
		for (Treasure t : treasures) {
			if (t.getValue() == coin) {
				temp = t;
			}
		}
		if (temp == null) {
			System.out.println("Treasure not found");
		} else {
			inventory.add(temp);
			System.out.println(temp.getName() + " added to your inventory.\n-----------------------");
		}

	}

	public void showTreasures() {
		for (Treasure t : treasures) {
			System.out.println(t.getName() + ", " + t.getDescription() + " - " + t.getValue() + "€");
		}
	}

	public void showInventory(Set<Treasure> inventory) {
		System.out.println("Your Inventory:");
		for (Treasure tr : inventory) {
			System.out.println(tr.getName() + ", " + tr.getDescription() + ". Value: " + tr.getValue() + "€");
			calculateTotalValue += tr.getValue();
		}
		System.out.println(
				"---------------------------\nCongratulations, you have collected: " + calculateTotalValue + "€");
	}

	public void startGame() {
		locations.put("Beach", new Location("Beach", "You are on a beautiful beach with golden sands."));
		locations.put("Disco", new Location("Disco", "You are in a beautiful nightclub with fantastic music."));
		locations.put("Bar", new Location("Bar", "You are in a Bar with great drinks and live music."));
		treasures.add(new Treasure("Gold Coin", "A shiny gold coin", 10));
		treasures.add(new Treasure("Silver Coin", "A shiny silver coin", 7));
		treasures.add(new Treasure("Bronze Coin", "A shiny bronze coin", 4));
		treasures.add(new Treasure("Diamond Coin", "A shiny diamond coin", 15));

		String currentLocation = "Beach";
		int option = 0;

		do {

			System.out.println(getCurrentLocation(locations, currentLocation) + "\n");
			System.out.println("Do you want to: \n1. pick up a treasure\n2. Move to the next location\n3. Quit\n");
			option = scanner.nextInt();

			switch (option) {
			case 1 -> {
				showTreasures();
				System.out.println("\nEnter a treasure value");
				int coin = scanner.nextInt();
				pickUpTreasue(treasures, coin);
			}
			case 2 -> {
				System.out.println(locations.keySet());
				System.out.println("Enter location to visit");
				scanner.nextLine();

				String loc = scanner.nextLine();
				currentLocation = loc;
			}
			case 3 -> showInventory(inventory);

			default -> System.out.println("Unexpected value: ");
			}

		} while (option != 3);

		System.out.println("Game over!!!");
	}

	public static void main(String[] args) {

		new TreasureHuntGame().startGame();
	}

}
