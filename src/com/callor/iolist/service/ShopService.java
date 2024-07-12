package com.callor.iolist.service;
/*
 * score.txt 파일을 생성자를 통해서 전달받고,
 * 1. 파일을 읽어서 컴마(,)로 각 항목을 분해하여 ScoreDto 에 담고
 * 		List<ScoreDto> 리스트에 추가하기
 * 2. List<ScoreDto> 리스트에 저장된 성적 리스트를 성적표로 출력하기
 */
public interface ShopService {
	
	public void loadPurchaseData();
	public void loadSalesData();
	public void printShopList();

}
