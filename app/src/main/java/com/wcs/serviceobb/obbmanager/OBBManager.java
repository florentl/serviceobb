package com.wcs.serviceobb.obbmanager;

import android.content.Context;
import android.os.storage.OnObbStateChangeListener;
import android.os.storage.StorageManager;

import java.io.File;

import static android.content.Context.STORAGE_SERVICE;

public class OBBManager {

    public static String getOBBPath(Context ctx, int mainVersion) {
        String packageName = ctx.getPackageName();

        // Build the full path to the app's expansion files
        final String obbDirPath = ctx.getObbDir().getPath();
        String strMainPath = obbDirPath + "/" + "main." +
                mainVersion + "." + packageName + ".obb";

        return strMainPath;
    }

    public static void mount(Context appContext, OnObbStateChangeListener listener) {
        StorageManager storageManager=
                (StorageManager) appContext.getSystemService(STORAGE_SERVICE);
        final String obbPath = OBBManager.getOBBPath( appContext, 1 );
        storageManager.mountObb( obbPath, "serviceobb", listener);
    }

    public static File getFileFromObb(Context appContext, String fileName) {
        StorageManager storageManager=
                (StorageManager) appContext.getSystemService(STORAGE_SERVICE);
        final String obbPath = OBBManager.getOBBPath( appContext, 1 );
        return new File(storageManager.getMountedObbPath( obbPath )
                + File.separator + fileName);

    }

}
