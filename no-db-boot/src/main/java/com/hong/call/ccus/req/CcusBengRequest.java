package com.hong.call.ccus.req;

import com.hong.bo.Beng;
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
@CcusUrl(url = "services/single/getDqBeng.json", name = "当前-泵数据",type = "BENG", returnClazz = Beng.class)
public class CcusBengRequest extends CcusBaseHead {

}
