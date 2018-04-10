package com.example.zengziqiang.rxjava2.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/4/3
 * @desc
 */

public class Tools {

    public static Tools getInstance() {
        return ToolsInstance.instance;
    }

    private static final class ToolsInstance {
        private static final Tools instance = new Tools();
    }

    /**
     * 判断字符串是否为空
     *
     * @param s
     * @return
     */
    public boolean isEmpty(String s) {
        if (s == null || s.equals("") || s.length() == 0 || s.replace(" ", "").length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 存储个人信息到本地
     *
     * @param params
     */
    public void savePersionINFO(Map<Object, Object> params) {
        //存储用户信息
        SharedPreferences sp = MyApp.appContext.getSharedPreferences("PERSON_INFO", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<Object, Object> entry : params.entrySet()) {
                edit.putString(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
        }
        edit.commit();
    }

    /**
     * 根据key获取相应的值
     *
     * @param key_info
     * @return
     */
    public String getPersionINFObyKEY(String key_info) {
        SharedPreferences sp = MyApp.appContext.getSharedPreferences("PERSON_INFO", MODE_PRIVATE);
        return sp.getString(key_info, "");
    }

    /**
     * @param key_info
     */
    public void clearPersionINFObyKEY(String key_info) {
        SharedPreferences sp = MyApp.appContext.getSharedPreferences("PERSON_INFO", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key_info, "");
        edit.commit();
    }

    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的
     *
     * @param context
     * @return true 表示开启
     */
    public boolean isOPen(final Context context) {
        LocationManager locationManager
                = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps || network) {
            return true;
        }
        return false;
    }

    /**
     * 吐司
     *
     * @param msg
     */
    public void showToast(String msg) {
        Toast.makeText(MyApp.appContext, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 获取cookie
     *
     * @return
     */
    public Map getCookie() {
        Map map = new HashMap();
        System.out.println("是否有值：" + getPersionINFObyKEY("JM_PRINCIPAL"));
        map.put("JM_PRINCIPAL", getPersionINFObyKEY("JM_PRINCIPAL"));
        map.put("JM_VISITOR", getPersionINFObyKEY("JM_VISITOR"));
        return map;
    }

    /**
     * 判断是否登录
     *
     * @return true 为登录成功
     */
    public boolean isLogin() {
        Map<String, String> cookie = getCookie();
        if (cookie != null && cookie.size() > 0) {
            for (Map.Entry<String, String> entry : cookie.entrySet()) {
                if (!isEmpty(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 清空登录信息
     */
    public void LoginOut() {
        SharedPreferences sp = MyApp.appContext.getSharedPreferences("PERSON_INFO", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.clear();
        edit.commit();
    }

    public void savaCookie(String cookie) {
        SharedPreferences sp = MyApp.appContext.getSharedPreferences("setcookie", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("setcookie", cookie);
        edit.commit();
    }

    public String getSetCookie() {
        SharedPreferences sp = MyApp.appContext.getSharedPreferences("setcookie", MODE_PRIVATE);
        String setcookie = sp.getString("setcookie", "");
        return setcookie;
    }

}
