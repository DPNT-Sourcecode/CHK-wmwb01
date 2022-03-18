package befaster.solutions.CHK;

import java.util.HashMap;

public class CheckoutSolution {
    public Integer checkout(String skus) {
    	
    	//Build Requested Items
    	HashMap<String,Integer> requestedItems = buildRequestedItemMap(skus);
    	//Populate Item Price
    	HashMap<String,Integer> itemPriceTable =  createItemPriceTable();
    	
    	if(!validateInput(requestedItems, itemPriceTable))
    		return -1;
    	//Populate Item offers
    	HashMap<String,ItemOffer> itemOffers = createItemOfferMap();
    	Integer totalPrice = calculateTotalPrice(requestedItems, itemPriceTable, itemOffers);
    	return totalPrice;
    }
    
    private boolean validateInput(HashMap<String,Integer> requestedItems,HashMap<String,Integer> itemPriceTable) {
    	boolean isValid = true;
    	
    	for (String item : requestedItems.keySet()) {
    		if(!itemPriceTable.containsKey(item)) {
    			isValid = false;
    			break;
    		}
    		
    	}
    	
    	return isValid;
    	
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
    	itemOfferMap.put("B", new ItemOffer("B",2,45));
    	return itemOfferMap;
    	
    }
    
    private HashMap<String,Integer> buildRequestedItemMap(String items){
    	HashMap<String,Integer> requestedItems = new HashMap<String,Integer>();
    	
    	//Create list of items and quantities requested
    	char[] itemArray = items.toCharArray();
    	for(char item: itemArray) {
    		int quantity = 1;
    		if(requestedItems.containsKey(Character.toString(item))) {
    			quantity = requestedItems.get(Character.toString(item));
    			quantity++;
    		}
    		requestedItems.put(Character.toString(item), quantity);
    		
    	}
    	return requestedItems;
    }
    
    
    private Integer calculateTotalPrice(HashMap<String,Integer> requestedItems, HashMap<String,Integer> itemPriceTable, HashMap<String,ItemOffer> 
    itemOfferTable) {
    	
    	int totalPrice = 0;
    	for (String item : requestedItems.keySet()) {
    		//Take requested quantity
    		int requestedQuantity = requestedItems.get(item);
    		//Check if item available in offer
    		if(itemOfferTable.containsKey(item)) {
    			ItemOffer itemOffer = itemOfferTable.get(item);
    			//If requested quantity is less than offer quantity, actual price will apply
    			if(requestedQuantity <  itemOffer.getQuanity()) {
    				totalPrice = totalPrice + itemPriceTable.get(item) * requestedQuantity;
    			} else if(requestedQuantity == itemOffer.getQuanity()) {
    				totalPrice = totalPrice + itemOffer.getItemPrice();
    			}else {
    				
    				totalPrice = totalPrice + (requestedQuantity % itemOffer.getQuanity())* itemPriceTable.get(item)
    						+ (requestedQuantity/itemOffer.getQuanity()) * itemOffer.getItemPrice();
    			}
    			
    			
    		} else {
    			//Take price from price table and multiply with requested quantity
    		    totalPrice = totalPrice + itemPriceTable.get(item) * requestedQuantity;
    			
    		}
    		
    		
    		
    	}
    	
    	
    	return totalPrice;
    	
    }
    
    
}
class PriceOffer {
	private String itemName;
	private int quanity;
	private Integer itemPrice;
	
	PriceOffer(String itemName,int quantity,Integer itemPrice){
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
	public Integer getItemPrice() {
		return itemPrice;
	}
	public void setItemPrize(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}
		
}

class FreeItemOffer {
	private String itemName;
	private int quantity;
	private String freeItemName;
	private int freeItemQuantity;
	
	FreeItemOffer(String itemName, int quantity, String freeItemName, int freeItemQuantity){
		this.itemName = itemName;
		this.quantity = quantity;
		this.freeItemName = freeItemName;
		this.freeItemQuantity = freeItemQuantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getFreeItemName() {
		return freeItemName;
	}

	public void setFreeItemName(String freeItemName) {
		this.freeItemName = freeItemName;
	}

	public int getFreeItemQuantity() {
		return freeItemQuantity;
	}

	public void setFreeItemQuantity(int freeItemQuantity) {
		this.freeItemQuantity = freeItemQuantity;
	}
	
	
}



