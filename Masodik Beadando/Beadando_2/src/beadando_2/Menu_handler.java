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
				System.out.println("Sikertelen bejelentkez�s.");
				return;
			}
			int choice;
			String[] options = {"Kil�p�s", "H�v�sok �llom�nyb�l t�rt�n� felt�lt�se","Aut�k random felt�lt�se","K�zi Adatfelvitel","Lek�rdez�s"};
			do {
				listOptions(options);
				choice=InputHandler.readInt(0, options.length-1, input);
				switch(choice) {
				case 0: System.out.println("Kil�p�s..."); break;
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
			String[] options = {"H�v�s", "Aut�", "Ment�s", "Osztag", "Kivonulas hozz�rendel�s", "Kivonul�s kimenetel"};
			listOptions(options);
			int choice=InputHandler.readInt(0, options.length-1, input);
			switch(choice) {
			
			case 0: 
				System.out.println("H�v� telefonsz�ma:");
				String phone = input.nextLine();
				System.out.println("H�v� neve:");
				String name = input.nextLine();
				System.out.println("C�m:");
				String address = input.nextLine();
				System.out.println("Fontoss�g (0-5):");
				int priority = InputHandler.readInt(0, 5, input);
				DB_handler.addCall(name, phone, address, priority);
				break;
				
			case 1:
				System.out.println("Aut� rendsz�ma:");
				String plate = input.nextLine();
				System.out.println("Aut� m�rk�ja:");
				String brand = input.nextLine();
				DB_handler.addCar(plate, brand);
				break;
				
			case 2:
				System.out.println("Ment�s neve:");
				String Mname = input.nextLine();
				System.out.println("Ment�s beoszt�sa:");
				String job = input.nextLine();
				DB_handler.addDoc(Mname, job);
				break;
				
			case 3:
				System.out.println("Osztag ID:");
				int OID = InputHandler.readInt(input);
				System.out.println("Ment�s ID:");
				int MID = InputHandler.readInt(input);
				DB_handler.addSquad(OID, MID);
				break;
				
			case 4:
				System.out.println("H�v�s ID:");
				int HID = InputHandler.readInt(input);
				System.out.println("Aut� ID:");
				int AID = InputHandler.readInt(input);
				DB_handler.assignToSite(HID, AID);
				break;
				
			case 5:
				System.out.println("Kivonul�s ID:");
				int KID = InputHandler.readInt(input);
				System.out.println("Ki�rkez�s id�pontja (yyyy-MM-dd.HH:mm):");
				LocalDateTime kierkezes = InputHandler.readDateTime(input, DB_handler.getDtf());
				System.out.println("Kimenetel:");
				String kimenetel = input.nextLine();
				DB_handler.endSite(KID, kierkezes, kimenetel);
				break;
				
			}
		}
		private  void queryData(DB_handler DB_handler, Scanner input) {
			String[] options = {"H�v�sok sz�r�se h�v� neve szerint", "H�v�sok sz�r�se id�szakra", "H�v�sok sz�ma adott napon"};
			listOptions(options);
			int choice=InputHandler.readInt(0, options.length-1, input);
			LocalDateTime beginning, end;
			switch(choice) {
			
			case 0: 
				System.out.println("N�v:");
				String name = input.nextLine();
				DB_handler.filterCallsByName(name);
				break;
				
			case 1: 
				System.out.println("Id�szak kezdete (yyyy-MM-dd.HH:mm):");
				beginning = InputHandler.readDateTime(input, DB_handler.getDtf());
				System.out.println("Id�szak v�ge (yyyy-MM-dd.HH:mm):");
				end = InputHandler.readDateTime(input, DB_handler.getDtf());
				DB_handler.filterCallsByTime(beginning, end);
				break;
				
			case 2:
				System.out.println("D�tum (yyyy-MM-dd):");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
				LocalDate day = InputHandler.readDate(input, dtf);
				System.out.println("A h�v�sok sz�ma "+day.format(dtf)+" napon: "+DB_handler.numberOfCallsOn(day));
				break;
				
			}
		}
		
		
}
	
	

