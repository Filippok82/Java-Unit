package homework01.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static homework01.shop.Shop.getShuffleListProducts;
import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */
    public static void main(String[] args) {

        Shop testShop = new Shop();
        testShop.setProducts(getShuffleListProducts(getTestListProducts()));

        //1. Проверить, что магазин хранит верный список продуктов (количество продуктов)
        assertThat(testShop.getProducts()).hasSize(4);


        // 2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct

        assertThat(testShop.getMostExpensiveProduct().getTitle()).isEqualTo(getTestListProducts().get(3).getTitle());


        //3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов

        assertThat(testShop.getSortedListProducts().get(0).getCost()).isEqualTo(100);
        assertThat(testShop.getSortedListProducts().get(1).getCost()).isEqualTo(150);
        assertThat(testShop.getSortedListProducts().get(2).getCost()).isEqualTo(200);
        assertThat(testShop.getSortedListProducts().get(3).getCost()).isEqualTo(500);

        for (Product product : getTestListProducts()) {
            System.out.println(product.getTitle() + "-" + product.getCost());
        }
        System.out.println("До сортировки:");
        for (Product product : getTestListProducts()) {
            System.out.println(product.getTitle() + "-" + product.getCost());
        }
        System.out.println("После пермешивания:");
        for (Product product : getShuffleListProducts(getTestListProducts())) {
            System.out.println(product.getTitle() + "-" + product.getCost());
        }
        System.out.println("После сортировки:");
        for (Product product : testShop.getSortedListProducts()) {
            System.out.println(product.getTitle() + "-" + product.getCost());
        }
        System.out.println(getTestListProducts());
    }


    static List<Product> getTestListProducts() {
        Product productA = new Product();
        productA.setTitle("Молоко");
        productA.setCost(100);

        Product productB = new Product();
        productB.setTitle("Помидоры");
        productB.setCost(150);


        Product productC = new Product();
        productC.setTitle("Курица");
        productC.setCost(200);

        Product productD = new Product();
        productD.setTitle("Креветки");
        productD.setCost(500);

        List<Product> productList = new ArrayList<>();
        productList.add(productA);
        productList.add(productB);
        productList.add(productC);
        productList.add(productD);


        return productList;
    }


}

