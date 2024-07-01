package com.aakarsh.ontime.util;

import android.view.View;

import com.aakarsh.ontime.model.Alarm;

public interface OnToggleAlarmListener {
    void onToggle(Alarm alarm);
    void onDelete(Alarm alarm);
    void onItemClick(Alarm alarm,View view);
}
