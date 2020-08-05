package com.shubao.sell.controller;

import com.shubao.sell.dataobject.ProductCategory;
import com.shubao.sell.dataobject.ProductInfo;
import com.shubao.sell.service.CategoryService;
import com.shubao.sell.service.ProductInfoService;
import com.shubao.sell.utils.ResultVOUtil;
import com.shubao.sell.vo.ProductInfoVO;
import com.shubao.sell.vo.ProductVO;
import com.shubao.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 卖家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //1. 查询所有的上架商品信息
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2. 查询所有类目信息(一次性查询)
//        List<Integer> categoryTypeList = new ArrayList<>();

        //方式一：
//        for (ProductInfo productInfo :
//                productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        //方式二：(Java8特性，lambda)
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory :
                productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo :
                    productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVOList);
        return ResultVOUtil.success(productVOList);
    }



}
