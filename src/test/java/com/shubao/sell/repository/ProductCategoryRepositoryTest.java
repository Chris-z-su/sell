package com.shubao.sell.repository;

import com.shubao.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    /**
     * 测试查询数据
     */
    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    /**
     * 测试添加数据
     */
    @Test
    @Transactional  //相当于事务回滚，测试数据不会添加到数据库中
    public void insertOneTest(){
        ProductCategory productCategory = new ProductCategory("女生最爱", 4);
        ProductCategory result = repository.save(productCategory);
//        Assert.assertNotEquals(null, result);
        Assert.assertNotNull(result);
    }

    /**
     * 测试更新数据
     */
    @Test
    public void saveTest(){
        //先查询，再更新
        ProductCategory productCategory = repository.findOne(2);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(2);
        repository.save(productCategory);
    }

    /**
     * 查询多条记录
     */
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}