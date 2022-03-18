package befaster.solutions.CHK;

import java.util.HashMap;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
    	HashMap<String,Double> itemPriceTable =  createItemPriceTable();
    	
    	return 0;
    }
    
    private HashMap<String,Double> createItemPriceTable(){
    	HashMap<String,Double> itemPriceTable = new HashMap<String,Double>();
    	itemPriceTable.put("A", 50.0);
    	itemPriceTable.put("B", 30.0);
    	itemPriceTable.put("C", 20.0);
    	itemPriceTable.put("D", 15.0);
    	
    	
    	return itemPriceTable;
    }
    
    
}
class ItemOffer {
	private String itemName;
	private int quanity;
	private double itemPrize;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuanity() {
		return quanity;
	}
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	public double getItemPrize() {
		return itemPrize;
	}
	public void setItemPrize(double itemPrize) {
		this.itemPrize = itemPrize;
	}
	
	
}




