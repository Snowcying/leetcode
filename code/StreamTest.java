package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    class Author {
        //id
        private Long id;
        //姓名
        private String name;
        //年龄
        private Integer age;

        public String getName() {
            return name;
        }

        public List<Book> getBooks() {
            return books;
        }

        public Author(Long id, String name, Integer age, String intro, List<Book> books) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.intro = intro;
            this.books = books;
        }

        //简介
        private String intro;
        //作品
        private List<Book> books;

        public void setBooks(List<Book> books) {
            this.books = books;
        }
    }

    class Book {
        public Book(Long id, String name, String category, Integer score, String intro) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.score = score;
            this.intro = intro;
        }

        //id
        private Long id;
        //书名
        private String name;

        //分类
        private String category;

        //评分
        private Integer score;

        public String getName() {
            return name;
        }

        //简介
        private String intro;

    }

    public List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }


    public static void main(String[] args) {
//        打印所有书籍的名字。要求对重复的元素进行去重。
        List<Author> authors = new StreamTest().getAuthors();


//        authors.stream()
//                .flatMap(author -> author.getBooks().stream())
//                .distinct()
//                .forEach(book -> System.out.println(book.getName()));
//
//        List<Book> collect = authors.stream()
//                .flatMap(author -> author.getBooks().stream())
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(collect);
        authors.stream()
                .map(author -> author.getName())
                .distinct()
                .forEach(name1 -> System.out.println(name1));


    }
}
