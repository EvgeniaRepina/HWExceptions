package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product first = new Product(1, "Java I", 1000);
    Product second = new Product(2, "Java I", 1000);
    Product third = new Product(3, "Java I", 1000);
    Product fourth = new Product(4, "Java I", 1000);


    @Test
    public void shouldldSaveOneItem() {
        repository.save(first);

        Product[] expected = new Product[]{first};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    //_______________ успешность удаления существующего элемента____________
    @Test
    public void shouldRemoveByIdNotExistLength4Last() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        try {
            repository.removeById(4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{first, second, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExistLength4First() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        try {
            repository.removeById(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{second, third, fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExistLength4Mid() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        try {
            repository.removeById(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{first, second, fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExistLength1() {
        repository.save(first);

        try {
            repository.removeById(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    //_______________ успешность удаления НЕсуществующего элемента____________
    @Test
    public void shouldRemoveByIdNotExistLength4Over() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        try {
            repository.removeById(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{first, second, third, fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExistLength4Zero() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        try {
            repository.removeById(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{first, second, third, fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExistLength4Negative() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        try {
            repository.removeById(-10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{first, second, third, fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExistLength1Over() {
        repository.save(first);

        try {
            repository.removeById(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{first};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExistLength1Zero() {
        repository.save(first);

        try {
            repository.removeById(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{first};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExistLength1Negative() {
        repository.save(first);

        try {
            repository.removeById(-10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{first};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExistLength0Over() {

        try {
            repository.removeById(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExistLength0Zero() {

        try {
            repository.removeById(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExistLength0Negative() {

        try {
            repository.removeById(-10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    //--------  успешность генерации NotFoundException при попытке удаления несуществующего элемента____________
    @Test
    public void shouldGetNotExistExceptionLength4Over() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

//        try {
//            repository.removeById(5);
//        } catch (Exception e) {
//            System.out.println("!!!!!!");
//            System.out.println(e.getMessage());
//        }

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });

    }

    @Test
    public void shouldGetNotExistExceptionLength4Zero() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(0);
        });

    }

    @Test
    public void shouldGetNotExistExceptionLength4Negative() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-10);
        });

    }

    @Test
    public void shouldGetNotExistExceptionLength1Over() {
        repository.save(first);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });

    }

    @Test
    public void shouldGetNotExistExceptionLength1Zero() {
        repository.save(first);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(0);
        });

    }

    @Test
    public void shouldGetNotExistExceptionLength1Negative() {
        repository.save(first);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-10);
        });

    }

    @Test
    public void shouldGetNotExistExceptionLength0Over() {

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });

    }

    @Test
    public void shouldGetNotExistExceptionLength0Zero() {


        assertThrows(NotFoundException.class, () -> {
            repository.removeById(0);
        });

    }

    @Test
    public void shouldGetNotExistExceptionLength0Negative() {


        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-10);
        });

    }

}
