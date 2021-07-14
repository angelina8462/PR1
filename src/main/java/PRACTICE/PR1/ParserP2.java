package PRACTICE.PR1;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

	
	public class ParserP2 {
	
	public static void getlink (String url ) throws IOException { // для того, чтобы вернуть документ
		Document page = Jsoup.parse(new URL(url), 3000); //3000 мс на получение ответа от сервера
		
		Element tableRasp = page.select("tbody").first(); //достаем со страницы таблицу
		Elements rows = tableRasp.select("td");
		int count = 1; // ячейка
		
		for (Element row : rows ) {
			if (count == 1) {
				System.out.println("Станция = " + row.text()); // выводим станцию
				}
			
			if (count == 2) { // если 2 ячейка
				if (row.text().equals("")) { // если время прибытия не написано, то выводим ---
					System.out.println("Прибытие = ---");
				}
				else {
				System.out.println("Прибытие = " + row.text()); // выводим прибытие
					}
				}
			
			if (count == 3) { // если 3 ячейка
				if (row.text().equals("")) { // если время стоянки не написано, то выводим ---
					System.out.println("Стоянка = ---");
				}
				else {
				System.out.println("Стоянка = " + row.text()); // выводим стоянку
					}
				}
			
			if (count == 4) {
				if (row.text().equals("")) { // если время отправления не написано, то выводим ---
					System.out.println("Отправление = ---");
				}
				else {
				System.out.println("Отправление = " + row.text()); // вывести отправление
					}
				}
			
			if (count == 5) { 
				if (row.text().equals("")) { // если время "в пути" не написано, то выводим ---
					System.out.println("В пути = ---");
				}
				else {
				System.out.println("В пути = " + row.text()); // выводим время "в пути"
				}
				System.out.println("————————————————————");
				}
			
				count++; 
				
			if (count == 6) { // если сейчас 6 ячейка
				count=1; 
				}	
		}
	}
}

