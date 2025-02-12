package com.uce.productos.Servicios;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.uce.productos.Datos.Product;
import com.uce.productos.Logica.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Product> getProductByCodigo(@PathVariable String codigo) {
        return productService.getProductByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}