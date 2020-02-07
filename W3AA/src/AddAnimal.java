
import java.io.ObjectInputStream.GetField;
import java.util.List;
import java.util.Scanner;

import view.ListItemHelper;
import model.Animals;

public class AddAnimal {

	static Scanner in = new Scanner(System.in);
	static ListItemHelper lih = new ListItemHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter an Animal: ");
		String store = in.nextLine();
		System.out.print("Enter an Amount: ");
		String item = in.nextLine();

		Animals toAdd = new Animals(store, item);
		lih.insertItem(toAdd);
	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the Animal to delete: ");
		String animal = in.nextLine();
		System.out.println("Enter Population amount:");
		String pop = in.nextLine();
		
		Animals toDelete = new Animals(animal,pop);
		lih.deleteItem(toDelete);
	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("Would you like to update an animal? ");
		System.out.println("1 : yes");
		System.out.println("2 : no");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Animals> foundItems = null;
		if (searchBy == 1) {
			System.out.print("Enter the Species name: ");
			String animalSpecies = in.nextLine();
			foundItems = lih.searchBySpecies(animalSpecies);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Animals l : foundItems) {
				System.out.println("Please input this id number: " + l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Animals toEdit = lih.searchForAnimalById(idToEdit);
			System.out.println("Species: " + toEdit.getSpecies() + " Population: " + toEdit.getAmount());
			System.out.println("1 : Update specias name");
			System.out.println("2 : Update specias population");

			int update = in.nextInt();
			in.nextLine();
 
			if (update == 1) {
				System.out.print("New Species: ");
				String species = in.nextLine();

				toEdit.setSpecies(species);

			} else if (update == 2) {
				System.out.print("Update Population: ");
				String newPop = in.nextLine();

				toEdit.setAmount(newPop);

			}

			lih.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Lets update the zoo ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an Animal");
			System.out.println("*  2 -- Edit an animal");
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub

		List<Animals> allItems = lih.showAllItems();
		for (Animals singleItem : allItems) {
			System.out.println("-------" + singleItem.returnItemDetails() + "-------");
			System.out.println("");
		}
	}

}