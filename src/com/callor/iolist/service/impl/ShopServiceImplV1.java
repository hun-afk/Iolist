package com.callor.iolist.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.iolist.models.ShopVo;
import com.callor.iolist.service.ShopService;
import com.callor.iolist.utils.Contract;
import com.callor.iolist.utils.Line;

public class ShopServiceImplV1 implements ShopService {
	
	protected final String shopDataFile;
	protected String[] shopTitle;
	protected final List<ShopVo> ShopList;
	protected final Scanner fileReader;
	
	public ShopServiceImplV1(String ShopDataFile) throws FileNotFoundException {
		this.shopDataFile = ShopDataFile;
		this.ShopList = new ArrayList<>();
		InputStream in = new FileInputStream(this.shopDataFile);
		this.fileReader = new Scanner(in);
	}

	@Override
	public void loadPurchaseData() {
		shopTitle = fileReader.nextLine().split(",");
		while(fileReader.hasNext()) {
			String line = fileReader.nextLine();
			String[] lines = line.split(",");
			ShopVo vo = new ShopVo();
			vo.date = lines[ Contract.Shop.거래일자];
			vo.time = Integer.valueOf(lines[ Contract.Shop.거래시각]);
			vo.trans = 1;
			vo.product = lines[Contract.Shop.상품명];
			vo.purchase = Integer.valueOf(lines[ Contract.Shop.수량])*Integer.valueOf(lines[ Contract.Shop.가격]);
			vo.sales = 0;
			ShopList.add(vo);
		}
	}

	@Override
	public void loadSalesData() {
		shopTitle = fileReader.nextLine().split(",");
		while(fileReader.hasNext()) {
			String line = fileReader.nextLine();
			String[] lines = line.split(",");
			ShopVo vo = new ShopVo();
			vo.date = lines[Contract.Shop.거래일자];
			vo.time = Integer.valueOf(lines[Contract.Shop.거래시각]);
			vo.trans = 2;
			vo.product = lines[Contract.Shop.상품명];
			vo.purchase = 0;
			vo.sales = Integer.valueOf(lines[Contract.Shop.수량])*Integer.valueOf(lines[ Contract.Shop.가격]);
			ShopList.add(vo);
		}
	}

	@Override
	public void printShopList() {

		int[] subjectTotal = new int[shopTitle.length];

		System.out.println(Line.dLine(100));
		for(String title : shopTitle) {
			System.out.print(title + "\t");
		}
		System.out.println("매입금액\t매출금액\n" + Line.sLine(100));

		for(ShopVo vo : ShopList) {
			System.out.printf("%5s\t",vo.date);
			System.out.printf("%4d\t",vo.trans);
			System.out.printf("%4d\t",vo.product);
			System.out.printf("%4d\t",vo.purchase);
			System.out.printf("%4d\t",vo.sales);

			subjectTotal[Contract.Shop.거래일자] = Integer.parseInt(vo.date);
			if(vo.trans== 1) {
				System.out.print("매입");
			} else {
				System.out.print("매출");
			}
			subjectTotal[Contract.Shop.상품명] = Integer.parseInt(vo.product);
			subjectTotal[Contract.Shop.매입금액] +=  vo.purchase;
			subjectTotal[Contract.Shop.매출금액] +=  vo.sales;

		}
		
		System.out.println(Line.sLine(100));
		System.out.print("\t");
		int cnt = 0;
		for(int i = 1 ; i < subjectTotal.length ; i++) {
			cnt++;
			System.out.printf("%.2f\t",cnt);
		}
		
		System.out.println("\n" +Line.dLine(100));
	}
}
