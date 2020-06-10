package cn.mt.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @Classname Page
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description 分页包装
 * @Date 2020/5/30 19:49
 */
@ToString
public class Page<T> {
    private int pageSize;
    private int totalRows;
    private int totalPages;
    private int currentPage;
    private int startIndex;
    private int lastIndex;
    private List<T> resultList;

    public Page( int currentPage, int pageSize, List<T> list) {
        setPageSize(pageSize);
        setCurrentPage(currentPage);
        setStartIndex();
//        System.out.println("StartIndex:" + startIndex);
        setLastIndex();
//        System.out.println("LastIndex:" + lastIndex);
        setResultList(list);
    }

    public Page( int currentPage, int pageSize, int totalRows, List<T> list) {
        setPageSize(pageSize);
        setCurrentPage(currentPage);
        setTotalRows(totalRows);
        setTotalPages();
        setStartIndex();
//        System.out.println("StartIndex:" + startIndex);
        setLastIndex();
//        System.out.println("LastIndex:" + lastIndex);
        setResultList(list);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages() {
        if (totalRows % pageSize == 0) {
            this.totalPages = totalRows / pageSize;
        } else {
            this.totalPages = (totalRows / pageSize) + 1;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex() {
        this.startIndex = (currentPage - 1) * pageSize;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex() {
        if(totalRows == 0 ) {
            this.lastIndex = 0;
        }else if (totalRows < pageSize) {
            this.lastIndex = totalRows -1 ;
        } else if ((totalRows % pageSize == 0) || (totalRows % pageSize != 0 && currentPage < totalPages)) {
            this.lastIndex = currentPage * pageSize -1 ;
        } else if (totalRows % pageSize != 0 && currentPage == totalPages) {
            this.lastIndex = totalRows - 1;
        }
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
