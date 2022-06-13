package com.optilog.log;

public class BeforeAndAfter {
    volatile String beforeInfo = "";
    volatile String beforeError = "";
    volatile String beforeWarn = "";
    volatile String beforeDebug = "";
    volatile String beforeFatal = "";

    volatile String afterInfo = "";
    volatile String afterError = "";
    volatile String afterWarn = "";
    volatile String afterDebug = "";
    volatile String afterFatal = "";

    volatile String beforeEach = "";
    volatile String afterEach = "";

    public String getInfoBefore() {
        return this.beforeInfo + this.beforeEach;
    }

    public String getErrorBefore() {
        return this.beforeError + this.beforeEach;
    }

    public String getWarnBefore() {
        return this.beforeWarn + this.beforeEach;
    }

    public String getDebugBefore() {
        return this.beforeDebug + this.beforeEach;
    }

    public String getFatalBefore() {
        return this.beforeFatal + this.beforeEach;
    }

    /////////////////////////////////

    public String getInfoAfter() {
        return this.afterEach + this.afterInfo;
    }

    public String getErrorAfter() {
        return this.afterEach + this.afterError;
    }

    public String getWarnAfter() {
        return this.afterEach + this.afterWarn;
    }

    public String getDebugAfter() {
        return this.afterEach + this.afterDebug;
    }

    public String getFatalAfter() {
        return this.afterEach + this.afterFatal;
    }
}
