package befaster.solutions.CHK;

import java.util.HashMap;

public class CheckoutSolution {
    public Integer checkout(String skus) {
    	//Build Requested Items
    	HashMap<Character,Integer> requestedItems = buildRequestedItemMap(skus);
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
    
    private HashMap<Character,Integer> buildRequestedItemMap(String items){
    	HashMap<Character,Integer> requestedItems = new HashMap<Character,Integer>();
    	
    	//Create list of items and quantities requested
    	char[] itemArray = items.toCharArray();
    	for(char item: itemArray) {
    		int quantity = 1;
    		if(requestedItems.containsKey(item)) {
    			quantity = requestedItems.get(item);
    			quantity++;
    		}
    		requestedItems.put(item, quantity);
    		
    	}
    	return requestedItems;
    }
    
    
    private Integer calculateTotalPrice(HashMap<Character,Integer> requestedItems, HashMap<String,Double> itemPriceTable, HashMap<String,ItemOffer> 
    itemOfferTable) {
    	
    	int totalPrice = 0;
    	
    	//Calculate Price
    	
    	
    	
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





