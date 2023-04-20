package com.hong.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author leon
 * @date 2023/4/17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Llj {
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
     * 压力
     */
    @JsonProperty(value = "YL")
    private String yl;
    /**
     * 温度
     */
    @JsonProperty(value = "WD")
    private String wd;
    /**
     * 累计流量
     */
    @JsonProperty(value = "SSLL")
    private String ssll;
    /**
     * 累计流量
     */
    @JsonProperty(value = "LJLL")
    private String ljll;
    /**
     * 纯油累计流量
     */
    @JsonProperty(value = "CYLJLL")
    private String cyljll;
    /**
     * 密度
     */
    @JsonProperty(value = "MD")
    private String md;
    /**
     * 含水
     */
    @JsonProperty(value = "HS")
    private String hs;
    /**
     * 日流量
     */
    @JsonProperty(value = "RLL")
    private String rll;
    /**
     * 日纯油流量
     */
    @JsonProperty(value = "RCYLL")
    private String rcyll;
    /**
     *
     */
    @JsonProperty(value = "ZCSJ")
    private String zcsj;
    /**
     *
     */
    @JsonProperty(value = "SFBL")
    private String sfbl;
    /**
     *
     */
    @JsonProperty(value = "YC")
    private String yc;
    /**
     *
     */
    @JsonProperty(value = "HHYZL")
    private String hhyzl;
    /**
     * 混合液质量累计
     */
    @JsonProperty(value = "HHYZLLJ")
    private String hhyzllj;
    /**
     * 水密度
     */
    @JsonProperty(value = "SMD")
    private String smd;
    /**
     * 纯油密度
     */
    @JsonProperty(value = "CYMD")
    private String cymd;
    /**
     * 纯油质量
     */
    @JsonProperty(value = "CYZL")
    private String cyzl;
    /**
     * 扣水量
     */
    @JsonProperty(value = "KSL")
    private String ksl;
    /**
     * 扣水量累计
     */
    @JsonProperty(value = "KSLLJ")
    private String ksllj;
    /**
     * 混合液体积
     */
    @JsonProperty(value = "HHYTJ")
    private String hhytj;
}
