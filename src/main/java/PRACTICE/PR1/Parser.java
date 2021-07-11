package PRACTICE.PR1;

import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


	public class Parser {
		private static Document getPage() throws IOException {
		String url = "https://poezdato.net/raspisanie-po-stancyi/samara/elektrichki/";
		Document page = Jsoup.parse(new URL(url), 3000);
		return page;
		}

		public static void main (String[] args) throws IOException {
		Document page = getPage();
		System.out.println("Номер Маршрут   Прибытие Стоянка Отправление");
		
		Element table = page.select("tbody").first();
		Elements rows = table.select("tr");
		
		for (Element row : rows) {
			System.out.println(row.text());
		}
	}
}