package com.hector.quarkus.app;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

/**
 La clase que esta anotada con @ApplicationScoped significa que solo tendra una instancia durante toda la aplicacion
 muy parecido a lo que es un bean de spring.

 La anotacion @Observes es parte de java enterprise y en el caso que sea StartupEvent, se ejecutara la logica que exista dentro de ese metodo
 al momento de INICIAR LA APP

 Y si es una clase de ShutdownEvent, se ejecutara la logica que existen dentro de ese metodo pero al momento de APAGAR LA APP

 */
@ApplicationScoped
public class AppLifeCycleBean {

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    public void onStart(@Observes StartupEvent event){
        LOGGER.info("The app is starting ...");
    }

    public void onStop(@Observes ShutdownEvent event){
        LOGGER.info("The app is stopping");
    }
}
