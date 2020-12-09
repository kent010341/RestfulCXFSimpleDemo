/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kent.restfulcxfwithoutspring;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author kent_chen
 */
public class Server {
    
    public static void main(String[] args) {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(ObjectResource.class);
        sf.setResourceProvider(
                new SingletonResourceProvider(new ObjectResource()));
        sf.setAddress("http://localhost:9000/");
        BindingFactoryManager manager = 
                sf.getBus().getExtension(BindingFactoryManager.class);
        JAXRSBindingFactory factory = new JAXRSBindingFactory();
        factory.setBus(sf.getBus());
        manager.registerBindingFactory(
                JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
        sf.create();
        
        System.out.println("rest ws is published.");
    }
    
}
