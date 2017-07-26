package com.ljr.e_commerce;


import com.ljr.mycore.activities.ProxyActivity;
import com.ljr.mycore.delegates.LatteDelegate;
public class MainActivity extends ProxyActivity {


    @Override
    public LatteDelegate setRootDelegate() {
        return new MainDelegate();
    }
}
