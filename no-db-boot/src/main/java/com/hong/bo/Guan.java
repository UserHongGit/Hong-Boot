package com.hong.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * 接口标识：G_DQ_BENG
 * 接口名称：泵当前数据
 * 接口地址：services/single/getDqBeng.json
 * 接口权限：SSC_BENG_DQ SELECT
 *
 * @author leon
 * @date 2023/4/17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Guan {
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
     * 进口压力
     */
    @JsonProperty(value = "JKYL")
    private String jkyl;
    /**
     * 出口压力
     */
    @JsonProperty(value = "CKYL")
    private String ckyl;
    /**
     * 上部温度
     */
    @JsonProperty(value = "SBWD")
    private String sbwd;
    /**
     * 中部温度
     */
    @JsonProperty(value = "ZBWD")
    private String zbwd;
    /**
     * 下部温度
     */
    @JsonProperty(value = "XBWD")
    private String xbwd;
    /**
     * 液位
     */
    @JsonProperty(value = "YW")
    private String yw;
    /**
     * 油水界面
     */
    @JsonProperty(value = "YSJM")
    private String ysjm;
    /**
     * 体积
     */
    @JsonProperty(value = "TJ")
    private String tj;
    /**
     * 纯油质量
     */
    @JsonProperty(value = "CYZL")
    private String cyzl;
    /**
     * 加热状态
     */
    @JsonProperty(value = "JRZT")
    private String jrzt;
    /**
     * 混合液温度1
     */
    @JsonProperty(value = "HHYWD")
    private String hhywd;
    /**
     * 罐压
     */
    @JsonProperty(value = "GY")
    private String gy;
    /**
     * 加热温度
     */
    @JsonProperty(value = "JRWD")
    private String jrwd;
    /**
     * 混合液温度2
     */
    @JsonProperty(value = "HHYWD2")
    private String hhywd2;
    /**
     * 开始加热时刻
     */
    @JsonProperty(value = "KSJRSK")
    private String ksjrsk;
    /**
     * 本次加热时间(h)
     */
    @JsonProperty(value = "BCJRSJ")
    private String bcjrsj;
    /**
     * 本次加热电量
     */
    @JsonProperty(value = "BCJRDL")
    private String bcjrdl;
}
