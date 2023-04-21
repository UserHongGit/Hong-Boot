package com.hong.entity.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * 当前-二氧化碳浓度检测仪-输出接口
 * 接口标识：G_DQ_KRQT
 * 接口名称：二氧化碳浓度检测仪当前数据
 * 接口地址：services/single/getDqKrqt.json
 * 接口权限：SSC_KRQT_DQ SELECT
 *
 * @author leon
 * @date 2023/4/17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Krqt {
    /**
     * 设备编码
     */
    @JsonProperty(value = "SBBM")
    private String sbbm;
    /**
     * 采集时间
     */
    @JsonProperty(value = "CJSJ")
    private String cjsj;
    /**
     * 气体浓度(mg/m3)
     */
    @JsonProperty(value = "ND")
    private String nd;
    /**
     * 备注
     */
    @JsonProperty(value = "BZ")
    private String bz;
    /**
     * 报警0正常1报警
     */
    @JsonProperty(value = "BJ")
    private String bj;
}
