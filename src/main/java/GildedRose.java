import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
}
	
	

	

	
    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
            if ((!"Aged Brie".equals(items.get(i).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) 
            {
                if (items.get(i).getQuality() > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
                    {
                    	
                    	if("Conjured Mana Cake".equals(items.get(i).getName()))
                    	{
                    		items.get(i).setQuality(items.get(i).getQuality() - 2);
                    		//Conjured Mana Cake Quality : 6-2
                    	}
                    	else
                    	{
                            items.get(i).setQuality(items.get(i).getQuality() - 1);
                        	//Elixir of the Mongoose		Quality: 7-1
                        	//+5 Dexterity Vest 			Quality : 20-1
                    	}
                    }
                }
            }
            else //Aged Brie ; Backstage passes to a TAFKAL80ETC concert
            {
                if (items.get(i).getQuality() < 50)
                { 
                    items.get(i).setQuality(items.get(i).getQuality() + 1);
                    //Aged Brie												Quality: 0+1
                	//Backstage passes to a TAFKAL80ETC concert 			Quality : 20+1

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
                    {
                        if (items.get(i).getSellIn() < 11)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                              //Backstage passes to a TAFKAL80ETC concert 			Quality : x+1
                            }
                        }

                        if (items.get(i).getSellIn() < 6)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                                //Backstage passes to a TAFKAL80ETC concert 			Quality : x+1
                                
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
            	//+5 Dexterity Vest ; Aged Brie ; Elixir of the Mongoose ; Backstage passes to a TAFKAL80ETC concert ; Conjured Mana Cake
            {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
                //+5 Dexterity Vest	SellIn : 10-1
                //Aged Brie SellIn : 2-1
                //Elixir SellIn : 5-1
                //backstage SellIn : 15-1
                //conjured SellIn :3-1
            }

            if (items.get(i).getSellIn() < 0)
            {
                if (!"Aged Brie".equals(items.get(i).getName()))
                {
                    //+5 Dexterity Vest	SellIn
                    //Elixir
                    //backstage
                    //conjured
                	//Sulfuris
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
                    {
                        //+5 Dexterity Vest	SellIn
                        //Elixir
                        //conjured
                    	//Sulfuris
                        if (items.get(i).getQuality() > 0)
                        {

                        	if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
                            {
                            	if("Conjured Mana Cake".equals(items.get(i).getName()))
                            	{
                            		items.get(i).setQuality(items.get(i).getQuality() - 2);
                            		//conjured Quality : x-2
                            	}
                            	else
                            	{
                                    items.get(i).setQuality(items.get(i).getQuality() - 1);
                                    //+5 Dexterity Vest	SellIn Quality : x -1
                                    //Elixir Quality : x-1
                            	}
                            	
                            }
                        }
                    }
                    else
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                }
                else
                {
                	//Aged Brie
                    if (items.get(i).getQuality() < 50)
                    {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
                        // AgedBrie Quality : x+1
                    }
                }
            }
        }
    }

}