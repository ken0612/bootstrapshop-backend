package main.java.com.shop.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.shop.model.ProductsEntity;
import main.java.com.shop.repository.ProductsRepository;

@Repository
public class ProductsDao {

	@Autowired
	ProductsRepository productsRepository;
	
	public List<ProductsEntity> getProductsByCategory(String category){
		if(category.equals("all")) {
			return productsRepository.findAll();
		}
		return productsRepository.getProductsEntitiesByCategory(category);
	}
	
	public void generateRandomProducts() {
		List<String> categoryList = new ArrayList<>();
		categoryList.add("spring");
		categoryList.add("summer");
		categoryList.add("autum");
		categoryList.add("winter");
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		for(int i =0;i<=20;i++) {
			ProductsEntity dammy = new ProductsEntity();
			dammy.setCategory(categoryList.get((int)Math.floor(Math.random()*categoryList.size())));
			dammy.setCreateDate(currentDate);
			dammy.setProductDesc("this is dammy products desc haha!");
			dammy.setProductImg("https://picsum.photos/300/200?random="+i);
			dammy.setProductName("dammyProduct"+i);
			dammy.setProductPrice(i*1000);
			dammy.setProductStock(i*5);
			dammy.setUpdateDate(currentDate);
			productsRepository.save(dammy);
		}
    }
	
	public List<ProductsEntity> getAllProducts() {
		return productsRepository.findAll();
	}
	
	public Optional<ProductsEntity> getProductsEntityById(int id) {
		return productsRepository.findById(id);
	}
	
	
}
