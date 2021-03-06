package jbr.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import jbr.graphql.dao.ProductRepository;
import jbr.graphql.model.Product;

public class Mutation implements GraphQLMutationResolver {

  @Autowired
  private ProductRepository productRepository;

  public Product newProduct(String name, String category, Long price) {
    Product newProduct = new Product();
    newProduct.setName(name);
    newProduct.setCategory(category);
    newProduct.setPrice(price);

    productRepository.save(newProduct);

    return newProduct;
  }
}
