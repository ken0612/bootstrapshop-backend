package main.java.com.shop.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.shop.DAO.ProductsDao;
import main.java.com.shop.model.ProductsEntity;

@Service
public class ProductsService {

    @Autowired
    ProductsDao productsDao;
    
    //產生假資料
    public List<ProductsEntity> generateDammyData() {
    	productsDao.generateRandomProducts();
    	return productsDao.getAllProducts();
    }
    
    //用類別取得商品列表
    public List<ProductsEntity> getProductsByCategory(String category){
    	return productsDao.getProductsByCategory(category);
    }
    
    //用ID取得商品詳細
    public ProductsEntity getProductDetailById(int id) {
    	Optional<ProductsEntity> target= productsDao.getProductsEntityById(id);
    	ProductsEntity productDetail= target.get();
    	return  productDetail;
    }
    
    public ProductsEntity saveProduct(ProductsEntity product) {
    	product.setCreateDate(new java.sql.Date(new Date().getTime()));
    	return productsDao.addProduct(product);
    }
    
    public List<ProductsEntity> deleteProductById(Map<String, Integer> data) {
    	return productsDao.deleteProductById(data);
    }
}
