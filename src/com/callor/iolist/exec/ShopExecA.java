package com.callor.iolist.exec;

import java.io.FileNotFoundException;

import com.callor.iolist.service.ShopService;
import com.callor.iolist.service.impl.ShopServiceImplV1;

public class ShopExecA {
	public static void main(String[] args) {
		
		ShopService shopService = null;
		String shopDataFile = "src/com/callor/iolist/shop.txt";
		try {
			shopService = new ShopServiceImplV1(shopDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		shopService.loadPurchaseData();
		shopService.loadSalesData();
		shopService.printShopList();
	}
}