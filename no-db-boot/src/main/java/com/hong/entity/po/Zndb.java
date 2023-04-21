package com.hong.entity.po;

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
public class Zndb {
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
     * A项电流
     */
    @JsonProperty(value = "IA")
    private String ia;
    /**
     * B项电流
     */
    @JsonProperty(value = "IB")
    private String ib;
    /**
     * C项电流
     */
    @JsonProperty(value = "IC")
    private String ic;
    /**
     * A相电压
     */
    @JsonProperty(value = "UA")
    private String ua;
    /**
     * B项电压
     */
    @JsonProperty(value = "UB")
    private String ub;
    /**
     * C项电压
     */
    @JsonProperty(value = "UC")
    private String uc;
    /**
     * 有功功率
     */
    @JsonProperty(value = "YGGL")
    private String yggl;
    /**
     * 无功功率
     */
    @JsonProperty(value = "WGGL")
    private String wggl;
    /**
     * 视在功率
     */
    @JsonProperty(value = "SZGL")
    private String szgl;
    /**
     * 功率因数
     */
    @JsonProperty(value = "GLYS")
    private String glys;
    /**
     * 周波
     */
    @JsonProperty(value = "ZB")
    private String zb;
    /**
     * 累计电量
     */
    @JsonProperty(value = "LJDL")
    private String ljdl;
    /**
     * 转储时间
     */
    @JsonProperty(value = "ZCSJ")
    private String zcsj;
    /**
     * 是否补入
     */
    @JsonProperty(value = "SFBL")
    private String sfbl;
    /**
     * A相有功功率
     */
    @JsonProperty(value = "YGGLA")
    private String yggla;
    /**
     * B相有功功率
     */
    @JsonProperty(value = "YGGLB")
    private String ygglb;
    /**
     * C相有功功率
     */
    @JsonProperty(value = "YGGLC")
    private String ygglc;
    /**
     * 正向尖有功电能值
     */
    @JsonProperty(value = "ZXJYGDNZ")
    private String zxjygdnz;
    /**
     * 正向峰有功电能值
     */
    @JsonProperty(value = "ZXFYGDNZ")
    private String zxfygdnz;
    /**
     * 正向平有功电能值
     */
    @JsonProperty(value = "ZXPYGDNZ")
    private String zxpygdnz;
    /**
     * 正向谷有功电能值
     */
    @JsonProperty(value = "ZXGYGDNZ")
    private String zxgygdnz;
    /**
     * A相电压谐波3次测量
     */
    @JsonProperty(value = "UAXB3")
    private String uaxb3;
    /**
     * A相电压谐波5次测量
     */
    @JsonProperty(value = "UAXB5")
    private String uaxb5;
    /**
     * A相电压谐波7次测量
     */
    @JsonProperty(value = "UAXB7")
    private String uaxb7;
    /**
     * A相电压谐波9次测量
     */
    @JsonProperty(value = "UAXB9")
    private String uaxb9;
    /**
     * A相电流谐波3次测量
     */
    @JsonProperty(value = "IAXB3")
    private String iaxb3;
    /**
     * A相电流谐波5次测量
     */
    @JsonProperty(value = "IAXB5")
    private String iaxb5;
    /**
     * A相电流谐波7次测量
     */
    @JsonProperty(value = "IAXB7")
    private String iaxb7;
    /**
     * A相电流谐波9次测量
     */
    @JsonProperty(value = "IAXB9")
    private String iaxb9;
}
