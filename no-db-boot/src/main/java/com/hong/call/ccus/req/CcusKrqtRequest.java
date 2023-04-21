package com.hong.call.ccus.req;

import com.hong.entity.po.Krqt;
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
@CcusUrl(url = "services/single/getDqKrqt.json", name = "当前-二氧化碳浓度检测仪",type = "KRQT", returnClazz = Krqt.class)
public class CcusKrqtRequest extends CcusBaseHead {
}
