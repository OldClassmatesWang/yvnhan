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
    @ApiModel(value="Book对象", description="")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "图书编号")
        @TableId(value = "id", type = IdType.ASSIGN_UUID)
      private String id;

      @ApiModelProperty(value = "书名")
      private String name;

      @ApiModelProperty(value = "作者")
      private String author;

      @ApiModelProperty(value = "出版社")
      private String press;

      @ApiModelProperty(value = "图书版本")
      private String edition;

      @ApiModelProperty(value = "书籍出版时间")
      private Date publicationDate;

      @ApiModelProperty(value = "书本字数， p单位为万")
      private Integer wordsNumber;

      @ApiModelProperty(value = "书本简介")
      private String description;

      @ApiModelProperty(value = "目录信息")
      private String directory;

      @ApiModelProperty(value = "乐观锁")
      @Version
    private Integer version;

      @ApiModelProperty(value = "逻辑删除")
      @TableLogic
    private Integer deleted;

      @TableField(fill = FieldFill.INSERT)
      private Date createTime;

      @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date updateTime;

      @ApiModelProperty(value = "标签1")
      private Integer label1;

      @ApiModelProperty(value = "标签2")
      private Integer label2;

      @ApiModelProperty(value = "标签3")
      private Integer label3;

      @ApiModelProperty(value = "标签5")
      private Integer label4;

      @ApiModelProperty(value = "标签6")
      private Integer label5;

      @ApiModelProperty(value = "库存")
      private Integer number;



}
