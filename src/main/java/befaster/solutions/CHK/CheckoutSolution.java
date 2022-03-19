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
    	itemPriceTable.put("F", 10);
    	
    	//Add more items
    	itemPriceTable.put("G", 20);
    	itemPriceTable.put("H", 10);
    	itemPriceTable.put("I", 35);
    	itemPriceTable.put("J", 60);
    	itemPriceTable.put("K", 80);
    	itemPriceTable.put("L", 90);
    	itemPriceTable.put("M", 15);
    	itemPriceTable.put("N", 40);
    	itemPriceTable.put("O", 10);
    	itemPriceTable.put("P", 50);
    	itemPriceTable.put("Q", 30);
    	itemPriceTable.put("R", 50);
    	itemPriceTable.put("S", 30);
    	itemPriceTable.put("T", 20);
    	itemPriceTable.put("U", 40);
    	itemPriceTable.put("V", 50);
    	itemPriceTable.put("W", 20);
    	itemPriceTable.put("X", 90);
    	itemPriceTable.put("Y", 10);
    	itemPriceTable.put("Z", 50);
    	
    	
    	
    	
    	
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
    	
    	//populate more offers
    	priceOfferList = new ArrayList<PriceOffer>();
    	offer1 = new PriceOffer("H", 10, 80);
    	offer2 = new PriceOffer("H",5,45);
    	priceOfferList.add(offer1);
    	priceOfferList.add(offer2);
    	priceOfferMap.put("H", priceOfferList);
    	
    	priceOfferList = new ArrayList<PriceOffer>();
    	offer1 = new PriceOffer("K", 2, 150);
    	priceOfferList.add(offer1);
    	priceOfferMap.put("K", priceOfferList);
    	
    	priceOfferList = new ArrayList<PriceOffer>();
    	offer1 = new PriceOffer("P", 5, 200);
    	priceOfferList.add(offer1);
    	priceOfferMap.put("P", priceOfferList);
    	
    	priceOfferList = new ArrayList<PriceOffer>();
    	offer1 = new PriceOffer("Q", 3, 80);
    	priceOfferList.add(offer1);
    	priceOfferMap.put("Q", priceOfferList);
    	
    	priceOfferList = new ArrayList<PriceOffer>();
    	offer1 = new PriceOffer("V", 3, 130);
    	offer2 = new PriceOffer("V",2,90);
    	priceOfferList.add(offer1);
    	priceOfferList.add(offer2);
    	priceOfferMap.put("V", priceOfferList);
    	
    	    	
    	
    	return priceOfferMap;
    	
    }
    
    
    private HashMap<String,List<FreeItemOffer>> createFreeItemOfferMap(){
    	
    	// populate offer of E
    	HashMap<String, List<FreeItemOffer>> freeItemOfferMap = new HashMap<String, List<FreeItemOffer>>();
    	
    	FreeItemOffer offer = new FreeItemOffer("E", 2, "B", 1);
    	List<FreeItemOffer> freeItemOfferList = new ArrayList<FreeItemOffer>();
    	freeItemOfferList.add(offer);
    	freeItemOfferMap.put("E", freeItemOfferList);
    	
    	// populate offer of F
    	offer = new FreeItemOffer("F", 2, "F", 1);
    	freeItemOfferList = new ArrayList<FreeItemOffer>();
    	freeItemOfferList.add(offer);
    	freeItemOfferMap.put("F", freeItemOfferList);
    	
    	offer = new FreeItemOffer("N", 3, "M", 1);
    	freeItemOfferList = new ArrayList<FreeItemOffer>();
    	freeItemOfferList.add(offer);
    	freeItemOfferMap.put("N", freeItemOfferList);
    	
    	offer = new FreeItemOffer("R", 3, "Q", 1);
    	freeItemOfferList = new ArrayList<FreeItemOffer>();
    	freeItemOfferList.add(offer);
    	freeItemOfferMap.put("R", freeItemOfferList);
    	
    	offer = new FreeItemOffer("U", 3, "U", 1);
    	freeItemOfferList = new ArrayList<FreeItemOffer>();
    	freeItemOfferList.add(offer);
    	freeItemOfferMap.put("U", freeItemOfferList);
    	

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
    	
    	HashMap<String, Integer> itemWiseTotalPrice = new HashMap<String, Integer>();
    	int totalItemPrice = 0;
    	
    	// Iterate through requestedItems
    	for (String item : requestedItems.keySet()) {
    		int totalPrice = 0;
    		
    		//Take requested quantity
    		int requestedQuantity = requestedItems.get(item);
    		
    		// If there is free item on requested item
    		if (freeItemOfferMap.containsKey(item)) {
    			// Get list of freeItemOffers
    			List<FreeItemOffer> listOfFreeItemOffers = freeItemOfferMap.get(item);
    			
    			// List should be added in sorted order of quantity, for now it will be one only as per example
    			for (FreeItemOffer freeItemOffer : listOfFreeItemOffers) {
    				int freeItemRemainingQuantityForPricing = 0;
    				int totalPriceForRemainingFreeItem = 0;
    				//If free item is the same as requested items
    				if(freeItemOffer.getFreeItemName().equalsIgnoreCase(item)) {
    					
    					//build logic for same item free
    					if(requestedQuantity > (freeItemOffer.getQuantity() + freeItemOffer.getFreeItemQuantity())) {
    						int freeItems = (requestedQuantity/(freeItemOffer.getQuantity() + freeItemOffer.getFreeItemQuantity())) * freeItemOffer.getFreeItemQuantity();
    						freeItemRemainingQuantityForPricing = requestedQuantity - freeItems;
    					} else if(requestedQuantity == (freeItemOffer.getQuantity() + freeItemOffer.getFreeItemQuantity())) {
    						freeItemRemainingQuantityForPricing = freeItemOffer.getQuantity();
    						
    					} else {
    						freeItemRemainingQuantityForPricing = requestedQuantity;
    					}
    					totalPrice = totalPrice + itemPriceTable.get(freeItemOffer.getItemName()) * freeItemRemainingQuantityForPricing;
    					
    				} else {
    				
	    				// How many free items we will get, if for 2E 1B is free, for 5E it should be 2B
	    				
	    				int freeItemQuantity = (requestedQuantity / freeItemOffer.getQuantity()) * freeItemOffer.getFreeItemQuantity();
	    				if(freeItemQuantity > 0) {
	    					// Adjust free items as per logic below in requestedItems
	    					if(requestedItems.get(freeItemOffer.getFreeItemName()) != null) {
	    						int freeItemRequestedQuantity = requestedItems.get(freeItemOffer.getFreeItemName());
	    						freeItemRemainingQuantityForPricing = 0;
	    						
	    						if(freeItemRequestedQuantity > freeItemQuantity) 
	    							freeItemRemainingQuantityForPricing = freeItemRequestedQuantity - freeItemQuantity;
	    						else
	    							freeItemRemainingQuantityForPricing = 0;
	    						
	    						requestedItems.put(freeItemOffer.getFreeItemName(), freeItemRemainingQuantityForPricing);
	    						totalPriceForRemainingFreeItem = 0;
	    						
	    						if(priceOfferMap.containsKey(freeItemOffer.getFreeItemName()))
	    							totalPriceForRemainingFreeItem = derivePriceFromPriceOfferMap(freeItemOffer.getFreeItemName(), 0, freeItemRemainingQuantityForPricing, priceOfferMap, itemPriceTable);
	    						else
	    							totalPriceForRemainingFreeItem = totalPriceForRemainingFreeItem + itemPriceTable.get(freeItemOffer.getFreeItemName()) * freeItemRemainingQuantityForPricing;
	    						
	    						itemWiseTotalPrice.put(freeItemOffer.getFreeItemName(), totalPriceForRemainingFreeItem);
	    								
	    					}
	    				}
	    				// Take price from price table and multiply with requested quantity
		    			totalPrice = totalPrice + itemPriceTable.get(item) * requestedQuantity;
	    				
	    			}
	    			
    			}
    			
    		} else if(priceOfferMap.containsKey(item)) {
    			int remainingQuantity = requestedItems.get(item);
    			
    			totalPrice = derivePriceFromPriceOfferMap(item, totalPrice, remainingQuantity, priceOfferMap, itemPriceTable);
    			
    		} else {
    			// Take price from price table and multiply with requested quantity
    			totalPrice = totalPrice + itemPriceTable.get(item) * requestedQuantity;
    		}
    		
    		itemWiseTotalPrice.put(item, totalPrice);    		
    		
    	}
    	
    	for (String item : itemWiseTotalPrice.keySet()) {
    		
    		totalItemPrice = totalItemPrice + itemWiseTotalPrice.get(item); 
    	}
    	
    	
    	return totalItemPrice;
    	
    }
    
    private Integer derivePriceFromPriceOfferMap(String item, Integer totalPrice, int remainingQuantity, 
    		HashMap<String, List<PriceOffer>> priceOfferMap, HashMap<String, Integer> itemPriceTable) {
    
    	List<PriceOffer> listOfPriceOffers = priceOfferMap.get(item);
    	
    	for(PriceOffer priceOffer : listOfPriceOffers) {
    		
    		if(remainingQuantity > priceOffer.getQuanity()) {
    			totalPrice = totalPrice + (remainingQuantity / priceOffer.getQuanity()) * priceOffer.getItemPrice();
    			remainingQuantity = remainingQuantity % priceOffer.getQuanity();
    		
    		} else if (remainingQuantity == priceOffer.getQuanity()) {
    			totalPrice = totalPrice + priceOffer.getItemPrice();
    			remainingQuantity = 0;
    		}
    	}
    	totalPrice = totalPrice + remainingQuantity * itemPriceTable.get(item);
    	
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





