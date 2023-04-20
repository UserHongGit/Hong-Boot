package com.hong.call.ccus;

import com.alibaba.fastjson2.annotation.JSONField;
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
public class CcusBaseHead {
    @Builder.Default
    private String username = "Sczh!2021333";
    @Builder.Default
    private String password = "sczh";

    @JsonProperty(value = "sbbm.s")
    @JSONField(name = "sbbm.s")
    private String sbbm;
}
