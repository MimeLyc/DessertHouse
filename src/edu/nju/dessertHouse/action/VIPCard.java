package edu.nju.dessertHouse.action;

public class VIPCard {
	
	public int judgeLevel(int money,int levelNow){
		int level = levelNow;
		if(money>=level*100){
			level = level+1;
		}
		
		return level;
		
	}
	
	public double discount(int level){
		
		return (1-level*0.03);
		
	}
}
