package com.imooc.controller;

import com.imooc.enums.CarouseIsShow;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import com.imooc.utils.WebResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "轮播图", notes = "轮播图")
    @GetMapping("carousel")
    public WebResponse queryAll() {
        List<Carousel> carousels = carouselService.queryAll(CarouseIsShow.Yes.type);

        return WebResponse.ok(carousels);
    }

    @ApiOperation(value = "一级分类")
    @GetMapping("/cats")
    public WebResponse queryAllCategory(){
        List<Category> categories = categoryService.queryAllCategory();

        return WebResponse.ok(categories);
    }

    @GetMapping("/subCat/{rootCatId}")
    public WebResponse subCat(@PathVariable("rootCatId") Integer rootCatId) {
        if (rootCatId == null) {
            return WebResponse.errorMsg("分类不存在");
        }
        List<CategoryVO> subCatList = categoryService.getSubCatList(rootCatId);

        return  WebResponse.ok(subCatList);
    }


    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据", notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public WebResponse sixNewItems(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {

        if (rootCatId == null) {
            return WebResponse.errorMsg("分类不存在");
        }

        List<NewItemsVO> list = categoryService.getSixNewItemsLazy(rootCatId);
        return WebResponse.ok(list);
    }

}
