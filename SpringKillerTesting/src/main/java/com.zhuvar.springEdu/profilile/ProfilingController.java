package com.zhuvar.springEdu.profilile;

public class ProfilingController implements ProfilingControllerMBean {
    private boolean isEnabled = true;

    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void setEnable(boolean enable) {
        this.isEnabled = enable;
    }
}
