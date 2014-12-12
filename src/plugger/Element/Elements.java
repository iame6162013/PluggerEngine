package plugger.Element;

import java.util.List;

public class Elements{
	List<Element> element;
	List<Byte> percentage;
	List<Byte> compression;
	
	public List<Element> getElement() {return element;}
	public void setElement(List<Element> element) {this.element = element;}
	public List<Byte> getPercentage() {return percentage;}
	public void setPercentage(List<Byte> percentage) {this.percentage = percentage;}
	public List<Byte> getCompression() {return compression;}
	public void setCompression(List<Byte> compression) {this.compression = compression;}

	
	
	public Elements(List<Element> element,List<Byte> percentage,List<Byte> compression){
		this.element=element;
		this.percentage=percentage;
		this.compression=compression;
	}
}
