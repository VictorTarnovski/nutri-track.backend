package com.nutri_track.application.dtos;

public class PaginatedDto {
    private int page;
    private int pageSize;

    public PaginatedDto(Integer page, Integer pageSize) {
        changePage(page);
        changePageSize(pageSize);
    }

    public int page() {
        return this.page;
    }

    public int pageSize() {
        return this.pageSize;
    }

    public void changePage(Integer page) {
        var value = 0;
        if (!(page == null)) value = page - 1;
        this.page = Math.max(value, 0);
    }

    public void changePageSize(Integer pageSize) {
        var value = 30;
        if (!(pageSize == null)) value = pageSize;
        this.pageSize = Math.min(value, 120);
    }

}
