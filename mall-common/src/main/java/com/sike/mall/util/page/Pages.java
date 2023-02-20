package com.sike.mall.util.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * 分页
 * @author sike
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pages<T> implements Serializable {


    private static final long serialVersionUID = -4999869044906571699L;

    private @Valid T data;
    private Integer pageIndex;
    private Integer pageSize;
    private String sort;
    private String order;


}
