package com.github.saturn220.dispatcher.fake;

import com.github.saturn220.dispatcher.EventData;
import com.github.saturn220.dispatcher.Listener;

public class MyListener implements Listener {

    public int value = 1;

    @Override
    public void handle(EventData eventData) {
        MyDataObject myDataObject = eventData.get(MyDataObject.class);
        value = myDataObject.value;
    }
}
