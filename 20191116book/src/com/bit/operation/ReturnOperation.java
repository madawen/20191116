package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.BookList;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("ReturnOperation");
        System.out.println("输入需要归还书籍的名称");
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
            book.isBorrowed = false;
            System.out.println("书籍归还成功！");
        }else {
            System.out.println("书籍归还失败");
        }
    }
}
