package com.wcs.serviceobb.obbmanager;

import android.content.Context;

public class OBBManager {

    public static String getOBBPath(Context ctx, int mainVersion) {
        String packageName = ctx.getPackageName();

        // Build the full path to the app's expansion files
        final String obbDirPath = ctx.getObbDir().getPath();
        String strMainPath = obbDirPath + "/" + "main." +
                mainVersion + "." + packageName + ".obb";

        return strMainPath;
    }

}
