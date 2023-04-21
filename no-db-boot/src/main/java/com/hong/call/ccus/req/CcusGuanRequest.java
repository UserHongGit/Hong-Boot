package com.hong.call.ccus.req;

import com.hong.entity.po.Guan;
import com.hong.call.ccus.CcusBaseHead;
import com.hong.call.ccus.CcusUrl;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author leon
 * @date 2023/4/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@CcusUrl(url = "services/single/getDqGuan.json", name = "当前-罐数据",type = "GUAN", returnClazz = Guan.class)
public class CcusGuanRequest extends CcusBaseHead {
}
