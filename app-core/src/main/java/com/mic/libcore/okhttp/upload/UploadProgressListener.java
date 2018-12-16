package com.mic.libcore.okhttp.upload;


public interface UploadProgressListener {
    void onProgress(long total, long current);
}
