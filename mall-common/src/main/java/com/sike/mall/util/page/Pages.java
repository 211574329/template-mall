package com.sike.mall.util.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * 分页
 *
 * @author sike
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pages<T> implements Serializable {


    private static final long serialVersionUID = -4999869044906571699L;

    /**
     * 查询对象
     */
    private @Valid T data;
    /**
     * 页码
     */
    private Integer pageIndex;
    /**
     * 每页大小
     */
    private Integer pageSize;
    /**
     * 是否排序 0:否 1:是
     */
    private Integer sort;
    /**
     * 需要排序的属性
     */
    private String order;


}
