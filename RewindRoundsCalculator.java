
public class RewindRoundsCalculator {

	public static void main(String[] args) {
		
		double reserves = 17;
		double magazineSize = 6;
		double refillPercentage = 0.6;
		
		int ammoRefilled = 0;
		int rewindRoundsCounter = 0;
		int rewindRoundsTriggered = 0;
		
		System.out.println("Beginning Reserves: " + (int) reserves);
		System.out.println("Beginning Magazine Size: " + (int) magazineSize);
		System.out.println();
		
		while(magazineSize > 0) {
			for(double i = magazineSize; i > 0; i--) {
				rewindRoundsCounter++;
				magazineSize--;
			}
			
			ammoRefilled = (int) Math.ceil(rewindRoundsCounter*refillPercentage);
			
			if(reserves > 0)
				rewindRoundsTriggered++;
			
			if(ammoRefilled < reserves) {
				magazineSize = ammoRefilled;
				reserves = reserves - magazineSize;				
			}
			else {
				magazineSize = reserves;
				reserves = 0;
			}
			 
			
			rewindRoundsCounter = 0;
			
			System.out.println("Rewind Rounds Triggered: " + rewindRoundsTriggered);
			System.out.println("Reserves: " + (int) reserves);
			System.out.println("Magazine Size: " + (int) magazineSize);
			System.out.println();
		}
	}

}
