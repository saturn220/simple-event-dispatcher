package com.github.saturn220.dispatcher.fake;

import com.github.saturn220.dispatcher.EventData;
import com.github.saturn220.dispatcher.EventListener;
import com.github.saturn220.dispatcher.Listener;

@EventListener("app.domain.entity.updated")
public class MyAnnotatedListener implements Listener {

    public int value = 1;

    @Override
    public void handle(EventData eventData) {
        MyDataObject myDataObject = eventData.get(MyDataObject.class);
        value = myDataObject.value;
    }
}
