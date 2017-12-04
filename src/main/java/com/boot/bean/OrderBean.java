package com.boot.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 7/4/16
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderBean  implements Serializable {
    private static final long serialVersionUID = -797586847427389162L;

    private final String id;

    public OrderBean(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
