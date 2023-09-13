package homework01.shop;


import java.util.Collections;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        Collections.sort(products);
        return products;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        return getSortedListProducts().get(products.size()-1);
    }

    public static List<Product> getShuffleListProducts(List<Product> productList) {
        Collections.shuffle((productList));
        return productList;
    }
}