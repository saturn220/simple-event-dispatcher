package com.github.saturn220.dispatcher.func.fake;

import com.github.saturn220.dispatcher.EventData;
import com.github.saturn220.dispatcher.Listener;

public class MyListener implements Listener {

    public int value = 1;

    @Override
    public void handle(EventData eventData) {
        if (eventData == null) {
            value = 10;
            return;
        }

        MyDataObject myDataObject = eventData.get(MyDataObject.class);
        value = myDataObject.value;
    }
}
