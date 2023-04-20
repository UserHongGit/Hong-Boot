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
public class Beng {
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
     * 进口温度
     */
    @JsonProperty(value = "JKWD")
    private String jkwd;
    /**
     * 润滑液温度
     */
    @JsonProperty(value = "RHYWD")
    private String rhywd;
    /**
     * 定子温度
     */
    @JsonProperty(value = "DZWD")
    private String dzwd;
    /**
     * 转子温度
     */
    @JsonProperty(value = "ZZWD")
    private String zzwd;
    /**
     * 运行状态
     */
    @JsonProperty(value = "YXZT")
    private String yxzt;
    /**
     * 变频工频
     */
    @JsonProperty(value = "BPGP")
    private String bpgp;
    /**
     * 工频单耗
     */
    @JsonProperty(value = "GPDH")
    private String gpdh;
    /**
     * 工频标耗
     */
    @JsonProperty(value = "GPBH")
    private String gpbh;
    /**
     * 工频效率
     */
    @JsonProperty(value = "GPXL")
    private String gpxl;
    /**
     * 变频单耗
     */
    @JsonProperty(value = "BPDH")
    private String bpdh;
    /**
     * 变频标耗
     */
    @JsonProperty(value = "BPBH")
    private String bpbh;
    /**
     * 变频效率
     */
    @JsonProperty(value = "BPXL")
    private String bpxl;
    /**
     * A项电流
     */
    @JsonProperty(value = "DC_IA")
    private String dc_ia;
    /**
     * B项电流
     */
    @JsonProperty(value = "DC_IB")
    private String dc_ib;
    /**
     * C项电流
     */
    @JsonProperty(value = "DC_IC")
    private String dc_ic;
    /**
     * A相电压
     */
    @JsonProperty(value = "DC_UA")
    private String dc_ua;
    /**
     * B项电压
     */
    @JsonProperty(value = "DC_UB")
    private String dc_ub;
    /**
     * C项电压
     */
    @JsonProperty(value = "DC_UC")
    private String dc_uc;
    /**
     * 有功功率
     */
    @JsonProperty(value = "DC_YGGL")
    private String dc_yggl;
    /**
     * 无功功率
     */
    @JsonProperty(value = "DC_WGGL")
    private String dc_wggl;
    /**
     * 视在功率
     */
    @JsonProperty(value = "DC_SZGL")
    private String dc_szgl;
    /**
     * 功率因数
     */
    @JsonProperty(value = "DC_GLYS")
    private String dc_glys;
    /**
     * 周波
     */
    @JsonProperty(value = "DC_ZB")
    private String dc_zb;
    /**
     * 累计电量
     */
    @JsonProperty(value = "DC_LJDL")
    private String dc_ljdl;
    /**
     * 累计电量前值
     */
    @JsonProperty(value = "DC_LJDLQZ")
    private String dc_ljdlqz;
    /**
     * 压力
     */
    @JsonProperty(value = "LLJ_YL")
    private String llj_yl;
    /**
     * 温度
     */
    @JsonProperty(value = "LLJ_WD")
    private String llj_wd;
    /**
     * 瞬时流量
     */
    @JsonProperty(value = "LLJ_SSLL")
    private String llj_ssll;
    /**
     * 累计流量
     */
    @JsonProperty(value = "LLJ_LJLL")
    private String llj_ljll;
    /**
     * 纯油累计流量
     */
    @JsonProperty(value = "LLJ_CYLJLL")
    private String llj_cyljll;
    /**
     * 密度
     */
    @JsonProperty(value = "LLJ_MD")
    private String llj_md;
    /**
     * 含水
     */
    @JsonProperty(value = "LLJ_HS")
    private String llj_hs;
    /**
     * 泵前轴温度
     */
    @JsonProperty(value = "BQZWD")
    private String bqzwd;
    /**
     * 泵后轴温度
     */
    @JsonProperty(value = "BHZWD")
    private String bhzwd;
    /**
     * 出口温度
     */
    @JsonProperty(value = "CKWD")
    private String ckwd;
    /**
     * 日耗电量
     */
    @JsonProperty(value = "RHDL")
    private String rhdl;
}
