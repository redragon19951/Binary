
public class QuadraSplit extends Binary2{
	public String firstHalfQ(String firstHalf) {
		firstHalf = firstHalf.substring(0, 2);
		return firstHalf;
	}
	
	public String secondHalfQ(String secondHalf) {
		secondHalf = secondHalf.substring(2, 4);
		return secondHalf;
	}
}
