package beadando_2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu_handler {
	
		public void startMenu(Scanner input) {
			String dateFormat = "yyyy-MM-dd.HH:mm";
			DB_handler DB_handler = login(input, dateFormat);
			if(!DB_handler.isValidConnection()) {
				System.out.println("Sikertelen bejelentkezés.");
				return;
			}
			int choice;
			String[] options = {"Kilépés", "Hívások állományból történõ feltöltése","Autók random feltöltése","Kézi Adatfelvitel","Lekérdezés"};
			do {
				listOptions(options);
				choice=InputHandler.readInt(0, options.length-1, input);
				switch(choice) {
				case 0: System.out.println("Kilépés..."); break;
				case 1: DB_handler.readCalls();break;
				case 2: DB_handler.randomGenerateCars();break;
				case 3: insertData(DB_handler, input); break;
				case 4: queryData(DB_handler, input); break;
				}
			}while(choice!=0);
		}
		
		private DB_handler login(Scanner input, String dateFormat) {
			System.out.println("Connection string:");
			String conn = input.nextLine();
			System.out.println("Username:");
			String uName = input.nextLine();
			System.out.println("Password:");
			String pswd = input.nextLine();
			return new DB_handler(conn, uName, pswd, dateFormat);
		}
		
		private void listOptions(String[] opt) {
			for(int i=0; i<opt.length; i++) {
				System.out.println(i+": "+opt[i]);
			}
		}

		private void insertData(DB_handler DB_handler, Scanner input) {
			String[] options = {"Hívás", "Autó", "Mentõs", "Osztag", "Kivonulas hozzárendelés", "Kivonulás kimenetel"};
			listOptions(options);
			int choice=InputHandler.readInt(0, options.length-1, input);
			switch(choice) {
			
			case 0: 
				System.out.println("Hívó telefonszáma:");
				String phone = input.nextLine();
				System.out.println("Hívó neve:");
				String name = input.nextLine();
				System.out.println("Cím:");
				String address = input.nextLine();
				System.out.println("Fontosság (0-5):");
				int priority = InputHandler.readInt(0, 5, input);
				DB_handler.addCall(name, phone, address, priority);
				break;
				
			case 1:
				System.out.println("Autó rendszáma:");
				String plate = input.nextLine();
				System.out.println("Autó márkája:");
				String brand = input.nextLine();
				DB_handler.addCar(plate, brand);
				break;
				
			case 2:
				System.out.println("Mentõs neve:");
				String Mname = input.nextLine();
				System.out.println("Mentõs beosztása:");
				String job = input.nextLine();
				DB_handler.addDoc(Mname, job);
				break;
				
			case 3:
				System.out.println("Osztag ID:");
				int OID = InputHandler.readInt(input);
				System.out.println("Mentõs ID:");
				int MID = InputHandler.readInt(input);
				DB_handler.addSquad(OID, MID);
				break;
				
			case 4:
				System.out.println("Hívás ID:");
				int HID = InputHandler.readInt(input);
				System.out.println("Autó ID:");
				int AID = InputHandler.readInt(input);
				DB_handler.assignToSite(HID, AID);
				break;
				
			case 5:
				System.out.println("Kivonulás ID:");
				int KID = InputHandler.readInt(input);
				System.out.println("Kiérkezés idõpontja (yyyy-MM-dd.HH:mm):");
				LocalDateTime kierkezes = InputHandler.readDateTime(input, DB_handler.getDtf());
				System.out.println("Kimenetel:");
				String kimenetel = input.nextLine();
				DB_handler.endSite(KID, kierkezes, kimenetel);
				break;
				
			}
		}
		private  void queryData(DB_handler DB_handler, Scanner input) {
			String[] options = {"Hívások szûrése hívó neve szerint", "Hívások szûrése idõszakra", "Hívások száma adott napon"};
			listOptions(options);
			int choice=InputHandler.readInt(0, options.length-1, input);
			LocalDateTime beginning, end;
			switch(choice) {
			
			case 0: 
				System.out.println("Név:");
				String name = input.nextLine();
				DB_handler.filterCallsByName(name);
				break;
				
			case 1: 
				System.out.println("Idõszak kezdete (yyyy-MM-dd.HH:mm):");
				beginning = InputHandler.readDateTime(input, DB_handler.getDtf());
				System.out.println("Idõszak vége (yyyy-MM-dd.HH:mm):");
				end = InputHandler.readDateTime(input, DB_handler.getDtf());
				DB_handler.filterCallsByTime(beginning, end);
				break;
				
			case 2:
				System.out.println("Dátum (yyyy-MM-dd):");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
				LocalDate day = InputHandler.readDate(input, dtf);
				System.out.println("A hívások száma "+day.format(dtf)+" napon: "+DB_handler.numberOfCallsOn(day));
				break;
				
			}
		}
		
		
}
	
	

