package com.bit.operation;


import com.bit.book.Book;
import com.bit.book.BookList;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("BorrowOperation");
        System.out.println("输入需要借阅书籍的名称");
        String name = scanner.next();
        //不会从bookList-》进行删除-》isBorrowed true
        //1、找这本书 是否存在
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            if(bookList.getBooks(i).name.equals(name)) {
                break;
            }
        }
        if(i >= bookList.getSize()) {
            System.out.println("没有此书");
            return;
        }
        //2、他是否被借出   false  可以借
        Book book = bookList.getBooks(i);
        if(book.isBorrowed) {
            System.out.println("已经借出去了");
        }else {
            book.isBorrowed = true;
            System.out.println("书籍成功借阅");
        }
    }
}
