package cloneable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testclone {
	public static void test(){
		List<String> keywords=new ArrayList<>(Arrays.asList("key1","key2","key3"));
		Paper paper=new Paper();
		paper.setTitle("title1");
		paper.setAuthor("author1");
		paper.setKeywords(keywords);
		
		Paper paper2=paper.clone();
		
		System.out.println(paper2.getAuthor());
		System.out.println(paper2.getTitle());

		System.out.println(paper2.getKeywords());
		paper.setTitle("title2");
		paper.setAuthor("author2");
		keywords.add("key4");
		System.out.println("********************************");
		System.out.println(paper2.getAuthor());
		System.out.println(paper2.getTitle());

		System.out.println(paper2.getKeywords());
	}
}
