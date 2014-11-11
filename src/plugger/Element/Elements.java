package src.plugger.Element;

public class Elements{
	Element element[];
	short percentage[];
	int compression[];
	
	public Element[] getElement() {return element;}
	public void setElement(Element element[]) {this.element = element;}
	public short[] getPercentage() {return percentage;}
	public void setPercentage(short percentage[]) {this.percentage = percentage;}
	public int[] getCompression() {return compression;}
	public void setCompression(int compression[]) {this.compression = compression;}

	
	
	public void add(Element[] element,short[] percentage,int[] compression){
		this.element=element;
		this.percentage=percentage;
		this.compression=compression;
	}
	
}
