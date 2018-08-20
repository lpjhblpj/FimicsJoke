// UserAidl.aidl
package com.mic.xsample;

// Declare any non-default types here with import statements

interface UserAidl {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */

    String getUserName();
    String getPassword();

    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
