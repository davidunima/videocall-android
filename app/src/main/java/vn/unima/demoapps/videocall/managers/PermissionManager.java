package vn.unima.demoapps.videocall.managers;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * myevolution-android
 * Created by jack on 12/7/2015.
 * Copyright 2015 Nikmesoft Company, Ltd. All rights reserved.
 */
public class PermissionManager {

    public static boolean checkPermission(@NonNull Activity activity, @NonNull String[] permissions, int requestCode) {
        ArrayList<String> requestPermissions = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions.add(permission);
            }
        }
        if (requestPermissions.size() > 0) {
            String[] mStringArray = new String[requestPermissions.size()];
            ActivityCompat.requestPermissions(activity, requestPermissions.toArray(mStringArray), requestCode);
            return false;
        }
        return true;
    }

    public static boolean checkPermission(@NonNull Fragment fragment, @NonNull String[] permissions, int requestCode) {
        ArrayList<String> requestPermissions = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(fragment.getContext(), permission) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions.add(permission);
            }
        }
        if (requestPermissions.size() > 0) {
            String[] mStringArray = new String[requestPermissions.size()];
            fragment.requestPermissions(requestPermissions.toArray(mStringArray), requestCode);
            return false;
        }
        return true;
    }

    public static boolean verifyPermissions(int[] grantResults) {
        // At least one result must be checked.
        if (grantResults == null || grantResults.length < 1) {
            return false;
        }

        // Verify that each required permission has been granted, otherwise return false.
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}
