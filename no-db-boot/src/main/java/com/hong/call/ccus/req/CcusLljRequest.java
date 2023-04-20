package com.hong.call.ccus.req;

import com.hong.bo.Llj;
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
@CcusUrl(url = "services/single/getDqLlj.json", name = "当前-流量计数据",type = "LLJ", returnClazz = Llj.class)
public class CcusLljRequest extends CcusBaseHead {
}
