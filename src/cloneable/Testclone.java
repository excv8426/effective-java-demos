package cloneable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Testclone {
	public static void test(){
		List<String> keywords=new ArrayList<>();
		keywords.add("key1");
		keywords.add("key2");
		keywords.add("key3");
		Paper paper=new Paper();
		paper.setTitle("title1");
		paper.setAuthor("author1");
		paper.setKeywords(keywords);
		
		Paper paper2=paper.clone();
		
		System.out.println(paper2.getAuthor());
		System.out.println(paper2.getTitle());
		Iterator<String> iterator=paper2.getKeywords().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		paper.setTitle("title2");
		paper.setAuthor("author2");
		keywords.add("key4");
		System.out.println("********************************");
		System.out.println(paper2.getAuthor());
		System.out.println(paper2.getTitle());
		iterator=paper2.getKeywords().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
