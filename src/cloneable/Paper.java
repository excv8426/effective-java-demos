package cloneable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Paper implements Cloneable{
	private String title;
	private String author;
	private List<String> keywords=new ArrayList<>();
	
	@Override
	public Paper clone(){
		Paper paper = null;
		try {
			paper=(Paper) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Iterator<String> iterator=keywords.iterator();
		List<String> key_words=new ArrayList<>();
		while (iterator.hasNext()) {
			key_words.add(iterator.next());
		}
		paper.setKeywords(key_words);
		return paper;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
	
}
