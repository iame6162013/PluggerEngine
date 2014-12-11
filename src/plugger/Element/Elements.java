package plugger.Element;

import java.util.List;

public class Elements{
	List<Element> element;
	List<Short> percentage;
	List<Integer> compression;
	
	public List<Element> getElement() {return element;}
	public void setElement(List<Element> element) {this.element = element;}
	public List<Short> getPercentage() {return percentage;}
	public void setPercentage(List<Short> percentage) {this.percentage = percentage;}
	public List<Integer> getCompression() {return compression;}
	public void setCompression(List<Integer> compression) {this.compression = compression;}

	
	
	public Elements(List<Element> element,List<Short> percentage,List<Integer> compression){
		this.element=element;
		this.percentage=percentage;
		this.compression=compression;
	}
}
