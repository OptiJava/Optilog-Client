package com.optilog.log;

public class LogState {
    public int allLogCount = 0;

    public int infoLogCount = 0;
    public int errorLogCount = 0;
    public int warnLogCount = 0;
    public int debugLogCount = 0;
    public int fatalLogCount = 0;

    public int commandCount = 0;

    public String getInfoProportion() {
        return (((double) this.infoLogCount / (double) this.allLogCount) * ((double) 100)) + "%";
    }

    public String getErrorProportion() {
        return (((double) this.errorLogCount / (double) this.allLogCount) * ((double) 100)) + "%";
    }

    public String getWarnProportion() {
        return (((double) this.warnLogCount / (double) this.allLogCount) * ((double) 100)) + "%";
    }

    public String getDebugProportion() {
        return (((double) this.debugLogCount / (double) this.allLogCount) * ((double) 100)) + "%";
    }

    public String getFatalProportion() {
        return (((double) this.fatalLogCount / (double) this.allLogCount) * ((double) 100)) + "%";
    }
}
