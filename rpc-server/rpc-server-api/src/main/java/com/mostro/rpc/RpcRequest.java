package com.mostro.rpc;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: MOSTRO
 */
@Data
public class RpcRequest implements Serializable {
    private static final long serialVersionUID = -7731146184476002801L;

    private String className;

    private String methodName;

    private Object[] parameter;
}
