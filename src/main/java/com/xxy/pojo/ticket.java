package com.xxy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

/**
 * @author xxy
 * @date 2020-08-28 - 16:38
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ticket implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer tid;
    private String tname;
    private Integer tyid;
}
