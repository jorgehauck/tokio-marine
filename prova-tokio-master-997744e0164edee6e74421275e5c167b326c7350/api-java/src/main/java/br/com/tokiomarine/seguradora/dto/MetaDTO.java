package br.com.tokiomarine.seguradora.dto;

public class MetaDTO {
    private Integer currentPage;
    private Integer itemsPerPage;
    private Integer totalOfItems;
    private Integer totalOfPages;
    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public Integer getTotalOfItems() {
        return totalOfItems;
    }

    public void setTotalOfItems(Integer totalOfItems) {
        this.totalOfItems = totalOfItems;
    }

    public Integer getTotalOfPages() {
        return totalOfPages;
    }

    public void setTotalOfPages(Integer totalOfPages) {
        this.totalOfPages = totalOfPages;
    }
}
