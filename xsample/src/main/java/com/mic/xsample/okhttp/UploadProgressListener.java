package com.mic.xsample.okhttp;

/**
 * Created by hcDarren on 2017/11/25.
 */
public interface UploadProgressListener {
    void onProgress(long total, long current);
}
