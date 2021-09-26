package Assignment1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Computer {
	private String brand, model;
	private long SN;
	private double price;
	private static int noOfComputersCreated = 0;
	
	public Computer(String brand, String model, long sN, double price) {
		this.brand = brand;
		this.model = model;
		this.SN = sN;
		this.price = price;
		
		noOfComputersCreated += 1;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getSN() {
		return SN;
	}

	public void setSN(long sN) {
		this.SN = sN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Computer [brand=" + brand + ", model=" + model + ", SN=" + SN + ", price=" + price + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		return SN == other.SN && Objects.equals(brand, other.brand) && Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	public static int findNumberOfCreatedComputers() {
		return noOfComputersCreated;
	}
	
}

public class Part2A {
	
	public static boolean checkAuthentication(Scanner sc) {
		final String password = "password";
		final int noOfTriesAllowed = 3;
		int noOfTriesCompleted = 0;
		boolean accessGranted = false;
	
		while(noOfTriesCompleted < noOfTriesAllowed) {
			System.out.println("Please enter the Password : ");
			String userEnteredPassword = sc.next();
			if(password.equalsIgnoreCase(userEnteredPassword)) {
				accessGranted = true;
			}
			if(accessGranted) {
				return true;
			}
			else {
				noOfTriesCompleted++;
			}
		}
		
		return false;
	}
	
	public static void addComputersToInventory(Scanner sc, ArrayList<Computer> inventory, int maxComputers) {
		int remainingPlacesInInventory = maxComputers - inventory.size();
		System.out.println("How many computers you want to enter/add ?");
		int noOfComputersToBeAdded = sc.nextInt();
		if(noOfComputersToBeAdded <= remainingPlacesInInventory) {
			for(int i=0; i<noOfComputersToBeAdded; i++) {
				System.out.println("Enter the brand of computer " + (i+1) + " : ");
				String brand = sc.next();
				System.out.println("Enter the model of computer " + (i+1) + " : ");
				String model = sc.next();
				System.out.println("Enter the sn of computer " + (i+1) + " : ");
				long sn = sc.nextLong();
				System.out.println("Enter the price of computer " + (i+1) + " : ");
				double price = sc.nextDouble();
				Computer c = new Computer(brand, model, sn, price);
				inventory.add(c);
			}
			System.out.println("Entries Made !");
		}
		else {
			System.out.println("Only " + remainingPlacesInInventory + " places are available in Inventory.");
		}
	}
	
	
	public static void updateComputerData(Scanner sc, ArrayList<Computer> inventory, int maxComputers) {
		System.out.println("Which computer number you want to update ? ");
		int computerIndexToUpdate = sc.nextInt();
		if(computerIndexToUpdate-1 >=0 && computerIndexToUpdate-1 < inventory.size() - 1) {
			Computer computerSelectedByUser = inventory.get(computerIndexToUpdate-1);
			System.out.println(
					"Computer # " + computerIndexToUpdate + "\r\n" +
					"Brand : " + computerSelectedByUser.getBrand() + "\r\n" +
					"Model : " + computerSelectedByUser.getModel() + "\r\n" +
					"SN : " + computerSelectedByUser.getSN() + "\r\n" +
					"Price : " + computerSelectedByUser.getPrice()
			);
			System.out.println(
					"What information would you like to change ?" + "\r\n" +
					"1. Brand" + "\r\n" +
					"2. Model" + "\r\n" +
					"3. SN" + "\r\n" +
					"4. Price" + "\r\n" +
					"5. Quit" + "\r\n" +
					"Enter your choice > "
			);
			int userChoiceForUpdatation = sc.nextInt();
			
			switch(userChoiceForUpdatation) {
				case 1:
					System.out.println("Enter the new brand value : ");
					computerSelectedByUser.setBrand(sc.next());
					updateComputerData(sc, inventory, maxComputers);
					break;
				case 2:
					System.out.println("Enter the new model value : ");
					computerSelectedByUser.setModel(sc.next());
					updateComputerData(sc, inventory, maxComputers);
					break;
				case 3:
					System.out.println("Enter the new SN value : ");
					computerSelectedByUser.setSN(sc.nextLong());
					updateComputerData(sc, inventory, maxComputers);
					break;
				case 4:
					System.out.println("Enter the new price value : ");
					computerSelectedByUser.setPrice(sc.nextDouble());
					updateComputerData(sc, inventory, maxComputers);
					break;
				case 5:
					System.out.println("Updation task completed !");
					break;
			}
			
		}
		else {
			System.out.println("Entered computer number do not exists. Do you want to enter another computer number ?");
			System.out.print("Enter Y or N : ");
			String userChoice = sc.next();
			if(userChoice == "Y") {
				updateComputerData(sc, inventory, maxComputers);
			}
			else {
				showMenu(sc, inventory, maxComputers);
			}
		}
	}
	
	public static void showComputers(ArrayList<Computer> computers) {
		computers.forEach(c -> 
			System.out.println(
					"Brand : " + c.getBrand() + "\r\n" +
					"Model : " + c.getModel() + "\r\n" +
					"SN : " + c.getSN() + "\r\n" +
					"Price : " + c.getPrice()
					)
				);
	}
	
	public static ArrayList<Computer> findComputersBy(String brandName, ArrayList<Computer> inventory) {
		ArrayList<Computer> filteredCompByBrandName = new ArrayList<Computer>();
		for(Computer comp : inventory) {
			if(comp.getBrand().equals(brandName)) {
				filteredCompByBrandName.add(comp);
			}
		}
		return filteredCompByBrandName;
	}
	
	public static ArrayList<Computer> findCheaperThan(double price, ArrayList<Computer> inventory) {
		ArrayList<Computer> filteredCompLessThanPrice = new ArrayList<Computer>();
		for(Computer comp : inventory) {
			if(comp.getPrice() <= price) {
				filteredCompLessThanPrice.add(comp);
			}
		}
		return filteredCompLessThanPrice;
	}
	
	public static void showMenu(Scanner sc, ArrayList<Computer> inventory, int maxComputers) {
		System.out.println("What do you want to do?\r\n"
				+ "1. Enter new computers (password required)\r\n"
				+ "2. Change information of a computer (password required)\r\n"
				+ "3. Display all computers by a specific brand\r\n"
				+ "4. Display all computers under a certain a price.\r\n"
				+ "5. Quit\r\n"
				+ "Please enter your choice > ");
		
		int optionSelected = sc.nextInt();
		
		if(1 <= optionSelected && optionSelected <= 5) {
			switch(optionSelected) {
				case 1:
					if(!checkAuthentication(sc)) {
						showMenu(sc, inventory, maxComputers);
					}
					else {
						addComputersToInventory(sc, inventory, optionSelected);
						showMenu(sc, inventory, maxComputers);
					}
					break;
				case 2:
					if(!checkAuthentication(sc)) {
						showMenu(sc, inventory, maxComputers);
					}
					else {
						updateComputerData(sc, inventory, maxComputers);
					}
					break;
				case 3:
					System.out.println("Enter the brand name : ");
					String brandNameToBeSearched = sc.next();
					ArrayList<Computer> filteredByBrand =  findComputersBy(brandNameToBeSearched, inventory);
					showComputers(filteredByBrand);
					showMenu(sc, inventory, maxComputers);
					break;
				case 4:
					System.out.println("Enter the budget price : ");
					double maxPriceCompToBeSearched = sc.nextDouble();
					ArrayList<Computer> filteredByPrice = findCheaperThan(maxPriceCompToBeSearched, inventory);
					showComputers(filteredByPrice);
					showMenu(sc, inventory, maxComputers);
					break;
				case 5:
					System.out.println("Thank you for visiting our store !");
					break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Computer Store !");
		System.out.println("Please enter the maximum number of computer the store can contain : ");
		int maxComputers = sc.nextInt();
		ArrayList<Computer> inventory = new ArrayList<Computer>();
		
		showMenu(sc, inventory, maxComputers);

		sc.close();
	}

}
