package vn.unima.demoapps.videocall.activities;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import vn.unima.demoapps.videocall.managers.PermissionManager;


/**
 * Created by unima-l002 on 6/8/17.
 */

public class LaunchActivity extends AppCompatActivity {
    private static final int RC_PERMISSION_CAMERA = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RC_PERMISSION_CAMERA && PermissionManager.verifyPermissions(grantResults)) {
            goNext();
        } else {
            finish();
        }
    }

    private void checkPermission() {
        if (PermissionManager.checkPermission(this, new String[]{Manifest.permission.CAMERA}, RC_PERMISSION_CAMERA)) {
            goNext();
        }
    }

    private void goNext() {
        startActivity(new Intent(LaunchActivity.this, MainActivity.class));
    }
}
