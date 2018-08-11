package com.mic.libcore.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;

import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Locale;

@SuppressWarnings("unused")
public final class Device {


    /**
     * 获取APP信息
     */
    public static class App {
        /**
         * 获取应用程序名称
         */
        public static synchronized String getAppName(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(
                        context.getPackageName(), 0);
                int labelRes = packageInfo.applicationInfo.labelRes;
                return context.getResources().getString(labelRes);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * [获取应用程序版本名称信息]
         *
         * @param context
         * @return 当前应用的版本名称
         */
        public static synchronized String getVersionName(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(
                        context.getPackageName(), 0);
                return packageInfo.versionName;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


        /**
         * [获取应用程序版本名称信息]
         *
         * @param context
         * @return 当前应用的版本名称
         */
        public static synchronized int getVersionCode(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(
                        context.getPackageName(), 0);
                return packageInfo.versionCode;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }


        /**
         * [获取应用程序版本名称信息]
         *
         * @param context
         * @return 当前应用的版本名称
         */
        public static synchronized String getPackageName(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(
                        context.getPackageName(), 0);
                return packageInfo.packageName;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }

    }

        /**
         * 获取手机系统信息
         * http://blog.51cto.com/2402766/1080837
         */
        public static class System {

            /**
             * 获取手机核心数据
             *
             * @return 返回手机核数
             */
            public static int getNumAvailableCores() {
                return Runtime.getRuntime().availableProcessors();
            }

            /**
             * 获取当前手机系统语言。
             *
             * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
             */
            public static String getSystemLanguage() {
                return Locale.getDefault().getLanguage();
            }

            /**
             * 获取当前系统上的语言列表(Locale列表)
             *
             * @return 语言列表
             */
            public static Locale[] getSystemLanguageList() {
                return Locale.getAvailableLocales();
            }

            /**
             * 获取当前手机系统版本号
             *
             * @return 系统版本号
             */
            public static String getSystemVersion() {
                return android.os.Build.VERSION.RELEASE;
            }

            /**
             * 获取手机型号
             *
             * @return 手机型号
             */
            public static String getSystemModel() {
                return android.os.Build.MODEL;
            }

            /**
             * 获取手机厂商
             *
             * @return 手机厂商
             */
            public static String getDeviceBrand() {
                return android.os.Build.BRAND;
            }

            /**
             * 获取手机IMEI(需要“android.permission.READ_PHONE_STATE”权限)
             *
             * @return 手机IMEI
             */
            @SuppressLint({"MissingPermission", "HardwareIds"})
            public static String getIMEI(Context ctx) {
                TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Activity.TELEPHONY_SERVICE);
                if (tm != null) {
                    return tm.getDeviceId();
                }
                return null;
            }

            // 获取Android手机中SD卡存储信息 获取剩余空间
            public void getSDCardInfo() {
                // 在manifest.xml文件中要添加
                /*
                 * <uses-permission
                 * android:name="android.permission.WRITE_EXTERNAL_STORAGE">
                 * </uses-permission>
                 */
                // 需要判断手机上面SD卡是否插好，如果有SD卡的情况下，我们才可以访问得到并获取到它的相关信息，当然以下这个语句需要用if做判断
                if (Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {
                    // 取得sdcard文件路径
                    File path = Environment.getExternalStorageDirectory();
                    StatFs statfs = new StatFs(path.getPath());
                    // 获取block的SIZE
                    long blocSize = statfs.getBlockSize();
                    // 获取BLOCK数量
                    long totalBlocks = statfs.getBlockCount();
                    // 空闲的Block的数量
                    long availaBlock = statfs.getAvailableBlocks();
                    // 计算总空间大小和空闲的空间大小
                    // 存储空间大小跟空闲的存储空间大小就被计算出来了。
                    long availableSize = blocSize * availaBlock;
                    // (availableBlocks * blockSize)/1024 KIB 单位
                    // (availableBlocks * blockSize)/1024 /1024 MIB单位
                    long allSize = blocSize * totalBlocks;
                }

            }

            // 获取手机ip method-1
            public String getLocalIpAddress(Context context) {
                try {
                    for (Enumeration<NetworkInterface> en = NetworkInterface
                            .getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf
                                .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress()) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException ex) {
                    ex.printStackTrace();
                    // Log.e("ifo", ex.toString());
                }
                return "";
            }

            // 获取手机MAC地址
            private String getMacAddress(Context context) {
                String result = "";
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                result = wifiInfo.getMacAddress();
                // Log.i(TAG, "macAdd:" + result);
                return result;
            }


        }


    }
