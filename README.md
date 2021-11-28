# Simple Event Dispatcher

The SimpleEventDispatcher java library provides tools that allow your application
modules(components) to communicate with each other by dispatching events and listening to
them.

## Usage

### Create event listener

```java
@EventListener("user.button.clicked")
public class UserButtonClickedListener implements Listener {
    
    @Override
    public void handle(EventData eventData) {
        Integer buttonId = eventData.get(Integer.class);
        if  (buttonId == SAVE_BUTTON_ID) {
            engineState.save();
        }
    }
}
```

### Scan your application
Scans your application directories for the presence of 
a `[Listener](src/main/java/com/github/saturn220/dispatcher/Listener.java)` interface 
and adds it to the dispatcher.
```java
Dispatcher dispatcher = new Dispatcher();
DispatcherRegistrar.registerListeners(dispatcher, "com.example"); 
```

### Dispatch event
```java
// In a button click method
dispatcher.dispatch("user.button.clicked", new EventData(buttonId));
```
