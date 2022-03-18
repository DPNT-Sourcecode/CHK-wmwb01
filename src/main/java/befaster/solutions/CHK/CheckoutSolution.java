package befaster.solutions.CHK;

import java.util.HashMap;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
    	//Populate Item Price
    	HashMap<String,Integer> itemPriceTable =  createItemPriceTable();
    	//Populate Item offers
    	HashMap<String,ItemOffer> itemOffers = createItemOfferMap();
    	
    	
    	
    	
    	return 0;
    }
    
    private HashMap<String,Integer> createItemPriceTable(){
    	HashMap<String,Integer> itemPriceTable = new HashMap<String,Integer>();
    	itemPriceTable.put("A", 50);
    	itemPriceTable.put("B", 30);
    	itemPriceTable.put("C", 20);
    	itemPriceTable.put("D", 15);
    	
    	
    	return itemPriceTable;
    }
    
    private HashMap<String,ItemOffer> createItemOfferMap(){
    	HashMap<String,ItemOffer> itemOfferMap= new HashMap<String,ItemOffer>();
    	itemOfferMap.put("A", new ItemOffer("A",3,130));
    	itemOfferMap.put("A", new ItemOffer("B",2,45));
    	return itemOfferMap;
    	
    }
    
    private Integer calculateTotalPrice(String items, HashMap<String,Double> itemPriceTable, HashMap<String,ItemOffer> 
    itemOfferTable) {
    	
    	Integer totalPrice = 0;
    	//Create list of items and quantities requested
    	
    	return totalPrice;
    	
    }
    
    
}
class ItemOffer {
	private String itemName;
	private int quanity;
	private Integer itemPrice;
	ItemOffer(String itemName,int quantity,Integer itemPrice){
		this.itemName = itemName;
		this.quanity = quantity;
		this.itemPrice = itemPrice;
	}
	
	
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
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrize(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
}



