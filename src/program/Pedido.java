package program;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Pedido {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter Cliente data:");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("email:");
		String email = sc.nextLine();
		System.out.println("Birth Date(DD/MM/YYYY):");
		Date birthdate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthdate);
		System.out.println("Enter Order Data:");
		System.out.println("Status");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this Order:");
		Integer ord = sc.nextInt();
		for(int i=1; i<=ord; i++) {
		System.out.println();
		System.out.println("Enter # " + i +" item data");
		System.out.println("Product Name");
		sc.nextLine();
		String pname = sc.nextLine();
		System.out.println("Product Price");
		Double pprice = sc.nextDouble();
		
		Product product = new Product(pname, pprice);
		
		System.out.println("Quantity:");
		int quantity = sc.nextInt();
		
		OrderItem orderItem = new OrderItem(quantity, pprice, product);
		
		order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("Order Summary:");
		System.out.println(order);
		
		sc.close();
	}

}
