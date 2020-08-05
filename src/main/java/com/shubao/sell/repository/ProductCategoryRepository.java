package com.shubao.sell.repository;

import com.shubao.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
