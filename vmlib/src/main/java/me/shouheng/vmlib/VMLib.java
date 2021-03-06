package me.shouheng.vmlib;

import android.app.Application;

import me.shouheng.uix.common.UIX;
import me.shouheng.utils.UtilsApp;

/**
 * ===================================================================
 *
 *              MM    MM VV     VV VV     VV MM    MM
 *              MMM  MMM VV     VV VV     VV MMM  MMM
 *              MM MM MM  VV   VV   VV   VV  MM MM MM
 *              MM    MM   VV VV     VV VV   MM    MM
 *              MM    MM    VVV       VVV    MM    MM
 *
 *                         == WngShhng ==
 *
 *        AN EASY AND CONVENIENT MVVM ARCHITECTURE FOR ANDROID.
 *
 * ==================================================================
 *
 * Sample code:
 *
 * <code>
 * class App : Application() {
 *
 *     override fun onCreate() {
 *         super.onCreate()
 *         // initialize mvvms
 *         VMLib.onCreate(this)
 *         // custom L, must be called after MVVMs.onCreate()
 *         customLog()
 *         // custom ARouter
 *         customARouter()
 *         // custom crash
 *         customCrash()
 *         // ... others
 *     }
 *
 *     private fun customLog() {
 *         L.getConfig()
 *             .setLogSwitch(true)
 *             .setLogHeadSwitch(true)
 *             .setBorderSwitch(true)
 *             .setConsoleSwitch(true)
 *     }
 *
 *     private fun customARouter() {
 *         if (BuildConfig.DEBUG) {
 *             ARouter.openLog()
 *             ARouter.openDebug()
 *         }
 *         ARouter.init(this)
 *     }
 *
 *     private fun customCrash() {
 *         if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
 *             == PackageManager.PERMISSION_GRANTED) {
 *             CrashHelper.init(this, "") { crashInfo, e ->
 *                 L.e(crashInfo)
 *                 L.e(e)
 *             }
 *         }
 *     }
 * }
 * </code>
 *
 * @author <a href="mailto:shouheng2015@gmail.com">WngShhng</a>
 * @version Date: 2019-6-29
 */
public final class VMLib {

    private static Application app;

    /**
     * Get the application
     *
     * @return the application
     */
    public static Application getApp() {
        if (app == null) {
            throw new IllegalStateException("Sorry, you should call MVVMs.onCreate() " +
                    "method on your custom application first.");
        }
        return app;
    }

    /**
     * Call this method in your custom {@link Application#onCreate()} method.
     *
     * @param application the application
     */
    public static void onCreate(Application application) {
        VMLib.app = application;
        UtilsApp.init(application);
        // If you want to use uix, you don't need to initialize it in your application manually.
        if (Platform.DEPENDENCY_UIX_ANALYTICS) UIX.INSTANCE.init(application);
    }
}
