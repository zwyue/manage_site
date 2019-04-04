package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Catagory;
import com.zr.gansu.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 积分商品分类控制类
 *
 * @author WG
 * @date 2019/2/20 14:08
 */
@RestController
@RequestMapping("/admin/catagory")
public class AdminCatagoryController {

    final
    private CatagoryService catagoryService;

    @Autowired
    public AdminCatagoryController(CatagoryService catagoryService) {
        this.catagoryService = catagoryService;
    }

    /**
     * 添加积分商品分类
     *
     * @author WG
     * @date 2019/2/20 13:59
     * @param catagory 积分商品分类
     * @return 是否添加成功
     */
    @RequestMapping("/add")
    public Map addCatagory(Catagory catagory) {
        if (ObjectUtil.isNotNull(catagory)) {
           return catagoryService.addCatagory(catagory);
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     * 查询商品分类
     *
     * @author WG
     * @date 2019/2/20 14:27
     * @return 商品分类
     */
    @RequestMapping("/list")
    public Map CatagoryList(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
                            @RequestParam(value="pageSize",defaultValue="10")Integer pageSize) {
        //分页参数，true代表统计count总数
        PageHelper.startPage(pageNum,pageSize,true);
        return ResultUtils.success(catagoryService.catagoryList());
    }

    /**
     *  删除分类
     *
     * @author WG
     * @date 2019/2/20 15:15
     * @param id 分类主键， name 分类名称
     * @return 是否删除成功
     */
    @RequestMapping("/delete")
    public Map deleteCatagory(Long id) {
        if (id != null) {
           return catagoryService.deleteCatagory(id);
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     * 更新分类名称
     *
     * @author WG
     * @date 2019/2/20 16:28
     * @param catagory 分类信息
     * @return 是否更新成功
     */
    @RequestMapping("/update")
    public Map updateCatagory(Catagory catagory) {
        if (ObjectUtil.isNotNull(catagory) && catagory.getId() != null) {
            return catagoryService.updateCatagory(catagory);
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

}
