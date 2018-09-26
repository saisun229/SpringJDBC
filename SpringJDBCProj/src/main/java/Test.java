import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtc.app.config.AppConfig;
import com.mtc.app.entity.Product;
import com.mtc.app.repsitory.ProductRepository;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); 

		ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

//		List<Product> products = productRepository.findAll();
//		
//		products.forEach(System.out::println);
		
		
//		Product product = productRepository.find(2);
//		
//		System.out.println(product);
		
		Product product = new Product(17,"KindleReader","Amazon Digital Library",100, 20);

		boolean flag = productRepository.addProduct(product);
		
		if(flag) {
			System.out.println("Record added successfully");
		}else {
			System.out.println("Failed to add record");
		}
	}
	

}
