package main.java.com.shop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import main.java.com.shop.model.ProductsEntity;
import main.java.com.shop.service.ProductsService;

@Controller
@CrossOrigin(origins="*")
public class ProductsController {
	
	@Autowired
	ProductsService productsService;
	
	
	@ResponseBody
	@GetMapping("/dammy")
	public List<ProductsEntity> generateRandomProducts(){
		return productsService.generateDammyData();
	}
	
	
	@ResponseBody
	@GetMapping("/getproducts")
	public List<ProductsEntity> getProductsByCategory(@RequestParam("category") String category){
		System.out.println("products被呼叫了，參數為： "+category);
		return productsService.getProductsByCategory(category);
	}
	
	@ResponseBody
	@GetMapping("/getproductdetail")
	public ProductsEntity getProductDetailById(@RequestParam("productid")int id) {
		return productsService.getProductDetailById(id);
	}
	
	@ResponseBody
	@PostMapping("/addproductentity")
	public ProductsEntity addProduct(@RequestBody ProductsEntity data ) {
		return productsService.saveProduct(data);
	}
	
	
	@ResponseBody
	@PostMapping("deleteproductbyid")
	public List<ProductsEntity> deleteProductById(@RequestBody Map<String,Integer> data) {
		return productsService.deleteProductById(data);
	}
	
}
