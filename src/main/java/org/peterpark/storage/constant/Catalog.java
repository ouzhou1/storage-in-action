package org.peterpark.storage.constant;

/**
 * Description:
 *
 * @author: peter
 * @date: 2018/8/16.
 */
public enum Catalog {
    /**
     * 默认类目
     */
    DEFAULT(0),
    MYSQL(100),
    POSTGRES(101),
    ORACLE(102),
    REDIS(201),
    MONGO(202),
    GRAPHDB(301),
    HBASE(302);

    private final int value;

    private Catalog(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Catalog valueOf(int value) {
        for (Catalog catalog : values()) {
            if (catalog.getValue() == value) {
                return catalog;
            }
        }
        return Catalog.DEFAULT;
    }
}
