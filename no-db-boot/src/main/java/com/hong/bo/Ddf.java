package com.hong.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * 当前-电动阀数据-输出接口
 * @author leon
 * @date 2023/4/17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ddf {
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
     * 远程本地状态
     */
    @JsonProperty(value = "YCBD")
    private String ycbd;
    /**
     * 阀门状态
     */
    @JsonProperty(value = "FMZT")
    private String fmzt;
    /**
     * 阀门开度
     */
    @JsonProperty(value = "FMKD")
    private String fmkd;
}
