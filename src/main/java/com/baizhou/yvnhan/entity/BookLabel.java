package com.baizhou.yvnhan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanghaipeng
 * @since 2021-07-14
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="BookLabel对象", description="")
public class BookLabel implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.ASSIGN_UUID)
      private Integer id;

    private String name;


}
