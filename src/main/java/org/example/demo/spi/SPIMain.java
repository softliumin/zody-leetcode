/**
 * @(#)SPIMain.java, 2020/7/24.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.example.demo.spi;

import java.util.ServiceLoader;

/**
 * @author 柳敏 liumin06@corp.netease.com
 * @since 2020-07-24 14:03
 */
public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
    }


}
