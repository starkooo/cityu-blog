package com.cityu.blog.service;

import com.cityu.blog.vo.CategoryVo;
import com.cityu.blog.vo.Result;

import java.util.List;

public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();
}
