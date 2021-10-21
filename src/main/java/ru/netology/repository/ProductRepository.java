package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) throws Exception {
        if (findById(id) == null) {
//        if (id > 4) {
            throw new NotFoundException("Element with id:" + id + " not found");
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;

        for (Product item : items) {
            if (item.getId() != id) {
//        try {
                tmp[index] = item;
//        } catch (Exception e) {
//          System.out.println("!!!!!!");
//          System.out.println(e.getMessage());
//        }
                index++;
            }
            items = tmp;
        }


    }


}
