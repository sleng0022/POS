package unit_test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import common.itemList;

public class test_itemList 
{

	@Test
	public final void test() throws IOException 
	{
		itemList item = new itemList();
		
		assertEquals("orange", item.getItemDescription(890)); // TODO
		assertEquals(890, item.getItemID("orange"));
		assertEquals(1.0, item.getPriceWithDescription("orange"), 0.001);
	}

}
