
public class BinarySplitter extends Binary2{
	
	public String firstHalf(String firstHalf) {
		firstHalf = firstHalf.substring(0, 4);
		return firstHalf;
	}
	
	public String secondHalf(String secondHalf) {
		secondHalf = secondHalf.substring(4, 8);
		return secondHalf;
	}
	
	
}
