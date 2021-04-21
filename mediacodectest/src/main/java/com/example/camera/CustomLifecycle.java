package com.example.camera;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

/**
 * Created by leiyao6
 * on2021/4/21
 */
public class CustomLifecycle implements LifecycleOwner {
    private LifecycleRegistry lifecycleRegistry;

    public CustomLifecycle(LifecycleRegistry lifecycleRegistry) {
        this.lifecycleRegistry = lifecycleRegistry;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
    }

    public void doOnResume() {
        lifecycleRegistry.setCurrentState(Lifecycle.State.RESUMED);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}
