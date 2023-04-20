package com.hong.call.ccus.req;

import com.hong.bo.Zndb;
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
@CcusUrl(url = "services/single/getDqZndb.json", name = "当前-智能电表数据",type = "ZNDB", returnClazz = Zndb.class)
public class CcusZndbRequest extends CcusBaseHead {
}
