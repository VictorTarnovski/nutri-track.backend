package com.nutri_track.domain.dtos;

import org.springframework.data.domain.Page;

import java.util.List;

public class PaginationDto<T> {
    public final List<T> items;
    public final int page;
    public final int pageSize;
    public final int totalPages;

    public PaginationDto(Page<T> page) {
        this.items = page.getContent();
        this.page = page.getNumber() + 1;
        this.pageSize = page.getSize();
        this.totalPages = page.getTotalPages();
    }
}
