package com.baizhou.yvnhan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
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
    @ApiModel(value="Record对象", description="")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "记录id")
        @TableId(value = "id", type = IdType.ASSIGN_UUID)
      private String id;

      @ApiModelProperty(value = "用户id")
      private String userId;

      @ApiModelProperty(value = "图书id")
      private String bookId;

      @ApiModelProperty(value = "借阅时间段")
      private Integer timeHours;

      @ApiModelProperty(value = "逻辑删除,表示是否归还，归还为1，为归还为0")
      @TableLogic
    private Integer deleted;

      @ApiModelProperty(value = "创建时间")
        @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @ApiModelProperty(value = "更新时间")
        @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;


}
