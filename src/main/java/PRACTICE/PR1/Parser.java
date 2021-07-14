package PRACTICE.PR1;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


	public class Parser {
		
		private static Document getPage() throws IOException { // для того, чтобы вернуть документ
		String url = "https://poezdato.net/raspisanie-po-stancyi/samara/elektrichki/";
		Document page = Jsoup.parse(new URL(url), 3000); //3000 мс на получение ответа от сервера
		return page;
		}

		public static void main (String[] args) throws IOException {
		Document page = getPage(); 
		
		int count = 1; //ячейка
		Element tableRasp = page.select("tbody").first(); //достаем со страницы таблицу
		Elements rows = tableRasp.select("td");  //row - ряд, куда входят названия "номер, маршрут"
		
		
		for (Element row : rows) {
			if (count == 2) { // если вторая ячейка
				System.out.println("————————————————————");
				System.out.println("Поезд: ");
				System.out.println("Номер = " + row.text()); // вывести номер поезда
				ParserP2.getlink("https://poezdato.net" + row.select("a").first().attr("href")); //получить ссылку , метод attr достает значение первого элемента, который ему встретится
			}
			
			if (count == 3) { // если 3 ячейка
				System.out.println("Маршрут = " + row.text()); // выводим маршрут
				}
			
			if (count == 4) { 
				if (row.text().equals("")) { // если время прибытия не написано, то выводим ---
					System.out.println("Прибытие = ---");
				}
				else {
				System.out.println("Прибытие = " + row.text()); // выводим прибытие
					}
				}
			
			if (count == 5) { 
				if (row.text().equals("")) { // время стоянки не написано, то выводим ---
					System.out.println("Стоянка = ---");
				}
				else {
				System.out.println("Стоянка = " + row.text()); // выводим стоянку
					}
				}
			
			if (count == 6) {
				if (row.text().equals("")) { // если время отправления не написано, то выводим ---
					System.out.println("Отправление = -");
				}
				else {
				System.out.println("Отправление = " + row.text());
					}
				}
			
				count++; // счетчик увеличивается на 1
				
			if (count == 9) { // если сейчас ячейка, которой не существует
				count=1; // 
				}	
			}

		}
	}
