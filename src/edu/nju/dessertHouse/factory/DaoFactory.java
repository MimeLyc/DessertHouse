package edu.nju.dessertHouse.factory;

import edu.nju.dessertHouse.dao.CustomerDao;
import edu.nju.dessertHouse.dao.UserDao;
import edu.nju.dessertHouse.dao.impl.CustomerDaoImpl;
import edu.nju.dessertHouse.dao.impl.UserDaoImpl;


public class DaoFactory {
	
	public static UserDao getUserDao()
	{
		return UserDaoImpl.getInstance();
	}
	
	public static CustomerDao getCustomerDao()
	{
		return CustomerDaoImpl.getInstance();
	}
	/*public static StockDao getStockDao()
	{
		return StockDaoImpl.getInstance();
	}*/
	
/*	public static TradeDao getTradeDao()
	{
		return TradeDaoImpl.getInstance();
	}*/
}
