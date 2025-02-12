package com.uce.stock.Logica;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uce.stock.Datos.Stock;
import com.uce.stock.Datos.StockRepository;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    public Optional<Stock> getStockByProductId(Long productId) {
        return stockRepository.findByProductId(productId);
    }

    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
