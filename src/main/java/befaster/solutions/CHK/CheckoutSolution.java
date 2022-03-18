package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckoutSolution {
    public Integer checkout(String skus) {
    	
    	//Build Requested Items
    	HashMap<String,Integer> requestedItems = buildRequestedItemMap(skus);
    	//Populate Item Price
    	HashMap<String,Integer> itemPriceTable =  createItemPriceTable();
    	
    	// Validate Input
    	if(!validateInput(requestedItems, itemPriceTable))
    		return -1;
    	
    	//Populate Item offers
    	HashMap<String, List<PriceOffer>> priceOfferMap = createPriceOfferMap();
    	HashMap<String, List<FreeItemOffer>> freeItemOfferMap = createFreeItemOfferMap();
    	
    	// Calculate total price
    	Integer totalPrice = calculateTotalPrice(requestedItems, itemPriceTable, priceOfferMap, freeItemOfferMap);
    	
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
    	itemPriceTable.put("E", 40);
    	
    	
    	return itemPriceTable;
    }
    
    private HashMap<String,List<PriceOffer>> createPriceOfferMap(){
    	
    	HashMap<String, List<PriceOffer>> priceOfferMap = new HashMap<String, List<PriceOffer>>();
    	
    	// populate offers of A
    	PriceOffer offer1 = new PriceOffer("A",5,200);
    	PriceOffer offer2 = new PriceOffer("A",3,130);
    	
    	List<PriceOffer> priceOfferList = new ArrayList<PriceOffer>();
    	priceOfferList.add(offer1);
    	priceOfferList.add(offer2);
    	
    	priceOfferMap.put("A", priceOfferList);
    	
    	// populate offers of B
    	priceOfferList = new ArrayList<PriceOffer>();
    	offer1 = new PriceOffer("B", 2, 45);
    	priceOfferList.add(offer1);
    	priceOfferMap.put("B", priceOfferList);
    	    	
    	
    	return priceOfferMap;
    	
    }
    
    
    private HashMap<String,List<FreeItemOffer>> createFreeItemOfferMap(){
    	
    	// populate offer of E
    	HashMap<String, List<FreeItemOffer>> freeItemOfferMap = new HashMap<String, List<FreeItemOffer>>();
    	
    	FreeItemOffer offer = new FreeItemOffer("E", 2, "B", 1);
    	List<FreeItemOffer> freeItemOfferList = new ArrayList<FreeItemOffer>();
    	freeItemOfferList.add(offer);
    	freeItemOfferMap.put("E", freeItemOfferList);
    	
    	return freeItemOfferMap;
    	
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
    
    
    private Integer calculateTotalPrice(HashMap<String,Integer> requestedItems, HashMap<String,Integer> itemPriceTable, 
    		HashMap<String, List<PriceOffer>> priceOfferMap, HashMap<String, List<FreeItemOffer>> freeItemOfferMap) {
    	
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


