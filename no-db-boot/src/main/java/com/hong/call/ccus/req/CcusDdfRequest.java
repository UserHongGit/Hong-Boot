package com.hong.call.ccus.req;

import com.hong.bo.Ddf;
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
@CcusUrl(url = "services/single/getDqDdf.json", name = "当前-电动阀数据",type = "DDF", returnClazz = Ddf.class)
public class CcusDdfRequest  extends CcusBaseHead {
}
