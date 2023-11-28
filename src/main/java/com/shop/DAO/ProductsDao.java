package main.java.com.shop.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
			ProductsEntity dummy = new ProductsEntity();
			dummy.setCategory(categoryList.get((int)Math.floor(Math.random()*categoryList.size())));
			dummy.setCreateDate(currentDate);
			dummy.setProductDesc("This is product description");
			dummy.setProductImg("https://picsum.photos/300/200?random="+i);
			dummy.setProductName("dummyProduct"+i);
			dummy.setProductPrice(i+1*1000);
			dummy.setProductStock(i*5);
			dummy.setUpdateDate(currentDate);
			productsRepository.save(dummy);
		}
    }
	
	public List<ProductsEntity> getAllProducts() {
		return productsRepository.findAll();
	}
	
	public Optional<ProductsEntity> getProductsEntityById(int id) {
		return productsRepository.findById(id);
	}
	
	public ProductsEntity addProduct(ProductsEntity product) {
		
		return productsRepository.save(product);
		
	}
	
	public List<ProductsEntity> deleteProductById(Map<String, Integer> data) {
		productsRepository.deleteById(data.get("productId"));
		return productsRepository.findAll();
	}
	
}
